/*
 * Copyright 2022 IBM All Rights Reserved.
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package org.hyperledger.fabric.client;

import org.hyperledger.fabric.protos.common.Common;

///**
// * A Fabric Gateway call to obtain block events. Supports off-line signing flow using
// * {@link Gateway#newSignedBlockEventsRequest(byte[], byte[])}.
// */
/**
 * A Fabric Gateway call to obtain block events.
 */
public interface BlockEventsRequest extends EventsRequest<Common.Block> {
    /**
     * Builder used to create a new block events request. The default behavior is to read events from the next
     * committed block.
     */
    interface Builder extends EventsBuilder<Common.Block> {
        @Override
        Builder startBlock(long blockNumber);

        @Override
        BlockEventsRequest build();
    }
}
