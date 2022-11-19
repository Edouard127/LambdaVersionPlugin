package com.lambda

import com.lambda.client.plugin.api.Plugin
import com.lambda.modules.ProtocolModule
import com.lambda.protocol.Protocol_1_12_2

internal object Loader : Plugin() {

    override fun onLoad() {
        modules.add(ProtocolModule)
    }

    override fun onUnload() { }
}