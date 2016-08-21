package com.scottkvitberg.beers.dao;

import com.scottkvitberg.beers.model.Api;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import spark.Spark;

import static org.junit.Assert.*;

/**
 * Created by kitsco12 on 20/08/16.
 */
public class ApiTest {

    public static final String PORT = "4568";
    public static final String TEST_DATASOURCE = "jdbc:h2:mem:testing";
    public static final String INIT_RUNSCRIPT = "INIT=RUNSCRIPT from 'classpath:db/init.sql";
    private Connection conn;


    @BeforeClass
    public static void startServer(){
        String[] args = {PORT, TEST_DATASOURCE};
        Api.main(null);
    }

    @AfterClass
    public static void stopServer(){
        Spark.stop();
    }


    @Before
    public void setUp() throws Exception {
        Sql2o sql2o = new Sql2o(TEST_DATASOURCE + INIT_RUNSCRIPT);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

}