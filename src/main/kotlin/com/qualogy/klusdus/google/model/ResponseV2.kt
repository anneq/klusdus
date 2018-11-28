package com.qualogy.klusdus.google.model

import com.qualogy.klusdus.google.model.assistant.GoogleResponseData

data class ResponseV2(val fulfillmentText: String? = null,
                      val source: String = "qualogy.com",
                      val payload: Payload,
                      val outputContexts: List<OutputContext> = ArrayList())

data class Payload(val google: GoogleResponseData)