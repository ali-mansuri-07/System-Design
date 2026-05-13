package com.builderdesignpattern.staticinnerbuilder;

// Student.java — Product class
public class Student {

    // Fields — some mandatory, some optional
    private final String name;      // mandatory
    private final int age;          // mandatory
    private final String email;     // optional
    private final String phone;     // optional
    private final String address;   // optional
    private final String course;    // optional

    // Private constructor — ONLY Builder can call this
    private Student(Builder builder) {
        this.name    = builder.name;
        this.age     = builder.age;
        this.email   = builder.email;
        this.phone   = builder.phone;
        this.address = builder.address;
        this.course  = builder.course;
    }

    // Getters — no setters (immutable after build)
    public String getName()    { return name; }
    public int    getAge()     { return age; }
    public String getEmail()   { return email; }
    public String getPhone()   { return phone; }
    public String getAddress() { return address; }
    public String getCourse()  { return course; }

    @Override
    public String toString() {
        return "Student {" +
               "\n  name    = " + name +
               "\n  age     = " + age +
               "\n  email   = " + (email   != null ? email   : "N/A") +
               "\n  phone   = " + (phone   != null ? phone   : "N/A") +
               "\n  address = " + (address != null ? address : "N/A") +
               "\n  course  = " + (course  != null ? course  : "N/A") +
               "\n}";
    }

    // ── Static Inner Builder ─────────────────────────────────
    public static class Builder {

        // Mandatory fields — set via constructor
        private final String name;
        private final int age;

        // Optional fields — default to null
        private String email   = null;
        private String phone   = null;
        private String address = null;
        private String course  = null;

        // Mandatory fields passed in Builder's constructor
        public Builder(String name, int age) {
            if (name == null || name.isEmpty())
                throw new IllegalArgumentException("Name is mandatory!");
            if (age <= 0)
                throw new IllegalArgumentException("Age must be positive!");
            this.name = name;
            this.age  = age;
        }

        // Each optional setter returns 'this' — enables chaining
        public Builder setEmail(String email) {
            this.email = email;
            return this;       // ← key: returns Builder not void
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setCourse(String course) {
            this.course = course;
            return this;
        }

        // Final step — validates and creates the Student object
        public Student build() {
            return new Student(this);
        }
    }
}