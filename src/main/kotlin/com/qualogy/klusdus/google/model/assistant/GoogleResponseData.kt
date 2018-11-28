package com.qualogy.klusdus.google.model.assistant

import com.qualogy.klusdus.google.model.systemintent.SystemIntent
import com.fasterxml.jackson.annotation.JsonProperty

data class GoogleResponseData(val expectUserResponse: Boolean = true,
                              val systemIntent: SystemIntent? = null,
                              @JsonProperty("is_ssml") val ssml: Boolean? = null,
                              val richResponse: RichResponse? = null)

data class RichResponse(val items: List<RichResponseItem>,
                        val suggestions: List<Suggestion>? = null
)

interface RichResponseItem

data class Suggestion(val title: String)
