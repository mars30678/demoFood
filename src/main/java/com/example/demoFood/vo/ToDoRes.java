package com.example.demoFood.vo;

import java.util.List;

import com.example.demoFood.entity.ToDo;

public class ToDoRes {
	private String statusCode ;
 private	String message ;
	private List<ToDo> toDoList ;
	public ToDoRes() {
		
	}
    public ToDoRes(String statusCode,String message ,List<ToDo> toDoList){
      this.statusCode =statusCode ;
      this.message =message ;
      this.toDoList =toDoList ;
	}
    public ToDoRes(String statusCode,String message ){
        this.statusCode =statusCode ;
        this.message =message ;  
  	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<ToDo> getToDoList() {
		return toDoList;
	}
	public void setToDoList(List<ToDo> toDoList) {
		this.toDoList = toDoList;
	}
	
    
    
}
