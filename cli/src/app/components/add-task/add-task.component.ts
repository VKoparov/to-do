import {Component, EventEmitter, Output} from '@angular/core';
import {UiService} from '../../services/ui.service';
import {Subscription} from 'rxjs';
import {Task} from '../../model/Task';
import {Status} from "../../enums/Status";

@Component({
  selector: 'app-add-task',
  templateUrl: './add-task.component.html',
  styleUrls: ['./add-task.component.scss'],
})
export class AddTaskComponent {

  @Output() create: EventEmitter<Task> = new EventEmitter();

  options: string[] = ['IN_PROGRESS', 'DONE'];

  header!: string;

  text!: string;

  status!: Status;

  showAddTask!: boolean;

  subscription: Subscription;

  constructor(private uiService: UiService) {
    this.subscription = this.uiService.onToggle()
      .subscribe((value) => this.showAddTask = value);
  }

  onSubmit() {
    this.create.emit({
        header: this.header,
        text: this.text,
        status: this.status
    });
  }
}
