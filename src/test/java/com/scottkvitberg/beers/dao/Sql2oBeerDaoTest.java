package com.scottkvitberg.beers.dao;

import com.scottkvitberg.beers.model.Beer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

/**
 * Created by kitsco12 on 28/06/16.
 */
public class Sql2oBeerDaoTest {

    private Sql2oBeerDao dao;
    private Connection conn;
    private String testParam1 = "Test";
    private String testParam2 = "http://www.test.com";

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from  'classpath:db/init.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        dao = new Sql2oBeerDao(sql2o);

        //Keep connection open though the entire test.
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        //Since we want the connection to be open through the whole test. We can simply use the tearDown method to close it.
        conn.close();

    }

    @Test
    public void addingBeerSetId() throws Exception {
        Beer beer = new Beer(testParam1, testParam2);
        int originalBeerId = beer.getId();

        dao.add(beer);
        assertNotEquals(originalBeerId, beer.getId());
    }

    @Test
    public void addedBeersAreReturnedFromFindAll() throws Exception {
        Beer beer = new Beer(testParam1, testParam2);
        dao.add(beer);

        assertEquals(1, dao.findAll().size());
    }

    @Test
    public void noBeersReturnEmptyList() throws Exception {
        assertEquals(0, dao.findAll().size());

    }

    @Test
    public void excisingBeersCanBeFoundById() throws Exception {
        Beer beer = new Beer(testParam1, testParam2);
        dao.add(beer);

        Beer foundBeer = dao.findById(beer.getId());
        assertEquals(beer, foundBeer);
    }
}