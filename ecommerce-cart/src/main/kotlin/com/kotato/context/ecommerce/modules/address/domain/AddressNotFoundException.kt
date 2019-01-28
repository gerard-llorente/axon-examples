package com.kotato.context.ecommerce.modules.address.domain

class AddressNotFoundException(id: String) : RuntimeException("Order for id <$id> was not found.")