package com.nology.AnimeQuotesAPI.repository;

import com.nology.AnimeQuotesAPI.Quote.IQuotesRepository;
import com.nology.AnimeQuotesAPI.Quote.Quote;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


class IQuotesRepositoryTest {

    @Autowired
    private IQuotesRepository underTest;

    @Test
    @Disabled
    void findAllByAnimeName() {
        Quote quote = new Quote(1, "test", "test", "test", "test");
        underTest.save(quote);
    }
}