package com.example.scraper.Controllers;


import com.example.scraper.Scrapers.CategoryScrapers.Automobile;
import com.example.scraper.Scrapers.CategoryScrapers.Telephonie;
import com.example.scraper.Scrapers.Item;
import com.example.scraper.Services.ScrapingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class DataController {
    @Autowired
    ScrapingService scrapingService ;

    @RequestMapping("scrap/{keyword}")
    public List<Item> scrap(@PathVariable(name = "keyword") String keyword)
    {
        System.out.println("********"+this.scrapingService.scrap(keyword));return this.scrapingService.scrap(keyword);}

    @RequestMapping("static/{param}")
            public List<Item>staticScrap(@PathVariable(name = "param") String param)
    {switch (param){

       case "auto":{


           Automobile auto = new Automobile();
           auto.start();
           while (true){if(! auto.isAlive())break;}
           return auto.finalItems;


       }

        case "tel":{
            Telephonie telephonie =new Telephonie();
            telephonie.start();
            while (true){if(! telephonie.isAlive())break;}
            return telephonie.finalItems;


        }

        default:return null;

    }



    }
}
