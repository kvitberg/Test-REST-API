package com.scottkvitberg.beers.dao;

import com.scottkvitberg.beers.exc.DaoException;
import com.scottkvitberg.beers.model.Beer;

import java.util.List;

/**
 * Created by kitsco12 on 27/06/16.
 */
public interface BeerDao {
    void add(Beer beer) throws DaoException;

    List<Beer> findAll();
}
