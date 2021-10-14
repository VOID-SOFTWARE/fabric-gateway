/*
 * Copyright 2021 IBM All Rights Reserved.
 *
 * SPDX-License-Identifier: Apache-2.0
 */

import { TxValidationCodeMap } from './protos/peer/transaction_pb';
import { Status, StatusNames } from './status';

/**
 * CommitError is thrown to indicate that a transaction committed with an unsuccessful status code.
 */
export class CommitError extends Error {
    /**
     * Transaction validation status code. The value corresponds to one of the values enumerated by {@link StatusCode}.
     */
    code: TxValidationCodeMap[keyof TxValidationCodeMap];

    /**
     * The ID of the transaction.
     */
    transactionId: string;

    constructor(properties: Omit<CommitError, keyof Error> & Partial<Error>) {
        super(properties.message);

        this.name = 'CommitError';
        this.code = properties.code;
        this.transactionId = properties.transactionId;
    }
}

export function newCommitError(status: Status): CommitError {
    return new CommitError({
        message: `Transaction ${status.transactionId} failed to commit with status code ${status.code} (${StatusNames[status.code]})`,
        code: status.code,
        transactionId: status.transactionId,
    });
}