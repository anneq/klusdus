package com.qualogy.klusdus.google.model.assistant


data class SimpleResponseItem(val simpleResponse: SimpleResponse) : RichResponseItem

data class SimpleResponse(val textToSpeech: String? = null,
                          val ssml: String? = null,
                          val displayText: String? = null)
