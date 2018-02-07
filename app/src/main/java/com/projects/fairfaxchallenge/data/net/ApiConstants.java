package com.projects.fairfaxchallenge.data.net;

/**
 * API Constants
 */

class ApiConstants {

    // milliseconds - timeout in making the initial connection i.e. completing the TCP connection handshake.
    public static final int DEFAULT_CONNECT_TIMEOUT = 6000;
    // milliseconds - timeout on waiting to read data.
    public static final int DEFAULT_READ_TIMEOUT = 10000;

    // Cache Size in MB's
    public static final int CACHE_SIZE = 10 * 1024 * 1024;

}
