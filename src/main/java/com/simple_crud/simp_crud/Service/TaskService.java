package com.simple_crud.simp_crud.Service;

import com.simple_crud.simp_crud.Config.InMemoryDB;
import com.simple_crud.simp_crud.Model.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final InMemoryDB inmemoryDB;
    public TaskService(InMemoryDB inmemoryDB){
        this.inmemoryDB = inmemoryDB;
    }

    public String createNewTask(Task task){
        return inmemoryDB.createNewTask(task);
    }

    public Task getTaskById(long id){
        return inmemoryDB.getTaskById(id);
    }

    public List<Task> getTasks(){
       return  inmemoryDB.getAllTasks();
    }

    public Task updateTaskById(long id, Task task){
        return inmemoryDB.updateTaskById(id, task);
    }

    public String deleteTaskById(long id){
        return inmemoryDB.deleteTaskById(id);
    }
}
