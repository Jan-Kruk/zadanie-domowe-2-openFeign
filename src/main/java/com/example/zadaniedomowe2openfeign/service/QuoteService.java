package com.example.zadaniedomowe2openfeign.service;

import com.example.zadaniedomowe2openfeign.proxy.QuoteResponse;
import com.example.zadaniedomowe2openfeign.proxy.QuoteServerProxy;
import com.example.zadaniedomowe2openfeign.proxy.ValueResponse;
import feign.FeignException;
import feign.RetryableException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Log4j2
public class QuoteService {


    @Qualifier("com.example.zadaniedomowe2openfeign.proxy.QuoteServerProxy")
    private final QuoteServerProxy quoteServerClient;

    public QuoteService(@Qualifier("com.example.zadaniedomowe2openfeign.proxy.QuoteServerProxy") QuoteServerProxy quoteServerClient) {
        this.quoteServerClient = quoteServerClient;
    }


    public List<QuoteResponse> fetchAllQuotes() {
        try {
            return quoteServerClient.getAllQuoteRequest();
        } catch (FeignException.FeignClientException e) {
            log.error("client exception: " + e.status());
        } catch (RetryableException e) {
            log.error("Feign server exception " + e.status() + " " + e.getMessage());
        } catch (FeignException e) {
            log.error("Feign exception " + e.status() + " " + e.getMessage());
        }
        return Collections.emptyList();
    }

    public QuoteResponse fetchQuoteByPathVariable(String id){
        try {
            return quoteServerClient.getQuoteByPathVariableRequest(id);
        } catch (FeignException.FeignClientException e) {
            log.error("client exception: " + e.status());
        } catch (RetryableException e) {
            log.error("Feign server exception " + e.status() + " " + e.getMessage());
        } catch (FeignException e) {
            log.error("Feign exception " + e.status() + " " + e.getMessage());
        }
        return new QuoteResponse("",new ValueResponse(0,""));
    }
    public QuoteResponse fetchRandomQuote(){
        try {
            return quoteServerClient.getRandomQuoteRequest();
        } catch (FeignException.FeignClientException e) {
            log.error("client exception: " + e.status());
        } catch (RetryableException e) {
            log.error("Feign server exception " + e.status() + " " + e.getMessage());
        } catch (FeignException e) {
            log.error("Feign exception " + e.status() + " " + e.getMessage());
        }
        return new QuoteResponse("",new ValueResponse(0,""));
    }
    public QuoteResponse fetchQuoteByRequestParam(String id){
        try {
            return quoteServerClient.getQuoteByRequestParamRequest(id);
        } catch (FeignException.FeignClientException e) {
            log.error("client exception: " + e.status());
        } catch (RetryableException e) {
            log.error("Feign server exception " + e.status() + " " + e.getMessage());
        } catch (FeignException e) {
            log.error("Feign exception " + e.status() + " " + e.getMessage());
        }
        return new QuoteResponse("",new ValueResponse(0,""));
    }
    public List<QuoteResponse> fetchQuoteWithHeader(String requestId){
        try {
            return quoteServerClient.getQuoteWithHeaderRequest(requestId);
        } catch (FeignException.FeignClientException e) {
            log.error("client exception: " + e.status());
        } catch (RetryableException e) {
            log.error("Feign server exception " + e.status() + " " + e.getMessage());
        } catch (FeignException e) {
            log.error("Feign exception " + e.status() + " " + e.getMessage());
        }
        return Collections.emptyList();
    }
    public void postQuote(ValueResponse quote){
        try {
            System.out.println(quoteServerClient.postQuoteRequest(quote));
        } catch (FeignException.FeignClientException e) {
            log.error("client exception: " + e.status());
        } catch (RetryableException e) {
            log.error("Feign server exception " + e.status() + " " + e.getMessage());
        } catch (FeignException e) {
            log.error("Feign exception " + e.status() + " " + e.getMessage());
        }
    }
}

