package com.kotato.context.ecommerce.modules.address.stub

import com.github.javafaker.Faker
import com.kotato.context.ecommerce.modules.address.domain.Street

class StreetStub {
    companion object {
        fun random() = Street(Faker().address().streetName())
    }
}