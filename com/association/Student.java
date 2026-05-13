package com.association;

class Student {
    String name;
    Student(String name) { this.name = name; }


    void learn() {
        System.out.println(name + " is learning");
    }
}


class Teacher {
    String name;
    Teacher(String name) { this.name = name; }


    // Teacher uses a Student — but does NOT own them
    void teach(Student student) {
        System.out.println(name + " is teaching " + student.name);
        student.learn();
    }
}
