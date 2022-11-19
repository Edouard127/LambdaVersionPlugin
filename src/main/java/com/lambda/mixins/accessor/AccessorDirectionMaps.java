package com.lambda.mixins.accessor;

import com.google.common.collect.BiMap;
import net.minecraft.network.EnumConnectionState;
import net.minecraft.network.EnumPacketDirection;
import net.minecraft.network.Packet;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;

@Mixin(EnumConnectionState.class)
public interface AccessorDirectionMaps {
    @Accessor("directionMaps")
    Map<EnumPacketDirection, BiMap<Integer, Class<? extends Packet<?>>>> getDirectionMaps();

    @Accessor("directionMaps")
    void setDirectionMaps(Map<EnumPacketDirection, BiMap<Integer, Class<? extends Packet<?>>>> directionMaps);
}
