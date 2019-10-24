package org.lrd.demokotlin.config.profiles

import javax.sql.DataSource

interface TestConfiguration {

    fun getDataSource() : DataSource

    fun getFetchCustomerUrl() : String

    fun getAddCustomerUrl() : String

    fun getDeleteCustomerUrl() : String

}