package com.hadilo.implementmockapi.api;

import com.hadilo.implementmockapi.BuildConfig;
import com.hadilo.implementmockapi.model.todosList.TodosResponse;
import com.hadilo.implementmockapi.model.todoDetail.TodoResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Hadilo Muhammad on 21/03/19.
 */
public interface ITodo {

    @GET(BuildConfig.version + "todos")
    Call<TodosResponse> getAllTodos();

    @GET(BuildConfig.version + "todo/{id}")
    Call<TodoResponse> getATodo(@Path("id") int id);
}
