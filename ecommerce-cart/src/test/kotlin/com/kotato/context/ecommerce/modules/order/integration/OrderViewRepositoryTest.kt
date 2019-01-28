package com.kotato.context.ecommerce.modules.order.integration

import com.kotato.assertSimilar.MatcherSimilar.assertSimilar
import com.kotato.context.ecommerce.modules.order.domain.OrderStatus
import com.kotato.context.ecommerce.modules.order.domain.view.OrderViewRepository
import com.kotato.context.ecommerce.modules.order.stub.OrderViewStub
import com.kotato.context.ecommerce.modules.user.stub.UserIdStub
import com.kotato.shared.ContextStarterTest
import com.kotato.shared.ReadModelTransactionWrapper
import org.junit.jupiter.api.Test
import java.time.ZonedDateTime
import javax.inject.Inject

open class OrderViewRepositoryTest : ContextStarterTest() {

    @Inject
    private lateinit var repository: OrderViewRepository
    @Inject
    private lateinit var readModelTransaction: ReadModelTransactionWrapper

    @Test
    open fun `it should save order view`() {
        val view = OrderViewStub.random()

        readModelTransaction { repository.save(view) }

        assertSimilar(view, repository.search(view.id))
    }

    @Test
    open fun `it should search order view by cartId`() {
        val view = OrderViewStub.random()

        readModelTransaction { repository.save(view) }

        assertSimilar(view, repository.searchByCartId(view.cartId))
    }

    @Test
    open fun `it should search order view by paymentId`() {
        val view = OrderViewStub.random()

        readModelTransaction { repository.save(view) }

        assertSimilar(view, repository.searchByPaymentId(view.paymentId))
    }

    @Test
    open fun `it should search order view by user id and status`() {
        val userId = UserIdStub.random()
        val view = OrderViewStub.random(userId = userId,
                                        status = OrderStatus.IN_PROGRESS,
                                        occurredOn = ZonedDateTime.now())
        val view2 = OrderViewStub.random(userId = userId,
                                         status = OrderStatus.IN_PROGRESS,
                                         occurredOn = view.createdOn.plusMinutes(1))
        val view3 = OrderViewStub.random(userId = userId, status = OrderStatus.FAILED)
        val view4 = OrderViewStub.random()

        readModelTransaction {
            repository.save(view)
            repository.save(view2)
            repository.save(view3)
            repository.save(view4)
        }

        assertSimilar(listOf(view2, view), repository.searchByUserIdAndStatus(view.userId, OrderStatus.IN_PROGRESS))
    }

}