package com.lambda.modules

import com.lambda.Loader
import com.lambda.VersionList
import com.lambda.client.module.Category
import com.lambda.client.plugin.api.PluginModule

internal object ProtocolModule : PluginModule(
    name = "ProtocolModule",
    category = Category.CLIENT,
    description = "Play sub-1.12 servers",
    pluginMain = Loader
) {
    var protocol = VersionList._1_12_2
}