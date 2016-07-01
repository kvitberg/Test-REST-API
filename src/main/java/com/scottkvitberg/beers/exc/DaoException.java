package com.scottkvitberg.beers.exc;

/**
 * Created by kitsco12 on 27/06/16.
 */
public class DaoException extends Exception {
    private final Exception originalException;

    public DaoException(Exception originalException, String msg){
        super(msg);
        this.originalException = originalException;
    }
}
