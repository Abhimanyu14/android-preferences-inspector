package com.makeappssimple.abhimanyu.preferencesinspector.android.preference

import android.content.Context
import com.makeappssimple.abhimanyu.preferencesinspector.android.model.Preference
import com.makeappssimple.abhimanyu.preferencesinspector.android.model.PreferenceFile
import java.io.File

interface PreferenceManager {
    fun getPreferenceFiles(): List<PreferenceFile>
}

class PreferenceManagerImpl(
    private val context: Context,
) : PreferenceManager {
    override fun getPreferenceFiles(): List<PreferenceFile> {
        val fileNames = getSharedPreferencesFileNames()
        return fileNames.map {
            val sharedPref = context.getSharedPreferences(
                it.removeXmlExtension(),
                Context.MODE_PRIVATE,
            )
            val preferences = sharedPref.all.map { (key, value) ->
                when (value) {
                    is Boolean -> {
                        Preference.BooleanPreference(key, value)
                    }

                    is Float -> {
                        Preference.FloatPreference(key, value)
                    }

                    is Int -> {
                        Preference.IntPreference(key, value)
                    }

                    is Long -> {
                        Preference.LongPreference(key, value)
                    }

                    is String -> {
                        Preference.StringPreference(key, value)
                    }

                    else -> {
                        if (value is Set<*> && (value as Set<String>) != null) {
                            Preference.StringSetPreference(key, value)
                        } else {
                            Preference.StringSetPreference(key, emptySet())
                        }
                    }
                }
            }
            PreferenceFile(
                fileName = it.removeXmlExtension(),
                preferences = preferences,
            )
        }
    }

    private fun getSharedPreferencesFileNames(): List<String> {
        val preferencesDirectory = File(context.applicationInfo.dataDir, "shared_prefs")
        return if (preferencesDirectory.exists() && preferencesDirectory.isDirectory) {
            preferencesDirectory.list()?.toList().orEmpty()
        } else {
            emptyList()
        }
    }

    private fun String.removeXmlExtension(): String {
        return this.substring(0, this.lastIndex - 3)
    }
}

/*
private fun updatePreferences() {
    val sharedPref1 = getSharedPreferences("file_1", Context.MODE_PRIVATE)
    val sharedPref2 = getSharedPreferences("file_2", Context.MODE_PRIVATE)

    val int1 = sharedPref1.getInt("int_1", 0)
    val int2 = sharedPref2.getInt("int_2", 0)
    val float1 = sharedPref1.getFloat("float_1", 0F)
    val float2 = sharedPref2.getFloat("float_2", 100F)
    val long1 = sharedPref1.getLong("long_1", 123L)
    val long2 = sharedPref2.getLong("long_2", 456L)
    val string1 = sharedPref1.getString("string_1", "string_1")
    val string2 = sharedPref2.getString("string_2", "string_2")
    val boolean1 = sharedPref1.getBoolean("boolean_1", true)
    val boolean2 = sharedPref2.getBoolean("boolean_2", false)

    with(sharedPref1.edit()) {
        putInt("int_1", int1 + 1)
        putFloat("float_1", float1 + 0.1F)
        putLong("long_1", long1 + 2L)
        putBoolean("boolean_1", !boolean1)
        apply()
    }
    with(sharedPref2.edit()) {
        putInt("int_2", int2 + 1)
        putFloat("float_2", float2 + 0.1F)
        putLong("long_2", long2 + 2L)
        putBoolean("boolean_2", !boolean2)
        apply()
    }
}
*/
