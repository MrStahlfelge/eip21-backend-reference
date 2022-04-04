package com.ergoplatform.tokencheck.model

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class GenuineToken(
    val tokenId: String,
    val tokenName: String,
    val uniqueName: Boolean,
    val issuer: String?
)
