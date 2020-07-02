package com.vikhyathdevadiga.bookgrocer;

public class Product {

    int product_image;
    float product_rating;
    String product_title, product_author, product_description;

    public Product() {
    }

    public Product(int product_image, float product_rating, String product_title, String product_author, String product_description) {
        this.product_image = product_image;
        this.product_rating = product_rating;
        this.product_title = product_title;
        this.product_author = product_author;
        this.product_description = product_description;
    }

    public Product(int product_image, String product_title, String product_author) {
        this.product_image = product_image;
        this.product_title = product_title;
        this.product_author = product_author;
    }

    public Product(int product_image, float product_rating, String product_title, String product_author) {
        this.product_image = product_image;
        this.product_rating = product_rating;
        this.product_title = product_title;
        this.product_author = product_author;
    }

    public int getProduct_image() {
        return product_image;
    }

    public void setProduct_image(int product_image) {
        this.product_image = product_image;
    }

    public float getProduct_rating() {
        return product_rating;
    }

    public void setProduct_rating(float product_rating) {
        this.product_rating = product_rating;
    }

    public String getProduct_title() {
        return product_title;
    }

    public void setProduct_title(String product_title) {
        this.product_title = product_title;
    }

    public String getProduct_author() {
        return product_author;
    }

    public void setProduct_author(String product_author) {
        this.product_author = product_author;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }
}
