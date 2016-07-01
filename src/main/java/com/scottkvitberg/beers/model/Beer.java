package com.scottkvitberg.beers.model;

/**
 * Created by kitsco12 on 27/06/16.
 */
public class Beer {
    private int id;
    private String name;
    private String url;


    public Beer(String name, String url) {

        this.name = name;
        this.url = url;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Beer beer = (Beer) o;

        if (id != beer.id) return false;
        if (!name.equals(beer.name)) return false;
        return url.equals(beer.url);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + url.hashCode();
        return result;
    }
}
