package com.qualogy.klusdus.action

import com.qualogy.klusdus.google.ContextFactory
import com.qualogy.klusdus.google.model.OutputContext
import com.qualogy.klusdus.google.model.ResponseV2

interface Action {
    fun perform(
            contexts: Map<String, OutputContext>,
            parameters: Map<String, Any>,
            contextFactory: ContextFactory): ResponseV2
}