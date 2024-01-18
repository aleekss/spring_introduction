package htl.steyr.spring_introduction.controller;

import htl.steyr.spring_introduction.model.ISubscriberInterface;
import htl.steyr.spring_introduction.model.PublisherInterface;
import htl.steyr.spring_introduction.model.SchoolClass;
import htl.steyr.spring_introduction.repository.SchoolClassRepository;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

@Component
public class ClassController implements PublisherInterface {
    public TextField classTextField;

    ISubscriberInterface subscriber;

    private final SchoolClassRepository classRepository;


    public ClassController(SchoolClassRepository classRepository) {
        this.classRepository = classRepository;

    }



    public void cancelClicked(ActionEvent actionEvent) {
        closeWindow(actionEvent);

    }

    public void saveClicked(ActionEvent actionEvent) {

        SchoolClass s = new SchoolClass(classTextField.getText());

        this.classRepository.save(s);

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
}
