package com.qualogy.klusdus.google.model

data class RequestV2(val responseId: String? = null,
                     val queryResult: QueryResult? = null,
                     val originalDetectIntentRequest: OriginalDetectIntentRequest? = null,
                     /**
                      * https://dialogflow.com/docs/reference/api-v2/rest/Shared.Types/WebhookRequest
                      * The unique identifier of detectIntent request session.
                      * Can be used to identify end-user inside webhook implementation.
                      * Format: projects/<Project ID>/agent/sessions/<Session ID>.
                      */
                     val session: String? = null)

data class QueryResult(val source: String? = null,
                       val queryText: String? = null,
                       val resolvedQuery: String? = null,
                       val action: String? = null,
                       val actionIncomplete: Boolean = true,
                       val parameters: Map<String, Any>? = null,
                       val outputContexts: List<OutputContext>? = null,
                       val metadata: Metadata? = null,
                       val intent: Intent? = null,
                       val intentDetectionConfidence: Double? = null)

data class Metadata(val matchedParameters: List<MatchedParameters> = emptyList(),
                    val intentName: String? = null,
                    val intentId: String? = null)

data class MatchedParameters(val name: String? = null)

data class OriginalDetectIntentRequest(val payload: ConversationData? = null)

data class ConversationData(val user: User? = null,
                            val conversation: Conversation? = null,
                            val inputs: List<Input> = emptyList(),
                            val surface: Surface? = null,
                            val isInSandbox: Boolean = true,
                            val availableSurfaces: List<Surface> = emptyList())

data class User(val userId: String? = null,
                val accessToken: String? = null,
                val locale: String? = null,
                val lastSeen: String? = null,
                val userStorage: String? = null)

data class Conversation(
                        /**
                         * https://developers.google.com/actions/reference/rest/Shared.Types/AppRequest#conversation
                         * Unique ID for the multi-turn conversation.
                         * It's assigned for the first turn. After that it remains the same for subsequent conversation turns
                         * until the conversation is terminated.
                         */
                        val conversationId: String? = null,
                        val type: String? = null)

data class Input(val intent: String? = null,
                 val rawInputs: List<RawInput> = emptyList())

data class RawInput(val inputType: String? = null,
                    val query: String? = null)

data class Intent(val displayName: String? = null)

data class Surface(val capabilities: List<Capability> = listOf())

data class Capability(val name: String? = null)