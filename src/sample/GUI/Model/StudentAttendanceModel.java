package sample.GUI.Model;

import sample.BE.Student;

public class StudentAttendanceModel {

    private static StudentAttendanceModel instance = null;

    private StudentAttendanceModel() {
    }

    public static StudentAttendanceModel getInstance() {
        if (instance == null)
            instance = new StudentAttendanceModel();

        return instance;
    }

    public Student getLoggedInStudent() {
        return loggedInStudent;
    }


    public void setLoggedInStudent(Student loggedInStudent) {
        this.loggedInStudent = loggedInStudent;
    }

    private Student loggedInStudent = null;

}
