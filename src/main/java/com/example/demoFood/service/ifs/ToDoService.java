package com.example.demoFood.service.ifs;

import java.util.List;

import com.example.demoFood.entity.ToDo;
import com.example.demoFood.vo.ToDoReq;

public interface ToDoService {
 public List<ToDo> getToDoList() throws Exception ;
 public List<ToDo> getToDoList(ToDoReq req) throws Exception ;
 public void createToDo(ToDoReq req)throws Exception ;
 public void setIsCheckOfToDo(ToDoReq req)throws Exception ;
 public void updateToDo(ToDoReq req)throws Exception ;
 public void deleteToDo(ToDoReq req)throws Exception ;
}
