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
package com.github.lldjw.api.request;

import com.github.lldjw.internal.rest.RestTask;

import java.util.function.Consumer;

/**
 * RequestResult is a wrapper for all REST request results.
 * Every request will succeed or fail.
 * If a failure occurs, this will be internally sent to the logger.
 * Additionally, all behaviour can be defined in the respective success/failure consumers using
 * {@link #setOnSuccess(Consumer)} and {@link #setOnError(Consumer)} respectively.
 *
 * Requests can be queried synchronously or asynchronously, depending on the use case.
 * It is recommended to send most, if possible all, requests asynchronously to avoid unnecessary thread blocking
 * for if the bot has to block the thread to avoid being rate-limited.
 *
 * @param <T> The type of the result object.
 */
public class RequestResult<T> {

    private final RestTask<T> task;
    private Consumer<T> successConsumer;
    private Consumer<Throwable> errorConsumer;

    /**
     * Creates a new request result.
     * @param task The task that will generate a result.
     * @throws NullPointerException If the task is null.
     */
    public RequestResult(RestTask<T> task) {
        if(task == null) {
            throw new NullPointerException("REST task is null");
        }
        this.task = task;
    }

    /**
     * Sets the success consumer.
     * This consumer will be invoked when the request is successful, and has generated a result object.
     * @param consumer The consumer, may be null.
     * @return This, for chaining.
     */
    public RequestResult<T> setOnSuccess(Consumer<T> consumer) {
        this.successConsumer = consumer;
        return this;
    }

    /**
     * Sets the error consumer.
     * @param consumer The consumer, may be null.
     * @return This, for chaining.
     */
    public RequestResult<T> setOnError(Consumer<Throwable> consumer) {
        this.errorConsumer = consumer;
        return this;
    }

    /**
     * Executes the request asynchronously.
     */
    public void async() {
        new Thread(this::execute).start();
    }

    /**
     * Executes the request synchronously.
     * @return The result object, or null if there was an error.
     */
    public T blocking() {
        return execute();
    }

    private T execute() {
        T result;
        try {
            result = task.execute();
            if(successConsumer != null) {
                successConsumer.accept(result);
            }
            return result;
        } catch(Throwable throwable) {
            // TODO: log.
            errorConsumer.accept(throwable);
            return null;
        }
    }

}
