package htl.steyr.spring_introduction.repository;

import htl.steyr.spring_introduction.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findAllByFirstname(String firstname);

    List<Student> findAllByLastname(String lastname);

    List<Student> findAllByFirstnameAndLastname(String firstname, String lastname);





}
