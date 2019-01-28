package com.kotato.context.ecommerce.modules.address.domain

import com.kotato.context.ecommerce.modules.address.domain.create.AddressCreatedEvent
import com.kotato.context.ecommerce.modules.user.domain.UserId
import com.kotato.shared.money.Money
import org.axonframework.commandhandling.model.AggregateIdentifier
import org.axonframework.commandhandling.model.AggregateLifecycle.apply
import org.axonframework.eventsourcing.EventSourcingHandler
import org.axonframework.spring.stereotype.Aggregate
import java.time.ZonedDateTime

@Aggregate
class Address {

    @AggregateIdentifier
    lateinit var addressId: AddressId
        private set
    lateinit var userId: UserId
        private set
    lateinit var name: Money
        private set
    lateinit var street: Street
        private set
    lateinit var country: Country
        private set

    @EventSourcingHandler
    fun on(event: AddressCreatedEvent) {
        addressId = AddressId.fromString(event.aggregateId)
        userId = UserId.fromString(event.userId)
        street = Street(event.street)
        country = Country(event.country)
    }

    companion object {
        fun create(addressId: AddressId,
                   userId: UserId,
                   street: Street,
                   country: Country) {
            apply(AddressCreatedEvent(addressId.asString(),
                                      ZonedDateTime.now(),
                                      userId.asString(),
                                      street.name,
                                      country.name))
        }
    }

}