package com.example.employeedatabase;

import android.util.Log;

import java.util.Locale;

public class EmployeeDataContract {

    public static final String DATABASE_NAME = "employee_db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "Employees";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_BIRTHDAY = "Birthday";
    public static final String COLUMN_WAGE = "Wage";
    public static final String COLUMN_HIRE_DATE = "Hire_Date";
    public static final String COLUMN_ID = "id";


    public static String createQuery() {
        StringBuilder queryBuilder = new StringBuilder();

        queryBuilder.append("CREATE_TABLE ");
        queryBuilder.append(TABLE_NAME);
        queryBuilder.append(" (");
        queryBuilder.append(COLUMN_ID);
        queryBuilder.append(" ");
        queryBuilder.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
        queryBuilder.append(COLUMN_NAME);
        queryBuilder.append(" TEXT, ");
        queryBuilder.append(COLUMN_BIRTHDAY);
        queryBuilder.append(" TEXT, ");
        queryBuilder.append(COLUMN_WAGE);
        queryBuilder.append(" TEXT, ");
        queryBuilder.append(COLUMN_HIRE_DATE);
        queryBuilder.append(" TEXT, ");

        Log.d("TAG", "createQuery(): " + queryBuilder.toString());

        return queryBuilder.toString();


    }

    public static String getAllEmployeesQuery() {
        return "SELECT * FROM " + TABLE_NAME;

    }


    public static String getOneEmployeeById(int id) {

        return String.format("SELECT * FROM %s WHERE %s = \"%d\"", TABLE_NAME, COLUMN_ID, id);
    }

    public static String getWhereClauseById() {
        return String.format(Locale.US, "%s = ", COLUMN_ID);

    }
}
