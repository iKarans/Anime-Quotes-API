package com.nology.AnimeQuotesAPI.Quote;

import com.nology.AnimeQuotesAPI.Quote.exceptions.Message;
import com.nology.AnimeQuotesAPI.Quote.exceptions.InvalidRequestException;
import com.nology.AnimeQuotesAPI.Quote.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class QuotesController {

    private QuotesService quotesService;

    @Autowired
    public QuotesController(QuotesService quotesService) {
        this.quotesService = quotesService;
    }

    @GetMapping("/quotes")
    public ResponseEntity<List<Quote>> getQuotesByParameter(@RequestParam(required = false) String category, @RequestParam(required = false) String animeName, @RequestParam(required = false) String characterName) {
        return quotesService.getQuotesByParameter(category, animeName, characterName);

    }

    @GetMapping("/quotes/all")
    public ResponseEntity<List<Quote>> getAllQuotes() {
        return quotesService.getAllQuotes();
    }

    @GetMapping("/quotes/{id}")
    public ResponseEntity<Quote> getQuoteById(@PathVariable int id) throws ResourceNotFoundException {
        return quotesService.getQuoteById(id);
    }

    @PostMapping("/quotes")
    public ResponseEntity<Quote> addQuote(@RequestBody Quote quote) throws InvalidRequestException {
        return quotesService.addQuote(quote);
    }

    @PutMapping("quotes/{id}")
    public ResponseEntity<Quote> updateQuoteById(@PathVariable int id, @RequestBody Quote quote) throws ResourceNotFoundException, InvalidRequestException {
        return quotesService.updateQuoteById(id, quote);
    }

    @DeleteMapping("quotes/{id}")
    public ResponseEntity<Message> deleteById(@PathVariable int id) throws ResourceNotFoundException {
        return quotesService.deleteById(id);
    }

}
