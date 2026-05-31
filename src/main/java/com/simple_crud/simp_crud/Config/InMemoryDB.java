package com.simple_crud.simp_crud.Config;

import com.simple_crud.simp_crud.Model.Task;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class InMemoryDB {
    private List<Task> tasks = new ArrayList<Task>();

    public InMemoryDB(){
        Task t1 = new Task();
        Task t2 = new Task();
        Task t3 = new Task();
        t1.setId(1L);
        t1.setName("Task 1 Name");
        t1.setDescription("Task 1 Description");
        t1.setCreationDate(LocalDateTime.now());

        t2.setId(2L);
        t2.setName("Task 2 Name");
        t2.setDescription("Task 2 Description");
        t2.setCreationDate(LocalDateTime.now());

        t3.setId(3L);
        t3.setName("Task 3 Name");
        t3.setDescription("Task 3 Description");
        t3.setCreationDate(LocalDateTime.now());

        tasks.add(t1);
        tasks.add(t2);
        tasks.add(t3);
    }

    public List<Task> getAllTasks(){
        return tasks;
    }

    public Task getTaskById(long id){
        return tasks
                .stream()
                .filter(task -> task.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Task updateTaskById(long id, Task task){
        Task taskToUpdate = getTaskById(id);
        if(task.getDescription() != null){
            taskToUpdate.setDescription(task.getDescription());
        }
        if(task.getName() != null) {
            taskToUpdate.setName(task.getName());
        }
        return taskToUpdate;
    }

    public String deleteTaskById(long id){
        if(getTaskById(id) != null){
            tasks.remove(getTaskById(id));
            return "Successfully deleted Task";
        }
        return "Task not found!";
    }

    public String createNewTask(Task task){
        Task newTask = new Task();
        List<Task> currentExistingTasks = getAllTasks();
        Task lastExistingTask = currentExistingTasks.get(currentExistingTasks.size()-1);
        newTask.setId(lastExistingTask.getId() + 1L);
        newTask.setName(task.getName());
        newTask.setDescription(task.getDescription());
        newTask.setCreationDate(LocalDateTime.now());
        currentExistingTasks.add(newTask);
        return newTask.toString();
    }

    public String toString(){
        return "Current tasks: " + tasks.toString();
    }
}
