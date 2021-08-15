package com.example.scraper.Scrapers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class AutomobileScraper extends Thread {


    public List<Item> finalNeufs =new ArrayList<Item>();
    public List<Item> finalOccasions=new ArrayList<Item>();
   private String neuf ="https://www.automobile.tn/fr/neuf/recherche?keyword=";
   private String occasion ="https://www.automobile.tn/fr/occasion?keyword=";

    public AutomobileScraper(String keyword) {
        occasion+=keyword;
        neuf+=keyword;

    }


    public void run (){
        try {
            System.out.println("running");
            Document documentO = Jsoup.connect(this.occasion).get();
            Document documentN=Jsoup.connect(this.neuf).get();
                      //versions-item
            Elements neufs = documentN.select("div.versions-item");
           Elements  occasions=documentO.select("div.occasion-item");


      //      System.out.println(documentO.outerHtml());


 getNeufs(neufs);
 getOccasions(occasions);

        }catch (Exception e){e.printStackTrace();}



    }




    public void getNeufs(Elements elems){


        for (Element e:elems
             ) {


            String title =e.select("h2").text();
            String price=e.select("div.price").text();
            Element imageElement = e.select("img").first();

            String absoluteUrl = imageElement.absUrl("src");  //absolute URL on src
            System.out.println(new Item(title,price,absoluteUrl));
            this.finalNeufs.add(new Item(title,price,absoluteUrl));

        }


    }
    public void getOccasions(Elements elems){

        for (Element elem :elems){

            Element imageElement = elem.select("img").first();

            String absoluteUrl = imageElement.absUrl("src");  //absolute URL on src

            String srcValue = imageElement.attr("data-src");





            String title =elem.select("h2").text();
            String price=elem.select("div.price").text();

           System.out.println(new Item(title,price,srcValue));
            this.finalOccasions.add(new Item(title,price,srcValue));


        }



    }





}
