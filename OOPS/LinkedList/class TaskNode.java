class TaskNode {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    TaskNode next;

    public TaskNode(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}
class TaskScheduler {
    private TaskNode head = null;
    private TaskNode tail = null;
    private TaskNode currentTask = null;

    public void addAtBeginning(int id, String name, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(id, name, priority, dueDate);
        if (head == null) {
            head = tail = newNode;
            newNode.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
    }

    public void addAtEnd(int id, String name, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(id, name, priority, dueDate);
        if (head == null) {
            head = tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
    }

    public void addAtPosition(int pos, int id, String name, int priority, String dueDate) {
        if (pos <= 0 || head == null) {
            addAtBeginning(id, name, priority, dueDate);
            return;
        }

        TaskNode newNode = new TaskNode(id, name, priority, dueDate);
        TaskNode temp = head;
        int index = 0;

        while (index < pos - 1 && temp.next != head) {
            temp = temp.next;
            index++;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        if (temp == tail) {
            tail = newNode;
        }
    }

    public boolean removeById(int id) {
        if (head == null) return false;

        TaskNode curr = head;
        TaskNode prev = tail;

        do {
            if (curr.taskId == id) {
                if (curr == head) {
                    if (head == tail) {
                        head = tail = null;
                    } else {
                        head = head.next;
                        tail.next = head;
                    }
                } else {
                    prev.next = curr.next;
                    if (curr == tail) {
                        tail = prev;
                    }
                }
                return true;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);

        return false;
    }

    public void viewCurrentTask() {
        if (currentTask == null) {
            currentTask = head;
        }
        if (currentTask != null) {
            System.out.println("Current Task:");
            printTask(currentTask);
        } else {
            System.out.println("No tasks available.");
        }
    }

    public void moveToNextTask() {
        if (currentTask == null && head != null) {
            currentTask = head;
        } else if (currentTask != null) {
            currentTask = currentTask.next;
        }
        viewCurrentTask();
    }

    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }

        TaskNode temp = head;
        do {
            printTask(temp);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks found.");
            return;
        }

        boolean found = false;
        TaskNode temp = head;
        do {
            if (temp.priority == priority) {
                printTask(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tasks with priority " + priority);
        }
    }

    private void printTask(TaskNode task) {
        System.out.println("ID: " + task.taskId +
                           " | Name: " + task.taskName +
                           " | Priority: " + task.priority +
                           " | Due: " + task.dueDate);
    }
}
