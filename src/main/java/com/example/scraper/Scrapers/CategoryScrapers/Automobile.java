package com.example.scraper.Scrapers.CategoryScrapers;

import com.example.scraper.Scrapers.Item;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class Automobile extends Thread{
   public List<Item> finalItems=new ArrayList<>();
    public void run (){
        try {
            System.out.println("running static autos");
            Document documentN = Jsoup.connect( "https://www.automobile.tn/fr/neuf/recherche?expand=1&brand%5B%5D=&model%5B%5D=&" +
                    "nombre_de_places_min=5&nombre_de_portes%5B%5D=452&nombre_de_cylindres_min=4&boite%5B%5D=11&nombre_de_rapports_min=5"
).get();

            //versions-item
            Elements neufs = documentN.select("div.versions-item");
            //  Elements  occasions=documentO.select("div.occasion-item");


            //      System.out.println(documentO.outerHtml());


            for (Element e:neufs
            ) {


                String title =e.select("h2").text();
                String price=e.select("div.price").text();
                Element imageElement = e.select("img").first();

                String absoluteUrl = imageElement.absUrl("src");  //absolute URL on src
                System.out.println(new Item(title,price,absoluteUrl));

                this.finalItems.add(new Item(title,price,absoluteUrl));

            }





// getOccasions(occasions);

        }catch (Exception e){e.printStackTrace();}



    }

}
