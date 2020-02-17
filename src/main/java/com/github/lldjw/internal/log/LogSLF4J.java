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

import com.github.lldjw.LLDJW;
import com.github.lldjw.api.log.LLDJWLog;
import com.github.lldjw.api.log.LLDJWLogLevel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This logger acts as a mapper from LLDJW's internal logging service to SLF4J.
 * This is achieved using the Logback classic library, which has SLF4J support.
 * This is the logger you probably want to use, especially if LLDJW is used with other libraries.
 */
public class LogSLF4J implements LLDJWLog {

    private final Logger logger = LoggerFactory.getLogger(LLDJW.class);

    /**
     * Sets the logback level of the logger at runtime.
     * The following mappings will be used (LLDJW -> Logback):
     * - {@link LLDJWLogLevel#FATAL} -> ERROR
     * - {@link LLDJWLogLevel#INFO} -> INFO
     * - {@link LLDJWLogLevel#TRACE} -> TRACE
     * - {@link LLDJWLogLevel#NONE} -> OFF
     * @param level The log level, may not be null.
     */
    @Override
    public void setLevel(LLDJWLogLevel level) {
        if(level == null) {
            throw new NullPointerException("level is null");
        }
        ch.qos.logback.classic.Level equivalence = null;
        switch(level) {
            case FATAL:
                equivalence = ch.qos.logback.classic.Level.ERROR;
                break;
            case INFO:
                equivalence = ch.qos.logback.classic.Level.INFO;
                break;
            case TRACE:
                equivalence = ch.qos.logback.classic.Level.TRACE;
                break;
            case NONE:
                equivalence = ch.qos.logback.classic.Level.OFF;
                break;
        }
        assert equivalence != null; // Will never fail.
        ((ch.qos.logback.classic.Logger) logger).setLevel(equivalence); // Set the level at runtime.
    }

    /**
     * Calls log function in Logback's logger.
     * The following mappings will be used (LLDJW -> Logback):
     * - {@link LLDJWLogLevel#FATAL} -> ERROR
     * - {@link LLDJWLogLevel#INFO} -> INFO
     * - {@link LLDJWLogLevel#TRACE} -> TRACE
     * {@link LLDJWLogLevel#NONE} will just be ignored.
     * @param level The log level that LLDJW has assigned to this message.
     * @param message The message.
     * @param format Any formatting objects, may be empty.
     */
    @Override
    public void log(LLDJWLogLevel level, String message, Object... format) {
        // Format manually due to incompatibilities with Logback's format
        String formatted = String.format(message, (Object[]) format);

        switch(level) { // Map to Logback functions.
            case FATAL:
                logger.error(formatted);
                break;
            case INFO:
                logger.info(formatted);
                break;
            case TRACE:
                logger.trace(formatted);
                break;
        }
    }

}
