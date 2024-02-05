package htl.steyr.spring_introduction.controller;

import htl.steyr.spring_introduction.model.ISubscriberInterface;
import htl.steyr.spring_introduction.model.PublisherInterface;
import htl.steyr.spring_introduction.model.SchoolClass;
import htl.steyr.spring_introduction.model.Student;
import htl.steyr.spring_introduction.repository.SchoolClassRepository;
import htl.steyr.spring_introduction.repository.StudentRepository;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@Component
public class StudentController implements Initializable, PublisherInterface {

    private final StudentRepository studentRepo;

    public TextField firstNameTextField;
    public TextField lastNameTextField;
    public TextField graduationYearTextField;
    public ComboBox<SchoolClass> classComboBox;
    private final SchoolClassRepository classRepository;

    private ISubscriberInterface subscriber;

    public StudentController(StudentRepository studentRepo, SchoolClassRepository classRepository) {
        this.studentRepo = studentRepo;
        this.classRepository = classRepository;
    }

    public void cancelClicked(ActionEvent actionEvent) {

        closeWindow(actionEvent);
    }

    public void saveClicked(ActionEvent actionEvent) {
        if (classComboBox.getSelectionModel().getSelectedIndex() >= 0) {
            Student s = new Student(firstNameTextField.getText(),
                    lastNameTextField.getText(),
                    Integer.parseInt(graduationYearTextField.getText())
            );

            s.setSchoolClass(classComboBox.getValue());
            this.studentRepo.save(s);

            subscriber.triggerAction();

            closeWindow(actionEvent);
        } else {
            classComboBox.requestFocus();
        }
    }

    private void closeWindow (ActionEvent e){
        Button button = (Button)(e.getSource());
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<SchoolClass> classes = classRepository.findAll();
        classComboBox.getItems().addAll(classes); //füge alle Klassen zur ComboBox hinzu!


        List<Student> negativeStudents = studentRepo.findALlStudensWithNegativeGrades();
         negativeStudents.forEach(System.out::print);
    }

    @Override
    public void addSubscriber(ISubscriberInterface sub) {
        this.subscriber = sub;
    }
}
