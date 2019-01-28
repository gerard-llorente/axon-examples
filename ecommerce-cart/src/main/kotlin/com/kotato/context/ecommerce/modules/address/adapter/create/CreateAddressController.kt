package com.kotato.context.ecommerce.modules.address.adapter.create

import com.kotato.context.ecommerce.modules.address.domain.create.CreateAddressCommand
import com.kotato.cqrs.domain.command.CommandBus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.net.URI
import javax.validation.Valid

@RestController
open class CreateAddressController(private val commandBus: CommandBus) {

    @PostMapping("/ecommerce/address")
    open fun create(@RequestBody @Valid request: CreateAddressRestRequest): ResponseEntity<Unit> {
        commandBus.handle(CreateAddressCommand(request.id.toString(),
                                               request.userId.toString(),
                                               request.street,
                                               request.country))
        return ResponseEntity.created(URI("/ecommerce/address/${request.id}")).build()
    }

}