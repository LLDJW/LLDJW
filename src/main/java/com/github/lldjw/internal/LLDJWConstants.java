/*
 * This file is part of the LLDJW distribution (https://github.com/LLDJW/LLDJW).
 * Copyright (c) 2020 LLDJW Contributors.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 3.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.github.lldjw.internal;

/**
 * A utility method containing all Discord specific constants.
 */
public final class LLDJWConstants {

    public static final int API_VERSION = 6;
    public static final String API_BASE = "https://discordapp.com/api/v" + API_VERSION + "/";
    public static final String API_GATEWAY = "gateway";
    public static final int API_GATEWAY_CLOSE_GRACE = 1000;
    public static final int API_GATEWAY_CLOSE_CLOUD_FLARE = 1001;
    public static final int API_GATEWAY_CLOSE_INTERNAL = 1006;
    public static final int API_GATEWAY_CLOSE_ERROR = 4000;
    public static final int API_GATEWAY_CLOSE_UNKNOWN_OP = 4001;
    public static final int API_GATEWAY_CLOSE_DECODE = 4002;
    public static final int API_GATEWAY_CLOSE_NOT_AUTH = 4004;
    public static final int API_GATEWAY_CLOSE_TOKEN = 4004;
    public static final int API_GATEWAY_CLOSE_ALREADY_AUTH = 4005;
    public static final int API_GATEWAY_CLOSE_SEQ = 4007;
    public static final int API_GATEWAY_CLOSE_RATE_LIMIT = 4008;
    public static final int API_GATEWAY_CLOSE_TIMEOUT = 4009;
    public static final int API_GATEWAY_CLOSE_SHARD_INVALID = 4010;
    public static final int API_GATEWAY_CLOSE_SHARD_REQUIRED = 4011;
    public static final int API_GATEWAY_OP_DISPATCH = 0;
    public static final int API_GATEWAY_OP_HEARTBEAT = 1;
    public static final int API_GATEWAY_OP_IDENTIFY = 2;
    public static final int API_GATEWAY_OP_PRESENCE = 3;
    public static final int API_GATEWAY_OP_RESUME = 6;
    public static final int API_GATEWAY_OP_RECONNECT = 7;
    public static final int API_GATEWAY_OP_REQUEST_MEMBERS = 8;
    public static final int API_GATEWAY_OP_INVALIDATE = 9;
    public static final int API_GATEWAY_OP_HELLO = 10;
    public static final int API_GATEWAY_OP_HEARTBEAT_ACK = 11;
    public static final String API_CDN_BASE = "https://cdn.discordapp.com/";
    public static final String API_CDN_EMOJI = "emojis/";
    public static final String API_CDN_ICON = "icons/";
    public static final String API_CDN_SPLASHES = "splashes/";
    public static final String API_CDN_AVATAR_DEFAULT = "embed/avatars/";
    public static final String API_CDN_AVATAR_CUSTOM = "avatars/";
    public static final String API_CDN_APPLICATION = "app-icons/";
    public static final String API_EVENT_READY = "READY";
    public static final String API_EVENT_RESUMED = "RESUMED";
    public static final String API_EVENT_INVALID_SESSION = "INVALID_SESSION";
    public static final String API_EVENT_CHANNEL_CREATE = "CHANNEL_CREATE";
    public static final String API_EVENT_CHANNEL_UPDADTE = "CHANNEL_UPDATE";
    public static final String API_EVENT_CHANNEL_DELETE = "CHANNEL_DELETE";
    public static final String API_EVENT_CHANNEL_PINS_UPDATE = "CHANNEL_PINS_UPDATE";
    public static final String API_EVENT_GUILD_CREATE = "GUILD_CREATE";
    public static final String API_EVENT_GUILD_UPDATE = "GUILD_UPDATE";
    public static final String API_EVENT_GUILD_DELETE = "GUILD_DELETE";
    public static final String API_EVENT_GUILD_BAN_ADD = "GUILD_BAN_ADD";
    public static final String API_EVENT_GUILD_BAN_REMOVE = "GUILD_BAN_REMOVE";
    public static final String API_EVENT_GUILD_EMOJI_UPDATE = "GUILD_EMOJIS_UPDATE";
    public static final String API_EVENT_GUILD_INTEGRATIONS_UPDATE = "GUILD_INTEGRATIONS_UPDATE";
    public static final String API_EVENT_GUILD_MEMBER_ADD = "GUILD_MEMBER_ADD";
    public static final String API_EVENT_GUILD_MEMBER_REMOVE = "GUILD_MEMBER_REMOVE";
    public static final String API_EVENT_GUILD_MEMBER_UPDATE = "GUILD_MEMBER_UPDATE";
    public static final String API_EVENT_GUILD_MEMBER_CHUNK = "GUILD_MEMBERS_CHUNK";
    public static final String API_EVENT_GUILD_ROLE_CREATE = "GUILD_ROLE_CREATE";
    public static final String API_EVENT_GUILD_ROLE_UPDATE = "GUILD_ROLE_UPDATE";
    public static final String API_EVENT_GUILD_ROLE_DELETE = "GUILD_ROLE_DELETE";
    public static final String API_EVENT_MESSAGE_CREATE = "MESSAGE_CREATE";
    public static final String API_EVENT_MESSAGE_UPDATE = "MESSAGE_UPDATE";
    public static final String API_EVENT_MESSAGE_DELETE = "MESSAGE_DELETE";
    public static final String API_EVENT_MESSAGE_DELETE_BULK = "MESSAGE_DELETE_BULK";
    public static final String API_EVENT_MESSAGE_REACTION_ADD = "MESSAGE_REACTION_ADD";
    public static final String API_EVENT_MESSAGE_REACTION_REMOVE = "MESSAGE_REACTION_REMOVE";
    public static final String API_EVENT_MESSAGE_REACTION_REMOVE_ALL = "MESSAGE_REACTION_REMOVE_ALL";
    public static final String API_EVENT_PRESENCE_UPDATE = "PRESENCE_UPDATE";
    public static final String API_EVENT_TYPING_START = "TYPING_START";
    public static final String API_EVENT_USER_UPDATE = "USER_UPDATE";
    public static final String API_EVENT_WEBHOOK_UPDATE = "WEBHOOKS_UPDATE";

}
