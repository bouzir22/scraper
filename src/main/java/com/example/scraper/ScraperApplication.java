package com.example.scraper;

import com.example.scraper.Scrapers.CategoryScrapers.Telephonie;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScraperApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScraperApplication.class, args);

	//	new Telephonie().start();
	}

}
