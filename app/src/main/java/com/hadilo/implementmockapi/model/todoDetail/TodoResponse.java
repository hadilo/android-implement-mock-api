package com.hadilo.implementmockapi.model.todoDetail;

import com.google.gson.annotations.SerializedName;

public class TodoResponse{

	@SerializedName("data")
	private TodoModel data;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private int status;

	public void setData(TodoModel data){
		this.data = data;
	}

	public TodoModel getData(){
		return data;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"TodoResponse{" + 
			"data = '" + data + '\'' + 
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}