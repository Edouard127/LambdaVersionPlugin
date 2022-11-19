package com.lambda.protocol

import com.google.common.collect.BiMap
import com.google.common.collect.HashBiMap
import net.minecraft.network.EnumPacketDirection
import net.minecraft.network.Packet
import net.minecraft.network.handshake.client.C00Handshake
import net.minecraft.network.login.client.CPacketEncryptionResponse
import net.minecraft.network.login.client.CPacketLoginStart
import net.minecraft.network.login.server.SPacketEnableCompression
import net.minecraft.network.login.server.SPacketEncryptionRequest
import net.minecraft.network.login.server.SPacketLoginSuccess
import net.minecraft.network.play.client.*
import net.minecraft.network.play.server.*
import net.minecraft.network.status.client.CPacketPing
import net.minecraft.network.status.client.CPacketServerQuery
import net.minecraft.network.status.server.SPacketPong
import net.minecraft.network.status.server.SPacketServerInfo

enum class Protocol_1_12_2(val id: Int) {
    HANDSHAKING(id = -1) {
        init {
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x00, SPacketServerInfo::class.java)
            registerPacket(EnumPacketDirection.SERVERBOUND, 0x00, C00Handshake::class.java)
        }
    },
    PLAY(id = 0) {
        init {
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x00, SPacketSpawnObject::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x01, SPacketSpawnExperienceOrb::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x02, SPacketSpawnGlobalEntity::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x03, SPacketSpawnMob::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x04, SPacketSpawnPainting::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x05, SPacketSpawnPlayer::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x06, SPacketAnimation::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x07, SPacketStatistics::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x08, SPacketBlockBreakAnim::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x09, SPacketUpdateTileEntity::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x0A, SPacketBlockAction::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x0B, SPacketBlockChange::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x0C, SPacketUpdateBossInfo::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x0D, SPacketServerDifficulty::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x0E, SPacketTabComplete::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x0F, SPacketChat::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x10, SPacketMultiBlockChange::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x11, SPacketConfirmTransaction::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x12, SPacketCloseWindow::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x13, SPacketOpenWindow::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x14, SPacketWindowItems::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x15, SPacketWindowProperty::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x16, SPacketSetSlot::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x17, SPacketCooldown::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x18, SPacketCustomPayload::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x19, SPacketCustomSound::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x1A, SPacketDisconnect::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x1B, SPacketEntityStatus::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x1C, SPacketExplosion::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x1D, SPacketUnloadChunk::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x1E, SPacketChangeGameState::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x1F, SPacketKeepAlive::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x20, SPacketChunkData::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x21, SPacketEffect::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x22, SPacketParticles::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x23, SPacketJoinGame::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x24, SPacketMaps::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x25, SPacketEntity::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x26, SPacketEntity.S15PacketEntityRelMove::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x27, SPacketEntity.S17PacketEntityLookMove::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x28, SPacketEntity.S16PacketEntityLook::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x29, SPacketMoveVehicle::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x2A, SPacketSignEditorOpen::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x2B, SPacketPlaceGhostRecipe::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x2C, SPacketPlayerAbilities::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x2D, SPacketCombatEvent::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x2E, SPacketPlayerListItem::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x2F, SPacketPlayerPosLook::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x30, SPacketUseBed::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x31, SPacketRecipeBook::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x32, SPacketDestroyEntities::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x33, SPacketRemoveEntityEffect::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x34, SPacketResourcePackSend::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x35, SPacketRespawn::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x36, SPacketEntityHeadLook::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x37, SPacketSelectAdvancementsTab::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x38, SPacketWorldBorder::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x39, SPacketCamera::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x3A, SPacketHeldItemChange::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x3B, SPacketDisplayObjective::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x3C, SPacketEntityMetadata::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x3D, SPacketEntityAttach::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x3E, SPacketEntityVelocity::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x3F, SPacketEntityEquipment::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x40, SPacketSetExperience::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x41, SPacketUpdateHealth::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x42, SPacketScoreboardObjective::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x43, SPacketSetPassengers::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x44, SPacketTeams::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x45, SPacketUpdateScore::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x46, SPacketSpawnPosition::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x47, SPacketTimeUpdate::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x48, SPacketTitle::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x49, SPacketSoundEffect::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x4A, SPacketPlayerListHeaderFooter::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x4B, SPacketCollectItem::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x4C, SPacketEntityTeleport::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x4D, SPacketAdvancementInfo::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x4E, SPacketEntityProperties::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x4F, SPacketEntityEffect::class.java)
            registerPacket(EnumPacketDirection.SERVERBOUND, 0x00, CPacketConfirmTeleport::class.java)
            registerPacket(EnumPacketDirection.SERVERBOUND, 0x01, CPacketTabComplete::class.java)
            registerPacket(EnumPacketDirection.SERVERBOUND, 0x02, CPacketChatMessage::class.java)
            registerPacket(EnumPacketDirection.SERVERBOUND, 0x03, CPacketClientStatus::class.java)
            registerPacket(EnumPacketDirection.SERVERBOUND, 0x04, CPacketClientSettings::class.java)
            registerPacket(EnumPacketDirection.SERVERBOUND, 0x05, CPacketConfirmTransaction::class.java)
            registerPacket(EnumPacketDirection.SERVERBOUND, 0x06, CPacketEnchantItem::class.java)
            registerPacket(EnumPacketDirection.SERVERBOUND, 0x07, CPacketClickWindow::class.java)
            registerPacket(EnumPacketDirection.SERVERBOUND, 0x08, CPacketCloseWindow::class.java)
            registerPacket(EnumPacketDirection.SERVERBOUND, 0x09, CPacketCustomPayload::class.java)
            registerPacket(EnumPacketDirection.SERVERBOUND, 0x0A, CPacketUseEntity::class.java)
            registerPacket(EnumPacketDirection.SERVERBOUND, 0x0B, CPacketKeepAlive::class.java)
            registerPacket(EnumPacketDirection.SERVERBOUND, 0x0C, CPacketPlayer::class.java)
            registerPacket(EnumPacketDirection.SERVERBOUND, 0x0D, CPacketPlayer.Position::class.java)
            registerPacket(EnumPacketDirection.SERVERBOUND, 0x0E, CPacketPlayer.PositionRotation::class.java)
            registerPacket(EnumPacketDirection.SERVERBOUND, 0x0F, CPacketPlayer.Rotation::class.java)
            registerPacket(EnumPacketDirection.SERVERBOUND, 0x10, CPacketVehicleMove::class.java)
            registerPacket(EnumPacketDirection.SERVERBOUND, 0x11, CPacketSteerBoat::class.java)
            registerPacket(EnumPacketDirection.SERVERBOUND, 0x12, CPacketPlaceRecipe::class.java)
            registerPacket(EnumPacketDirection.SERVERBOUND, 0x13, CPacketPlayerAbilities::class.java)
            registerPacket(EnumPacketDirection.SERVERBOUND, 0x14, CPacketPlayerDigging::class.java)
            registerPacket(EnumPacketDirection.SERVERBOUND, 0x15, CPacketEntityAction::class.java)
            registerPacket(EnumPacketDirection.SERVERBOUND, 0x16, CPacketInput::class.java)
            registerPacket(EnumPacketDirection.SERVERBOUND, 0x17, CPacketRecipeInfo::class.java)
            registerPacket(EnumPacketDirection.SERVERBOUND, 0x18, CPacketResourcePackStatus::class.java)
            registerPacket(EnumPacketDirection.SERVERBOUND, 0x19, CPacketSeenAdvancements::class.java)
            registerPacket(EnumPacketDirection.SERVERBOUND, 0x1A, CPacketHeldItemChange::class.java)
            registerPacket(EnumPacketDirection.SERVERBOUND, 0x1B, CPacketCreativeInventoryAction::class.java)
            registerPacket(EnumPacketDirection.SERVERBOUND, 0x1C, CPacketUpdateSign::class.java)
            registerPacket(EnumPacketDirection.SERVERBOUND, 0x1D, CPacketAnimation::class.java)
            registerPacket(EnumPacketDirection.SERVERBOUND, 0x1E, CPacketSpectate::class.java)
            registerPacket(EnumPacketDirection.SERVERBOUND, 0x1F, CPacketPlayerTryUseItemOnBlock::class.java)
            registerPacket(EnumPacketDirection.SERVERBOUND, 0x20, CPacketPlayerTryUseItem::class.java)
        }
    },
    STATUS(id = 1) {
        init {
            registerPacket(EnumPacketDirection.SERVERBOUND, 0x00, CPacketServerQuery::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x01, SPacketServerInfo::class.java)
            registerPacket(EnumPacketDirection.SERVERBOUND, 0x00, CPacketPing::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x01, SPacketPong::class.java)
        }
    },
    LOGIN(id = 2) {
        init {
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x00, SPacketDisconnect::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x01, SPacketEncryptionRequest::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x02, SPacketLoginSuccess::class.java)
            registerPacket(EnumPacketDirection.CLIENTBOUND, 0x03, SPacketEnableCompression::class.java)
            registerPacket(EnumPacketDirection.SERVERBOUND, 0x00, CPacketLoginStart::class.java)
            registerPacket(EnumPacketDirection.SERVERBOUND, 0x01, CPacketEncryptionResponse::class.java)
        }
    };

    val PROTOCOL: MutableMap<EnumPacketDirection, BiMap<Int, Class<out Packet<*>>>> = mutableMapOf()

    fun registerPacket(direction: EnumPacketDirection, id: Int, clazz: Class<out Packet<*>>) {
        PROTOCOL.getOrPut(direction) { HashBiMap.create() }[id] = clazz
    }

    class PacketRegistry : Protocol(340)
}