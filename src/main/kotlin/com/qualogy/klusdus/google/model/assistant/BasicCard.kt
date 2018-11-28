package com.qualogy.klusdus.google.model.assistant

data class BasicCardItem(val basicCard: BasicCard) : RichResponseItem

data class BasicCard(val title: String?,
                     val subtitle: String? = null,
                     val formattedText: String? = null,
                     val image: Image? = null,
                     val imageDisplayOptions: ImageDisplayOptions? = null,
                     val buttons: List<CardButton>? = null)

data class CardButton(val title: String,
                      val openUrlAction: OpenUrlAction)