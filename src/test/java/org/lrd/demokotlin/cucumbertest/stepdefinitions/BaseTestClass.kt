package org.lrd.demokotlin.cucumbertest.stepdefinitions


import com.squareup.okhttp.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.web.client.RestTemplate
import java.util.*
import kotlin.collections.Map


abstract  class BaseTestClass {

    @Autowired
    protected lateinit var addCustomerUrl: String

    @Autowired
    protected lateinit var getCustomerUrl: String

    @Autowired
    protected lateinit var restTemplate: RestTemplate

    @Autowired
    protected lateinit var jdbcTemplate: JdbcTemplate

    companion object {
        var payload: String? = null
        var httpHeaders: Map<String, String> = HashMap()
        var response : Response? = null
    }

}