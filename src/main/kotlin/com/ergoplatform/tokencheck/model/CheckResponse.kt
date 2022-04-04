package com.ergoplatform.tokencheck.model

import com.fasterxml.jackson.annotation.JsonInclude
import io.swagger.v3.oas.annotations.media.Schema

@JsonInclude(JsonInclude.Include.NON_NULL)
data class CheckResponse(
    @Schema(description = "Flag with 0 unknown, 1 verified, 2 suspicious, 3 blocked (see EIP-21)")
    val genuine: Int,
    @Schema(description = "Information on a verified token the genuine flag rating is based on. " +
            "For a suspicious or blocked token, this might be the actual genuine token.")
    val token: GenuineToken?
)

const val GENUINE_UNKNOWN = 0
const val GENUINE_VERIFIED = 1
const val GENUINE_SUSPICIOUS = 2
const val GENUINE_BLOCKED = 3

