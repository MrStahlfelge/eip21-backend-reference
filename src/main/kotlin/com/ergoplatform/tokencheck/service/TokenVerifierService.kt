package com.ergoplatform.tokencheck.service

import com.ergoplatform.tokencheck.model.*
import org.springframework.stereotype.Service

@Service
class TokenVerifierService {
    /**
     * list entries from https://github.com/ergoplatform/eips/blob/master/eip-0021.md
     */
    val genuineTokens: List<GenuineToken> = listOf(
        GenuineToken(
            "03faf2cb329f2e90d6d23b58d91bbb6c046aa143261cc21f52fbe2824bfcbf04",
            "SigUSD",
            true,
            "sigmausd.io"
        ),
        GenuineToken(
            "003bd19d0187117f130b62e1bcab0939929ff5c7709f843c5c4dd158949285d0",
            "SigRSV",
            true,
            "sigmausd.io"
        ),
    )

    val blockedTokens: List<String> = emptyList()

    /**
     * This checks if the given token is genuine, suspicious or blocked according to EIP-21
     * https://github.com/ergoplatform/eips/blob/master/eip-0021.md
     */
    fun checkTokenGenuine(tokenId: String, tokenDisplayName: String): CheckResponse {
        // check EIP-21
        val eip21token = genuineTokens.find { it.tokenId.equals(tokenId, true) }
            ?: genuineTokens.find {
                it.uniqueName && it.tokenName.equals(
                    tokenDisplayName,
                    ignoreCase = true
                )
            }

        val tokenGenuine = when {
            blockedTokens.contains(tokenId) -> GENUINE_BLOCKED
            eip21token == null -> GENUINE_UNKNOWN
            eip21token.tokenId == tokenId -> GENUINE_VERIFIED
            else -> GENUINE_SUSPICIOUS
        }

        return CheckResponse(tokenGenuine, eip21token)
    }
}