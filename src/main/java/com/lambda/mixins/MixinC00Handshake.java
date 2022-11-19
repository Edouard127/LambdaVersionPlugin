package com.lambda.mixins;

import com.lambda.modules.ProtocolModule;
import net.minecraft.network.EnumConnectionState;
import net.minecraft.network.handshake.client.C00Handshake;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(C00Handshake.class)
public class MixinC00Handshake {

    @Shadow private int protocolVersion;

    @Shadow private String ip;

    @Shadow private int port;

    @Shadow private EnumConnectionState requestedState;

    @Inject(method = "<init>(Ljava/lang/String;ILnet/minecraft/network/EnumConnectionState;)V", at = @At("RETURN"))
    public void init(String p_i47613_1_, int p_i47613_2_, EnumConnectionState p_i47613_3_, CallbackInfo ci) {
        this.protocolVersion = ProtocolModule.INSTANCE.getProtocol().getProtocol();
        this.ip = p_i47613_1_;
        this.port = p_i47613_2_;
        this.requestedState = p_i47613_3_;
    }
}

