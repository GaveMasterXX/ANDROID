package com.example.tiago.aula4.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.tiago.aula4.data.dao.TaskDao;

@Database(entities = {Task.class}, version = 1, exportSchema = false)
public abstract class TasksDatabase extends RoomDatabase {

    private static TasksDatabase instance = null;


    public static TasksDatabase getInstance(Context context){
        if(instance == null){
            //criar instancia

        instance = Room.databaseBuilder(context, TasksDatabase.class, "tasks_db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
        }

        return instance;
    }


    public abstract TaskDao taskDao();

}
