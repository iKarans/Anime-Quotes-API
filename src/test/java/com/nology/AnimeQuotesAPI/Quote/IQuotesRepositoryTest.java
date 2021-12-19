package com.nology.AnimeQuotesAPI.Quote;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;


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
    void findAllByCategory() {
        Quote quote = new Quote(1, "Eren", "Kill", "AOT", "Cruel World");
        underTest.save(quote);
        List<Quote> expected = new ArrayList<>(Arrays.asList(quote));
        List<Quote> actual = underTest.findAllByCategory("Cruel World");
        assertThat(actual.get(0))
                .usingRecursiveComparison()
                .isEqualTo(quote);
    }

    @Test
    void findAllByAnimeName() {
        Quote quote = new Quote(2, "Eren", "Kill", "AOT", "Cruel World");
        underTest.save(quote);
        Quote expected = quote;
        List<Quote> actual = underTest.findAllByAnimeName("AOT");
        assertThat(actual.get(0))
                .usingRecursiveComparison()
                .isEqualTo(quote);
    }

    @Test
    void findAllByCharacterName() {
        Quote quote = new Quote(3, "Eren", "Kill", "AOT", "Cruel World");
        underTest.save(quote);
        Quote expected = quote;
        List<Quote> actual = underTest.findAllByCharacterName("Eren");
        assertThat(actual.get(0))
                .usingRecursiveComparison()
                .isEqualTo(quote);
    }
}