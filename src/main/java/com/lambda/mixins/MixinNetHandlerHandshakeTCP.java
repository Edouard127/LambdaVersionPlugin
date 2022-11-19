package com.lambda.mixins;

import com.lambda.modules.ProtocolModule;
import net.minecraft.network.EnumConnectionState;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.handshake.client.C00Handshake;
import net.minecraft.network.login.server.SPacketDisconnect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.NetHandlerHandshakeTCP;
import net.minecraft.server.network.NetHandlerLoginServer;
import net.minecraft.server.network.NetHandlerStatusServer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NetHandlerHandshakeTCP.class)
public class MixinNetHandlerHandshakeTCP {
    @Shadow @Final private NetworkManager networkManager;

    @Shadow @Final private MinecraftServer server;

    @Inject(method = "processHandshake", at = @At("HEAD"))
    public void processHandshake(C00Handshake packetIn, CallbackInfo ci) {
        if (!net.minecraftforge.fml.common.FMLCommonHandler.instance().handleServerHandshake(packetIn, this.networkManager)) return;

        switch (packetIn.getRequestedState())
        {
            case LOGIN:
                this.networkManager.setConnectionState(EnumConnectionState.LOGIN);

                if (packetIn.getProtocolVersion() > ProtocolModule.INSTANCE.getProtocol().getProtocol())
                {
                    ITextComponent itextcomponent = new TextComponentTranslation("multiplayer.disconnect.outdated_server", "1.12.2");
                    this.networkManager.sendPacket(new SPacketDisconnect(itextcomponent));
                    this.networkManager.closeChannel(itextcomponent);
                }
                else if (packetIn.getProtocolVersion() < ProtocolModule.INSTANCE.getProtocol().getProtocol())
                {
                    ITextComponent itextcomponent = new TextComponentTranslation("multiplayer.disconnect.outdated_client", "1.12.2");
                    this.networkManager.sendPacket(new SPacketDisconnect(itextcomponent));
                    this.networkManager.closeChannel(itextcomponent);
                }
                else
                {
                    this.networkManager.setNetHandler(new NetHandlerLoginServer(this.server, this.networkManager));
                }
                break;
            case STATUS:
                this.networkManager.setConnectionState(EnumConnectionState.STATUS);
                this.networkManager.setNetHandler(new NetHandlerStatusServer(this.server, this.networkManager));
                break;
            default:
                throw new UnsupportedOperationException("Invalid intention " + packetIn.getRequestedState());
        }
    }
}
