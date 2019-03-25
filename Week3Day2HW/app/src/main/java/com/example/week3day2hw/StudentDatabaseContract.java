package com.example.week3day2hw;

import android.util.Log;

import java.util.Locale;

public class StudentDatabaseContract {
    public static final String DATABASE_NAME = "student_db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "students";
    public static final String COLUMN_STUDENT_ID = "studentId";
    public static final String COLUMN_STUDENT_NAME = "studentName";
    public static final String COLUMN_STUDENT_MAJOR = "studentMajor";
    public static final String COLUMN_STUDENT_MINOR = "studentMinor";
    public static final String COLUMN_STUDENT_GRAD_YEAR = "studentGradYear";
    public static final String COLUMN_STUDENT_GPA = "studentGPA";
    public static final String COLUMN_STUDENT_COMPLETED_HRS = "studentCompletedHrs";
    public static final String COLUMN_ID = "id";


    public static String createQuery() {
        StringBuilder queryBuilder = new StringBuilder();

        queryBuilder.append("CREATE TABLE ");
        queryBuilder.append(TABLE_NAME);
        queryBuilder.append(" (");
        queryBuilder.append(COLUMN_ID);
        queryBuilder.append(" ");
        queryBuilder.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
        queryBuilder.append(COLUMN_STUDENT_ID);
        queryBuilder.append(" TEXT, ");
        queryBuilder.append(COLUMN_STUDENT_NAME);
        queryBuilder.append(" TEXT, ");
        queryBuilder.append(COLUMN_STUDENT_MAJOR);
        queryBuilder.append(" TEXT, ");
        queryBuilder.append(COLUMN_STUDENT_MINOR);
        queryBuilder.append(" TEXT, ");
        queryBuilder.append(COLUMN_STUDENT_GRAD_YEAR);
        queryBuilder.append(" TEXT, ");
        queryBuilder.append(COLUMN_STUDENT_GPA);
        queryBuilder.append(" TEXT, ");
        queryBuilder.append(COLUMN_STUDENT_COMPLETED_HRS);
        queryBuilder.append(" TEXT, ");


        Log.d("TAG", "createQuery: " + queryBuilder.toString());

        return queryBuilder.toString();


    }

    public static String getAllStudentsQuery() {
        return "SELECT * FROM " + TABLE_NAME;

    }

    public static String getOneStudentById(int id) {
        return String.format("SELECT * FROM %s WHERE %s = \"%D\"", TABLE_NAME, COLUMN_ID, id);

    }

    public static String getWhereClauseById() {
        return String.format(Locale.US, "%s = ", COLUMN_ID);

    }

}
