package com.example.todolist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.todolist.data.Todo
import com.example.todolist.data.TodoDatabase
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect

// AndroidViewModel은 액티비티와 수명을 같이 함
class MainViewModel(application: Application) : AndroidViewModel(application) {
    // Room 데이터베이스
    private val db = Room.databaseBuilder( // Application 객체, 데이터베이스 클래스, 데이터베이스 이름 필요
        application,
        TodoDatabase::class.java, "todo"
    ).build()

    // DB의 결과를 관찰할 수 있는 방법
    private val _items = MutableStateFlow<List<Todo>>(emptyList())
    val items: StateFlow<List<Todo>> = _items

    // 초기화 시 모든 데이터를 읽어옴
    init {
        viewModelScope.launch {
            db.todoDao().getAll().collect { todos ->
                db.todoDao().getAll().collect { todos ->
                    _items.value = todos
                }
            }
        }
    }

    fun addTodo(text: String) {
        viewModelScope.launch {
            db.todoDao().insert(Todo(text))
        }
    }
}
