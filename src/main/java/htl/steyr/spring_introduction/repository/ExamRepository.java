package htl.steyr.spring_introduction.repository;

import htl.steyr.spring_introduction.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExamRepository extends JpaRepository<Student, Long> {







}
