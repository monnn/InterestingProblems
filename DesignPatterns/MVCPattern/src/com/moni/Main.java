package com.moni;

public class Main {

    public static void main(String[] args) {
        StudentView view = new StudentView();
        StudentModel model = retriveStudentFromDatabase();
        StudentController controller = new StudentController(model, view);
        controller.updateView();
        controller.setStudentName("John");
        controller.updateView();
    }

    private static StudentModel retriveStudentFromDatabase() {
        StudentModel student = new StudentModel();
        student.setName("Robert");
        student.setRollNo("10");
        return student;
    }
}
