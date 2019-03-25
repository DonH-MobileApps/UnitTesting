package com.example.employeedatabase;

import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;

public class Employee implements Parcelable {
    private String employeeName;
    private String employeeBirthday;
    private String employeeWage;
    private String employeeHireDate;
    private Image employeeImage;
    private int employeeId;

    protected Employee(Parcel in) {
        employeeName = in.readString();
        employeeBirthday = in.readString();
        employeeWage = in.readString();
        employeeHireDate = in.readString();
        employeeId = in.readInt();
    }

    public Employee(String employeeName, String employeeBirthday,
                    String employeeWage, String employeeHireDate, int employeeId) {
        this.employeeName = employeeName;
        this.employeeBirthday = employeeBirthday;
        this.employeeWage = employeeWage;
        this.employeeHireDate = employeeHireDate;
        this.employeeImage = employeeImage;
        this.employeeId = employeeId;
    }



    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(employeeName);
        dest.writeString(employeeBirthday);
        dest.writeString(employeeWage);
        dest.writeString(employeeHireDate);
        dest.writeInt(employeeId);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Employee> CREATOR = new Creator<Employee>() {
        @Override
        public Employee createFromParcel(Parcel in) {
            return new Employee(in);
        }

        @Override
        public Employee[] newArray(int size) {
            return new Employee[size];
        }
    };

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(String employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeWage() {
        return employeeWage;
    }

    public void setEmployeeWage(String employeeWage) {
        this.employeeWage = employeeWage;
    }

    public String getEmployeeHireDate() {
        return employeeHireDate;
    }

    public void setEmployeeHireDate(String employeeHireDate) {
        this.employeeHireDate = employeeHireDate;
    }

    public Image getEmployeeImage() {
        return employeeImage;
    }

    public void setEmployeeImage(Image employeeImage) {
        this.employeeImage = employeeImage;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}
