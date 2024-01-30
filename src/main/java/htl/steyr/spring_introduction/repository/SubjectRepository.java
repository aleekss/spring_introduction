package htl.steyr.spring_introduction.repository;

import htl.steyr.spring_introduction.model.SchoolClass;
import htl.steyr.spring_introduction.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
