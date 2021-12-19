package com.nology.AnimeQuotesAPI.Quote;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class IQuotesRepositoryTest {

    private IQuotesRepository underTest;
    private Quote quote;

    @Autowired
    public IQuotesRepositoryTest(IQuotesRepository underTest) {
        this.underTest = underTest;
    }

    @BeforeAll
    void setUp() {
        quote = new Quote(1, "Eren", "Kill", "AOT", "Cruel World");
        underTest.save(quote);
    }

    @Test
    void canFindAllByCategory() {
        List<Quote> actual = underTest.findAllByCategory("Cruel World");
        assertThat(actual.get(0))
                .usingRecursiveComparison()
                .isEqualTo(quote);
    }

    @Test
    void canFindAllByAnimeName() {
        List<Quote> actual = underTest.findAllByAnimeName("AOT");
        assertThat(actual.get(0))
                .usingRecursiveComparison()
                .isEqualTo(quote);
    }

    @Test
    void canFindAllByCharacterName() {
        List<Quote> actual = underTest.findAllByCharacterName("Eren");
        assertThat(actual.get(0))
                .usingRecursiveComparison()
                .isEqualTo(quote);
    }
}