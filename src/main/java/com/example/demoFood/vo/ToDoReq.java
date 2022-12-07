package com.example.demoFood.vo;

public class ToDoReq {
private String id ;
private String name ;
private boolean checked ;
public ToDoReq() {
	
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
//public boolean isChecked() {
//	return isChecked;
//}
public boolean isChecked() {
	return checked;
}
public void setChecked(boolean checked) {
	this.checked = checked;
}


}
