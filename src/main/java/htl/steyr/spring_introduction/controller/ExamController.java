package htl.steyr.spring_introduction.controller;

import htl.steyr.spring_introduction.model.*;
import htl.steyr.spring_introduction.repository.ExamRepository;
import htl.steyr.spring_introduction.repository.StudentRepository;
import htl.steyr.spring_introduction.repository.SubjectRepository;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;

@Component
public class ExamController implements Initializable, PublisherInterface {

private final ExamRepository examRepository;
    public ComboBox<Subject> subjectComboBox;
    public ComboBox<Student> studentComboBox;
    public DatePicker datePicker;
    public Spinner<Integer> gradeSpinner;
    private ISubscriberInterface subscriber = null;
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;
    public ExamController(ExamRepository examRepository, StudentRepository studentRepository, SubjectRepository subjectRepository) {
        this.examRepository = examRepository;
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
    }




    public void cancelClicked(ActionEvent actionEvent) {

        closeWindow(actionEvent);
    }

    public void saveClicked(ActionEvent actionEvent) {
        Subject selSubject = subjectComboBox.getValue();
        Student selStudent = studentComboBox.getValue();
        LocalDate selDate = datePicker.getValue();
        int grade = gradeSpinner.getValue();

        Exam e = new Exam();
        e.setGrade(grade);
        e.setDate(LocalDate.from(Date.from(selDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()).toInstant()));
        e.setStudent(selStudent);
        e.getSubject(selSubject);



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
