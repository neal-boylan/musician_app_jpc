package ie.setu.musician_jpc.data.room

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context):
            AppDatabase =
                Room.databaseBuilder(context, AppDatabase::class.java, "clip_database")
                .fallbackToDestructiveMigration()
                .build()

    @Provides
    fun provideClipDAO(appDatabase: AppDatabase):
            ClipDAO = appDatabase.getClipDAO()

    @Provides
    fun provideRoomRepository(clipDAO: ClipDAO):
            RoomRepository = RoomRepository(clipDAO)
}