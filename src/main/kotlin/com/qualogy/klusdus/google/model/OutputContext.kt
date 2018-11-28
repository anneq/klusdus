package com.qualogy.klusdus.google.model

import com.fasterxml.jackson.annotation.JsonInclude

// The default serialization setting is that we do not send null values. We need to override this settign for the
// context parameters to be able to send a null value for a context parameter to remove it from the context.
// If we don't Google keeps re-sending the context parameter
data class OutputContext(val name: String,
                         val lifespanCount: Int,
                         @JsonInclude(JsonInclude.Include.ALWAYS) val parameters: Map<String, Any?> = emptyMap())