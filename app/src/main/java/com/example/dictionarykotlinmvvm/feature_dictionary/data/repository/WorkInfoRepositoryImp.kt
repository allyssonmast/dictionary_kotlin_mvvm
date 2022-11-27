package com.example.dictionarykotlinmvvm.feature_dictionary.data.repository

import com.example.dictionarykotlinmvvm.core.util.Resource
import com.example.dictionarykotlinmvvm.feature_dictionary.data.local.WordInfoDao
import com.example.dictionarykotlinmvvm.feature_dictionary.data.remote.DictionaryApi
import com.example.dictionarykotlinmvvm.feature_dictionary.domain.model.WordInfo
import com.example.dictionarykotlinmvvm.feature_dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException

class WorkInfoRepositoryImp(
    private val api: DictionaryApi,
    private val dao: WordInfoDao
):WordInfoRepository {

    override fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>> = flow{
        emit(Resource.Loading())

        val wordInfos= dao.getWordInfos(word).map { it.toIWordInfo() }

        emit(Resource.Loading(data = wordInfos))

        try {
            val remoreWordInfos=api.getWordInfo(word)
            dao.deleteWordInfos(remoreWordInfos.map { it.word })
            dao.insertWordInfos(remoreWordInfos.map { it.toWordInfoEntity() })
        }catch (e:HttpException){
            emit(Resource.Error(
                "Oops, somethings went wrong!",
                data = wordInfos
            ))
        }catch (e:IOException){
            emit(Resource.Error(
                "Couldn't reach server, check your internet!",
                data = wordInfos
            ))
        }

        val newWorkInfos = dao.getWordInfos(word).map { it.toIWordInfo() }

        emit(Resource.Success(newWorkInfos))

    }
}