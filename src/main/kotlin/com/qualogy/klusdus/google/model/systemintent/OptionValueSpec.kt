package com.qualogy.klusdus.google.model.systemintent

import com.qualogy.klusdus.google.model.assistant.ImageDisplayOptions
import com.qualogy.klusdus.google.model.assistant.Image
import com.fasterxml.jackson.annotation.JsonProperty

interface OptionValueSpec  : InputData {
    val type: String?
}

data class ListOptionValueSpec(@JsonProperty("@type") override val type: String? = "type.googleapis.com/google.actions.v2.OptionValueSpec",
                               val listSelect: ListSelect) : OptionValueSpec

data class ListSelect(val title: String,
                      val items: List<OptionSelectItem>)

data class CarouselOptionValueSpec(@JsonProperty("@type") override val type: String? = "type.googleapis.com/google.actions.v2.OptionValueSpec",
                                   val carouselSelect: CarouselSelect) : OptionValueSpec

data class CarouselSelect(val items: List<OptionSelectItem>,
                          val imageDisplayOptions: ImageDisplayOptions? = null)


data class OptionSelectItem(val optionInfo: OptionInfo,
                            val title: String,
                            val description: String? = null,
                            val image: Image? = null)

data class OptionInfo(val key: String,
                      val synonyms: List<String>? = null)
