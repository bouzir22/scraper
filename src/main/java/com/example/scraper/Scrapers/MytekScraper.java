package com.example.scraper.Scrapers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class MytekScraper extends Thread {
    String baseUrl ;
    public List<Item> finalitems =new ArrayList<Item>();

    public  MytekScraper(String keyword)
    {this.baseUrl="https://www.mytek.tn/nouveaute.html";
        this.baseUrl= "https://www.mytek.tn/recherche?search_query="+keyword+"&orderby=position&orderway=desc&submit_search=&n=179"
        ;}


    public void run () {
        int i = 0;


        try {
            final Document document = Jsoup.connect(baseUrl).get();
            //System.out.println(document.outerHtml());

            Elements elems = document.select("li.ajax_block_product");
            System.out.println(elems.size());


            for (Element elem : elems) {
                i++;
                //   System.out.println(elem);
                Element imageElement = elem.select("img").first();

                String absoluteUrl = imageElement.absUrl("src");  //absolute URL on src

                String srcValue = imageElement.attr("src");

                String title = elem.select("a.product-name").text();
                String price = elem.select("span.price").text();
                System.out.println(title);
                System.out.println(price);
                System.out.println(srcValue);

                finalitems.add(new Item(title, price, srcValue));

                //System.out.println(price);
                //   System.out.println(title);
                //  System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }}


