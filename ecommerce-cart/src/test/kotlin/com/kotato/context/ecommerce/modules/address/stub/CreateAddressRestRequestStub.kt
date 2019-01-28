package com.kotato.context.ecommerce.modules.address.stub

import com.kotato.context.ecommerce.modules.address.adapter.create.CreateAddressRestRequest
import com.kotato.context.ecommerce.modules.cart.stub.CartIdStub
import com.kotato.context.ecommerce.modules.user.stub.UserIdStub
import java.util.UUID

class CreateAddressRestRequestStub {
    companion object {
        fun random(id: UUID = CartIdStub.random().id,
                   userId: UUID = UserIdStub.random().id,
                   street: String = StreetStub.random().name,
                   country: String = CountryStub.random().name) = CreateAddressRestRequest(id, userId, street, country)
    }
}