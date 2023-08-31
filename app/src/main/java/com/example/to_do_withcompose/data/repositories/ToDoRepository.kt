package com.example.to_do_withcompose.data.repositories

import com.example.to_do_withcompose.data.ToDoDao
import com.example.to_do_withcompose.data.models.ToDoTask
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


@ViewModelScoped
class ToDoRepository @Inject constructor(private val toDoDao: ToDoDao) {
	
	val getAllTask: Flow<List<ToDoTask>> = toDoDao.getAllTask()
	val sortByLowPriority : Flow<List<ToDoTask>> = toDoDao.sortByLowPriority()
	val sortByHighPriority : Flow<List<ToDoTask>> = toDoDao.sortByHighPriority()
	
	fun getSelectedTask(taskId: Int): Flow<ToDoTask> {
		return toDoDao.getSelectedTask(taskId)
	}
	
	suspend fun addTask(toDoTask: ToDoTask) {
		 toDoDao.addTask(toDoTask)
	}
	
	suspend fun updateTask(toDoTask: ToDoTask) {
		toDoDao.updateTask(toDoTask)
	}
	
	suspend fun deleteTask(toDoTask: ToDoTask) {
		toDoDao.deleteTask(toDoTask)
	}
	
	suspend fun deleteAllTask() {
		toDoDao.deleteAllTask()
	}
	
	suspend fun searchDatabase(searchQuery: String) :Flow<List<ToDoTask>> {
		return toDoDao.searchDatabase(searchQuery)
	}
}