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
package com.github.lldjw.internal.log;

import com.github.lldjw.api.log.LLDJWLog;
import com.github.lldjw.api.log.LLDJWLogLevel;

/**
 * This logger prints to STDOUT; it is a very basic implementation.
 * For anything remotely more configurable, consider using Logback/SLF4J and {@link LogSLF4J}.
 */
public final class Log implements LLDJWLog {

    private LLDJWLogLevel level = LLDJWLogLevel.INFO;

    /**
     * Sets the log level.
     * @param level The log level, may not be null.
     */
    @Override
    public void setLevel(LLDJWLogLevel level) {
        this.level = level;
    }

    /**
     * Logs the message if the current log level is higher than that of the assigned level.
     * For example, a log on {@link LLDJWLogLevel#INFO} will also log {@link LLDJWLogLevel#FATAL}.
     * The hierarchy can be seen in the declaration of {@link LLDJWLogLevel};
     * every level also includes the levels <b>before</b> (lower ordinal) it.
     *
     * @param level The log level that LLDJW has assigned to this message.
     * @param message The message.
     * @param format Any formatting objects, may be empty.
     */
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
