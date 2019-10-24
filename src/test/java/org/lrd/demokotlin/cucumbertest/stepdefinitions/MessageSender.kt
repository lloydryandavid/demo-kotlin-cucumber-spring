package org.lrd.demokotlin.cucumbertest.stepdefinitions

import com.squareup.okhttp.*
import cucumber.api.java.en.When
import com.squareup.okhttp.Response;


class MessageSender :  BaseTestClass() {

    @When(value = "I send this message to the add customer path")
    fun sendAddCustomerMessage() {
        val request: Request = Request.Builder()
            .url(addCustomerUrl)
            .post(RequestBody.create(MediaType.parse("application/json"), payload))
            .headers(Headers.of(httpHeaders))
            .build()
        response = OkHttpClient().newCall(request).execute()
    }

    @When(value = "I retrieve the customer {string} {string} using the get customer path")
    fun sendGetCustomerMessage(firstName : String, lastName : String) {
        val request: Request = Request.Builder()
            .url("${getCustomerUrl}firstName=$firstName&lastName=$lastName")
            .get()
            .build()
        response = OkHttpClient().newCall(request).execute()
    }


}
