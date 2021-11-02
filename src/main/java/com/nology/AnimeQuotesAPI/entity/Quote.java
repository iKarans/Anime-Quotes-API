package com.nology.AnimeQuotesAPI.entity;

import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Validated
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String characterName;
    @NotNull
    private String quote;
    private String animeName;
    @NotNull
    private String category;

    public Quote(int id, String characterName, String quote, String animeName, String category) {
        this.id = id;
        this.characterName = characterName;
        this.quote = quote;
        this.animeName = animeName;
        this.category = category;
    }

    public Quote() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getAnimeName() {
        return animeName;
    }

    public void setAnimeName(String animeName) {
        this.animeName = animeName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

