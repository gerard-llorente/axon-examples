package com.kotato.context.ecommerce.modules.address.domain

import com.kotato.context.ecommerce.modules.user.domain.UserId

interface AddressRepository {

    fun search(addressId: AddressId): Address?
    fun new(addressId: AddressId, userId: UserId, street: Street, country: Country)

}