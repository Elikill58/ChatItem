package me.dadus33.chatitem.packets;

import java.util.ArrayList;
import java.util.List;

public interface PacketType {

	String name();
	String getPacketName();
	String getFullName();
	List<String> getAlias();
	
	static final String CLIENT_PREFIX = "PacketPlayIn", SERVER_PREFIX = "PacketPlayOut", LOGIN_PREFIX = "PacketLogin", STATUS_PREFIX = "PacketStatus", HANDSHAKE_PREFIX = "PacketHandshaking";
	
	public static PacketType getType(String packetName) {
		if(packetName.startsWith(CLIENT_PREFIX)) {
			return getPacketTypeFor(packetName, Client.values(), Client.UNSET);
		} else if(packetName.startsWith(SERVER_PREFIX)) {
			return getPacketTypeFor(packetName, Server.values(), Server.UNSET);
		} else if(packetName.startsWith(LOGIN_PREFIX)) {
			return getPacketTypeFor(packetName, Login.values(), Login.UNSET);
		} else if(packetName.startsWith(STATUS_PREFIX)) {
			return getPacketTypeFor(packetName, Status.values(), Status.UNSET);
		} else if(packetName.startsWith(HANDSHAKE_PREFIX)) {
			return getPacketTypeFor(packetName, Handshake.values(), Handshake.UNSET);
		} else {
			return null;
		}
	}
	
	static PacketType getPacketTypeFor(String packetName, PacketType[] types, PacketType unset) {
		for(PacketType packet : types)
			if(packet.getFullName().equalsIgnoreCase(packetName) || packet.getPacketName().equalsIgnoreCase(packetName)  || packet.getAlias().contains(packetName))
				return packet;
		return unset;
	}
	
	public static enum Client implements PacketType {
		ABILITIES("Abilities"),
		ADVANCEMENTS("Advancements"),
		ARM_ANIMATION("ArmAnimation"),
		AUTO_RECIPE("AutoRecipe"),
		BEACON("Beacon"),
		BEDIT("BEdit"),
		BOAT_MOVE("BoatMove"),
		BLOCK_DIG("BlockDig"),
		BLOCK_PLACE("BlockPlace"),
		CHAT("Chat"),
		CLIENT_COMMAND("ClientCommand"),
		CLOSE_WINDOW("CloseWindow"),
		CUSTOM_PAYLOAD("CustomPayload"),
		DIFFICULTY_CHANGE("DifficultyChange"),
		DIFFICULTY_LOCK("DifficultyLock"),
		ENCHANT_ITEM("EnchantItem"),
		ENTITY_ACTION("EntityAction"),
		ENTITY_NBT_QUERY("EntityNBTQuery"),
		FLYING("Flying"),
		HELD_ITEM_SLOT("HeldItemSlot"),
		ITEM_NAME("ItemName"),
		KEEP_ALIVE("KeepAlive"),
		LOOK("Look", "Rotation"),
		PICK_ITEM("PickItem"),
		POSITION("Position"),
		POSITION_LOOK("PositionLook", "PositionRotation"),
		RECIPE_DISPLAYED("RecipeDisplayed"),
		RESOURCE_PACK_STATUS("ResourcePackStatus"),
		SET_COMMAND_BLOCK("SetCommandBlock"),
		SET_COMMAND_MINECART("SetCommandMinecart"),
		SET_CREATIVE_SLOT("SetCreativeSlot"),
		SET_JIGSAW("SetJigsaw"),
		SETTINGS("Settings", "ClientSettings"),
		SPECTATE("Spectate"),
		STEER_VEHICLE("SteerVehicle"),
		STRUCT("Struct"),
		TAB_COMPLETE("TabComplete"),
		TELEPORT_ACCEPT("TeleportAccept"),
		TILE_NBT_QUERY("TileNBTQuery"),
		TR_SEL("TrSel"),
		TRANSACTION("Transaction"),
		UPDATE_SIGN("UpdateSign"),
		USE_ENTITY("UseEntity"),
		USE_ITEM("UseItem"),
		VEHICLE_MOVE("VehicleMove"),
		WINDOW_CLICK("WindowClick"),
		UNSET("Unset");
		
		private final String packetName, fullName;
		private final List<String> alias = new ArrayList<>();
		
		Client(String packetName, String... alias) {
			this.packetName = packetName;
			for(String al : alias)
				this.alias.add(CLIENT_PREFIX + al);
			this.fullName = CLIENT_PREFIX + packetName;
		}
		
		@Override
		public String getPacketName() {
			return packetName;
		}

		@Override
		public String getFullName() {
			return fullName;
		}
		
		@Override
		public List<String> getAlias() {
			return alias;
		}
	}
	
	public static enum Server implements PacketType {
		
		ABILITIES("Abilities"),
		ADVANCEMENTS("Advancements"),
		ANIMATION("Animation"),
		ATTACH_ENTITY("AttachEntity"),
		AUTO_RECIPE("AutoRecipe"),
		BED("Bed"),
		BLOCK_ACTION("BlockAction"),
		BLOCK_BREAK("BlockBreak"),
		BLOCK_BREAK_ANIMATION("BlockBreakAnimation"),
		BLOCK_CHANGE("BlockChange"),
		BOSS("Boss"),
		CAMERA("Camera"),
		CHAT("Chat"),
		CLOSE_WINDOW("CloseWindow"),
		COLLECT("Collect"),
		COMBAT_EVENT("CombatEvent"),
		COMMANDS("Commands"),
		CUSTOM_PAYLOAD("CustomPayload"),
		CUSTOM_SOUND_EFFECT("CustomSoundEffect"),
		ENTITY("Entity"),
		ENTITY_DESTROY("EntityDestroy"),
		ENTITY_EFFECT("EntityEffect"),
		ENTITY_EQUIPMENT("EntityEquipment"),
		ENTITY_HEAD_ROTATION("EntityHeadRotation"),
		ENTITY_LOOK("EntityLook"),
		ENTITY_METADATA("EntityMetadata"),
		ENTITY_STATUS("EntityStatus"),
		ENTITY_SOUND("EntitySound"),
		ENTITY_TELEPORT("EntityTeleport"),
		ENTITY_VELOCITY("EntityVelocity"),
		EXPERIENCE("Experience"),
		EXPLOSION("Explosion"),
		GAME_STATE_CHANGE("GameStateChange"),
		HELD_ITEM_SLOT("HeldItemSlot"),
		KEEP_ALIVE("KeepAlive"),
		KICK_DISCONNECT("KickDisconnect"),
		LIGHT_UPDATE("LightUpdate"),
		LOOK_AT("LookAt"),
		LOGIN("Login"),
		MAP("Map"),
		MAP_CHUNK("MapChunk"),
		MAP_CHUNK_BULK("MapChunkBulk"),
		MOUNT("Mount"),
		MULTI_BLOCK_CHANGE("MultiBlockChange"),
		NAMED_ENTITY_SPAWN("NamedEntitySpawn"),
		NAMED_SOUND_EFFECT("NamedSoundEffect"),
		NBT_QUERY("NBTQuery"),
		OPEN_BOOK("OpenBook"),
		OPEN_SIGN_EDITOR("OpenSignEditor"),
		OPEN_WINDOW("OpenWindow"),
		OPEN_WINDOW_MERCHANT("OpenWindowMerchant"),
		OPEN_WINDOW_HORSE("OpenWindowHorse"),
		PLAYER_INFO("PlayerInfo"),
		PLAYER_LIST_HEADER_FOOTER("PlayerListHeaderFooter"),
		POSITION("Position"),
		RECIPES("Recipes"),
		RECIPE_UPDATE("RecipeUpdate"),
		REL_ENTITY_MOVE("RelEntityMove"),
		REL_ENTITY_MOVE_LOOK("RelEntityMoveLook"),
		REMOVE_ENTITY_EFFECT("RemoveEntityEffect"),
		RESOURCE_PACK_SEND("ResourcePackSend"),
		RESPAWN("Respawn"),
		SCOREBOARD_DISPLAY_OBJECTIVE("ScoreboardDisplayObjective"),
		SCOREBOARD_OBJECTIVE("ScoreboardObjective"),
		SCOREBOARD_SCORE("ScoreboardScore"),
		SCOREBOARD_TEAM("ScoreboardTeam"),
		SERVER_DIFFICULTY("ServerDifficulty"),
		SET_COMPRESSION("SetCompression"),
		SET_COOLDOWN("SetCooldown"),
		SET_SLOT("SetSlot"),
		SPAWN_ENTITY("SpawnEntity"),
		SPAWN_ENTITY_EXPERIENCE_ORB("SpawnEntityExperienceOrb"),
		SPAWN_ENTITY_LIVING("SpawnEntityLiving"),
		SPAWN_ENTITY_PAINTING("SpawnEntityPainting"),
		SPAWN_ENTITY_WEATHER("SpawnEntityWeather"),
		SPAWN_POSITION("SpawnPosition"),
		STATISTIC("Statistic"),
		STOP_SOUND("StopSound"),
		TAB_COMPLETE("TabComplete"),
		TAGS("Tags"),
		TILE_ENTITY_DATA("TileEntityData"),
		TITLE("Title"),
		TRANSACTION("Transaction"),
		UNLOAD_CHUNK("UnloadChunk"),
		UPDATE_ATTRIBUTES("UpdateAttributes"),
		UPDATE_ENTITY_NBT("UpdateEntityNBT"),
		UPDATE_HEALTH("UpdateHealth"),
		UPDATE_SIGN("UpdateSign"),
		UPDATE_TIME("UpdateTime"),
		VEHICLE_MOVE("VehicleMove"),
		VIEW_DISTANCE("ViewDistance"),
		VIEW_CENTRE("ViewCentre"),
		WINDOW_DATA("WindowData"),
		WINDOW_ITEMS("WindowItems"),
		WORLD_BORDER("WorldBorder"),
		WORLD_EVENT("WorldEvent"),
		WORLD_PARTICLES("WorldParticles"),
		UNSET("Unset");
		
		private final String packetName, fullName;
		private List<String> alias = new ArrayList<>();
		
		private Server(String packetName, String... alias) {
			this.packetName = packetName;
			this.fullName = SERVER_PREFIX + packetName;
			for(String al : alias)
				this.alias.add(SERVER_PREFIX + al);
		}

		@Override
		public String getPacketName() {
			return packetName;
		}

		@Override
		public String getFullName() {
			return fullName;
		}
		
		@Override
		public List<String> getAlias() {
			return alias;
		}
	}
	
	public static enum Login implements PacketType {
		
		CUSTOM_PAYLOAD_OUT("OutCustomPayload"),
		CUSTOM_PAYLOAD_IN("InCustomPayload"),
		DISCONNECT("OutDisconnect"),
		ENCRYPTION_BEGIN_OUT("OutEncryptionBegin"),
		ENCRYPTION_BEGIN_IN("InEncryptionBegin"),
		LISTENER_OUT("OutListener"),
		LISTENER_IN("InListener"),
		SET_COMPRESSION("OutSetCompression"),
		START("InStart"),
		SUCCESS("OutSuccess"),
		UNSET("Unset");
		
		private final String packetName, fullName;
		private List<String> alias = new ArrayList<>();
		
		private Login(String packetName, String... alias) {
			this.packetName = packetName;
			for(String al : alias)
				this.alias.add(LOGIN_PREFIX + al);
			this.fullName = LOGIN_PREFIX + packetName;
		}

		@Override
		public String getPacketName() {
			return packetName;
		}

		@Override
		public String getFullName() {
			return fullName;
		}
		
		@Override
		public List<String> getAlias() {
			return alias;
		}
	}
	
	public static enum Status implements PacketType {

		LISTENER("Listener"),
		LISTENER_IN("InListener"),
		LISTENER_OUT("OutListener"),
		PING("InPing"),
		START("InStart"),
		PONG("OutPong"),
		SERVER_INFO("OutServerInfo"),
		UNSET("Unset");
		
		private final String packetName, fullName;
		private List<String> alias = new ArrayList<>();
		
		private Status(String packetName, String... alias) {
			this.packetName = packetName;
			for(String al : alias)
				this.alias.add(STATUS_PREFIX + al);
			this.fullName = STATUS_PREFIX + packetName;
		}

		@Override
		public String getPacketName() {
			return packetName;
		}

		@Override
		public String getFullName() {
			return fullName;
		}
		
		@Override
		public List<String> getAlias() {
			return alias;
		}
	}

	public static enum Handshake implements PacketType {
		
		IN_LISTENER("InListener"),
		IS_SET_PROTOCOL("InSetProtocol"),
		UNSET("Unset");
		
		private final String packetName, fullName;
		private List<String> alias = new ArrayList<>();
		
		private Handshake(String packetName, String... alias) {
			this.packetName = packetName;
			for(String al : alias)
				this.alias.add(HANDSHAKE_PREFIX + al);
			this.fullName = HANDSHAKE_PREFIX + packetName;
		}

		@Override
		public String getPacketName() {
			return packetName;
		}

		@Override
		public String getFullName() {
			return fullName;
		}
		
		@Override
		public List<String> getAlias() {
			return alias;
		}
		
	}
}
