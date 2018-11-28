package com.qualogy.klusdus.google

import com.qualogy.klusdus.google.model.ResponseV2
import com.qualogy.klusdus.log.log
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice("com.qualogy.klusdus.google")
class GoogleErrorHandler() {

    @ExceptionHandler(Exception::class)
    @ResponseBody
    fun genericException(ex: Exception): ResponseEntity<ResponseV2> {
        log.error("Error processing fulfilment request", ex)
        return ResponseEntity(errorResponse("Ik kan je vraag nu even niet beantwoorden. Probeer het later nog eens"), HttpStatus.OK)
    }
}