package htl.steyr.spring_introduction.model;

import jakarta.persistence.*;

import java.util.List;


@Entity
    @Table(name = "astokani_schoolclass")
    public class SchoolClass{

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name="class_name")
        private String name;


       @OneToMany(mappedBy = "schoolClass")
    private List<Student> students;


    }

