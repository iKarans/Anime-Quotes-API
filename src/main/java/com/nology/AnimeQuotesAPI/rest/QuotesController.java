package com.nology.AnimeQuotesAPI.rest;

import com.nology.AnimeQuotesAPI.entity.Message;
import com.nology.AnimeQuotesAPI.entity.Quote;
import com.nology.AnimeQuotesAPI.exceptions.InvalidRequestException;
import com.nology.AnimeQuotesAPI.exceptions.ResourceNotFoundException;
import com.nology.AnimeQuotesAPI.repository.IQuotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
public class QuotesController {

    @Autowired
    private IQuotesRepository quotesRepo;

    @GetMapping("/quotes")
    public ResponseEntity<List<Quote>> getQuotesByCategory(@RequestParam String search) {
        return ResponseEntity.status(HttpStatus.OK).body(quotesRepo.findAllByCategory(search));
    }

    @GetMapping("/quotes/all")
    public ResponseEntity<List<Quote>> getAllQuotes() {
        return ResponseEntity.status(HttpStatus.OK).body(quotesRepo.findAll());
    }

    @GetMapping("/quotes/{id}")
    public ResponseEntity<Quote> getQuoteById(@PathVariable int id) throws ResourceNotFoundException {
        handleResourceNotFound(id);
        return ResponseEntity.status(HttpStatus.OK).body(quotesRepo.findById(id).orElse(null));
    }

    @PostMapping("/quotes")
    public ResponseEntity<Quote> addQuote(@RequestBody Quote quote) throws InvalidRequestException {
        try {
            Quote createdQuote = quotesRepo.save(quote);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdQuote);
        } catch (Exception e) {
            throw new InvalidRequestException("Incorrect data supplied");
        }
    }

    @PutMapping("quotes/{id}")
    public ResponseEntity<Quote> updateQuoteById(@PathVariable int id, @RequestBody Quote quote) throws ResourceNotFoundException, InvalidRequestException {
        handleResourceNotFound(id);
        try {
            quote.setId(id);
            quotesRepo.save(quote);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(quote);
        } catch (Exception e) {
            throw new InvalidRequestException("Incorrect data supplied");
        }

    }

    @DeleteMapping("quotes/{id}")
    public ResponseEntity<Message> deleteById(@PathVariable int id) throws ResourceNotFoundException {
        handleResourceNotFound(id);
        quotesRepo.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new Message("The quote with id " + id + " has been deleted"));
    }

    private void handleResourceNotFound(int id) throws ResourceNotFoundException {
        Quote existingQuote = quotesRepo.findById(id).orElse(null);
        if (existingQuote == null) throw new ResourceNotFoundException("Quote with ID " + id + " not found :(");
    }
}
