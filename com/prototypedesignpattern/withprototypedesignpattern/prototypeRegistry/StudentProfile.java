package com.prototypedesignpattern.withprototypedesignpattern.prototypeRegistry;

import java.util.ArrayList;
import java.util.List;

class StudentProfile {

    private String name;
    private String college;
    private String course;
    private String city;
    private int yearOfStudy;
    List<String> subjects;

    // Full constructor
    public StudentProfile(String name, String college, String course,
            String city, int yearOfStudy, List<String> subjects) {
        this.name = name;
        this.college = college;
        this.course = course;
        this.city = city;
        this.yearOfStudy = yearOfStudy;
        this.subjects = new ArrayList<>(subjects); // deep copy on construction
    }

    // Private copy constructor — used by clone()
    private StudentProfile(StudentProfile source) {
        this.name        = source.name;
        this.college     = source.college;
        this.course      = source.course;
        this.city        = source.city;
        this.yearOfStudy = source.yearOfStudy;
        this.subjects    = new ArrayList<>(source.subjects); // deep copy!
    }

    // clone() — explicitly cast to StudentProfile, no type mismatch
    @Override
    public StudentProfile clone() {
        return new StudentProfile(this); // uses copy constructor, not super.clone()
    }

    // Setters
    public void setName(String name)            { this.name = name; }
    public void setCollege(String college)      { this.college = college; }
    public void setCourse(String course)        { this.course = course; }
    public void setCity(String city)            { this.city = city; }
    public void setYearOfStudy(int year)        { this.yearOfStudy = year; }
    public void addSubject(String subject)      { this.subjects.add(subject); }

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