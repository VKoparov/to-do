import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Task} from '../../model/Task';
import {faTimes} from '@fortawesome/free-solid-svg-icons';
import {Status} from "../../enums/Status";
import {IconDefinition} from "@fortawesome/free-regular-svg-icons";

@Component({
  selector: 'app-task-item',
  templateUrl: './task-item.component.html',
  styleUrls: ['./task-item.component.scss'],
})
export class TaskItemComponent {

  protected readonly Status = Status;

  @Input() task!: Task;

  @Output() delete: EventEmitter<Task> = new EventEmitter();

  @Output() update: EventEmitter<Task> = new EventEmitter();

  faTimes: IconDefinition = faTimes;

  onDelete(task: Task) {
    this.delete.emit(task);
  }

  onUpdate(task: Task) {
    this.updateStatus(task);
    this.update.emit(task);
  }

  private updateStatus(task: Task) {
    if (task.status === Status.DONE) {
      task.status = Status.IN_PROGRESS;
      return;
    }

    if (task.status === Status.IN_PROGRESS) {
      task.status = Status.DONE;
      return;
    }
  }
}
