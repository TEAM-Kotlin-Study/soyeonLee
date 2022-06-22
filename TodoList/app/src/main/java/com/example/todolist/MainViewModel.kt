package com.example.todolist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.todolist.data.Todo
import com.example.todolist.data.TodoDatabase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.*

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

    // 선택할 객체를 저장하도록 하고 이의 존재 유무에 따라 추가인지 수정인지 판단
    var selectedTodo: Todo? = null

    // 초기화 시 모든 데이터를 읽어옴
    init {
        viewModelScope.launch {
                db.todoDao().getAll().collect { todos ->
                    _items.value = todos
            }
        }
    }

    fun addTodo(text: String, date: Long) {
        viewModelScope.launch {
            db.todoDao().insert(Todo(text, date))
        }
    }

    fun updateTodo(text: String, date:Long) {
        selectedTodo?.let { todo ->
            todo.apply {
                this.title = text
                this.date = date
            }

            viewModelScope.launch {
                db.todoDao().update(todo)
            }

            selectedTodo = null
        }
    }

    fun deleteTodo(id: Long) {
        _items.value
            .find {todo -> todo.id == id}
            ?.let { todo ->
                viewModelScope.launch {
                    db.todoDao().delete(todo)
                }
                selectedTodo = null
            }
    }
}
