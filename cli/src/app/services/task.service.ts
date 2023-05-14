import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Task } from '../model/Task';

@Injectable({
  providedIn: 'root',
})
export class TaskService {

  private readonly apiUrl: string = 'http://localhost:8080/v1';

  constructor(private http: HttpClient) {}

  items(): Observable<Task[]> {
    return this.http.get<Task[]>(`${this.apiUrl}/items`);
  }

  create(task: Task): Observable<Task> {
    return this.http.post<Task>(`${this.apiUrl}/create`, task);
  }

  update(id: string, task: Task): Observable<Task> {
    return this.http.put<Task>(`${this.apiUrl}/update/${id}`, task);
  }

  delete(id: string): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/delete/${id}`);
  }
}
