package com.example.demoFood.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoFood.constants.RtnInfo;
import com.example.demoFood.entity.ToDo;
import com.example.demoFood.service.ifs.ToDoService;
import com.example.demoFood.vo.ToDoReq;
import com.example.demoFood.vo.ToDoRes;

@CrossOrigin
@RestController
public class ToDoController {
     
	@Autowired ToDoService toDoService ;
	
	@PostMapping("/api/getToDoList")
	public ToDoRes getToDoList(@RequestBody ToDoReq req) {
		List<ToDo>toDoListRes = new ArrayList<>();
		try {
			toDoListRes = StringUtils.hasText(req.getName())
					?toDoService.getToDoList(req)
					:toDoService.getToDoList();		
		}catch(Exception e) {
			return new ToDoRes(
					RtnInfo.FAILED.getCode(),
					RtnInfo.FAILED.getMessage(),
					null
					);
		}
		return new ToDoRes(
				RtnInfo.SUCCESSFUL.getCode(),
				RtnInfo.SUCCESSFUL.getMessage(),
			   toDoListRes
				);
	}
	@PostMapping("/api/createToDo")
	public ToDoRes createToDo(@RequestBody ToDoReq req) {
		List<ToDo>toDoListRes = new ArrayList<>();
		try {
			if(!StringUtils.hasText(req.getName()))	{
				return new ToDoRes(
						RtnInfo.PARAMETER_REQUIRED.getCode(),
						RtnInfo.PARAMETER_REQUIRED.getMessage(),
						null
						);
			}
			toDoService.createToDo(req);
			toDoListRes = toDoService.getToDoList();
		}catch(Exception e) {
			return new ToDoRes(
					RtnInfo.FAILED.getCode(),
					RtnInfo.FAILED.getMessage(),
					null
					);
		}
		return new ToDoRes(
				RtnInfo.SUCCESSFUL.getCode(),
				RtnInfo.SUCCESSFUL.getMessage(),
			   toDoListRes
				);
		
	}
	
	@PostMapping("/api/deleteToDo")
	public ToDoRes deleteToDo(@RequestBody ToDoReq req)  {
		List<ToDo>toDoListRes = new ArrayList<>();
		try {
			if(!StringUtils.hasText(req.getId()))	{
				return new ToDoRes(
						RtnInfo.PARAMETER_REQUIRED.getCode(),
						RtnInfo.PARAMETER_REQUIRED.getMessage(),
						null
						);
			}
			toDoService.deleteToDo(req);
			toDoListRes = toDoService.getToDoList();
		}catch(Exception e) {
			return new ToDoRes(
					RtnInfo.FAILED.getCode(),
					RtnInfo.FAILED.getMessage(),
					null
					);
		}
		return new ToDoRes(
				RtnInfo.SUCCESSFUL.getCode(),
				RtnInfo.SUCCESSFUL.getMessage(),
			   toDoListRes
				);
	}
	@PostMapping("/api/updateToDo")
	public ToDoRes updateToDo(@RequestBody ToDoReq req)  {
		List<ToDo>toDoListRes = new ArrayList<>();
		try {
			if(!StringUtils.hasText(req.getId())||
					!StringUtils.hasText(req.getName())	)	{
				return new ToDoRes(
						RtnInfo.PARAMETER_REQUIRED.getCode(),
						RtnInfo.PARAMETER_REQUIRED.getMessage(),
						null
						);
			}
			toDoService.updateToDo(req);
			toDoListRes = toDoService.getToDoList();
		}catch(Exception e) {
			return new ToDoRes(
					RtnInfo.FAILED.getCode(),
					RtnInfo.FAILED.getMessage(),
					null
					);
		}
		return new ToDoRes(
				RtnInfo.SUCCESSFUL.getCode(),
				RtnInfo.SUCCESSFUL.getMessage(),
			   toDoListRes
				);
	}
	@PostMapping("/api/setIsCheckedOfToDo")
	public ToDoRes setIsCheckedOfToDo(@RequestBody ToDoReq req)  {
		List<ToDo>toDoListRes = new ArrayList<>();
		try {
			if(!StringUtils.hasText(req.getId())
						){
				return new ToDoRes(
						RtnInfo.PARAMETER_REQUIRED.getCode(),
						RtnInfo.PARAMETER_REQUIRED.getMessage(),
						null
						);
			}
			toDoService.setIsCheckOfToDo(req);
			toDoListRes = toDoService.getToDoList();
		}catch(Exception e) {
			return new ToDoRes(
					RtnInfo.FAILED.getCode(),
					RtnInfo.FAILED.getMessage(),
					null
					);
		}
		return new ToDoRes(
				RtnInfo.SUCCESSFUL.getCode(),
				RtnInfo.SUCCESSFUL.getMessage(),
			   toDoListRes
				);
	}
}
