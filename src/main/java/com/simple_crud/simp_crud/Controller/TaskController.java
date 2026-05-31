package com.simple_crud.simp_crud.Controller;


import com.simple_crud.simp_crud.Config.InMemoryDB;
import com.simple_crud.simp_crud.Model.Task;
import com.simple_crud.simp_crud.Service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("task")
public class TaskController {

    private final TaskService taskService;
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/")
    public ResponseEntity<String>createNewTask(@RequestBody Task task){
        return ResponseEntity.ok(taskService.createNewTask(task));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task>getTask(@PathVariable long id){
        Task task  = taskService.getTaskById(id);
        if(task == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(task);

    }

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getAllTasks(){
        List<Task> tasks = taskService.getTasks();
        if(tasks.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(tasks);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask (@PathVariable long id, @RequestBody Task task){
        return ResponseEntity.ok(taskService.updateTaskById(id, task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTaskById(@PathVariable long id){
        return ResponseEntity.notFound().build();
    }
    //delete taskById
    //edit taskById
    //get byId -- DONE
    //get all - DONE
}
