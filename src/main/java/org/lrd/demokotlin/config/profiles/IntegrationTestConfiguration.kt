package org.lrd.demokotlin.config.profiles

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Profile
import org.springframework.core.env.Environment
import org.springframework.jdbc.datasource.DriverManagerDataSource
import org.springframework.stereotype.Component
import javax.sql.DataSource

@Component
@Profile(value = ["integration"])
class IntegrationTestConfiguration : TestConfiguration {

    @Autowired
    val environment: Environment?=null

    override fun getDataSource(): DataSource {
        val dataSource = DriverManagerDataSource()
        dataSource.setDriverClassName("org.postgresql.Driver")
        dataSource.url = environment?.getProperty("integration-config.datasource.url")
        dataSource.username = environment?.getProperty("integration-config.datasource.username")
        dataSource.password = environment?.getProperty("integration-config.datasource.password")
        return dataSource
    }

    override fun getAddCustomerUrl(): String {
        val addCustomerUrl = environment?.getProperty("integration-config.customer-api.endpoint.add-customer")
        return "http://${getHost()}${getPort()}$addCustomerUrl"
    }

    override fun getDeleteCustomerUrl(): String {
        val deleteUrl = environment?.getProperty("integration-config.customer-api.endpoint.delete-customer")
        return "http://${getHost()}${getPort()}$deleteUrl"
    }

    override fun getFetchCustomerUrl(): String {
        val fetchCustomerUrl = environment?.getProperty("integration-config.customer-api.endpoint.fetch-customer")
        return "http://${getHost()}${getPort()}$fetchCustomerUrl"
    }

    private fun getHost() : String? {
        return environment?.getProperty("integration-config.customer-api.host")
    }

    private fun getPort() : String? {
        return environment?.getProperty("integration-config.customer-api.port")
    }

}