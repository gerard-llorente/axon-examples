package com.kotato.context.ecommerce.modules.address.behaviour

import com.kotato.context.ecommerce.modules.address.domain.Address
import com.kotato.context.ecommerce.modules.address.domain.AddressId
import com.kotato.context.ecommerce.modules.address.domain.Country
import com.kotato.context.ecommerce.modules.address.domain.Street
import com.kotato.context.ecommerce.modules.address.domain.create.AddressCreator
import com.kotato.context.ecommerce.modules.address.domain.create.CreateAddressCommandHandler
import com.kotato.context.ecommerce.modules.address.infrastructure.AxonAddressRepository
import com.kotato.context.ecommerce.modules.address.stub.AddressCreatedEventStub
import com.kotato.context.ecommerce.modules.address.stub.CreateAddressCommandStub
import com.kotato.context.ecommerce.modules.user.domain.UserId
import com.kotato.shared.expectDomainEvent
import com.kotato.shared.loadAggregate
import org.axonframework.test.aggregate.AggregateTestFixture
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class AddressCreatorTest {

    private val fixture = AggregateTestFixture(Address::class.java)
    private val repository = AxonAddressRepository(fixture.repository)
    private val service = AddressCreator(repository)
    private val handler = CreateAddressCommandHandler(service)

    @BeforeEach
    fun setUp() {
        fixture.registerAnnotatedCommandHandler(handler)
    }

    @Test
    fun `it should create a cart`() {
        val command = CreateAddressCommandStub.random()
        val expectedEvent = AddressCreatedEventStub.random(aggregateId = command.id,
                                                           userId = command.userId,
                                                           street = command.street,
                                                           country = command.country)

        fixture.givenNoPriorActivity()
                .`when`(command)
                .expectSuccessfulHandlerExecution()
                .expectDomainEvent(expectedEvent)

        fixture.loadAggregate(command.id)
                .let { aggregate ->
                    assertEquals(AddressId.fromString(command.id), aggregate.addressId)
                    assertEquals(UserId.fromString(command.userId), aggregate.userId)
                    assertEquals(Street(command.street), aggregate.street)
                    assertEquals(Country(command.country), aggregate.country)
                }
    }

}