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

import com.github.lldjw.api.log.LLDJWLog;
import com.github.lldjw.api.log.LLDJWLogLevel;

public final class LLDJWLogImpl implements LLDJWLog {

    private LLDJWLogLevel level = LLDJWLogLevel.INFO;

    @Override
    public void setLevel(LLDJWLogLevel level) {
        this.level = level;
    }

    @Override
    public void log(LLDJWLogLevel level, String message, Object... format) {
        if(level.ordinal() <= this.level.ordinal()) {
            System.out.println(new StringBuilder("[")
                    .append(level)
                    .append("] ")
                    .append(String.format(message, (Object[]) format))
            );
        }
    }

}
