package com.example.dictionarykotlinmvvm.feature_dictionary.data.remote.dto

import com.example.dictionarykotlinmvvm.feature_dictionary.domain.model.Definition

data class DefinitionDto(
    val antonyms: List<String>,
    val definition: String,
    val example: String?,
    val synonyms: List<String>
){
    fun toDefinition(): Definition{
        return Definition(
            antonyms=antonyms,
            definition=definition,
            example = example,
            synonyms = synonyms
        )
    }
}