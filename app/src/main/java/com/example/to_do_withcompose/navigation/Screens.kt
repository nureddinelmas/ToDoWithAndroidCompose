package com.example.to_do_withcompose.navigation

import androidx.navigation.NavController
import com.example.to_do_withcompose.util.Action
import com.example.to_do_withcompose.util.Constants.LIST_SCREEN

class Screens(navController: NavController) {
val list: (Action) -> Unit = { action ->
	navController.navigate("list/${action.name}"){
		popUpTo(LIST_SCREEN){
			inclusive = true
		}
	}
	
}
	
	val task : (Int) -> Unit ={taskId ->
		navController.navigate("task/$taskId"){
		
		}
		
	}
}