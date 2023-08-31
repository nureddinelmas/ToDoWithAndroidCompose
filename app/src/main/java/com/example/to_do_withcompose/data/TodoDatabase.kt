package com.example.to_do_withcompose.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.to_do_withcompose.data.models.ToDoTask


@Database(entities = [ToDoTask::class], version = 2, exportSchema = false)
abstract class TodoDatabase: RoomDatabase() {
	
	abstract fun toDoDao(): ToDoDao
}