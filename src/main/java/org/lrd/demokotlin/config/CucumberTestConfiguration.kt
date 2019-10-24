package org.lrd.demokotlin.config


import org.lrd.demokotlin.config.profiles.TestConfiguration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.*
import org.springframework.core.env.Environment
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.web.client.RestTemplate
import org.testcontainers.containers.FixedHostPortGenericContainer


@ComponentScan(value = ["org.lrd.demokotlin.config"])
class CucumberTestConfiguration {

    @Autowired
    private lateinit var env: Environment

    @Autowired
    private lateinit var  profileConfig: TestConfiguration

    @Bean
    fun restTemplate() : RestTemplate {
       return RestTemplate()
    }

    @Bean
    fun getCustomerUrl() : String? {
        return profileConfig.getFetchCustomerUrl()
    }

    @Bean
    fun addCustomerUrl() : String? {
        return profileConfig.getAddCustomerUrl()
    }

    @Bean
    fun deleteCustomerUrl() : String? {
        return profileConfig.getDeleteCustomerUrl()
    }

    @Bean
    fun jdbcTemplate() : JdbcTemplate? {
        return JdbcTemplate(profileConfig.getDataSource())
    }

    @Bean
    @Profile(value = ["local", "default"])
    fun postgreSQLContainer() : FixedHostPortGenericContainer<*> {
        val postgreSQLContainer = FixedHostPortGenericContainer<Nothing>("postgres:latest")
        postgreSQLContainer.withEnv("POSTGRES_USER", env.getProperty("local-config.datasource.username"))
        postgreSQLContainer.withEnv("POSTGRES_PASSWORD", env.getProperty("local-config.datasource.password"))
        postgreSQLContainer.withEnv("POSTGRES_DB", env.getProperty("local-config.datasource.database"))
        postgreSQLContainer.withFixedExposedPort(
            Integer.parseInt(env.getProperty("local-config.datasource.host-port")!!),
            Integer.parseInt(env.getProperty("local-config.datasource.container-port")!!)
        )
        postgreSQLContainer.start()
        while (!postgreSQLContainer.isRunning()) {
            Thread.sleep(500)
        }
        return postgreSQLContainer

    }

}
