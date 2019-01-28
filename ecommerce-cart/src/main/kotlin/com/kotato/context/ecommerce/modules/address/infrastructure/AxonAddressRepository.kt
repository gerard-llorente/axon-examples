package com.kotato.context.ecommerce.modules.address.infrastructure

import com.kotato.context.ecommerce.modules.address.domain.Address
import com.kotato.context.ecommerce.modules.address.domain.AddressId
import com.kotato.context.ecommerce.modules.address.domain.AddressRepository
import com.kotato.context.ecommerce.modules.address.domain.Country
import com.kotato.context.ecommerce.modules.address.domain.Street
import com.kotato.context.ecommerce.modules.user.domain.UserId
import org.axonframework.commandhandling.model.AggregateNotFoundException
import org.springframework.stereotype.Repository
import org.axonframework.commandhandling.model.Repository as AggregateRepository

@Repository
open class AxonAddressRepository(private val persistenceRepository: AggregateRepository<Address>) : AddressRepository {
    override fun search(addressId: AddressId) =
            try {
                persistenceRepository.load(addressId.asString()).invoke { it }
            } catch (exception: AggregateNotFoundException) {
                null
            }

    override fun new(addressId: AddressId, userId: UserId, street: Street, country: Country) {
        persistenceRepository.newInstance {
            Address.create(addressId, userId, street, country)
            Address()
        }
    }

}