package com.simple_crud.simp_crud.Controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("task")
public class TaskController {

    @GetMapping("/")
    public ResponseEntity<Object>helloWorld(){
        Object response = new Object(){
            public String message = "Hello World!";
            public String test = "test";
        };
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("Burat", "Sobrang Burat")
                .body(response);

    }
}
