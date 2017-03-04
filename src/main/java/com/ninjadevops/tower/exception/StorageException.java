package com.ninjadevops.tower.exception;

/**
 * Created by me@liguoliang.com on 3/4/2017.
 */
public class StorageException extends Exception {
    public StorageException(Throwable cause) {
        super(cause);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
