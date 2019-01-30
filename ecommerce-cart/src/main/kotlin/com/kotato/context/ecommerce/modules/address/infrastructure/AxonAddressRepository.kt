package com.kotato.context.ecommerce.modules.address.infrastructure

import com.kotato.context.ecommerce.modules.address.domain.Address
import com.kotato.context.ecommerce.modules.address.domain.AddressId
import org.axonframework.commandhandling.model.AggregateNotFoundException
import org.springframework.stereotype.Repository
import org.axonframework.commandhandling.model.Repository as AggregateRepository

@Repository
open class AxonAddressRepository(private val persistenceRepository: AggregateRepository<Address>) {
    fun search(addressId: AddressId) =
            try {
                persistenceRepository.load(addressId.asString()).invoke { it }
            } catch (exception: AggregateNotFoundException) {
                null
            }

    fun new(addressId: AddressId) {
        persistenceRepository.newInstance {
            Address.create(addressId)
            Address()
        }
    }

}