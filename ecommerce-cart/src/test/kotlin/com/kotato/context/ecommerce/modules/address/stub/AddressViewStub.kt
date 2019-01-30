package com.kotato.context.ecommerce.modules.address.stub

import com.kotato.context.ecommerce.modules.address.domain.AddressId
import com.kotato.context.ecommerce.modules.address.domain.view.AddressView

object AddressViewStub {
    fun random(id: AddressId = AddressIdStub.random()) =
            AddressView(id)
}