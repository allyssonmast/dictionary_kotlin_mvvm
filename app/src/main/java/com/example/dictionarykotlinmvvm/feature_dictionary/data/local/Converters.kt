package com.example.dictionarykotlinmvvm.feature_dictionary.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.dictionarykotlinmvvm.feature_dictionary.data.util.JsonParser
import com.example.dictionarykotlinmvvm.feature_dictionary.domain.model.Meaning
import com.google.gson.reflect.TypeToken
import java.util.ArrayList

@ProvidedTypeConverter
class Converters(
    private val jsonParser: JsonParser
) {
    @TypeConverter
    fun fromMeaningsJson(json: String): List<Meaning>{
        return jsonParser.fromJson<ArrayList<Meaning>>(
            json,
            object : TypeToken<ArrayList<Meaning>>(){}.type
        )?: emptyList()
    }

    @TypeConverter
    fun toMeaningsJson(meanigs: List<Meaning>):String {
        return jsonParser.toJson(
            meanigs,
            object : TypeToken<ArrayList<Meaning>>(){}.type
        )?: "[]"
    }
}