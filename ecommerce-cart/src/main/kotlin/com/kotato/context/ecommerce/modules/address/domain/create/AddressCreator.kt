package com.kotato.context.ecommerce.modules.address.domain.create

import com.kotato.context.ecommerce.modules.address.domain.AddressId
import com.kotato.context.ecommerce.modules.address.domain.AddressRepository
import com.kotato.context.ecommerce.modules.address.domain.Country
import com.kotato.context.ecommerce.modules.address.domain.Street
import com.kotato.context.ecommerce.modules.user.domain.UserId
import javax.inject.Named

@Named
open class AddressCreator(private val repository: AddressRepository) {

    operator fun invoke(addressId: AddressId, userId: UserId, street: Street, country: Country) {
            repository.new(addressId,
                           userId,
                           street,
                           country)
    }

}