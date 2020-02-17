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
package com.github.lldjw.api.entity;

/**
 * CacheLevel represents the level of cache to use,
 * The Discord gateway is relatively complicated, and individual performance can be tweaked here.
 */
public enum CacheLevel {

    /**
     * Caches all entities, except messages. This will request offline members in guilds.
     */
    ALL,

    /**
     * Caches all but messages and offline members.
     */
    MINIMAL,

    /**
     * Caches nothing. This is not recommended unless the instance is a purely an event handler.
     * Clients are expected to cache by Discord, and disabling the cache may result in an API ban.
     */
    NONE

}
