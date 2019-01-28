package com.kotato.context.ecommerce.modules.address.infrastructure

import com.kotato.context.ecommerce.modules.address.domain.Address
import org.axonframework.commandhandling.model.Repository
import org.axonframework.common.caching.Cache
import org.axonframework.eventsourcing.AggregateFactory
import org.axonframework.eventsourcing.CachingEventSourcingRepository
import org.axonframework.eventsourcing.Snapshotter
import org.axonframework.eventsourcing.eventstore.EventStore
import org.axonframework.spring.eventsourcing.SpringPrototypeAggregateFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class AddressRepositoryConfiguration {

    @Bean
    open fun addressAggregateFactory(): AggregateFactory<Address> =
            SpringPrototypeAggregateFactory<Address>().also {
                it.setPrototypeBeanName(Address::class.simpleName!!.toLowerCase())
            }

    @Bean
    open fun addressRepository(snapshotter: Snapshotter,
                               eventStore: EventStore,
                               cache: Cache): Repository<Address> =
            CachingEventSourcingRepository(addressAggregateFactory(), eventStore, cache)
}