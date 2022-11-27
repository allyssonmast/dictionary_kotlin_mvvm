package com.example.dictionarykotlinmvvm.feature_dictionary.domain.model

import com.example.dictionarykotlinmvvm.feature_dictionary.data.remote.dto.MeaningDto
import com.example.dictionarykotlinmvvm.feature_dictionary.data.remote.dto.PhoneticDto

class WordInfo (
    val meanings: List<Meaning>,
    val phonetic: String,
    val word: String
        )