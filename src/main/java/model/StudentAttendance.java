package model;

public class StudentAttendance {
    private String name;
    private String rollno;
    private String attendance;
    private String date;

    public StudentAttendance(String name, String rollno, String attendance, String date) {
        this.name = name;
        this.rollno = rollno;
        this.attendance = attendance;
        this.date = date;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}