package com.hadilo.implementmockapi.views.list;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hadilo.implementmockapi.R;
import com.hadilo.implementmockapi.model.todosList.TodosModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hadilo Muhammad on 27/03/19.
 */

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String TAG = "MainAdapter";

    protected Context context;
    private List<TodosModel> models;

    private OnSelectListener onSelectListener;

    public MainAdapter() {
    }

    public void init(Context context, RecyclerView recyclerView, OnSelectListener onSelectListener) {
        this.context = context;
        this.models = new ArrayList<>();
        this.onSelectListener = onSelectListener;

        //recyclerview dengan layout listview
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linearLayoutManager);

        //mengaktifkan smooth scroll
        linearLayoutManager.setSmoothScrollbarEnabled(true);
        //agar tidak auto scroll ke recyclerview bila diatas recyclerview terdapat layout lain
        recyclerView.setFocusable(false);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(this);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_todo, viewGroup, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, final int position) {
        TodosModel model = models.get(position);
        ((ItemViewHolder) viewHolder).lblTitle.setText(model.getTitle());
    }

    @Override
    public int getItemCount() {
        // Add two more counts to accomodate header and footer
        if (models != null) return models.size();
        else return 0;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        final TextView lblTitle;

        public ItemViewHolder(View view) {
            super(view);
            lblTitle = view.findViewById(R.id.lbl_title);

            View.OnClickListener clickListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int mSelectedItem = getAdapterPosition();

                    onSelectListener.onSelect(mSelectedItem);
                }
            };
            itemView.setOnClickListener(clickListener);
        }
    }

    public TodosModel getItemModel(int position) {
        return models.get(position);
    }

    public void removeItem(int position) {
        //http://stackoverflow.com/a/34828256/7062987
        models.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeRemoved(position, getItemCount()); //reset position
    }

    public void insertItems(List<TodosModel> data) {
        models.addAll(data);
        notifyDataSetChanged();
    }

    public void insertItem(int position, TodosModel data) {
        models.add(position, data);
        notifyItemInserted(position);
        notifyDataSetChanged();
    }

    public interface OnSelectListener {
        void onSelect(int positionSelect);
    }
}