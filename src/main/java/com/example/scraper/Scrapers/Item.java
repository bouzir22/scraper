package com.example.scraper.Scrapers;


import java.util.List;

public final class Item {
    private String title ;
    private String price ;
    private String image;
    private String ancher;
    private List<String> images;

    public Item(String title, String price, String image) {
        this.title = title;
        this.price = price;
        this.image = image;

    }

    public Item(String title, String price, String image,List<String> images) {
        this.title = title;
        this.price = price;
        this.image = image;
        this.images=images;

    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    @Override
    public String toString() {
        return "Item{" +
                "title='" + title + '\'' +
                ", price='" + price + '\'' +
                ", image='" + image + '\'' +
                ", ancher='" + ancher + '\'' +
                ", images=" + images +
                '}';
    }
}