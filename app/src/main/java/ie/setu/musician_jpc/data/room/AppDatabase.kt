package ie.setu.musician_jpc.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ie.setu.musician_jpc.data.model.ClipModel

@Database(entities = [ClipModel::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getClipDAO(): ClipDAO
}
