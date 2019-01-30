package com.kotato.context.ecommerce.modules.address.infrastructure.view

import com.kotato.context.ecommerce.modules.address.domain.AddressId
import com.kotato.context.ecommerce.modules.address.domain.view.AddressView
import org.springframework.data.jpa.repository.JpaRepository
import javax.inject.Named

@Named
open class JpaAddressViewRepository(private val persistenceRepository: JpaAddressViewPersistenceRepository) {

    fun save(entity: AddressView) {
        entity.let(persistenceRepository::saveAndFlush)
    }

    fun search(id: AddressId): AddressView? = id.let(persistenceRepository::findOne)

    interface JpaAddressViewPersistenceRepository : JpaRepository<AddressView, AddressId>

}