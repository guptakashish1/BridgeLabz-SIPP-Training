// Node representing each process
class ProcessNode {
    int pid, burstTime, priority, remainingTime;
    ProcessNode next;

    public ProcessNode(int pid, int burstTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.priority = priority;
        this.remainingTime = burstTime;
        this.next = null;
    }
}

// Scheduler using Circular Linked List
class RoundRobinScheduler {
    private ProcessNode head = null;

    // Add a new process at the end
    public void addProcess(int pid, int burstTime, int priority) {
        ProcessNode newNode = new ProcessNode(pid, burstTime, priority);
        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }
        ProcessNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.next = head;
    }

    // Remove a process by Process ID
    private void removeProcess(int pid) {
        if (head == null) return;

        ProcessNode curr = head, prev = null;
        do {
            if (curr.pid == pid) {
                if (prev != null) {
                    prev.next = curr.next;
                    if (curr == head) head = curr.next;
                } else {
                    if (head.next == head) {
                        head = null;
                        return;
                    }
                    ProcessNode last = head;
                    while (last.next != head) last = last.next;
                    last.next = head.next;
                    head = head.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    // Execute processes in Round Robin manner
    public void executeProcesses(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int time = 0, totalWaitingTime = 0, totalTurnaroundTime = 0;
        int processCount = countProcesses();
        int completed = 0;
        ProcessNode curr = head;

        System.out.println("Starting Round Robin Scheduling with Time Quantum = " + timeQuantum);

        while (completed < processCount) {
            if (curr.remainingTime > 0) {
                System.out.println("Executing PID: " + curr.pid + " | Remaining Time: " + curr.remainingTime);
                if (curr.remainingTime > timeQuantum) {
                    time += timeQuantum;
                    curr.remainingTime -= timeQuantum;
                } else {
                    time += curr.remainingTime;
                    curr.remainingTime = 0;
                    completed++;
                    int turnaroundTime = time;
                    int waitingTime = turnaroundTime - curr.burstTime;
                    totalWaitingTime += waitingTime;
                    totalTurnaroundTime += turnaroundTime;
                    System.out.println("Process PID: " + curr.pid + " completed | Turnaround Time: " + turnaroundTime + " | Waiting Time: " + waitingTime);
                    removeProcess(curr.pid);
                }
                displayProcesses();
            }
            curr = (curr != null) ? curr.next : head;
        }

        System.out.printf("Average Waiting Time: %.2f\n", (double) totalWaitingTime / processCount);
        System.out.printf("Average Turnaround Time: %.2f\n", (double) totalTurnaroundTime / processCount);
    }

    // Count total number of processes
    private int countProcesses() {
        if (head == null) return 0;
        int count = 0;
        ProcessNode temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }

    // Display current processes
    public void displayProcesses() {
        if (head == null) {
            System.out.println("Process queue is empty.");
            return;
        }
        ProcessNode temp = head;
        System.out.print("Current Process Queue: ");
        do {
            System.out.print("[PID: " + temp.pid + " RemTime: " + temp.remainingTime + "] -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }
}

// Main class to run the scheduler
public class RoundRobinMain {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        // Adding processes: PID, Burst Time, Priority
        scheduler.addProcess(1, 10, 2);
        scheduler.addProcess(2, 5, 1);
        scheduler.addProcess(3, 8, 3);
        scheduler.addProcess(4, 6, 2);

        System.out.println("Initial Process Queue:");
        scheduler.displayProcesses();

        int timeQuantum = 3;
        System.out.println("\nExecuting Round Robin Scheduling with Time Quantum = " + timeQuantum);
        scheduler.executeProcesses(timeQuantum);
    }
}
