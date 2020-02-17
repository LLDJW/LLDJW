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
 * Lookup wraps different lookup types. These are different ways that LLDJW will treat looking up data.
 *
 */
public enum Lookup {

    /**
     * LLDJW will first perform a lookup with {@link #CACHE}.
     * If this fails, it will perform a lookup with {@link #REST}.
     * The result is then returned. {@link #ACTION} is not used.
     */
    GLOBAL,

    /**
     * LLDJW will look for the entity in the local cache.
     * If it is not found, null will be returned.
     */
    CACHE,

    /**
     * LLDJW will try to retrieve the entity from the REST endpoint.
     * If this is not found, null will be returned.
     */
    REST,

    /**
     * LLDJW will create a fake entity with the corresponding ID.
     * This entity will have absolutely no data (aside from the ID), but its methods can be used.
     * Null will never be returned.
     */
    ACTION

}
