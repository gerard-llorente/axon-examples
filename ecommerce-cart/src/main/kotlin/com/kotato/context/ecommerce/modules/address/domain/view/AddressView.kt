package com.kotato.context.ecommerce.modules.address.domain.view

import com.kotato.context.ecommerce.modules.address.domain.AddressId
import org.hibernate.annotations.DynamicUpdate
import java.io.Serializable
import javax.persistence.EmbeddedId
import javax.persistence.Entity

@Entity
@DynamicUpdate
data class AddressView(@EmbeddedId val id: AddressId) : Serializable