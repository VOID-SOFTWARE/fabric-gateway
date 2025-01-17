/*
 * Copyright 2022 IBM All Rights Reserved.
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package org.hyperledger.fabric.client;

/**
 * Builder used to create a new events request.
 * @param <T> Event type returned by the request.
 */
public interface EventsBuilder<T> extends Builder<EventsRequest<T>> {
    /**
     * Specify the block number at which to start reading events.
     * <p>Note that the block number is an unsigned 64-bit integer, with the sign bit used to hold the top bit of
     * the number.</p>
     * @param blockNumber a ledger block number.
     * @return This builder.
     */
    EventsBuilder<T> startBlock(long blockNumber);
}
