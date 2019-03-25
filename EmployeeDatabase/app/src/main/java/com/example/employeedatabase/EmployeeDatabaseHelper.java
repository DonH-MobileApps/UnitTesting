package com.example.employeedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;

import static com.example.employeedatabase.EmployeeDataContract.COLUMN_BIRTHDAY;
import static com.example.employeedatabase.EmployeeDataContract.COLUMN_HIRE_DATE;
import static com.example.employeedatabase.EmployeeDataContract.COLUMN_ID;
import static com.example.employeedatabase.EmployeeDataContract.COLUMN_NAME;
import static com.example.employeedatabase.EmployeeDataContract.COLUMN_WAGE;
import static com.example.employeedatabase.EmployeeDataContract.DATABASE_NAME;
import static com.example.employeedatabase.EmployeeDataContract.DATABASE_VERSION;
import static com.example.employeedatabase.EmployeeDataContract.TABLE_NAME;
import static com.example.employeedatabase.EmployeeDataContract.getWhereClauseById;

public class EmployeeDatabaseHelper extends SQLiteOpenHelper {

    public EmployeeDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(EmployeeDataContract.createQuery());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);

    }

    public long insertEmployeeIntoDatabase(@NonNull Employee employee) {

        SQLiteDatabase writableDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_NAME, employee.getEmployeeName());
        contentValues.put(COLUMN_BIRTHDAY, employee.getEmployeeBirthday());
        contentValues.put(COLUMN_WAGE, employee.getEmployeeWage());
        contentValues.put(COLUMN_WAGE, employee.getEmployeeWage());

        return writableDatabase.insert(TABLE_NAME, null, contentValues);
    }

    public ArrayList<Employee> getAllEmployeesFromDatabase() {
        ArrayList<Employee> returnEmployeeList = new ArrayList<>();
        SQLiteDatabase readableDatabase = this.getReadableDatabase();

        Cursor cursor = readableDatabase.rawQuery(EmployeeDataContract.getAllEmployeesQuery(), null);

        if (cursor.moveToFirst()) {

            do{
                int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                String birthday = cursor.getString(cursor.getColumnIndex(COLUMN_BIRTHDAY));
                String wage = cursor.getString(cursor.getColumnIndex(COLUMN_WAGE));
                String hireDate = cursor.getString(cursor.getColumnIndex(COLUMN_HIRE_DATE));

                returnEmployeeList.add(new Employee(name,birthday,wage,hireDate,id));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return returnEmployeeList;

    }

    public Employee getEmployeeById(int id) {
        SQLiteDatabase readableDatabase = this.getReadableDatabase();

        Employee returnEmployee = new Employee();

        Cursor cursor = readableDatabase.rawQuery(EmployeeDataContract.getOneEmployeeById(id), null);
        if (cursor.moveToFirst()) {

            int idFromDB = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
            String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
            String birthday = cursor.getString(cursor.getColumnIndex(COLUMN_BIRTHDAY));
            String wage = cursor.getString(cursor.getColumnIndex(COLUMN_WAGE));
            String hireDate = cursor.getString(cursor.getColumnIndex(COLUMN_HIRE_DATE));

            returnEmployee  = new Employee(name,birthday,wage,hireDate,idFromDB);
        }

        cursor.close();
        return returnEmployee;
    }

    public long updateEmployeeInDatabase(@NonNull Employee newEmployeeInfo) {
        SQLiteDatabase writableDatabase = this.getWritableDatabase();

        ContentValues contentValues =  new ContentValues();

        contentValues.put(COLUMN_NAME, newEmployeeInfo.getEmployeeName());
        contentValues.put(COLUMN_BIRTHDAY, newEmployeeInfo.getEmployeeBirthday());
        contentValues.put(COLUMN_WAGE, newEmployeeInfo.getEmployeeWage());
        contentValues.put(COLUMN_HIRE_DATE, newEmployeeInfo.getEmployeeHireDate());

        return writableDatabase.update(TABLE_NAME,
                contentValues, getWhereClauseById(),
                new String[] {String.valueOf(newEmployeeInfo.getEmployeeId())});

    }

    public long deleteDromDatabaseById(String[] id) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
       return sqLiteDatabase.delete(TABLE_NAME, getWhereClauseById() + id[0],null);
    }

}
