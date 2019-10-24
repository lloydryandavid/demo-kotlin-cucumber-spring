package org.lrd.demokotlin.cucumbertest.stepdefinitions


import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import org.lrd.demokotlin.utils.HeaderBuilder


class MessageBuilder : BaseTestClass() {

    @Given("I have a payload containing the following properties: {string} {string}")
    fun setAddCustomerMessagePayload(firstName : String, lastName : String) {
         payload = "{\"firstName\":\"${firstName}\", \"lastName\":\"${lastName}\"}"
    }

    @And("^I have set the message headers (.*)$")
    fun setHttpHeaders(headers : String)  {
        httpHeaders = HeaderBuilder.getAddCustomerMessage(headers)
    }

}