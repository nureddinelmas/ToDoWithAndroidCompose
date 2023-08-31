package com.example.to_do_withcompose.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.to_do_withcompose.data.models.ToDoTask
import com.example.to_do_withcompose.data.repositories.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SharedViewModel @Inject constructor(private val repository: ToDoRepository) : ViewModel(){
	
	private val _allTasks = MutableStateFlow<List<ToDoTask>>(emptyList())
	
	val allTasks : StateFlow<List<ToDoTask>> = _allTasks
	
	fun getAllTask() {
		viewModelScope.launch {
			repository.getAllTask.collect{
			_allTasks.value= it
			}
		}
	}
	
}