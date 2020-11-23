package com.demo.todo.DemoTodo.bo.impl;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.todo.DemoTodo.bo.TodoBO;
import com.demo.todo.DemoTodo.controller.model.TodoItem;
import com.demo.todo.DemoTodo.dao.TodoRepository;
import com.demo.todo.DemoTodo.entity.TodoItemEntity;

@Component
public class TodoBOImpl implements TodoBO{
	@Autowired
	private TodoRepository todoRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<TodoItem> getTodoItems() {
		List<TodoItemEntity> list = todoRepository.findAll();
		Type type = new TypeToken<List<TodoItem>>() {}.getType();
		return modelMapper.map(list, type);
	}

	@Override
	public TodoItem addTodoItem(TodoItem todoItem) {
		return modelMapper.map(todoRepository.save(modelMapper.map(todoItem, TodoItemEntity.class)), TodoItem.class);
	}

	@Override
	public void deleteTodoItem(Integer id) {
		todoRepository.deleteById(id);
	}

	@Override
	public List<TodoItem> getTodoItems(boolean complete) {
		
		List<TodoItemEntity> list = todoRepository.findByComplete(complete);
		Type type = new TypeToken<List<TodoItem>>() {}.getType();
		return modelMapper.map(list, type);
	}

	@Override
	public void changeTodoItemStatus(Integer id, String status) {
		Optional<TodoItemEntity> todoItemEntity = todoRepository.findById(id);
		if(null != todoItemEntity) {
			if(status != null && status.equals("pending")) {
				todoItemEntity.get().setComplete(false);
			}else {
				todoItemEntity.get().setComplete(true);
				todoItemEntity.get().setDate(new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date()));
			}
			
			todoRepository.save(todoItemEntity.get());
			
		}
	}

}