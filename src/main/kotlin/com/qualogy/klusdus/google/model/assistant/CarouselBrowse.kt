package com.qualogy.klusdus.google.model.assistant

data class CarouselBrowseItem(val carouselBrowse: CarouselBrowse) : RichResponseItem

data class CarouselBrowse(val items: List<CarouselItem>,
                          val imageDisplayOptions: ImageDisplayOptions? = null)

data class CarouselItem(val title: String?,
                        val description: String? = null,
                        val footer: String? = null,
                        val image: Image? = null,
                        val openUrlAction: OpenUrlAction)
