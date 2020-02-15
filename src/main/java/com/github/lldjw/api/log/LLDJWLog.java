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
package com.github.lldjw.api.log;

/**
 * LLDJWLog is the logger wrapper that can be specified when logging.
 */
public interface LLDJWLog {

    /**
     * Sets the log level for LLDJW related log events.
     * For more information about the log level, see {@link com.github.lldjw.api.log.LLDJWLogLevel}.
     * @param level The log level, may not be null.
     */
    void setLevel(LLDJWLogLevel level);

    /**
     * Logs a message.
     * All log events call this method; it is up to the implementation to decide whether or not the specific log
     * message is at a level that will actually be logged.
     * @param level The log level that LLDJW has assigned to this message.
     * @param message The message.
     * @param format Any formatting objects, may be empty.
     */
    void log(LLDJWLogLevel level, String message, Object... format);

}
