package htl.steyr.spring_introduction.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "astokani_examclass")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "exam_grade")
    private Integer grade;


    @Column(name = "exam_date", nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name= "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name= "subject_id")
    private Subject subject;

    public Exam(Integer grade, Date date, Student student, Subject subject) {
        this.grade = grade;
        this.date = date;
        this.student = student;
        this.subject = subject;
    }

    public Exam() {
    }


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject(Subject selSubject) {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Date getDate() {
        return date;
    }


    public void setDate(LocalDate from) {
    }
}
