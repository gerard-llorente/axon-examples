package com.kotato.context.ecommerce.modules.address.domain.create

import com.kotato.cqrs.domain.command.Command


data class CreateAddressCommand(val id: String, val userId: String, val street: String, val country: String) : Command