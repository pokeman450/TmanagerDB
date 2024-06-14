package project.pbc.TmanagerDB.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.pbc.TmanagerDB.Entity.Tasks;
import project.pbc.TmanagerDB.Services.TaskService;

import java.util.List;

@RestController
public class TasksController {

    @Autowired
    public TaskService ts;

    //home page
    @GetMapping("/")
    public String home(){
        return "<h1>Task Manager</h1>";
    }
    //all tasks
    @GetMapping("/tasks")
    public List<Tasks> getTasks(){
        return this.ts.getAllTasks();
    }
    //all tasks matched with the taskID
    @GetMapping("/tasks/{taskID}")
    public Tasks getTaskById(@PathVariable long taskID){
        return this.ts.getTaskById(taskID);
    }
    //add task
    @PostMapping("/tasks")
    public Tasks addTask(@RequestBody Tasks task){
        return this.ts.addTask(task);
    }
    //update task properties
    @PutMapping("/tasks")
    public Tasks updateTask(@RequestBody Tasks task){
        return this.ts.updateTask(task);
    }
    
    //delete tasks
    @DeleteMapping("/tasks/{taskID}")
    public String deleteTask(@PathVariable long taskID){
        return this.ts.deleteTaskById(taskID);
    }

}
