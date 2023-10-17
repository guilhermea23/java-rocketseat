package br.com.guilhermea23.todolist.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {


    @Autowired
    private InterfaceTaskRepository taskRepository;

    @PostMapping("/")
    public Task create(@RequestBody Task task){
        System.out.println("no controller");
        var taskCreation = this.taskRepository.save(task);
        return taskCreation;
    }
    
}
