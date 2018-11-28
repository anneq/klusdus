package com.qualogy.klusdus.google

import com.qualogy.klusdus.action.Action
import com.qualogy.klusdus.google.model.OutputContext
import com.qualogy.klusdus.google.model.Payload
import com.qualogy.klusdus.google.model.RequestV2
import com.qualogy.klusdus.google.model.ResponseV2
import com.qualogy.klusdus.google.model.assistant.GoogleResponseData
import com.qualogy.klusdus.google.model.assistant.RichResponse
import com.qualogy.klusdus.google.model.assistant.SimpleResponse
import com.qualogy.klusdus.google.model.assistant.SimpleResponseItem
import com.qualogy.klusdus.log.log
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.annotation.PostConstruct

@RestController
@RequestMapping("google/v2")
class GoogleActionsController(val actions: Map<String, Action>) {

    @PostMapping("/webhook", produces = [(MediaType.APPLICATION_JSON_VALUE)])
    fun googleActionsWebhook(@RequestBody request: RequestV2): ResponseV2 {

        val queryResult = request.queryResult
        val actionName = queryResult?.action.orEmpty()
        val contexts = getContexts(queryResult?.outputContexts)
        val parameters = queryResult?.parameters ?: emptyMap()
        val utterance = queryResult?.queryText ?: ""

        val accessToken = request.originalDetectIntentRequest?.payload?.user?.accessToken  // OAuth token
        val conversationUserId = request.originalDetectIntentRequest?.payload?.user?.userId  // unique user id, dependent on voice

        log.info("Performing action $actionName")
        return actions[actionName]?.perform(contexts, parameters, ContextFactory(request)) ?: errorResponse("Nieuw klusje voor jou: fix de fulfilment service want actie $actionName ken ik niet")

    }

    private fun getContexts(outputContexts: List<OutputContext>?) = (outputContexts ?: listOf())
            .associateBy({ getBareContextName(it.name) }, { it })

    /**
     * Google context names are prefixed with the session id and more stuff. Strip all this google-specific meuk
     */
    private fun getBareContextName(name: String) = if (name.contains("/")) name.substring(name.lastIndexOf('/') + 1) else name

    @PostConstruct
    private fun init() {
        val firstColWidth = actions.keys.map { it.length }.max() ?: 20
        log.info("\n========================================================================================================================\n" +
        "Available actions are: \n${actions.map { "${it.key.padEnd(firstColWidth)} = ${it.value}" }.joinToString(separator = "\n")}\n" +
        "========================================================================================================================")
    }
}

fun errorResponse(errorMessage: String) = ResponseV2(
    payload = Payload(GoogleResponseData(
            richResponse = RichResponse(listOf(
                    SimpleResponseItem(SimpleResponse(textToSpeech = errorMessage)))))))

