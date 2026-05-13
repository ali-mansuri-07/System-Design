package com.prototypedesignpattern.withprototypedesignpattern;
import java.util.ArrayList;
import java.util.List;

// StudentProfile.java
class StudentProfile implements Prototype<StudentProfile> {

    private String       name;
    private String       college;
    private String       course;
    private String       city;
    private int          yearOfStudy;
    List<String> subjects;   // mutable — needs deep copy!

    // Full constructor
    public StudentProfile(String name, String college, String course,
                          String city, int yearOfStudy, List<String> subjects) {
        this.name        = name;
        this.college     = college;
        this.course      = course;
        this.city        = city;
        this.yearOfStudy = yearOfStudy;
        this.subjects    = new ArrayList<>(subjects); // deep copy
    }

    // Private copy constructor — used internally by clone()
    private StudentProfile(StudentProfile source) {
        this.name        = source.name;
        this.college     = source.college;
        this.course      = source.course;
        this.city        = source.city;
        this.yearOfStudy = source.yearOfStudy;
        this.subjects    = new ArrayList<>(source.subjects); // deep copy!
    }

    // clone() — returns a deep copy
    @Override
    public StudentProfile clone() {
        return new StudentProfile(this);  // uses copy constructor
    }

    // Setters — to change only what differs in the clone
    public void setName(String name)             { this.name = name; }
    public void setYearOfStudy(int yearOfStudy)  { this.yearOfStudy = yearOfStudy; }
    public void addSubject(String subject)        { this.subjects.add(subject); }
    public void setCollege(String college)        { this.college = college; }

    @Override
    public String toString() {
        return "StudentProfile {" +
               "\n  name        = " + name +
               "\n  college     = " + college +
               "\n  course      = " + course +
               "\n  city        = " + city +
               "\n  yearOfStudy = " + yearOfStudy +
               "\n  subjects    = " + subjects +
               "\n}";
    }
}