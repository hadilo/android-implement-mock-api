package com.hadilo.implementmockapi.model.todoDetail;

import com.google.gson.annotations.SerializedName;

public class TodoModel {

	@SerializedName("date")
	private String date;

	@SerializedName("description")
	private String description;

	@SerializedName("id")
	private int id;

	@SerializedName("is_complete")
	private boolean isComplete;

	@SerializedName("title")
	private String title;

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setIsComplete(boolean isComplete){
		this.isComplete = isComplete;
	}

	public boolean isIsComplete(){
		return isComplete;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"date = '" + date + '\'' + 
			",description = '" + description + '\'' + 
			",id = '" + id + '\'' + 
			",is_complete = '" + isComplete + '\'' + 
			",title = '" + title + '\'' + 
			"}";
		}
}