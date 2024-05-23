/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package taskpart2;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class TaskPart2 {
    private static int taskCount = 0;
    private static double totalDuration = 0;

    public static void main(String[] args) {
        if (Login()) {
            JOptionPane.showMessageDialog(null, "Welcome to EasyKanban ");

            while (true) {
                String menu = "1) Add tasks\n2) Show report\n3) Quit ";
                String choice = JOptionPane.showInputDialog(menu);

                if (choice == null) continue;
                switch (choice) {
                    case "1":
                        createTask();
                        break;
                    case "2":
                        JOptionPane.showMessageDialog(null, "Coming Soon");
                        break;
                    case "3":
                        JOptionPane.showMessageDialog(null, "Total Duration: " + totalDuration);
                        System.exit(0);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid choice, please try again. ");
                        break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid login, Exiting. ");
        }

        // Login
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();

        Login login = new Login(username, password);
        boolean isAuthenticated = login.loginUser(username, password);

        // Task creation
        System.out.println("How many tasks do you wish to enter?");
        int numOfTasks = scanner.nextInt();
        scanner.nextLine(); // consume newline
        Task[] tasks = new Task[numOfTasks];
        for (int i = 0; i < numOfTasks; i++) {
            System.out.println("\nTask " + (i + 1));
            tasks[i] = createTask();
        }

        // Display tasks
        System.out.println("\nTasks entered:");
        for (Task task : tasks) {
            displayTaskDetails(task);
        }

        // Display total duration
        System.out.println("\nTotal Duration: " + totalDuration + " hours");

        scanner.close();
    }

    private static boolean Login() {
        String username = JOptionPane.showInputDialog("Enter username: ");
        String password = JOptionPane.showInputDialog("Enter password: ");
        return "admin".equals(username) && "password".equals(password);
    }

    public static Task createTask() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Task Name:");
        String taskName = scanner.nextLine();
        System.out.println("Enter Task Description:");
        String taskDescription = scanner.nextLine();
        if (taskDescription.length() > 50) {
            JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
            return createTask(); // Recursive call to createTask to allow the user to enter a new task description
        }

        System.out.println("Enter Developer First Name:");
        String devFirstName = scanner.nextLine();
        System.out.println("Enter Developer Last Name:");
        String devLastName = scanner.nextLine();
        System.out.println("Enter Task Duration (in hours):");
        double taskDuration = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        // Generate Task ID
        String taskID = generateTaskID(taskName, devLastName);

        // Get Task Status
        System.out.println("Select Task Status:");
        System.out.println("1. To Do");
        System.out.println("2. Done");
        System.out.println("3. Doing");
        int choice = scanner.nextInt();
        String taskStatus = "";
        switch (choice) {
            case 1:
                taskStatus = "To Do";
                break;
            case 2:
                taskStatus = "Done";
                break;
            case 3:
                taskStatus = "Doing";
                break;
            default:
                taskStatus = "To Do";
        }

        // Accumulate total duration
        totalDuration += taskDuration;

        // Create a new Task object
        Task task = new Task(taskName, taskDescription, devFirstName, devLastName, taskDuration, taskID, taskStatus);

        // Increment the task count
        taskCount++;

        // Return the created task
        return task;
    }

    public static String generateTaskID(String taskName, String devLastName) {
        String taskId = taskName.substring(0, 2).toUpperCase() + ":" + taskCount + ":" + devLastName.substring(devLastName.length() - 3).toUpperCase();
        return taskId;
    }

    public static void displayTaskDetails(Task task) {
        String message = "Task Status: " + task.getTaskStatus() + "\n" +
                         "Developer Details: " + task.getDevFirstName() + " " + task.getDevLastName() + "\n" +
                         "Task Number: " + taskCount + "\n" +
                         "Task Name: " + task.getTaskName() + "\n" +
                         "Task Description: " + task.getTaskDescription() + "\n" +
                         "Task ID: " + task.getTaskID() + "\n" +
                         "Task Duration: " + task.getTaskDuration() + " hours";
        JOptionPane.showMessageDialog(null, message);
        JOptionPane.showMessageDialog(null, "Task Successfully Captured ");
    }
}

class Task {
    private String taskName;
    private String taskDescription;
    private String devFirstName;
    private String devLastName;
    private double taskDuration;
    private String taskID;
    private String taskStatus;

    public Task(String taskName, String taskDescription, String devFirstName, String devLastName, double taskDuration, String taskID, String taskStatus) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.devFirstName = devFirstName;
        this.devLastName = devLastName;
        this.taskDuration = taskDuration;
        this.taskID = taskID;
        this.taskStatus = taskStatus;
    }

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
