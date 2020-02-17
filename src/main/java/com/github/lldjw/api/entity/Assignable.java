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
 * Assignable represents an interface that allows the supertype to be modified based off of an offered value.
 * @param <F> The type of offered value.
 */
public interface Assignable<F> {

    /**
     * Whether or not the offered value is compatible with the supertype.
     * This is true by default, but behaviour can be changed.
     * @param from The offered value.
     * @return True (default) if it is compatible, false otherwise.
     */
    default boolean isCompatible(F from) {
        return true;
    }

    /**
     * Change the supertype.
     * @param from The offered value.
     */
    void offer(F from);

}
