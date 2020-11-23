package com.demo.todo.DemoTodo.controller.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TodoItem {
	
	
	 private Integer id;
	 private String name;
	 private String desc;
	 private String date;
    private boolean complete;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

	
	  public String getDate() { return date; } public void setDate(String date) {
	  this.date = date; }
	 
	public boolean isComplete() {
		return complete;
	}
	public void setComplete(boolean complete) {
		this.complete = complete;
	}
    
    
    
}