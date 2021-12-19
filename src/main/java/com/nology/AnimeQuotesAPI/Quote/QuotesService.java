package com.nology.AnimeQuotesAPI.Quote;

import com.nology.AnimeQuotesAPI.Quote.exceptions.InvalidRequestException;
import com.nology.AnimeQuotesAPI.Quote.exceptions.Message;
import com.nology.AnimeQuotesAPI.Quote.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuotesService {

    private IQuotesRepository quotesRepo;

    @Autowired
    public QuotesService(IQuotesRepository quotesRepo) {
        this.quotesRepo = quotesRepo;
    }

    public ResponseEntity<List<Quote>> getQuotesByParameter(String category, String animeName, String characterName) {
        if(category != null) {
            return ResponseEntity.status(HttpStatus.OK).body(quotesRepo.findAllByCategory(category));
        } else if (animeName != null) {
            return ResponseEntity.status(HttpStatus.OK).body(quotesRepo.findAllByAnimeName(animeName));
        }
        return ResponseEntity.status(HttpStatus.OK).body(quotesRepo.findAllByCharacterName(characterName));
    }

    public ResponseEntity<List<Quote>> getAllQuotes() {
        return ResponseEntity.status(HttpStatus.OK).body(quotesRepo.findAll());
    }

    public ResponseEntity<Quote> getQuoteById(int id) throws ResourceNotFoundException {
        handleResourceNotFound(id);
        return ResponseEntity.status(HttpStatus.OK).body(quotesRepo.findById(id).orElse(null));
    }

    public ResponseEntity<Quote> addQuote(Quote quote) throws InvalidRequestException {
        try {
            Quote createdQuote = quotesRepo.save(quote);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdQuote);
        } catch (Exception e) {
            throw new InvalidRequestException("Incorrect data supplied");
        }
    }

    public ResponseEntity<Quote> updateQuoteById(int id, Quote quote) throws ResourceNotFoundException, InvalidRequestException {
        handleResourceNotFound(id);
        try {
            quote.setId(id);
            quotesRepo.save(quote);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(quote);
        } catch (Exception e) {
            throw new InvalidRequestException("Incorrect data supplied");
        }
    }

    public ResponseEntity<Message> deleteById(int id) throws ResourceNotFoundException {
        handleResourceNotFound(id);
        quotesRepo.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new Message("The quote with id " + id + " has been deleted"));
    }

    private void handleResourceNotFound(int id) throws ResourceNotFoundException {
        Quote existingQuote = quotesRepo.findById(id).orElse(null);
        if (existingQuote == null) throw new ResourceNotFoundException("Quote with ID " + id + " not found :(");
    }


}
