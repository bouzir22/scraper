package com.example.scraper.Scrapers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class JumiaScraper extends  Thread {
    String baseUrl = "https://www.jumia.com.tn/catalog/?q=";
    String testUrl = "https://www.jumia.com.tn/lc-waikiki-short-bermuda-femmes-couleur-beige-clair-9su516z8-fvu-light-beige-288705.html";
    public List<Item> finalitems = new ArrayList<Item>();


    public JumiaScraper(String keyword) {
        this.baseUrl += keyword;

    }


    public void run() {
        try {

            Document document = Jsoup.connect(baseUrl).get();
            // System.out.println(document.outerHtml());
            Elements elems = document.select("article.prd");

            for (Element elem : elems) {
                String name = elem.select("h3.name").text();
                String price = elem.select("div.prc").text();

               //product image
                Element imageElement = elem.select("img").first();

                String absoluteUrl = imageElement.absUrl("src");  //absolute URL on src

                String srcValue = imageElement.attr("data-src");




                //product page
                Element anchor = elem.select("a").first();
                String pageUrl = anchor.absUrl("href");

                finalitems.add(new Item(name, price, srcValue,getImages(pageUrl)));
                System.out.println(new Item(name, price, srcValue,getImages(pageUrl)));


            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    List<String> getImages(String url) {
        List<String> urls = new ArrayList<>();

        try {
            Document document = Jsoup.connect(url).get();
            Element element = document.select("div.sldr._img._prod.-rad4.-oh.-mbs").first();
            Elements elements = element.select("img");
            for (Element elem : elements) {
                urls.add(elem.attr("data-src"));
            }}

        catch(Exception e){
                e.printStackTrace();
            }



        return urls;

    }

}