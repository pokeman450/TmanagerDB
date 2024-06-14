package project.pbc.TmanagerDB.Services;

import project.pbc.TmanagerDB.Entity.Tasks;

import java.util.*;

public interface TaskService {
    List<Tasks> getAllTasks();

    Tasks getTaskById(long id);

    Tasks addTask(Tasks task);

    Tasks updateTask(Tasks task);

    String deleteTaskById(long id);
}
