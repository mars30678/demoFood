package com.example.demoFood.service.imp;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoFood.entity.ToDo;
import com.example.demoFood.repository.ToDoDao;
import com.example.demoFood.service.ifs.ToDoService;
import com.example.demoFood.vo.ToDoReq;

@Service
public class ToDoServiceImpl implements ToDoService {

	@Autowired
	ToDoDao toDoDao;

	@Override
	public List<ToDo> getToDoList() throws Exception {
		List<ToDo> toDoList = toDoDao.findAll();
		if (toDoList == null || toDoList.isEmpty())
			return null;
		toDoList.sort(Comparator.comparing(ToDo::getUpdateDate).reversed());
		return toDoList;
	}

	@Override
	public List<ToDo> getToDoList(ToDoReq req) throws Exception {
		List<ToDo> toDoList = toDoDao.findByNameContaining(req.getName());
		if (toDoList == null || toDoList.isEmpty())
			return null;
		toDoList.sort(Comparator.comparing(ToDo::getUpdateDate).reversed());
		return toDoList;
	}

	@Override
	public void createToDo(ToDoReq req) throws Exception {
		ToDo toCreateToDo = new ToDo();
		toCreateToDo.setId(UUID.randomUUID());
		toCreateToDo.setName(req.getName());
		toCreateToDo.setChecked(false);
		toCreateToDo.setCreateDate(LocalDateTime.now());
		toCreateToDo.setUpdateDate(LocalDateTime.now());
		toDoDao.save(toCreateToDo);
	}

	@Override
	public void setIsCheckOfToDo(ToDoReq req) throws Exception {
		UUID id = UUID.fromString(req.getId());

		Optional<ToDo> toDoOp = toDoDao.findById(id);
		if (!toDoOp.isPresent())
			throw new Exception("To set isChecked to do is null");

		ToDo toUpdateToDo = toDoOp.get();
		toUpdateToDo.setChecked(req.isChecked());
		toDoDao.save(toUpdateToDo);

	}

	@Override
	public void updateToDo(ToDoReq req) throws Exception {
		UUID id = UUID.fromString(req.getId());

		Optional<ToDo> toDoOp = toDoDao.findById(id);
		if (!toDoOp.isPresent())
			throw new Exception("To update to do is null");

		ToDo toUpdateToDo = toDoOp.get();
		toUpdateToDo.setName(req.getName());
		toUpdateToDo.setUpdateDate(LocalDateTime.now());
		toDoDao.save(toUpdateToDo);
	}

	@Override
	public void deleteToDo(ToDoReq req)  {
		UUID id = UUID.fromString(req.getId());

		Optional<ToDo> toDoOp = toDoDao.findById(id);
//		if (!toDoOp.isPresent())
//			throw new Exception("To delete to do is null");
		ToDo toUpdateToDo = toDoOp.get();
		toDoDao.delete(toUpdateToDo);
	}
   
}
