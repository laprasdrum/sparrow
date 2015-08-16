package com.laprasdrum.sparrow.model

interface Employee {
    fun register(key: String): String
}

class CompanyAdmin() : Employee {
    override fun register(key: String): String {
        return "registered with admin"
    }
}

class PayrollEdit() : Employee {
    override fun register(key: String): String {
        return "registered"
    }
}

class User(companyAdmin: CompanyAdmin) : Employee by companyAdmin
