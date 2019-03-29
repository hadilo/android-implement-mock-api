package com.hadilo.implementmockapi.views.detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.hadilo.implementmockapi.R;
import com.hadilo.implementmockapi.api.ITodo;
import com.hadilo.implementmockapi.helper.retrofit.RetrofitConfig;
import com.hadilo.implementmockapi.model.todoDetail.TodoModel;
import com.hadilo.implementmockapi.model.todoDetail.TodoResponse;
import com.hadilo.implementmockapi.model.todosList.TodosModel;
import com.hadilo.implementmockapi.model.todosList.TodosResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    private static final String TAG = "DetailActivity";

    TodosModel todoModel;

    TextView lblTitle;
    TextView lblDate;
    TextView lblDesc;
    TextView lblComplete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        todoModel = getIntent().getParcelableExtra("todoModel");

        getApi();

        initLayout();
    }

    private void initLayout() {
        lblTitle = findViewById(R.id.lbl_title);
        lblDate = findViewById(R.id.lbl_date);
        lblDesc = findViewById(R.id.lbl_desc);
        lblComplete = findViewById(R.id.lbl_complete);
    }

    private void setData(TodoModel todoModel) {
        lblTitle.setText(todoModel.getTitle());
        lblDate.setText(todoModel.getDate());
        lblDesc.setText(todoModel.getDescription());
        lblComplete.setText(Boolean.toString(todoModel.isIsComplete()));
    }

    private void getApi() {
        // Create a very simple REST adapter which points the GitHub API endpoint.
        RetrofitConfig retrofit = new RetrofitConfig();
        // Create a very simple REST adapter which points the GitHub API endpoint.
        ITodo client =  retrofit.getService();

        // Fetch a list of the Github repositories.
        Call<TodoResponse> call =
                client.getATodo(todoModel.getId());

        // Execute the call asynchronously. Get a positive or negative callback.
        call.enqueue(new Callback<TodoResponse>() {
            @Override
            public void onResponse(Call<TodoResponse> call, Response<TodoResponse> response) {
                // The network call was a success and we got a response
                // TODO: use the repository list and display it
                Log.d(TAG, "onResponse: " + response.body().getData());
                setData(response.body().getData());
            }

            @Override
            public void onFailure(Call<TodoResponse> call, Throwable t) {
                // the network call was a failure
                // TODO: handle error
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}
