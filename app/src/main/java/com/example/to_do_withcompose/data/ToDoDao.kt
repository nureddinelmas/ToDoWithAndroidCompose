package com.example.to_do_withcompose.data

import androidx.room.*
import com.example.to_do_withcompose.data.models.ToDoTask
import kotlinx.coroutines.flow.Flow


@Dao
interface ToDoDao {
	
	@Query("SELECT * FROM todo_tables ORDER BY 'id' ASC")
	fun getAllTask(): Flow<List<ToDoTask>>
	
	
	@Query("SELECT * FROM todo_tables WHERE id=:taskId")
	fun getSelectedTask(taskId: Int) : Flow<ToDoTask>
	
	@Insert(onConflict = OnConflictStrategy.IGNORE)
	suspend fun addTask(toDoTask: ToDoTask)
	
	
	@Update
	suspend fun updateTask(toDoTask: ToDoTask)
	
	@Delete
	suspend fun deleteTask(toDoTask: ToDoTask)
	
	@Query("DELETE FROM todo_tables")
	suspend fun deleteAllTask()
	
	@Query("SELECT * FROM todo_tables WHERE title LIKE :searchQuery OR description LIKE :searchQuery")
	fun searchDatabase(searchQuery: String): Flow<List<ToDoTask>>
	
	
	@Query("SELECT * FROM todo_tables ORDER BY CASE WHEN priority LIKE 'L%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'H%' THEN 3 END" )
	fun sortByLowPriority(): Flow<List<ToDoTask>>
	
	@Query("SELECT * FROM todo_tables ORDER BY CASE WHEN priority LIKE 'H%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'L%' THEN 3 END" )
	fun sortByHighPriority(): Flow<List<ToDoTask>>
}