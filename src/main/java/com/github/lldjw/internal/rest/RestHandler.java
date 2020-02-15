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
package com.github.lldjw.internal.rest;

import com.github.lldjw.internal.LLDJWConstants;
import de.arraying.kotys.JSON;
import okhttp3.*;

import java.io.IOException;

public class RestHandler {

    private final OkHttpClient client;
    private String gatewayUrl;

    public RestHandler(OkHttpClient client) {
        this.client = client;
    }

    public synchronized String getGatewayUrl(boolean force) throws IOException {
        if(gatewayUrl == null || force) { // Gateway is not cached or it needs to be forced.
            Request request = getRequest("GET", LLDJWConstants.API_BASE + LLDJWConstants.API_GATEWAY, null);
            JSON json = sync(request);
            gatewayUrl = json.string("url");
        }
        return gatewayUrl;
    }

    private Request getRequest(String method, String url, RequestBody body) {
        return new Request.Builder()
                .url(url)
                .method(method, body)
                .build();
    }

    private JSON sync(Request request) throws IOException {
        try(Response response = client.newCall(request).execute()) {
            ResponseBody body = response.body();
            return body == null ? new JSON() : new JSON(body.string());
        }
    }

}
