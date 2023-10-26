package com.example.zadaniedomowe2openfeign.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@FeignClient(value = "quote-server-service")
public interface QuoteServerProxy {
    @GetMapping("/api")
    List<QuoteResponse> getAllQuoteRequest();

    @GetMapping("/api/{id}")
    QuoteResponse getQuoteByPathVariableRequest(@PathVariable String id);
    @GetMapping("/api/random")
    QuoteResponse getRandomQuoteRequest();
    @GetMapping("/apiWithRequestParam")
    QuoteResponse getQuoteByRequestParamRequest(@RequestParam String id);
    @GetMapping("/apiWithHeader")
    List<QuoteResponse> getQuoteWithHeaderRequest(@RequestHeader String requestId);
    @PostMapping("/api/quote")
    String  postQuoteRequest(@RequestBody ValueResponse quote);
}
