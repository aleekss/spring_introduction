package htl.steyr.spring_introduction.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "astokani_student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name= "firstname", nullable = false)
    private String firstname;
    @Column(name= "lastname", nullable = false)
    private String lastname;

    @Column(name ="graduation_year", nullable = true)
    private Integer graduationYear;

    @ManyToOne
    @JoinColumn(name = "school_class_id")
    private SchoolClass schoolClass;

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Exam> exams;

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }

    public Student(){
        //Empty Constructor is REQUIRED
    }
    public Student(String firstname, String lastname, int graduationYear) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.graduationYear = graduationYear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(Integer graduationYear) {
        this.graduationYear = graduationYear;
    }

    @Override
    public String toString() {
        return getFirstname() + " " + getLastname();
    }
}
