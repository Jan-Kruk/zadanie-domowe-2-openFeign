package com.example.zadaniedomowe2openfeign.proxy;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Component
@Log4j2
@FeignClient
public class QuoteServerProxy {
    @GetMapping("/api")
    public List<QuoteResponse> getAllQuoteRequest(){

    }
}
