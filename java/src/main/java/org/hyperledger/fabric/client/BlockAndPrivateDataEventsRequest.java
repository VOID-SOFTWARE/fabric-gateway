/*
 * Copyright 2022 IBM All Rights Reserved.
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package org.hyperledger.fabric.client;

import org.hyperledger.fabric.protos.peer.EventsPackage;

/**
 * A Fabric Gateway call to obtain block and private data events. Supports off-line signing flow using
 * {@link Gateway#newSignedBlockAndPrivateDataEventsRequest(byte[], byte[])}.
 */
public interface BlockAndPrivateDataEventsRequest extends EventsRequest<EventsPackage.BlockAndPrivateData> {
    /**
     * Builder used to create a new block and private data events request. The default behavior is to read events from
     * the next committed block.
     */
    interface Builder extends EventsBuilder<EventsPackage.BlockAndPrivateData> {
        @Override
        Builder startBlock(long blockNumber);

        @Override
        BlockAndPrivateDataEventsRequest build();
    }
}
