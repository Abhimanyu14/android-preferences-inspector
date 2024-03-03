package com.makeappssimple.abhimanyu.preferencesinspector.android.model

sealed class Preference(
    open val key: String,
    open val value: Any,
) {
    data class BooleanPreference(
        override val key: String,
        override val value: Boolean,
    ) : Preference(key, value)

    data class FloatPreference(
        override val key: String,
        override val value: Float,
    ) : Preference(key, value)

    data class IntPreference(
        override val key: String,
        override val value: Int,
    ) : Preference(key, value)

    data class LongPreference(
        override val key: String,
        override val value: Long,
    ) : Preference(key, value)

    data class StringPreference(
        override val key: String,
        override val value: String,
    ) : Preference(key, value)

    data class StringSetPreference(
        override val key: String,
        override val value: Set<String>,
    ) : Preference(key, value)
}
