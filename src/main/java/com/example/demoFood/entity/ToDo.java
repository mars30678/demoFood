package com.example.demoFood.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;


@Entity
@Table(name = "to_do")
public class ToDo {
@Id
@Column(name = "id")
@Type(type = "uuid-char")
private UUID id ;

@Column(name = "name")
private String name ;

@Column(name = "is_checked")
private boolean isChecked ;

@Column(name = "create_date")
private LocalDateTime createDate ;

@Column(name = "update_date")
private LocalDateTime updateDate ;

public UUID getId() {
	return id;
}

public void setId(UUID id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}





public boolean getIsChecked() {
	return isChecked;
}

public void setChecked(boolean isChecked) {
	this.isChecked = isChecked;
}

public LocalDateTime getCreateDate() {
	return createDate;
}

public void setCreateDate(LocalDateTime createDate) {
	this.createDate = createDate;
}

public LocalDateTime getUpdateDate() {
	return updateDate;
}

public void setUpdateDate(LocalDateTime updateDate) {
	this.updateDate = updateDate;
}

public ToDo(){
	
}
}
