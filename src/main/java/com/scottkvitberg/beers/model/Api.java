package com.scottkvitberg.beers.model;

import com.google.gson.Gson;
import com.scottkvitberg.beers.dao.BeerDao;
import com.scottkvitberg.beers.dao.Sql2oBeerDao;
import com.scottkvitberg.beers.model.Beer;
import org.sql2o.Sql2o;

import static spark.Spark.*;

/**
 * Created by kitsco12 on 30/06/16.
 */
public class Api {
    public static void main(String[] args){
        String datasource = "jdbc:h2:~/reviews.db;";

        if (args.length > 0){
            if(args.length != 2){
                System.out.println("Java API - required args: <port> <datasource>");
                System.exit(0);
            }
            port(Integer.parseInt(args[0]));
            datasource = args[1];
        }
        Sql2o sql2o = new Sql2o(
                String.format("%sINIT=RUNSCRIPT from 'classpath:db/init.sql'", datasource, "", ""));
        BeerDao beerDao = new Sql2oBeerDao(sql2o);
        Gson gson = new Gson();

        post("/beers", "application/json", (req, res) -> {

            Beer beer = gson.fromJson(req.body(), Beer.class);         //Returns the json
            beerDao.add(beer);
            res.status(201);        // 201 = Created
            res.type("application/json");
            return beer;
        }, gson::toJson);   // <- To transform back to JSON. Method referanse.

        get("/beers", "application/json", (req, res) -> beerDao.findAll(), gson::toJson);

        get("/beers/:id", "application/json", (req, res) -> {

            int id = Integer.parseInt(req.params("id"));
            // TODO:csd - What if this is not found
            Beer beer = beerDao.findById(id);
            return beer;
        }, gson::toJson);


        after((req, res) -> {
            res.type("application/json");

        });
    }
}
