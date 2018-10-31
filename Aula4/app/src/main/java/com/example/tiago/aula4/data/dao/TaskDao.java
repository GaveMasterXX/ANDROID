package com.example.tiago.aula4.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.tiago.aula4.data.Task;

import java.util.List;

@Dao
public interface TaskDao {

    @Insert
    long insert(Task task);


    @Update
    int update(Task task);

    @Delete
    int delete(Task task);

    @Query("SELECT * FROM tasks")
    List<Task> getAllTasks();


    @Query("SELECT * FROM tasks WHERE id = :id")
    Task getTask(long id);

}
