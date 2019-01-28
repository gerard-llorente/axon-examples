package com.kotato.context.ecommerce.modules.address.stub

import com.kotato.context.ecommerce.modules.address.domain.create.CreateAddressCommand
import com.kotato.context.ecommerce.modules.cart.stub.CartIdStub
import com.kotato.context.ecommerce.modules.user.stub.UserIdStub

class CreateAddressCommandStub {
    companion object {
        fun random(id: String = CartIdStub.random().asString(),
                   userId: String = UserIdStub.random().asString(),
                   street: String = StreetStub.random().name,
                   country: String = CountryStub.random().name) = CreateAddressCommand(id, userId, street, country)
    }
}