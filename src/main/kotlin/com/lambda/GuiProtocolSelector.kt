package com.lambda

import com.lambda.modules.ProtocolModule
import com.lambda.protocol.Protocol_1_12_1
import com.lambda.protocol.Protocol_1_12_2
import com.mojang.realmsclient.gui.ChatFormatting
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.GuiButton
import net.minecraft.client.gui.GuiScreen
import net.minecraft.client.gui.GuiSlot
import net.minecraft.network.EnumConnectionState
import org.lwjgl.opengl.GL11


class GuiProtocolSelector(private val parent: GuiScreen) : GuiScreen() {
    private var list: SlotList? = null
    override fun initGui() {
        super.initGui()
        buttonList.add(GuiButton(1, width / 2 - 100, height - 27, 200,
            20, "Back"))
        list = SlotList(mc, width, height, 32, height - 32, 10)
    }

    override fun actionPerformed(p_actionPerformed_1_: GuiButton) {
        list!!.actionPerformed(p_actionPerformed_1_)
        if (p_actionPerformed_1_.id == 1) mc.displayGuiScreen(parent)
    }

    override fun handleMouseInput() {
        list!!.handleMouseInput()
        super.handleMouseInput()
    }

    override fun drawScreen(p_drawScreen_1_: Int, p_drawScreen_2_: Int, p_drawScreen_3_: Float) {
        list!!.drawScreen(p_drawScreen_1_, p_drawScreen_2_, p_drawScreen_3_)
        GL11.glPushMatrix()
        GL11.glScalef(2.0f, 2.0f, 2.0f)
        drawCenteredString(fontRenderer, ChatFormatting.GOLD.toString() + "Protocol Selector", width / 4, 6, 16777215)
        GL11.glPopMatrix()
        drawString(fontRenderer, "Kamigen#0001", 1, 1, -1)
        super.drawScreen(p_drawScreen_1_, p_drawScreen_2_, p_drawScreen_3_)
    }

    inner class SlotList(p_i1052_1_: Minecraft?, p_i1052_2_: Int, p_i1052_3_: Int, p_i1052_4_: Int, p_i1052_5_: Int, p_i1052_6_: Int) : GuiSlot(p_i1052_1_!!, p_i1052_2_, p_i1052_3_, p_i1052_4_, p_i1052_5_, p_i1052_6_) {
        override fun getSize(): Int {
            return ProtocolList.protocolList.size
        }

        override fun elementClicked(i: Int, b: Boolean, i1: Int, i2: Int) {
            ProtocolModule.protocol = ProtocolList.protocolList[i]
            if (ProtocolModule.protocol.protocol == 340) {
                EnumConnectionState.HANDSHAKING.directionMaps = Protocol_1_12_2.HANDSHAKING.PROTOCOL
                EnumConnectionState.PLAY.directionMaps = Protocol_1_12_2.PLAY.PROTOCOL
                EnumConnectionState.STATUS.directionMaps = Protocol_1_12_2.STATUS.PROTOCOL
                EnumConnectionState.LOGIN.directionMaps = Protocol_1_12_2.LOGIN.PROTOCOL
            }
            when (ProtocolModule.protocol.protocol) {
                340 -> {
                    EnumConnectionState.HANDSHAKING.directionMaps = Protocol_1_12_2.HANDSHAKING.PROTOCOL
                    EnumConnectionState.PLAY.directionMaps = Protocol_1_12_2.PLAY.PROTOCOL
                    EnumConnectionState.STATUS.directionMaps = Protocol_1_12_2.STATUS.PROTOCOL
                    EnumConnectionState.LOGIN.directionMaps = Protocol_1_12_2.LOGIN.PROTOCOL
                }
                338 -> {
                    EnumConnectionState.HANDSHAKING.directionMaps = Protocol_1_12_1.HANDSHAKING.PROTOCOL
                    EnumConnectionState.PLAY.directionMaps = Protocol_1_12_1.PLAY.PROTOCOL
                    EnumConnectionState.STATUS.directionMaps = Protocol_1_12_1.STATUS.PROTOCOL
                    EnumConnectionState.LOGIN.directionMaps = Protocol_1_12_1.LOGIN.PROTOCOL
                }
            }
        }

        override fun isSelected(i: Int): Boolean {
            return false
        }

        override fun drawBackground() {
            drawDefaultBackground()
        }

        override fun drawSlot(i: Int, i1: Int, i2: Int, i3: Int, i4: Int, i5: Int, v: Float) {
            val version = ProtocolList.protocolList[i]
            drawString(fontRenderer, version.name, width / 2, i2, -1)
        }
    }
}