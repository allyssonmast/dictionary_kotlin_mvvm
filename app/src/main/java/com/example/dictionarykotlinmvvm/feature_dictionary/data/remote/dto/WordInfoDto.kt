package com.example.dictionarykotlinmvvm.feature_dictionary.data.remote.dto

import com.example.dictionarykotlinmvvm.feature_dictionary.domain.model.WordInfo

data class WordInfoDto(
    val meanings: List<MeaningDto>,
    val phonetic: String,
    val phonetics: List<PhoneticDto>,
    val sourceUrls: List<String>,
    val word: String
){
    fun toWordInfo(): WordInfo{
        return WordInfo(
            meanings=meanings.map { it.toMeaning() },
            phonetic=phonetic,
            word =word
        )
    }
}