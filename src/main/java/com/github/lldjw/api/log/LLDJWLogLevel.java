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
 * LLDJWLogLevel represents the log level.
 */
public enum LLDJWLogLevel {

    /**
     * Logging is disabled.
     */
    NONE,

    /**
     * Only fatal events will be logged.
     */
    FATAL,

    /**
     * Fatal events and information (such as warning) will be logged.
     */
    INFO,

    /**
     * Everything will be logged.
     */
    TRACE

}