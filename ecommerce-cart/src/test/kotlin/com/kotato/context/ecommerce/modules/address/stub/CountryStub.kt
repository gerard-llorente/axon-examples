package com.kotato.context.ecommerce.modules.address.stub

import com.github.javafaker.Faker
import com.kotato.context.ecommerce.modules.address.domain.Country

object CountryStub {
    fun random() = Country(Faker().address().country())
}