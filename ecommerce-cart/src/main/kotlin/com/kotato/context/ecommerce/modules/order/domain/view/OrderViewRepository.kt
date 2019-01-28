package com.kotato.context.ecommerce.modules.order.domain.view

import com.kotato.context.ecommerce.modules.cart.domain.CartId
import com.kotato.context.ecommerce.modules.order.domain.OrderId
import com.kotato.context.ecommerce.modules.order.domain.OrderStatus
import com.kotato.context.ecommerce.modules.payment.domain.PaymentId
import com.kotato.context.ecommerce.modules.user.domain.UserId

interface OrderViewRepository {

    fun save(view: OrderView)
    fun search(id: OrderId): OrderView?
    fun searchByCartId(id: CartId): OrderView?
    fun searchByPaymentId(id: PaymentId): OrderView?
    fun searchByUserIdAndStatus(userId: UserId, status: OrderStatus): List<OrderView>

}