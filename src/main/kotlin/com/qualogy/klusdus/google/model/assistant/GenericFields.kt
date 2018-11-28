package com.qualogy.klusdus.google.model.assistant

data class Image(val url: String?,
                 val accessibilityText: String?,
                 val width: Int? = null,
                 val height: Int? = null)

data class OpenUrlAction(val url: String,
                         val androidApp: String? = null,
                         val urlTypeHint: String? = null)