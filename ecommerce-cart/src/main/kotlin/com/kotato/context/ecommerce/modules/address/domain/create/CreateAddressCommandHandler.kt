package com.kotato.context.ecommerce.modules.address.domain.create

import com.kotato.context.ecommerce.modules.address.domain.AddressId
import com.kotato.context.ecommerce.modules.address.domain.Country
import com.kotato.context.ecommerce.modules.address.domain.Street
import com.kotato.context.ecommerce.modules.user.domain.UserId
import com.kotato.cqrs.domain.command.CommandHandler
import javax.inject.Inject
import javax.inject.Named

@Named
open class CreateAddressCommandHandler(@Inject private val creator: AddressCreator) {

    @CommandHandler
    fun on(command: CreateAddressCommand) {
        creator(AddressId.fromString(command.id),
                UserId.fromString(command.userId),
                Street(command.street),
                Country(command.country))
    }

}