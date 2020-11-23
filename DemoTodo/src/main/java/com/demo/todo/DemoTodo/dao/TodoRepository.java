package com.demo.todo.DemoTodo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.todo.DemoTodo.entity.TodoItemEntity;

@Repository
public interface TodoRepository extends JpaRepository<TodoItemEntity, Integer>{
	
	List<TodoItemEntity> findByComplete(boolean complete);

	Optional<TodoItemEntity> findById(Integer id);
}
