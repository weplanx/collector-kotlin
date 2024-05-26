package com.creator.server

import com.alibaba.fastjson2.JSONSchemaValidException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ServerExceptionHandler {
    @ExceptionHandler(JSONSchemaValidException::class)
    fun handleValidationExceptions(exception: JSONSchemaValidException): ResponseEntity<*> {
        val errors: MutableMap<String, String?> = HashMap()
        errors["message"] = exception.message
        return ResponseEntity.badRequest().body<Map<String, String?>>(errors)
    }
}
