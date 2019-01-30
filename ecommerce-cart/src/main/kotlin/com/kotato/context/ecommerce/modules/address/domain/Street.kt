package com.kotato.context.ecommerce.modules.address.domain

import com.kotato.shared.valueobject.ValueObject
import java.io.Serializable

@ValueObject
data class Street(val name: String) : Serializable