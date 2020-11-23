package com.demo.todo.DemoTodo.bo;

import java.util.List;

import com.demo.todo.DemoTodo.controller.model.TodoItem;

public interface TodoBO {

	List<TodoItem> getTodoItems();

	TodoItem addTodoItem(TodoItem todoItem);

	void deleteTodoItem(Integer id);

	List<TodoItem> getTodoItems(boolean complete);

	void changeTodoItemStatus(Integer id, String status);

}