package com.nology.AnimeQuotesAPI.Quote;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IQuotesRepository extends JpaRepository<Quote, Integer> {

    @Query("SELECT Q FROM Quote Q WHERE category LIKE :category")
    List<Quote> findAllByCategory(String category);

    @Query("SELECT Q FROM Quote Q WHERE animeName LIKE :animeName")
    List<Quote> findAllByAnimeName(String animeName);

    @Query("SELECT Q FROM Quote Q WHERE characterName LIKE :characterName")
    List<Quote> findAllByCharacterName(String characterName);

}
