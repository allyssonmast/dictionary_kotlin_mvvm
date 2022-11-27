package com.example.dictionarykotlinmvvm.feature_dictionary.domain.model


data class Meaning(
    val definition: List<Definition>,
    val partOfSpeech: String
)
