package com.hadilo.implementmockapi.model.todosList;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class TodosResponse implements Parcelable {

	@SerializedName("data")
	private List<TodosModel> data;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private int status;

	public void setData(List<TodosModel> data){
		this.data = data;
	}

	public List<TodosModel> getData(){
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
			"TodosResponse{" + 
			"data = '" + data + '\'' + 
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}


	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeTypedList(this.data);
		dest.writeString(this.message);
		dest.writeInt(this.status);
	}

	public TodosResponse() {
	}

	protected TodosResponse(Parcel in) {
		this.data = in.createTypedArrayList(TodosModel.CREATOR);
		this.message = in.readString();
		this.status = in.readInt();
	}

	public static final Parcelable.Creator<TodosResponse> CREATOR = new Parcelable.Creator<TodosResponse>() {
		@Override
		public TodosResponse createFromParcel(Parcel source) {
			return new TodosResponse(source);
		}

		@Override
		public TodosResponse[] newArray(int size) {
			return new TodosResponse[size];
		}
	};
}