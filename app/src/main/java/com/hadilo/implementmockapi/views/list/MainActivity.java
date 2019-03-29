package com.hadilo.implementmockapi.views.list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.hadilo.implementmockapi.R;
import com.hadilo.implementmockapi.api.ITodo;
import com.hadilo.implementmockapi.helper.retrofit.RetrofitConfig;
import com.hadilo.implementmockapi.model.todosList.TodosModel;
import com.hadilo.implementmockapi.model.todosList.TodosResponse;
import com.hadilo.implementmockapi.views.detail.DetailActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    RecyclerView recyclerView;
    MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupRecyclerView();

        getApi();
    }

    private void setupRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new MainAdapter();
        adapter.init(getBaseContext(), recyclerView, new MainAdapter.OnSelectListener() {
            @Override
            public void onSelect(int positionSelect) {
                Intent intent = new Intent(getBaseContext(), DetailActivity.class);
                intent.putExtra("todoModel", adapter.getItemModel(positionSelect));
                startActivity(intent);
            }
        });

    }

    private void setModelsToAdapter(List<TodosModel> todosModel){
        adapter.insertItems(todosModel);
    }



    private void getApi() {
        // Create a very simple REST adapter which points the GitHub API endpoint.
        RetrofitConfig retrofit = new RetrofitConfig();
        // Create a very simple REST adapter which points the GitHub API endpoint.
        ITodo client =  retrofit.getService();

        // Fetch a list of the Github repositories.
        Call<TodosResponse> call =
                client.getAllTodos();

        // Execute the call asynchronously. Get a positive or negative callback.
        call.enqueue(new Callback<TodosResponse>() {
            @Override
            public void onResponse(Call<TodosResponse> call, Response<TodosResponse> response) {
                // The network call was a success and we got a response
                // TODO: use the repository list and display it
                Log.d(TAG, "onResponse: " + response.body().getData());
                setModelsToAdapter(response.body().getData());
            }

            @Override
            public void onFailure(Call<TodosResponse> call, Throwable t) {
                // the network call was a failure
                // TODO: handle error
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}
