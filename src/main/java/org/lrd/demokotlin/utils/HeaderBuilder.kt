package org.lrd.demokotlin.utils


class HeaderBuilder {

    companion object {

        fun getAddCustomerMessage(headers: String) : Map<String, String> {
            var httpHeaders : HashMap<String, String>  = HashMap()
            for(header in headers.trim('"').split(",")) {
                val keyVal = header.split(":")
                httpHeaders[keyVal[0]] = keyVal[1]
            }
            return httpHeaders
        }

    }

}