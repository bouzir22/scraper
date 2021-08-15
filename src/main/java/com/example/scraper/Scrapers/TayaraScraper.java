package com.example.scraper.Scrapers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class TayaraScraper extends  Thread {
    String baseUrl ="https://www.tayara.tn/k/";
    public  TayaraScraper(String keyword)
    {this.baseUrl+=keyword;}

    public List<Item> finalitems =new ArrayList<Item>();

    public void run () {

        try {
            final Document document = Jsoup.connect(baseUrl).get();

            int i = 0;

            // System.out.println(document.outerHtml());
            Elements elems = document.select("div.card__body");
            System.out.println(elems.size());

            //System.out.println("elems" + elems);
            for (Element elem : document.select("div.card")) {
                Element imageElement = elem.select("div").first();
                String imageUrl =  elem.select("div[class=card__preview]").attr("style");
               imageUrl= imageUrl.substring(imageUrl.indexOf('\'')+1,imageUrl.indexOf(')')-1);
                String price = elem.select("h2.card__body__element").first().text();
                String title = elem.select("h2.card__body__element").last().text();
                System.out.println(imageUrl);

                // System.out.println(elem);
                // finalitems.add(new Item(title ,price));

                //System.out.println(price);
                //   System.out.println(title);
                //  System.out.println();
                finalitems.add(new Item(title, price, imageUrl));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


      /*  for (Item e : finalitems) {
            System.out.println(e.toString());
        }*/


    }}