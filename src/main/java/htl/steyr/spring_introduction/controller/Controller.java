package htl.steyr.spring_introduction.controller;

import htl.steyr.spring_introduction.JavaFxApplication;
import htl.steyr.spring_introduction.model.ISubscriberInterface;
import htl.steyr.spring_introduction.model.PublisherInterface;
import htl.steyr.spring_introduction.model.SchoolClass;
import htl.steyr.spring_introduction.model.Student;
import htl.steyr.spring_introduction.repository.SchoolClassRepository;
import htl.steyr.spring_introduction.repository.StudentRepository;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.List;
import java.util.ResourceBundle;

@Component
public class Controller implements Initializable {

    private StudentRepository studentRepository;

    private SchoolClassRepository schoolClassRepository;

 @FXML
 private ListView<SchoolClass> schoolClassListView;

    @FXML
    private ListView<Student> studentListView;


    public Controller(StudentRepository studentRepository, SchoolClassRepository schoolClassRepository) {
        this.studentRepository = studentRepository;
        this.schoolClassRepository = schoolClassRepository;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        schoolClassListView.getItems().addAll(schoolClassRepository.findAll());
    }

    public void schoolClassListViewClicked(MouseEvent mouseEvent) {
        studentListView.getItems().clear();

        SchoolClass c = schoolClassListView.getSelectionModel().getSelectedItem();

        if (c != null){

            studentListView.getItems().addAll(c.getStudents());
        }
    }

    public void manageClasses(ActionEvent actionEvent) throws IOException {
        ISubscriberInterface sub = () -> {
            schoolClassListView.getItems().clear();
            schoolClassListView.getItems().addAll(schoolClassRepository.findAll());

        };

        FXMLLoader loader = new FXMLLoader(getClass().getResource("edit_class.fxml"));
        loader.setControllerFactory(JavaFxApplication.getSpringContext()::getBean);
        PublisherInterface controller = loader.getController();
        controller.addSubscriber(sub);

        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void manageStudents(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("edit_student.fxml"));
        loader.setControllerFactory(JavaFxApplication.getSpringContext()::getBean);

        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }






/*
    public void onButtonClick(ActionEvent actionEvent) {

  List<Student> students = studentRepository.findAll();

  for (Student s: students){
      System.out.println(s);
  }

    }

 */
}
