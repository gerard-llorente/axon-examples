package com.kotato.context.ecommerce.modules.address.stub

import com.github.javafaker.Faker
import com.kotato.context.ecommerce.modules.address.domain.Street

object StreetStub {
    fun random() = Street(Faker().address().streetName())
}