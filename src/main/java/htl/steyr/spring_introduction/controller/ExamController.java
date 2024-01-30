package htl.steyr.spring_introduction.controller;

import htl.steyr.spring_introduction.model.*;
import htl.steyr.spring_introduction.repository.SchoolClassRepository;
import htl.steyr.spring_introduction.repository.StudentRepository;
import htl.steyr.spring_introduction.repository.SubjectRepository;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@Component
public class ExamController implements Initializable, PublisherInterface {


    public ComboBox<Subject> subjectComboBox;
    public ComboBox<Student> studentComboBox;
    public DatePicker datePicker;
    public Spinner<Integer> gradeSpinner;
    private ISubscriberInterface subscriber = null;
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;
    public ExamController(StudentRepository studentRepository, SubjectRepository subjectRepository) {
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
    }




    public void cancelClicked(ActionEvent actionEvent) {

        closeWindow(actionEvent);
    }

    public void saveClicked(ActionEvent actionEvent) {

    }

    private void closeWindow (ActionEvent e){
        Button button = (Button)(e.getSource());
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        subjectComboBox.getItems().addAll(subjectRepository.findAll());
        studentComboBox.getItems().addAll(studentRepository.findAll());

        gradeSpinner.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1,5)
        );

    }

    @Override
    public void addSubscriber(ISubscriberInterface sub) {
        this.subscriber = sub;
    }
}
