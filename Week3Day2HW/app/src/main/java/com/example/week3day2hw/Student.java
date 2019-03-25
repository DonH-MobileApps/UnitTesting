package com.example.week3day2hw;

import android.os.Parcel;
import android.os.Parcelable;

public class Student implements Parcelable {
    private String studentId;
    private String studentName;
    private String studentMajor;
    private String studentMinor;
    private String studentGradYear;
    private String studentGPA;
    private String studentCompletedHrs;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentMajor() {
        return studentMajor;
    }

    public void setStudentMajor(String studentMajor) {
        this.studentMajor = studentMajor;
    }

    public String getStudentMinor() {
        return studentMinor;
    }

    public void setStudentMinor(String studentMinor) {
        this.studentMinor = studentMinor;
    }

    public String getStudentGradYear() {
        return studentGradYear;
    }

    public void setStudentGradYear(String studentGradYear) {
        this.studentGradYear = studentGradYear;
    }

    public String getStudentGPA() {
        return studentGPA;
    }

    public void setStudentGPA(String studentGPA) {
        this.studentGPA = studentGPA;
    }

    public String getStudentCompletedHrs() {
        return studentCompletedHrs;
    }

    public void setStudentCompletedHrs(String studentCompletedHrs) {
        this.studentCompletedHrs = studentCompletedHrs;
    }

    public Student (){}

    public Student(String studentId, String studentName, String studentMajor, String studentMinor,
                   String studentGradYear, String studentGPA, String studentCompletedHrs){

        this.studentId = studentId;
        this.studentName = studentName;
        this.studentMajor = studentMajor;
        this.studentMinor = studentMinor;
        this.studentGradYear = studentGradYear;
        this.studentGPA = studentGPA;
        this.studentCompletedHrs = studentCompletedHrs;
    }


    protected Student(Parcel in) {
        studentId = in.readString();
        studentName = in.readString();
        studentMajor = in.readString();
        studentMinor = in.readString();
        studentGradYear = in.readString();
        studentGPA = in.readString();

        studentCompletedHrs = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentMajor='" + studentMajor + '\'' +
                ", studentMinor='" + studentMinor + '\'' +
                ", studentGradYear='" + studentGradYear + '\'' +
                ", studentGPA='" + studentGPA + '\'' +
                ", studentCompletedHrs='" + studentCompletedHrs + '\'' +
                '}';
    }
}
