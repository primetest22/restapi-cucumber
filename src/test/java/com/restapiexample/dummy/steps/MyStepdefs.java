package com.restapiexample.dummy.steps;

import com.restapiexample.dummy.employeeinfo.EmployeeSteps;
import com.restapiexample.dummy.model.EmployeePojo;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

public class MyStepdefs {

    static ValidatableResponse response;

    @Steps
    EmployeeSteps employeeSteps;

    @When("^User send GET request to employee endpoint$")
    public void userSendGETRequestToEmployeeEndpoint() {
        response = employeeSteps.getAllEmployee();
    }

    @Then("^User should see status code (\\d+)$")
    public void userShouldSeeStatusCode(int code) {
        response.statusCode(code).log().all();
    }

    @When("^User send GET request to employee endpoint where id is (\\d+)$")
    public void userSendGETRequestToEmployeeEndpointWhereIdIs(int id) {
        String actual = "Successfully! Record has been fetched.";
        response = employeeSteps.getEmployeeWithId(id);
    }

    @When("^user send POST request with name \"([^\"]*)\" salary \"([^\"]*)\" age \"([^\"]*)\"$")
    public void userSendPOSTRequestWithNameSalaryAge(String name, String salary, String age)  {
        response = employeeSteps.createEmployee(name,salary,age);

    }

    @When("^User send PATCH request with name \"([^\"]*)\" id (\\d+)$")
    public void userSendPATCHRequestWithNameId(String name, int id){
         response = employeeSteps.updateEmployee(name,id);
    }
}
