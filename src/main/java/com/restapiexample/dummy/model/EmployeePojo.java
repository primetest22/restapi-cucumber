package com.restapiexample.dummy.model;

import io.restassured.response.ValidatableResponse;

public class EmployeePojo {

    private String name;
    private String salary;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public static EmployeePojo getEmployee(String name,String salary,String age){
        EmployeePojo employeePojo = new EmployeePojo();
        employeePojo.setName(name);
        employeePojo.setSalary(salary);
        employeePojo.setAge(age);
        return employeePojo;

    }

    public static EmployeePojo updateEmployee(String name){
        EmployeePojo employeePojo = new EmployeePojo();
        employeePojo.setName(name);
        return employeePojo;
    }
}
