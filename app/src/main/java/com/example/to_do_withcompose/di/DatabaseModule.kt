package com.example.to_do_withcompose.di

import android.content.Context
import androidx.room.Room
import com.example.to_do_withcompose.data.TodoDatabase
import com.example.to_do_withcompose.util.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
	
	
	@Singleton
	@Provides
	fun provideDatabase(
		@ApplicationContext context: Context
	) = Room.databaseBuilder(
		context,
		TodoDatabase::class.java,
		DATABASE_NAME)
	
	
	@Singleton
	@Provides
	fun provideDao(database: TodoDatabase) = database.toDoDao()
}