package ie.setu.musician_jpc.data.room

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.Date


class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time?.toLong()
    }

    @TypeConverter
    fun fromString(value: String?): List<String> {
        //return stringListString.split(",").map { it }
        val listType = object : TypeToken<List<String>>(){}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun toString(list: List<String?>): String {
        // return stringList.joinToString(separator = ",")
        return Gson().toJson(list)
    }

//    @TypeConverter
//    fun listToJson(value: List<String>?) = Gson().toJson(value)
//
//    @TypeConverter
//    fun jsonToList(value: String) = Gson().fromJson(value, Array<String>::class.java).toList()

}