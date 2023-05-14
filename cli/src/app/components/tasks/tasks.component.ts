import { Component, OnInit } from '@angular/core';
import { TaskService } from '../../services/task.service';
import { Task } from '../../model/Task';

@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.scss'],
})
export class TasksComponent implements OnInit {

  tasks: Task[] = [];

  constructor(private taskService: TaskService) {}

  ngOnInit(): void {
   this.loadTasks();
  }

  loadTasks(): void {
    this.taskService.items()
      .subscribe((tasks) => this.tasks = tasks);
  }

  deleteTask(task: Task) {
    if (task.id != null) {
      this.taskService.delete(task.id)
        .subscribe(() => this.loadTasks());
    }
  }

  addTask(task: Task) {
    this.taskService.create(task)
      .subscribe(() => this.loadTasks());
  }

  updateTask(task: Task) {
    if (task.id != null) {
      this.taskService.update(task.id, task)
        .subscribe(() => this.loadTasks());
    }
  }
}
