package com.qualogy.klusdus.google.model.assistant

import com.qualogy.klusdus.google.model.Capability

object GoogleAssistantCapability {
    @JvmField
    val SCREEN_OUTPUT = Capability("actions.capability.SCREEN_OUTPUT")
    @JvmField
    val AUDIO_OUTPUT = Capability("actions.capability.AUDIO_OUTPUT")
    @JvmField
    val BROWSER = Capability("actions.capability.WEB_BROWSER")
    @JvmField
    val MEDIA_AUDIO = Capability("actions.capability.MEDIA_RESPONSE_AUDIO")
}