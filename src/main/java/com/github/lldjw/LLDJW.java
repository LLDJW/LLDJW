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

import com.github.lldjw.api.event.LLDJWEventHandler;
import com.github.lldjw.api.log.LLDJWLog;
import com.github.lldjw.internal.LLDJWLogImpl;
import com.github.lldjw.internal.rest.RestHandler;
import okhttp3.OkHttpClient;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * LLDJW is the core object that is used to communicate with Discord's API.
 * An instance can represent an entire client, or a singular shard.
 * While the websocket is supported, the client does not exclusively rely on it,
 * REST request can be dispatched without establishing a websocket connection.
 */
public final class LLDJW {

    private final String token;

    private final Object logMutex = new Object();
    private LLDJWLog log = new LLDJWLogImpl();
    private RestHandler restHandler = new RestHandler(new OkHttpClient());
    private final Object eventHandlerMutex = new Object();
    private Set<LLDJWEventHandler> eventHandlers = new HashSet<>();

    /**
     * Creates a new LLDJW client.
     * @param token The token to use to authenticate with Discord.
     * @throws IllegalArgumentException If the token is null or empty.
     */
    public LLDJW(String token) {
        if(token == null || token.isEmpty()) {
            throw new IllegalArgumentException("token is null or empty");
        }
        this.token = token;
    }

    /**
     * Gets the current log implementation.
     * @return The log implementation.
     */
    public LLDJWLog getLog() {
        synchronized(logMutex) {
            return log;
        }
    }

    /**
     * Specifies a new log implementation.
     * @param log The new log implementation.
     * @return This, for chaining.
     * @throws NullPointerException If the log implementation is null.
     */
    public LLDJW useLog(LLDJWLog log) {
        if(log == null) {
            throw new NullPointerException("log is null");
        }
        synchronized(logMutex) {
            this.log = log;
        }
        return this;
    }

    //
    // Settings related.
    //

    /**
     * Specifies the OkHTTPClient to use.
     * By default, {@link okhttp3.OkHttpClient} is called with its default constructor, {@link OkHttpClient#OkHttpClient()}.
     * @param client The new client.
     * @return This, for chaining.
     * @throws NullPointerException If the client is null.
     */
    public LLDJW useHttpClient(OkHttpClient client) {
        if(client == null) {
            throw new NullPointerException("client is null");
        }
        this.restHandler = new RestHandler(client);
        return this;
    }

    //
    // Self user related
    //

    //
    // Event related.
    //

    /**
     * Sets the event handlers set type.
     * By default, all event handles are stored in a {@link java.util.HashSet}.
     * With this method, the type of set can be changed. This can be useful if there are supposed to be event priorities,
     * where i.e. a {@link java.util.TreeSet} can be used and each handler has its own weight.
     *
     * All existing event handlers will be copied into a HashSet, and re-added to the new set.
     * @param newSet The new set.
     * @return This, for chaining.
     * @throws NullPointerException If the set is null.
     */
    public LLDJW setEventHandlersTyped(Set<LLDJWEventHandler> newSet) {
        if(newSet == null) {
            throw new NullPointerException("set is null");
        }
        synchronized(eventHandlerMutex) {
            Set<LLDJWEventHandler> copy = new HashSet<>(this.eventHandlers);
            this.eventHandlers = newSet;
            this.eventHandlers.addAll(copy);
        }
        return this;
    }

    /**
     * Sets one or more event handlers.
     * @param eventHandlers A variadic array of event handlers.
     * @return This, for chaining.
     * @throws NullPointerException If the event handlers are null, or a single specified event handler is null.
     */
    public LLDJW setEventHandlers(LLDJWEventHandler... eventHandlers) {
        if(eventHandlers == null) {
            throw new NullPointerException("event handlers are null");
        }
        synchronized(eventHandlerMutex) {
            Collections.addAll(this.eventHandlers, eventHandlers);
        }
        return this;
    }

    /**
     * Unsets (removes) one or more event handlers.
     * @param eventHandlers A variadic array of event handlers.
     * @return This, for chaining.
     * @throws NullPointerException If the event handlers are null,
     * or the set does not allow the removal of null elements (see the specific set implementation).
     */
    public LLDJW unsetEventHandlers(LLDJWEventHandler... eventHandlers) {
        if(eventHandlers == null) {
            throw new NullPointerException("event handlers are null");
        }
        synchronized(eventHandlerMutex) {
            for(LLDJWEventHandler eventHandler : eventHandlers) {
                this.eventHandlers.remove(eventHandler);
            }
        }
        return this;
    }

}
