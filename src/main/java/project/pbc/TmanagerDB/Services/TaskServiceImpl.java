package project.pbc.TmanagerDB.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.pbc.TmanagerDB.Entity.Tasks;
import project.pbc.TmanagerDB.Repository.TasksDAO;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    public TasksDAO tasksDAO;

    //return all tasks
    @Override
    public List<Tasks> getAllTasks() {
        return this.tasksDAO.findAll();
    }
    //return the task the matches the passed in ID
    @Override
    public Tasks getTaskById(long taskID) {
        //return this.tasksDAO.getReferenceById(taskID);
        Optional<Tasks> t = this.tasksDAO.findById(taskID);
        Tasks task = null;
        //if the taskID matches, send to task
        if (t.isPresent()) {
            task = t.get();
        }
        else{
            throw new RuntimeException("Task not found: "+taskID);
        }
        return task;
    }

    //add task to manager
    @Override
    public Tasks addTask(Tasks task) {
        return this.tasksDAO.save(task);
    }
    //update the properties in the tasks and saves the results
    @Override
    public Tasks updateTask(Tasks task) {
        return this.tasksDAO.save(task);
    }
    // retrieve a task by its ID and delete it. Display message that item has been
    //deleted
    @Override
    public String deleteTaskById(long TaskID) {
        this.tasksDAO.deleteById(TaskID);
        return "Tasks Closed";
    }
}
