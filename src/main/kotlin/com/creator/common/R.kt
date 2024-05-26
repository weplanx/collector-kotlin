package com.creator.common

import org.springframework.http.ResponseEntity

class R(private val code: Int, private val msg: String) {
    companion object {
        fun Ok(): ResponseEntity<*> {
            return ResponseEntity.ok<R>(R(0, "ok"))
        }

        fun Ok(msg: String): ResponseEntity<*> {
            return ResponseEntity.ok<R>(R(0, msg))
        }

        fun Fail(code: Int, msg: String): ResponseEntity<*> {
            return ResponseEntity.status(400).body<R>(R(code, msg))
        }

        fun WithStatus(code: Int, msg: String, httpCode: Int): ResponseEntity<*> {
            return ResponseEntity.status(httpCode).body<R>(R(code, msg))
        }
    }
}
