CREATE TABLE IF NOT EXISTS beers (
   id int PRIMARY KEY auto_increment,
   name VARCHAR,
   url VARCHAR
);

CREATE TABLE IF NOT EXISTS reviews (
   id INTEGER PRIMARY KEY auto_increment,
   beer_id INTEGER,
   rating INTEGER,
   country VARCHAR,
   comment VARCHAR,
   FOREIGN KEY(beer_id) REFERENCES public.beers(id)
);