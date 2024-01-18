package htl.steyr.spring_introduction;

import htl.steyr.spring_introduction.model.SchoolClass;
import htl.steyr.spring_introduction.model.Student;
import htl.steyr.spring_introduction.repository.SchoolClassRepository;
import htl.steyr.spring_introduction.repository.StudentRepository;
import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringIntroductionApplication {



    public static void main(String[] args) {
        Application.launch(JavaFxApplication.class, args);

    }

    }

