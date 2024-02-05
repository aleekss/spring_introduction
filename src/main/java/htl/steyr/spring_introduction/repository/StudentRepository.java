package htl.steyr.spring_introduction.repository;

import htl.steyr.spring_introduction.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findAllByFirstname(String firstname);

    List<Student> findAllByLastname(String lastname);

    List<Student> findAllByFirstnameAndLastname(String firstname, String lastname);
    @Query(nativeQuery = true,
            value = """
        SELECT distinct s.* from astokani_student s 
        inner join astokani_exam e on (e.student_id = s.id)
        where e.grade >= 5 group by s.id having count (*) >= 2
                """)

    List<Student> findALlStudensWithNegativeGrades();

    @Query(value = """
    select s from Student s inner join Exam e on (e.student = s)
    where e.grade >= 5
    group by s.id
    having count(*) >= 2
""")
    List<Student> findALlStudensWithNegativeGradesJPQL();

    /**
     * Schreiben Sie ein JPQL Query, welches alle Schüler liefert, die noch keine Prüfung zugeordnet haben
     */






}
