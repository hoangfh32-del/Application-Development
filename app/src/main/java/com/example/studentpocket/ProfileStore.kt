package com.example.studentpocket

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

private val Context.studentData by preferencesDataStore(name = "student")

object ProfileStore {
    private val NAME = stringPreferencesKey("name")
    private val ID = stringPreferencesKey("student_id")
    private val MAJOR = stringPreferencesKey("major")

    suspend fun save(
        context: Context, data: List<String>
    ){
        context.studentData.edit { p ->
            p[NAME] = data[0]
            p[ID] = data[1]
            p[MAJOR] = data[2]
        }
    }

    suspend fun read(
        context: Context
    ): List<String>
    {
        val p = context.studentData.data.first()
        return listOf(
            p[NAME] ?:"",
            p[ID] ?:"",
            p[MAJOR] ?:""
        )
    }


}