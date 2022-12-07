package com.example.demoFood.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demoFood.entity.ToDo;

@Repository
public interface ToDoDao extends JpaRepository<ToDo,UUID>{
	
	public List<ToDo> findByNameContaining(String name);

//	public Optional<ToDo> findById(UUID id);

}
