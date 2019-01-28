package com.kotato.context.ecommerce.modules.address.acceptance

import com.kotato.context.ecommerce.modules.address.stub.CreateAddressRestRequestStub
import com.kotato.shared.ContextStarterTest
import io.restassured.RestAssured
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus

class CreateAddressControllerTest : ContextStarterTest() {

    @Test
    fun `it should create address`() {
        val restRequest = CreateAddressRestRequestStub.random()
        RestAssured.given()
                .header("Content-Type", "application/json")
                .body(objectMapper.writeValueAsString(restRequest))
                .`when`()
                .post("/ecommerce/address")
                .then()
                .statusCode(HttpStatus.CREATED.value())
    }

}