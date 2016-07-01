package com.scottkvitberg.beers.dao;

import com.scottkvitberg.beers.exc.DaoException;
import com.scottkvitberg.beers.model.Review;

import java.util.List;

/**
 * Created by kitsco12 on 27/06/16.
 */
public interface ReviewDao {
    void add(Review review) throws DaoException;

    List<Review> findAll();
    List<Review> findByBeerId(int beerId);

}
