package com.lambda

enum class VersionList(val string: String, val protocol: Int) {
    _1_12(string = "1.12", protocol = 335),
    _1_12_1(string = "1.12.1", protocol = 338),
    _1_12_2(string = "1.12.2", protocol = 340),
}

class ProtocolList {
    companion object {
        val protocolList = listOf(
            VersionList._1_12,
            VersionList._1_12_1,
            VersionList._1_12_2
        )
    }
}
