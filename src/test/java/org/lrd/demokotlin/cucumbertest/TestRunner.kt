package org.lrd.demokotlin.cucumbertest

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith


@RunWith(Cucumber::class)
@CucumberOptions(
    glue = ["org.lrd.demokotlin.cucumbertest.stepdefinitions"],
    plugin = ["io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm"]
)
class TestRunner