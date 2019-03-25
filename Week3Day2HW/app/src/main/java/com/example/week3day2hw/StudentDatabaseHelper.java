package com.example.week3day2hw;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;

import static com.example.week3day2hw.StudentDatabaseContract.COLUMN_ID;
import static com.example.week3day2hw.StudentDatabaseContract.COLUMN_STUDENT_COMPLETED_HRS;
import static com.example.week3day2hw.StudentDatabaseContract.COLUMN_STUDENT_GPA;
import static com.example.week3day2hw.StudentDatabaseContract.COLUMN_STUDENT_GRAD_YEAR;
import static com.example.week3day2hw.StudentDatabaseContract.COLUMN_STUDENT_ID;
import static com.example.week3day2hw.StudentDatabaseContract.COLUMN_STUDENT_MAJOR;
import static com.example.week3day2hw.StudentDatabaseContract.COLUMN_STUDENT_MINOR;
import static com.example.week3day2hw.StudentDatabaseContract.COLUMN_STUDENT_NAME;
import static com.example.week3day2hw.StudentDatabaseContract.DATABASE_NAME;
import static com.example.week3day2hw.StudentDatabaseContract.DATABASE_VERSION;
import static com.example.week3day2hw.StudentDatabaseContract.TABLE_NAME;
import static com.example.week3day2hw.StudentDatabaseContract.getWhereClauseById;

public class StudentDatabaseHelper extends SQLiteOpenHelper {
    public StudentDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insertStudentIntoDatabase(@NonNull Student student) {
        SQLiteDatabase writableDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_STUDENT_ID, student.getStudentId());
        contentValues.put(COLUMN_STUDENT_NAME, student.getStudentName());
        contentValues.put(COLUMN_STUDENT_MAJOR, student.getStudentMajor());
        contentValues.put(COLUMN_STUDENT_MINOR, student.getStudentGradYear());
        contentValues.put(COLUMN_STUDENT_GRAD_YEAR, student.getStudentGradYear());
        contentValues.put(COLUMN_STUDENT_GPA, student.getStudentGPA());
        contentValues.put(COLUMN_STUDENT_COMPLETED_HRS, student.getStudentCompletedHrs());

        return writableDatabase.insert(TABLE_NAME, null, contentValues);
    }



    public ArrayList<Student> getAllStudentFromDatabase() {
        ArrayList<Student> returnStudentList = new ArrayList<>();
        SQLiteDatabase readableDatabase = this.getReadableDatabase();
        Cursor cursor = readableDatabase.rawQuery(StudentDatabaseContract.getAllStudentsQuery());
                if(cursor.moveToFirst()) {
                    do {
                        int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                        String studentId = cursor.getString(cursor.getColumnIndex(COLUMN_STUDENT_ID));
                        String studentName = cursor.getString(cursor.getColumnIndex(COLUMN_STUDENT_NAME));
                        String studentMajor = cursor.getString(cursor.getColumnIndex(COLUMN_STUDENT_MAJOR));
                        String studentMinor = cursor.getString(cursor.getColumnIndex(COLUMN_STUDENT_MINOR));
                        String studentGradYear = cursor.getString(cursor.getColumnIndex(COLUMN_STUDENT_GRAD_YEAR));
                        String studentGPA = cursor.getString(cursor.getColumnIndex(COLUMN_STUDENT_GPA));
                        String studentCompletedHrs = cursor.getString(cursor.getColumnIndex(COLUMN_STUDENT_COMPLETED_HRS));

                        returnStudentList.add(new Student(studentId, studentName, studentMajor, studentMinor, studentGradYear,
                                studentGPA, studentCompletedHrs));
                    }while (cursor.moveToNext());

                    }
        cursor.close();
                return  returnStudentList;
    }

    public Student getStudentById(int id) {
        SQLiteDatabase readableDatabase = this.getReadableDatabase();

        Student returnStudent = new Student();

        Cursor cursor = readableDatabase.rawQuery(StudentDatabaseContract.getOneStudentById(id));
                if(cursor.moveToFirst()) {
                    int idFromDB = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                    String studentId = cursor.getString(cursor.getColumnIndex(COLUMN_STUDENT_ID));
                    String studentName = cursor.getString(cursor.getColumnIndex(COLUMN_STUDENT_NAME));
                    String studentMajor = cursor.getString(cursor.getColumnIndex(COLUMN_STUDENT_MAJOR));
                    String studentMinor = cursor.getString(cursor.getColumnIndex(COLUMN_STUDENT_MINOR));
                    String studentGradYear = cursor.getString(cursor.getColumnIndex(COLUMN_STUDENT_GRAD_YEAR));
                    String studentGPA = cursor.getString(cursor.getColumnIndex(COLUMN_STUDENT_GPA));
                    String studentCompletedYears = cursor.getString(cursor.getColumnIndex(COLUMN_STUDENT_COMPLETED_HRS));

                    returnStudent = new Student( studentId, studentName, studentMajor, studentMinor, studentGradYear,
                            studentGPA, studentCompletedYears);
                }

                cursor.close();
                return returnStudent;
        }

    public long updateStudentInDatabase(@NonNull Student newStudentInfo) {
        SQLiteDatabase writableDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_STUDENT_ID, newStudentInfo.getStudentId());
        contentValues.put(COLUMN_STUDENT_NAME, newStudentInfo.getStudentName());
        contentValues.put(COLUMN_STUDENT_MAJOR, newStudentInfo.getStudentMajor());
        contentValues.put(COLUMN_STUDENT_MINOR, newStudentInfo.getStudentMinor());
        contentValues.put(COLUMN_STUDENT_GRAD_YEAR, newStudentInfo.getStudentGradYear());
        contentValues.put(COLUMN_STUDENT_GPA, newStudentInfo.getStudentGPA());
        contentValues.put(COLUMN_STUDENT_COMPLETED_HRS, newStudentInfo.getStudentCompletedHrs());

        return writableDatabase.update(TABLE_NAME,
                contentValues,
                getWhereClauseById(),
                new String[]{String.valueOf(newStudentInfo.getStudentId())});
    }


}
