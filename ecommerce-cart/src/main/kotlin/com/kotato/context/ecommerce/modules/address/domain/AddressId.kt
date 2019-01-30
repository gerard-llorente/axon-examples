package com.kotato.context.ecommerce.modules.address.domain

import com.kotato.shared.valueobject.ValueObject
import java.io.Serializable
import java.util.UUID
import javax.persistence.Column

@ValueObject
data class AddressId(@Column(columnDefinition = "binary(16)") val id: UUID) : Serializable {

    override fun toString() = id.toString()

    fun asString() = id.toString()

    companion object {
        fun fromString(uuid: String) = AddressId(UUID.fromString(uuid))
    }

}