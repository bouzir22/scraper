package com.example.scraper.Services;

import com.example.scraper.Scrapers.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScrapingService {



    public List<Item> scrap (String keyword){
        List<Item> finalItems =new ArrayList<>();

        List<Item> tItems ;
         List<Item> jItems;
          List<Item> mItems;
          List<Item>tuItems;

        TayaraScraper t=new TayaraScraper(keyword);
        MytekScraper m =new MytekScraper(keyword) ;
        JumiaScraper j =new JumiaScraper(keyword);
        TunisianetScraper tu = new TunisianetScraper(keyword);
        AutomobileScraper a = new AutomobileScraper(keyword);
        jItems=j.finalitems;
        tItems=t.finalitems;
        mItems=m.finalitems;
        tuItems=tu.finalitems;


        //tu.start();
      // t.start();
        j.start();
     // m.start();
     // a.start();

        while (true){
            if(!t.isAlive()&& !j.isAlive() && !m.isAlive() && !tu.isAlive() && ! a.isAlive())
            {
                finalItems.addAll(tItems);finalItems.addAll(jItems);finalItems.addAll(mItems);finalItems.addAll(tuItems);
            finalItems.addAll(a.finalOccasions);finalItems.addAll(a.finalNeufs);
            //   System.out.println("mytek"+mItems.size());
               // System.out.println("total="+finalItemes.size());
                break;}}

        System.out.println(finalItems);
        return finalItems.stream()
                .filter(c ->  c.getTitle().toLowerCase().indexOf(keyword.toLowerCase()) !=-1 )
                .collect(Collectors.toList());

    }














}
