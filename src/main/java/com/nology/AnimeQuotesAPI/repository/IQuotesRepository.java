package com.nology.AnimeQuotesAPI.repository;

import com.nology.AnimeQuotesAPI.entity.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IQuotesRepository extends JpaRepository<Quote, Integer> {
    @Query("SELECT Q FROM Quote Q WHERE category LIKE :category")
    List<Quote> findAllByCategory(String category);

//    @Query("SELECT Q FROM Quote Q WHERE id = :id")
//    @Override
//    Quote findById(int id);
}