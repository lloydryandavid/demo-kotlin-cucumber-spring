package org.lrd.demokotlin.cucumbertest.stepdefinitions


import cucumber.api.java.Before
import org.lrd.customerapi.CustomerApplication
import org.lrd.demokotlin.config.CucumberTestConfiguration
import org.lrd.demokotlin.utils.DbSql
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer
import org.springframework.test.context.ContextConfiguration

@ContextConfiguration(
    initializers = [ConfigFileApplicationContextInitializer::class],
    classes = [CucumberTestConfiguration::class]
)
class TestInitializer : BaseTestClass() {

    companion object {
        var isInitialized = false
    }

    @Before
    fun initializeTest() {
        startApplication()
        initDatabase()
    }

    fun startApplication() {
        if(!isInitialized)
            CustomerApplication.main(arrayOf(""))
        isInitialized = true
    }

    fun initDatabase() {
        jdbcTemplate.execute(DbSql.DELETE_CUSTOMER)
    }

}

