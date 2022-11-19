package com.lambda

import com.google.common.collect.BiMap
import com.lambda.mixins.accessor.AccessorDirectionMaps
import net.minecraft.network.EnumConnectionState
import net.minecraft.network.EnumPacketDirection
import net.minecraft.network.Packet

var EnumConnectionState.directionMaps: Map<EnumPacketDirection, BiMap<Int, Class<out Packet<*>>>>?
    get() = (this as AccessorDirectionMaps).directionMaps
    set(value) { (this as AccessorDirectionMaps).directionMaps = value }



