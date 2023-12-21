package htl.steyr.spring_introduction;

import htl.steyr.spring_introduction.model.Student;
import htl.steyr.spring_introduction.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringIntroductionApplication implements CommandLineRunner {

    /**
     * SpringBoot injects an instance of the StudentRepository -
     * class into our repo - variable.
     */

    @Autowired
    private StudentRepository repo;

    public static void main(String[] args) {
        SpringApplication.run(SpringIntroductionApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        /**
//         * Create 2 student - instances
//         */
//
//        Student s1 = new Student("Aleks", "Stokanic");
//        Student s2 = new Student("Heinz", "Schweiger");
//
//
//        /**
//         * Store each object into the database
//         */
//
//        repo.save(s1);
//        repo.save(s2);

        List<Student> students = repo.findAll();
        System.out.println(students);


//        for(Student s : students){
//            if (s.getLastname().equals("Schweiger")){
//                s.setLastname("Murauer");
//
//                repo.save(s);
//
//            }
//        }

        List<Student> myList = repo.findAllByFirstname("Heinz");
           for(Student s : myList){
            System.out.println(s);

            }

       myList = repo.findAllByLastname("Stokanic");
        for(Student s : myList){
            System.out.println(s);

        }

        myList = repo.findAllByFirstnameAndLastname("Aleks" , "Stokanic");
        for(Student s : myList){
            System.out.println(s);

        }
       }

    }

