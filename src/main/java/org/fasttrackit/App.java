package org.fasttrackit;


import org.fasttrackit.domain.Task;
import org.fasttrackit.persistance.TaskRepository;
import org.fasttrackit.transfer.CreateTaskRequest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static java.time.LocalDate.now;

public class App
{
    public static void main( String[] args ) throws IOException, SQLException, ClassNotFoundException {
        CreateTaskRequest request = new CreateTaskRequest();
        request.setDescription("Learn JDBC");
        request.setDeadline(now().plusWeeks(2));

        TaskRepository taskRepository = new TaskRepository();
        taskRepository.createTask(request);

        List<Task> tasks = taskRepository.getTask();
        System.out.println(tasks);

//        UpdateTaskRequest updateTaskRequest = new UpdateTaskRequest();
//        updateTaskRequest.setDone(true);
//       taskRepository.deleteTask(3);
    }
}
