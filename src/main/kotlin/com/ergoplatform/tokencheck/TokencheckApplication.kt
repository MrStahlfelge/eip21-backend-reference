package com.ergoplatform.tokencheck

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TokencheckApplication

fun main(args: Array<String>) {
	runApplication<TokencheckApplication>(*args)
}
