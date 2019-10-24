package org.lrd.demokotlin.cucumbertest.stepdefinitions

import cucumber.api.java.en.Then
import org.junit.Assert

class ResponseValidator : BaseTestClass() {

    @Then("the http response code must be 200")
    fun validateResponseCode200OK() {
        Assert.assertEquals(200, response?.code())
    }

    @Then("the {string} {string} must be retrieved")
    fun validateGetCustomerResponseMessage(firstName : String, lastName : String) {
        Assert.assertEquals(response?.body()?.string(), "{\"firstName\":\"$firstName\",\"lastName\":\"$lastName\"}")
    }

}