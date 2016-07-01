import com.scottkvitberg.beers.dao.BeerDao;
import com.scottkvitberg.beers.dao.Sql2oBeerDao;
import org.sql2o.Sql2o;

import static spark.Spark.post;

/**
 * Created by kitsco12 on 30/06/16.
 */
public class Api {
    public static void main(String[] args){
        Sql2o sql2o = new Sql2o("jdbc:h2:~/reviews.db;INIT=RUNSCRIPT from 'classpath:db/init.sql'");
        BeerDao beerDao = new Sql2oBeerDao(sql2o);

        post("/Beers", "application/json", (req, res) -> {
            req.body();         //Returns the json
            return null;
        })
    }
}
