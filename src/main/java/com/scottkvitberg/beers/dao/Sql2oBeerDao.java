package com.scottkvitberg.beers.dao;

import com.scottkvitberg.beers.exc.DaoException;
import com.scottkvitberg.beers.model.Beer;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

/**
 * Created by kitsco12 on 28/06/16.
 */
public class Sql2oBeerDao implements BeerDao {

    private final Sql2o sql2o;

    public Sql2oBeerDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    public void add(Beer beer) throws DaoException {
        String sql = "INSERT INTO beers(name, url) VALUES(:name, :url)";
        try (Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql)
                    .bind(beer)
                    .executeUpdate()
                    .getKey();
            beer.setId(id);

        } catch (Sql2oException ex){
            throw new DaoException(ex, "Problem adding beer");
        }

    }

    public List<Beer> findAll() {

        try (Connection con = sql2o.open()){

            return con.createQuery("SELECT * FROM beers").executeAndFetch(Beer.class);
        }
    }

    @Override
    public Beer findById(int id) {
        try (Connection con = sql2o.open()){
            return con.createQuery("SELECT * from beers WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Beer.class);

        }

    }
}
