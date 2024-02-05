package htl.steyr.spring_introduction.controller;

import htl.steyr.spring_introduction.model.ISubscriberInterface;
import htl.steyr.spring_introduction.model.PublisherInterface;
import htl.steyr.spring_introduction.model.SchoolClass;
import htl.steyr.spring_introduction.repository.SchoolClassRepository;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class ClassController implements Initializable, PublisherInterface {
    public TextField classTextField;

    ISubscriberInterface subscriber;

    private final SchoolClassRepository classRepository;

    private ISubscriberInterface iSubscriberInterface = null;


    public ClassController(SchoolClassRepository classRepository) {
        this.classRepository = classRepository;

    }



    public void cancelClicked(ActionEvent actionEvent) {
        closeWindow(actionEvent);

    }

    public void saveClicked(ActionEvent actionEvent) {

        SchoolClass sc = new SchoolClass(classTextField.getText());

        this.classRepository.save(sc);

        this.subscriber.triggerAction();

        closeWindow(actionEvent);


    }

    private void closeWindow(ActionEvent e){
        Button button = (Button)(e.getSource());
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
    }

    @Override
    public void addSubscriber(ISubscriberInterface sub) {
        this.subscriber = sub;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
