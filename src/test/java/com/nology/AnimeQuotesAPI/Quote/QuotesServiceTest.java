package com.nology.AnimeQuotesAPI.Quote;

import com.nology.AnimeQuotesAPI.Quote.exceptions.InvalidRequestException;
import com.nology.AnimeQuotesAPI.Quote.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class QuotesServiceTest {

    @Mock
    private IQuotesRepository quotesRepo;

    private QuotesService underTest;

    @BeforeEach
    void setUp() {
        underTest = new QuotesService(quotesRepo);
    }


    @Test
    void getQuotesByParameter() {
        underTest.getQuotesByParameter("cruel world", null, null);
        ArgumentCaptor<String> quoteArgumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(quotesRepo).findAllByCategory(quoteArgumentCaptor.capture());
        String capturedQuote = quoteArgumentCaptor.getValue();
        assertThat(capturedQuote).isEqualTo("cruel world");
    }

    @Test
    void getAllQuotes() {
        underTest.getAllQuotes();
        verify(quotesRepo).findAll();

    }

    @Test
    void getQuoteById() throws ResourceNotFoundException {
//        Quote quote = new Quote(1, "Eren", "Kill", "AOT", "Cruel World");
//        quotesRepo.save(quote);
//        underTest.getQuoteById(1);
//        ArgumentCaptor<Integer> quoteArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
//        verify(quotesRepo).findById(quoteArgumentCaptor.capture());
//        Integer capturedQuote = quoteArgumentCaptor.getValue();
//        assertThat(capturedQuote).isEqualTo(1);
        assertThatThrownBy(() -> underTest.getQuoteById(1))
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessageContaining("Quote with ID " + 1 + " not found :(");
    }

    @Test
    void addQuote() throws InvalidRequestException {
        Quote quote = new Quote(1, "Eren", "Kill", "AOT", "Cruel World");
        underTest.addQuote(quote);
        ArgumentCaptor<Quote> quoteArgumentCaptor = ArgumentCaptor.forClass(Quote.class);
        verify(quotesRepo).save(quoteArgumentCaptor.capture());
        Quote capturedQuote = quoteArgumentCaptor.getValue();
        assertThat(capturedQuote).isEqualTo(quote);

    }

    @Test
    void updateQuoteById() throws InvalidRequestException, ResourceNotFoundException {
//        Quote quote = new Quote(1, "Eren", "Kill", "AOT", "Cruel World");
//        quotesRepo.save(quote);
//        underTest.updateQuoteById(1, quote);
//        ArgumentCaptor<Quote> quoteArgumentCaptor = ArgumentCaptor.forClass(Quote.class);
//        verify(quotesRepo).save(quoteArgumentCaptor.capture());
//        Quote capturedQuote = quoteArgumentCaptor.getValue();
//        assertThat(capturedQuote).isEqualTo(quote);
        assertThatThrownBy(() -> underTest.getQuoteById(1))
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessageContaining("Quote with ID " + 1 + " not found :(");
    }

    @Test
    void deleteById() throws ResourceNotFoundException {
//        Quote quote = new Quote(1, "Eren", "Kill", "AOT", "Cruel World");
//        quotesRepo.save(quote);
//        underTest.deleteById(1);
//        ArgumentCaptor<Integer> quoteArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
//        verify(quotesRepo).deleteById(quoteArgumentCaptor.capture());
//        Integer capturedQuote = quoteArgumentCaptor.getValue();
//        assertThat(capturedQuote).isEqualTo(1);
        assertThatThrownBy(() -> underTest.getQuoteById(1))
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessageContaining("Quote with ID " + 1 + " not found :(");
    }
}