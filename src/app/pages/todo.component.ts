import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { TaskService, Task } from '../services/task.service';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-todo',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, FormsModule, HttpClientModule],
  templateUrl: './todo.html',
  styleUrls: ['./todo.css']
})
export class TodoComponent implements OnInit {
  todoForm!: FormGroup;
  tasks: Task[] = [];

  filter: 'all' | 'pending' | 'completed' = 'all';
  searchText: string = '';
  userId: number = 1; // Replace this with actual user ID if available

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private taskService: TaskService
  ) {}

  ngOnInit(): void {
    this.todoForm = this.fb.group({
      title: ['', Validators.required],
      description: ['']
    });

    this.loadTasks();
  }

  loadTasks(): void {
    this.taskService.getTasks(this.userId).subscribe({
      next: tasks => (this.tasks = tasks),
      error: err => console.error('Failed to load tasks', err)
    });
  }

  addTask(): void {
    if (this.todoForm.invalid) return;

    const newTask: Task = {
      title: this.todoForm.value.title!,
      description: this.todoForm.value.description || '',
      completed: false
    };

    this.taskService.addTask(this.userId, newTask).subscribe({
      next: task => {
        this.tasks.push(task);
        this.todoForm.reset();
      },
      error: err => console.error('Failed to add task', err)
    });
  }

  toggleComplete(index: number): void {
    const task = this.tasks[index];
    task.completed = !task.completed;

    this.taskService.updateTask(task).subscribe({
      next: () => this.loadTasks(),
      error: err => console.error('Failed to update task', err)
    });
  }

  deleteTask(index: number): void {
    const taskId = this.tasks[index].id!;
    this.taskService.deleteTask(taskId).subscribe({
      next: () => this.tasks.splice(index, 1),
      error: err => console.error('Failed to delete task', err)
    });
  }

  logout(): void {
    localStorage.removeItem('loggedIn');
    this.router.navigate(['/login']);
  }

  setFilter(filter: 'all' | 'pending' | 'completed') {
    this.filter = filter;
  }

  getFilteredTasks(): Task[] {
    let filtered = this.tasks;

    if (this.filter === 'completed') {
      filtered = filtered.filter(task => task.completed);
    } else if (this.filter === 'pending') {
      filtered = filtered.filter(task => !task.completed);
    }

    if (this.searchText.trim() !== '') {
      filtered = filtered.filter(task =>
        task.title.toLowerCase().includes(this.searchText.toLowerCase())
      );
    }

    return filtered;
  }
}
