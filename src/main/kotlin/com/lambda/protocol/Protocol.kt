package com.lambda.protocol

abstract class Protocol(public val version: Int) {
    init {
        if (version < 0) {
            throw IllegalArgumentException("Protocol version must be positive")
        }
    }
}