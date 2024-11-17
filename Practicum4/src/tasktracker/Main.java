package tasktracker;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        Task task1 = new Task(manager.generateId(), "Task 1", "Description 1", TaskStatus.NEW);
        Task task2 = new Task(manager.generateId(), "Task 2", "Description 2", TaskStatus.IN_PROGRESS);

        manager.addTask(task1);
        manager.addTask(task2);

        Epic epic1 = new Epic(manager.generateId(), "Epic 1", "Epic Description 1");
        manager.addEpic(epic1);

        Subtask subtask1 = new Subtask(manager.generateId(), "Subtask 1", "Subtask Description 1", TaskStatus.NEW, epic1.getId());
        Subtask subtask2 = new Subtask(manager.generateId(), "Subtask 2", "Subtask Description 2", TaskStatus.DONE, epic1.getId());

        manager.addSubtask(subtask1);
        manager.addSubtask(subtask2);

        System.out.println("Tasks: " + manager.getAllTasks());
        System.out.println("Epics: " + manager.getAllEpics());
        System.out.println("Subtasks: " + manager.getAllSubtasks());

        subtask1.setStatus(TaskStatus.DONE);
        manager.updateSubtask(subtask1);

        System.out.println("Updated Epics: " + manager.getAllEpics());

        manager.deleteTaskById(task1.getId());
        manager.deleteEpicById(epic1.getId());

        System.out.println("Tasks after deletion: " + manager.getAllTasks());
        System.out.println("Epics after deletion: " + manager.getAllEpics());
    }
}
