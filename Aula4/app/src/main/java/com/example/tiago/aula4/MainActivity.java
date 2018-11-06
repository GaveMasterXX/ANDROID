package com.example.tiago.aula4;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tiago.aula4.data.Task;
import com.example.tiago.aula4.data.TasksDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TaskAdpter adpter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        this.adpter = new TaskAdpter();

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adpter);


    }

    public void createNewTask(View view) {
        FormActivity.start(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        List<Task> tasks = TasksDatabase.getInstance(this).taskDao().getAllTasks();
        this.adpter.setData(tasks);

    }

    public class TaskViewHolder extends RecyclerView.ViewHolder{

        private  TextView title;
        private  TextView description;
        private ImageView delete;


        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            this.title = itemView.findViewById(R.id.task_title);
            this.description = itemView.findViewById(R.id.task_description);
            this.delete = itemView.findViewById(R.id.delete_task);
        }

        public void bind(Task task){
            this.title.setText(task.getTitle());
            this.description.setText(task.getDescription());
        }

    }


    public class TaskAdpter extends RecyclerView.Adapter<TaskViewHolder>{

        private List<Task> data = new ArrayList<>();


        private void delete(int position){
            Task task;
        }

        @NonNull
        @Override
        public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.task_list_item, viewGroup, false);
            return new TaskViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull TaskViewHolder taskViewHolder, int position) {
            Task task = data.get(position);
            taskViewHolder.bind(task);
        }

        @Override
        public int getItemCount() {
            return this.data.size();
        }

        public void setData(List<Task> tasks) {
            this.data = tasks;
            notifyDataSetChanged();
        }
    }
}
