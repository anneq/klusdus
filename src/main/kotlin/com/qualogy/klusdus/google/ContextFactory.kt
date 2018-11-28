package com.qualogy.klusdus.google

import com.qualogy.klusdus.google.model.OutputContext
import com.qualogy.klusdus.google.model.RequestV2

class ContextFactory(private val request: RequestV2) {

    fun get(contextName: String, lifespanCount: Int, parameters: Map<String, Any?> = emptyMap()) =
            OutputContext(name ="${request.session}/contexts/$contextName", lifespanCount = lifespanCount, parameters = parameters)

}