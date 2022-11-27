package com.example.dictionarykotlinmvvm.feature_dictionary.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.dictionarykotlinmvvm.feature_dictionary.domain.model.Meaning
import com.example.dictionarykotlinmvvm.feature_dictionary.domain.model.WordInfo

@Entity
data class WordInfoEntity (
    val word:String,
    val phonetic:String,
    val meanings: List<Meaning>,
    @PrimaryKey val id :Int?=null
){
    fun toIWordInfo():WordInfo{
        return  WordInfo(
            meanings=meanings,
            word = word,
            phonetic = phonetic
        )
    }
}