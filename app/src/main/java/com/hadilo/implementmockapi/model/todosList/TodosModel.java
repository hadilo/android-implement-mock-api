package com.hadilo.implementmockapi.model.todosList;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class TodosModel implements Parcelable {

	@SerializedName("id")
	private int id;

	@SerializedName("is_complete")
	private boolean isComplete;

	@SerializedName("title")
	private String title;

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
			"DataItem{" + 
			"id = '" + id + '\'' + 
			",is_complete = '" + isComplete + '\'' + 
			",title = '" + title + '\'' + 
			"}";
		}


	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(this.id);
		dest.writeByte(this.isComplete ? (byte) 1 : (byte) 0);
		dest.writeString(this.title);
	}

	public TodosModel() {
	}

	protected TodosModel(Parcel in) {
		this.id = in.readInt();
		this.isComplete = in.readByte() != 0;
		this.title = in.readString();
	}

	public static final Parcelable.Creator<TodosModel> CREATOR = new Parcelable.Creator<TodosModel>() {
		@Override
		public TodosModel createFromParcel(Parcel source) {
			return new TodosModel(source);
		}

		@Override
		public TodosModel[] newArray(int size) {
			return new TodosModel[size];
		}
	};
}