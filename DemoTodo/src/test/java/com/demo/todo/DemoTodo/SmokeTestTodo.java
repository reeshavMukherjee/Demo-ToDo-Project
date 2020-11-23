package com.demo.todo.DemoTodo;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.todo.DemoTodo.controller.TodoController;

@SpringBootTest
public class SmokeTestTodo {
	
		@Autowired
		private TodoController controller;
	
		@Test
		void contextLoads() {
			Assertions.assertThat(controller).isNotNull();
		}


}
