package htl.steyr.spring_introduction.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
    @Table(name = "astokani_schoolclass")
    public class SchoolClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "class_name")
    private String name;


    /*
     * mappedBy: name of the variable located in the Student class
     * orphanRemoval: first: delete all students for this class, when finished: delete the class (manually)
     * cascade: "Löschweitergabe": uses cascade delete feature of the database
     */
    @OneToMany(mappedBy = "schoolClass", orphanRemoval = true, cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private List<Student> students;

    public SchoolClass(String name) {
        this.name = name;
    }

    public SchoolClass() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        if (students == null) {
            students = new ArrayList<>();
        }
        return students;
    }

    @Override
    public String toString() {
        return this.getName();
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}

