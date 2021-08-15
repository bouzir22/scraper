package com.example.scraper.Scrapers.CategoryScrapers;

import com.example.scraper.Scrapers.Item;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.CommandLineRunner;

import java.util.ArrayList;
import java.util.List;

public class Telephonie extends Thread  {
   public List<Item>finalItems =new ArrayList<>();

    public void run()
    {


       try { Document document = Jsoup.connect("https://www.jumia.com.tn/mlp-telephone-tablette/smartphones/").get();
        //   System.out.println(document.outerHtml());


           Elements elems = document.select("article.prd");
           boolean x=true;

           for(Element elem :elems){
               String name =elem.select("h3.name").text();
               String price = elem.select("div.prc").text();
               Element imageElement = elem.select("img").first();

               String absoluteUrl = imageElement.absUrl("src");  //absolute URL on src

               String srcValue = imageElement.attr("data-src");
             //  System.out.println(elem);
              // System.out.println(srcValue);

               finalItems.add(new Item(name,price,srcValue));
               if(x==true) {System.out.println(new Item(name,price,srcValue));}
               x=false;

           /*System.out.println(name);
            System.out.println(price);
           ;*/



           }











       }
       catch (Exception e){e.printStackTrace();}



    }



}
