package main.oracle.academy.fp.service;

import main.oracle.academy.fp.model.Request;

/**
 * Provides all of business operations with <code>Request</code> objects that we’re interested in.
 * Also provides all transactions.
 *
 */
public interface RequestService {
    Request sendRequest(Long taskId, Request request);
    Request getRequestById(Long requestId);
}
