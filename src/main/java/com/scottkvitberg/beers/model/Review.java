package com.scottkvitberg.beers.model;

/**
 * Created by kitsco12 on 27/06/16.
 */
public class Review {
    private int id;
    private int beerId;
    private int rating;
    private String country;
    private String comment;



    public Review(int beerId, int rating, String country, String comment) {

        this.beerId = beerId;
        this.rating = rating;
        this.country = country;
        this.comment = comment;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBeerId() {
        return beerId;
    }

    public void setBeerId(int beerId) {
        this.beerId = beerId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Review review = (Review) o;

        if (id != review.id) return false;
        if (beerId != review.beerId) return false;
        if (rating != review.rating) return false;
        if (!country.equals(review.country)) return false;
        return comment != null ? comment.equals(review.comment) : review.comment == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + beerId;
        result = 31 * result + rating;
        result = 31 * result + country.hashCode();
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return result;
    }

}
