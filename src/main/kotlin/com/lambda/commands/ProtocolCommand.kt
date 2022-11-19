package com.lambda.commands

import com.lambda.VersionList
import com.lambda.client.command.ClientCommand
import com.lambda.client.module.AbstractModule
import com.lambda.client.util.text.MessageSendHelper
import com.lambda.directionMaps
import com.lambda.modules.ProtocolModule
import net.minecraft.client.gui.GuiDisconnected
import net.minecraft.client.gui.GuiMainMenu
import net.minecraft.client.gui.GuiMultiplayer
import net.minecraft.network.EnumConnectionState
import net.minecraft.util.text.TextComponentString

object ProtocolCommand : ClientCommand(
    name = "protocol",
    description = "Change the protocol of the client"
) {
    init {
        literal("set") {
            string("protocol") { protocolArg ->
                execute("Set the protocol") {
                    val protocol = VersionList.values().find { it.name.equals(protocolArg.value, true) }
                    val chatName = AbstractModule::chatName
                    if (protocol != null) {
                        ProtocolModule.protocol = protocol
                        MessageSendHelper.sendChatMessage("$chatName Set protocol to ${protocol.name}")
                        // Disconnect from server
                        connection!!.networkManager.closeChannel(TextComponentString("Protocol changed"))
                        mc.loadWorld(null)
                        mc.displayGuiScreen(GuiDisconnected(getScreen(), "Protocol changed", TextComponentString("Protocol changed")))
                    } else {
                        MessageSendHelper.sendChatMessage("$chatName Invalid protocol")
                    }
                }
            }
        }
    }

    private fun getScreen() = if (mc.isIntegratedServerRunning) {
        GuiMainMenu()
    } else {
        GuiMultiplayer(GuiMainMenu())
    }
}