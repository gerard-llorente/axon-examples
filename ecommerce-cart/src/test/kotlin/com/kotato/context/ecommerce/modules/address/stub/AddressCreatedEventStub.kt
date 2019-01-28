package com.kotato.context.ecommerce.modules.address.stub

import com.kotato.context.ecommerce.modules.address.domain.create.AddressCreatedEvent
import com.kotato.context.ecommerce.modules.user.stub.UserIdStub
import java.time.ZonedDateTime

class AddressCreatedEventStub {
    companion object {
        fun random(aggregateId: String = AddressIdStub.random().asString(),
                   occurredOn: ZonedDateTime = ZonedDateTime.now(),
                   userId: String = UserIdStub.random().asString(),
                   street: String,
                   country: String) =
                AddressCreatedEvent(aggregateId, occurredOn, userId, street, country)
    }
}