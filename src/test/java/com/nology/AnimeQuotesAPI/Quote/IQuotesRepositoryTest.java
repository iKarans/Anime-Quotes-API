package com.nology.AnimeQuotesAPI.Quote;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@DataJpaTest
class IQuotesRepositoryTest {

    private IQuotesRepository underTest;

    @Autowired
    public IQuotesRepositoryTest(IQuotesRepository underTest) {
        this.underTest = underTest;
    }


    @Test
    @Disabled
    void findAllByCategory() {
        Quote quote = new Quote(1, "test", "test", "test", "test");
        underTest.save(quote);
        List<Quote> expected = new ArrayList<>(Arrays.asList(quote));
        List<Quote> actual = underTest.findAllByCategory("test");
        assertEquals(actual, expected);
    }

    @Test
    void findAllById() {
        Quote quote = new Quote(1, "test", "test", "test", "test");
        underTest.save(quote);
        Quote expected = quote;
        Quote actual = underTest.findById(1).orElse(null);
        assertThat(expected)
                .usingRecursiveComparison()
                .isEqualTo(actual);
    }
}