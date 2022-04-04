package com.ergoplatform.tokencheck.rest

import com.ergoplatform.tokencheck.model.CheckResponse
import com.ergoplatform.tokencheck.model.GenuineToken
import com.ergoplatform.tokencheck.service.TokenVerifierService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
class TokenCheckController(val tokenVerifierService: TokenVerifierService) {

    @Operation(summary = "Check a token verification", tags = ["tokenVerification"])
    @GetMapping("/tokens/check/{tokenId}/{tokenName}")
    fun checkToken(
        @Parameter(description = "")
        @PathVariable tokenId: String,
        @PathVariable tokenName: String
    ): CheckResponse {
        return tokenVerifierService.checkTokenGenuine(tokenId, tokenName)
    }

    @Operation(summary = "Lists all genuine tokens known", tags = ["tokenVerification"])
    @GetMapping("/tokens/listGenuine")
    fun listGenuine(): List<GenuineToken> {
        return tokenVerifierService.genuineTokens
    }

    @Operation(summary = "Lists all blocked tokens", tags = ["tokenVerification"])
    @GetMapping("/tokens/listBlocked")
    fun listBlocked(): List<String> {
        return tokenVerifierService.blockedTokens
    }

}