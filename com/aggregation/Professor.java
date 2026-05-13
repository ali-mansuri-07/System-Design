package com.aggregation;

import java.util.ArrayList;
import java.util.List;

class Professor {
    String name;
    Professor(String name) { this.name = name; }
    void teach() {
        System.out.println(name + " is teaching");
    }
}
class Department {
    String name;
    List<Professor> professors;   // Department HAS professors
    Department(String name) {
        this.name = name;
        this.professors = new ArrayList<>();
    }
    void addProfessor(Professor p) {
        professors.add(p);      // Professor created OUTSIDE, passed in
    }
}

