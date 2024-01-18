package htl.steyr.spring_introduction.repository;

import htl.steyr.spring_introduction.model.SchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolClassRepository extends JpaRepository<SchoolClass, Long> {
}
