package com.kotato.context.ecommerce.modules.payment.behaviour

import com.kotato.context.ecommerce.modules.cart.domain.toSerializedCartItems
import com.kotato.context.ecommerce.modules.cart.stub.CartItemsStub
import com.kotato.context.ecommerce.modules.order.stub.OrderCreatedEventStub
import com.kotato.context.ecommerce.modules.payment.domain.Payment
import com.kotato.context.ecommerce.modules.payment.domain.create.CreatePaymentOnOrderCreatedEventHandler
import com.kotato.context.ecommerce.modules.payment.domain.create.PaymentCreator
import com.kotato.context.ecommerce.modules.payment.infrastructure.AxonPaymentRepository
import com.kotato.context.ecommerce.modules.payment.stub.PaymentCreatedEventStub
import com.kotato.shared.expectDomainEvent
import com.kotato.shared.money.Money
import com.kotato.shared.whenLambda
import org.axonframework.test.aggregate.AggregateTestFixture
import org.junit.jupiter.api.Test

class PaymentCreatorTest {

    private val fixture = AggregateTestFixture(Payment::class.java)
    private val repository = AxonPaymentRepository(fixture.repository)
    private val service = PaymentCreator(repository)
    private val handler = CreatePaymentOnOrderCreatedEventHandler(service)

    @Test
    fun `it should create a payment`() {
        val givenItems = CartItemsStub.random()
        val price = givenItems.entries.map { it.key.price * it.value }.reduce(Money::plus)
        val event = OrderCreatedEventStub.random(cartItems = givenItems.toSerializedCartItems())
        val expected = PaymentCreatedEventStub.random(aggregateId = event.paymentId,
                                                       price = price.amount,
                                                       currency = price.currency)

        fixture.givenNoPriorActivity()
                .whenLambda({ handler.on(event) })
                .expectSuccessfulHandlerExecution()
                .expectDomainEvent(expected)
    }

}