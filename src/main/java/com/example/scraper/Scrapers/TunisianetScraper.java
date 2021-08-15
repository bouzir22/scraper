package com.example.scraper.Scrapers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class TunisianetScraper extends Thread {
    String baseUrl ;
    public List<Item> finalitems =new ArrayList<Item>();
    public TunisianetScraper(String keyword)
    {
      this.baseUrl=  "https://www.tunisianet.com.tn/recherche?controller=search&orderby=price&orderway=asc&s="+keyword+"&submit_search=";
        System.out.println(keyword);

    }



    public void run (){
        try {
            Document document = Jsoup.connect(this.baseUrl).get();
           // System.out.println(document.outerHtml());
            Elements elements = document.select("div.item-product.col-xs-12");
            System.out.println(elements.size());


            for (Element e:elements
                 ) {

             // System.out.println(e);

               String title=    e.select("h2.h3.product-title").select("a").first().text();
                String price=e.select("span.price").first().text();
                Element imageElement = e.select("img").first();

                String absoluteUrl = imageElement.absUrl("src");

             //   System.out.println(new Item(title,price,absoluteUrl));
              this.finalitems.add(new Item(title,price,absoluteUrl));





            }
        }
        catch (Exception e){e.printStackTrace();}



    }



}
