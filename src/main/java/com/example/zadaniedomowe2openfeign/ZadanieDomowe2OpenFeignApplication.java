package com.example.zadaniedomowe2openfeign;

import com.example.zadaniedomowe2openfeign.proxy.ValueResponse;
import com.example.zadaniedomowe2openfeign.service.QuoteService;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.event.EventListener;

import static org.apache.logging.log4j.LogManager.getLogger;

@SpringBootApplication
@EnableFeignClients
public class ZadanieDomowe2OpenFeignApplication {

    private final QuoteService quoteService;

    public ZadanieDomowe2OpenFeignApplication(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    Logger log = getLogger(ZadanieDomowe2OpenFeignApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(ZadanieDomowe2OpenFeignApplication.class, args);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void run() {
        log.info(quoteService.fetchAllQuotes());
        log.info("quoteService fetched: " + quoteService.fetchQuoteByPathVariable("2"));
        log.info("quoteService fetched random: " + quoteService.fetchRandomQuote());
        log.info("quoteService fetched: " + quoteService.fetchQuoteByRequestParam("3"));
        log.info("quoteService fetched: " + quoteService.fetchQuoteWithHeader("hello World!"));

    }
}
