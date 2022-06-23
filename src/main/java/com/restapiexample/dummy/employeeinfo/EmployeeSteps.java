package com.restapiexample.dummy.employeeinfo;

import com.restapiexample.dummy.constants.Endpoints;
import com.restapiexample.dummy.constants.Path;
import com.restapiexample.dummy.model.EmployeePojo;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class EmployeeSteps {

    EmployeePojo employeePojo;

    @Step("Get all employee information")
    public ValidatableResponse getAllEmployee(){
     return SerenityRest.given().log().all()
               .when()
               .get(Endpoints.GET_ALL_EMPLOYEE)
               .then();
    }

    @Step("Get employee information with id 8")
    public ValidatableResponse getEmployeeWithId(int id){
        return SerenityRest.given().log().all()
                .pathParam("id",id)
                .when()
                .get(Endpoints.GET_SINGLE_EMPLOYEE)
                .then();
    }

    @Step("Add new employee to server")
    public ValidatableResponse createEmployee(String name,String salary,String age){
        EmployeePojo employeePojo = EmployeePojo.getEmployee(name,salary,age);
        return SerenityRest.given().log().all()
                .header("Content-Type","application/json")
                .body(employeePojo)
                .when()
                .post(Endpoints.CREATE_NEW_EMPLOYEE)
                .then();
    }
    @Step("Update the employee name with id")
    public ValidatableResponse updateEmployee(String name,int id){
        EmployeePojo employeePojo = EmployeePojo.updateEmployee(name);
        return SerenityRest.given().log().all()
                .pathParam("id",id)
                .header("Content-Type","application/json")
                .body(employeePojo)
                .when()
                .post(Endpoints.UPDATE_EMPLOYEE)
                .then();

    }

}
