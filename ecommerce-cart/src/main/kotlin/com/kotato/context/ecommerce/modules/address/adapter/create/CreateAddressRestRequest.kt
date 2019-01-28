package com.kotato.context.ecommerce.modules.address.adapter.create

import java.util.UUID
import javax.validation.constraints.NotNull

data class CreateAddressRestRequest(
        @field:NotNull val id: UUID,
        @field:NotNull val userId: UUID,
        @field:NotNull val street: String,
        @field:NotNull val country: String)