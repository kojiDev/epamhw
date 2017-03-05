package com.kojidev.epamhw.unit2;

import lombok.ToString;

import java.util.HashSet;
import java.util.Set;


@ToString
public class Course<T extends Student> {

    private final String title;
    private final GradeSystem gradeSystem;
    private final Set<T> students = new HashSet<>();

    Course(String title, GradeSystem gradeSystem) {
        this.title = title;
        this.gradeSystem = gradeSystem;
    }

    public void add(T student) {
        students.add(student);
    }

    public Set<T> getStudents() {
        return students;
    }

}
