package com.kotato.context.ecommerce.modules.address.domain

import org.axonframework.commandhandling.model.AggregateIdentifier
import org.axonframework.spring.stereotype.Aggregate

@Aggregate
class Address {

    @AggregateIdentifier
    lateinit var addressId: AddressId
        private set

    companion object {
        fun create(addressId: AddressId) {

        }
    }

}