package com.kotato.context.ecommerce.modules.order.infrastructure.view

import com.kotato.context.ecommerce.modules.cart.domain.CartId
import com.kotato.context.ecommerce.modules.order.domain.OrderId
import com.kotato.context.ecommerce.modules.order.domain.OrderStatus
import com.kotato.context.ecommerce.modules.order.domain.view.OrderView
import com.kotato.context.ecommerce.modules.order.domain.view.OrderViewRepository
import com.kotato.context.ecommerce.modules.payment.domain.PaymentId
import com.kotato.context.ecommerce.modules.user.domain.UserId
import org.springframework.data.jpa.repository.JpaRepository
import javax.inject.Named

@Named
open class JpaOrderViewRepository(private val persistenceRepository: JpaOrderViewPersistenceRepository) : OrderViewRepository {

    override fun save(view: OrderView) {
        view.let(persistenceRepository::saveAndFlush)
    }

    override fun search(id: OrderId): OrderView? = id.let(persistenceRepository::findOne)

    override fun searchByCartId(id: CartId): OrderView? = id.let(persistenceRepository::findByCartId)

    override fun searchByPaymentId(id: PaymentId): OrderView? = id.let(persistenceRepository::findByPaymentId)
    
    override fun searchByUserIdAndStatus(userId: UserId, status: OrderStatus) =
            persistenceRepository.findByUserIdAndStatusOrderByCreatedOnDesc(userId, status)

    interface JpaOrderViewPersistenceRepository : JpaRepository<OrderView, OrderId> {
        fun findByCartId(cartId: CartId): OrderView?
        fun findByPaymentId(paymentId: PaymentId): OrderView?
        fun findByUserIdAndStatusOrderByCreatedOnDesc(userId: UserId, status: OrderStatus): List<OrderView>
    }

}