/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskpart2;

public class Task {

    static String generateTaskID(String taskName, String devLastName) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private String taskName;
    private String taskDescription;
    private String devFirstName;
    private String devLastName;
    private double taskDuration;
    private String taskID;
    private String taskStatus;

    public Task(String taskName, String taskDescription, String devFirstName, String devLastName, double taskDuration, String taskStatus) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.devFirstName = devFirstName;
        this.devLastName = devLastName;
        this.taskDuration = taskDuration;
        this.taskID = createTaskID();
        this.taskStatus = taskStatus;
    }

    // Method to check task description length
    private boolean checkTaskDescription(String description) {
        return description.length() <= 50;
    }

    // Method to create task ID
    private String createTaskID() {
        return taskName.substring(0, Math.min(2, taskName.length())).toUpperCase() + ":" +
               devLastName.substring(Math.max(0, devLastName.length() - 3)).toUpperCase();
    }

    // Method to print task details
    public String printTaskDetails() {
        return "Task Status: " + taskStatus + "\n" +
               "Developer Details: " + devFirstName + " " + devLastName + "\n" +
               "Task Name: " + taskName + "\n" +
               "Task Description: " + taskDescription + "\n" +
               "Task ID: " + taskID + "\n" +
               "Task Duration: " + taskDuration + " hours";
    }

    // Method to return total hours of all tasks
    public static double returnTotalHours(Task[] tasks) {
        double totalHours = 0;
        for (Task task : tasks) {
            totalHours += task.taskDuration;
        }
        return totalHours;
    }

    // Setters
    public void setTaskName(String taskName) {
        this.taskName = taskName;
        this.taskID = createTaskID();
    }

    public void setTaskDescription(String taskDescription) {
        if (checkTaskDescription(taskDescription)) {
            this.taskDescription = taskDescription;
        } else {
            System.out.println("Task description exceeds 50 characters.");
        }
    }

    public void setDevFirstName(String devFirstName) {
        this.devFirstName = devFirstName;
    }

    public void setDevLastName(String devLastName) {
        this.devLastName = devLastName;
        this.taskID = createTaskID();
    }

    public void setTaskDuration(double taskDuration) {
        this.taskDuration = taskDuration;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    // Getters
    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getDevFirstName() {
        return devFirstName;
    }

    public String getDevLastName() {
        return devLastName;
    }

    public double getTaskDuration() {
        return taskDuration;
    }

    public String getTaskID() {
        return taskID;
    }

    public String getTaskStatus() {
        return taskStatus;
    }
}


