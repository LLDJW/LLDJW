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
package com.github.lldjw;

/**
 * The gateway represents a wrapper for Discord's websocket gateway.
 * The connection to the gateway, as well as behaviour can be defined.
 */
public final class LLDJWGateway {

    private final LLDJW client;

    /**
     * Creates a new gateway instance.
     * @param client The LLDJW client.
     */
    LLDJWGateway(LLDJW client) {
        this.client = client;
    }

    /**
     * Opens the connection to the gateway and begins a long handshake and initialization process.
     * @return The client, for chaining.
     */
    public LLDJW open() {
        return client;
    }

    /**
     * Closes the connection to the gateway.
     * @return The client, for chaining.
     */
    public LLDJW close() {
        return client;
    }

}
