# Anime Quotes API

![Anime Quotes API Project](https://github.com/iKarans/Anime-Quotes-API/blob/master/Anime-Quotes.png)

## Introduction

An Anime Quotes API built from scratch using Java, SQL and the Spring framework. The quotes are stored on a mySQL database. Each Quote has five attributes: id, Anime Name, Character Name, Category and the actual quote. Currently, there are three categories: motivation, cruel world, portfolio. 

## LocalHost Root Endpoint

* ```http://localhost:8080/quotes```

## Parameters

* ```http://localhost:8080/quotes/all``` to fetch all the quotes
* ```http://localhost:8080/quotes/{id}``` to fetch by the quote's id.
* ```http://localhost:8080/quotes?category={category name}``` to fetch all quotes in a category.
* ```http://localhost:8080/quotes?animeName={Anime name}``` to fetch all quotes from an anime
* ```http://localhost:8080/quotes?characterName={Character Name}``` to fetch all quotes from an character.

* ```http://localhost:8080/quotes``` to create a new quote.
* ```http://localhost:8080/quotes/{id}``` to update and delete a quote.

## Improvements / To-Dos
[ ] Add more quotes and categories.
[ ] Get it hosted using Google cloud.
