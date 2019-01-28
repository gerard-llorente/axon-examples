package com.kotato.context.ecommerce.modules.address.domain.create

import com.kotato.shared.domainevent.DomainEvent
import java.time.ZonedDateTime


data class AddressCreatedEvent(val aggregateId: String,
                               val occurredOn: ZonedDateTime,
                               val userId: String,
                               val street: String,
                               val country: String) : DomainEvent {

    override fun aggregateId() = aggregateId
    override fun occurredOn() = occurredOn

}