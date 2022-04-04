package com.ergoplatform.tokencheck

import io.swagger.v3.oas.annotations.ExternalDocumentation
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@OpenAPIDefinition(
    info = Info(
        title = "Ergo Platform Genuine Tokens Verification",
        description = "See [EIP-21](https://github.com/ergoplatform/eips/blob/master/eip-0021.md) for full information"
    ),
    tags = [Tag(
        name = "tokenVerification",
        description = "APIs implementing EIP-21",
        externalDocs = ExternalDocumentation(
            description = "EIP-21",
            url = "https://github.com/ergoplatform/eips/blob/master/eip-0021.md"
        )
    )]
)
@SpringBootApplication
class TokencheckApplication

fun main(args: Array<String>) {
    runApplication<TokencheckApplication>(*args)
}
