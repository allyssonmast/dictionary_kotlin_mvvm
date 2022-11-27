package com.example.dictionarykotlinmvvm.feature_dictionary.domain.repository

import com.example.dictionarykotlinmvvm.core.util.Resource
import com.example.dictionarykotlinmvvm.feature_dictionary.domain.model.WordInfo
import kotlinx.coroutines.flow.Flow


interface WordInfoRepository {

    fun getWordInfo(word:String): Flow<Resource<List<WordInfo>>>

}