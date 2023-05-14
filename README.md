# To Do Application

## Setup
### Clone the repository using the following command:

```bash
git clone <repository_url>
```

- Navigate to the main directory of the cloned repository.
- Start the application using Docker Compose:

```bash
docker-compose up -d
```
## To accessing the Application

- Open a web browser.
- Enter **localhost:4200** in the address bar.
- The main user interface **(UI)** page will be displayed.

## API Endpoints
### The API server provides the following endpoints:

- Main Route Prefix: **/v1**
- List All: **/items**
- Delete: **/delete**
- Create: **/create**
- Update: **/update**

## Actions
### Using the UI
- To finish a task: **click on top**
- A **green** line will appear on the left.
- To move a task back to **"In Progress"** click once again on top.
