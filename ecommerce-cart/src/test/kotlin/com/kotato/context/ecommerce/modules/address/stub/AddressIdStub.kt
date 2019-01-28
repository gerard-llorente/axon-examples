package com.kotato.context.ecommerce.modules.address.stub

import com.kotato.context.ecommerce.modules.address.domain.AddressId
import java.util.UUID

class AddressIdStub {
    companion object {
        fun random() = AddressId(UUID.randomUUID())
    }
}