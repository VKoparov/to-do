import {Status} from "../enums/Status";

export interface Task {
  id?: string;
  header: string;
  text: string;
  status: Status;
}
