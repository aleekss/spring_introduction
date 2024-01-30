package htl.steyr.spring_introduction.controller;

import htl.steyr.spring_introduction.model.ISubscriberInterface;
import htl.steyr.spring_introduction.model.PublisherInterface;
import htl.steyr.spring_introduction.model.SchoolClass;
import htl.steyr.spring_introduction.model.Subject;
import htl.steyr.spring_introduction.repository.SchoolClassRepository;
import htl.steyr.spring_introduction.repository.SubjectRepository;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

@Component
public class SubjectController implements PublisherInterface {
    public TextField subjectNameTextFiled;

    ISubscriberInterface subscriber = null;

    private final SubjectRepository subjectRepository;


    public SubjectController(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;

    }



    public void cancelClicked(ActionEvent actionEvent) {
        closeWindow(actionEvent);

    }

    public void saveClicked(ActionEvent actionEvent) {




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
