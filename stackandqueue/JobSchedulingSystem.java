package stackandqueue;


import java.util.LinkedList;
import java.util.Queue;

class Job {
    private int id;
    private int processingTime;
    private int arrivalTime;
    private int waitingTime;
    private int turnaroundTime;

    public Job(int id, int processingTime, int arrivalTime) {
        this.id = id;
        this.processingTime = processingTime;
        this.arrivalTime = arrivalTime;
    }

    public int getId() {
        return id;
    }

    public int getProcessingTime() {
        return processingTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public int getTurnaroundTime() {
        return turnaroundTime;
    }

    public void setTurnaroundTime(int turnaroundTime) {
        this.turnaroundTime = turnaroundTime;
    }
}

public class JobSchedulingSystem {
    private Queue<Job> jobQueue;
    private int currentTime;

    public JobSchedulingSystem() {
        jobQueue = new LinkedList<>();
        currentTime = 0;
    }

    public void addJob(Job job) {
        jobQueue.offer(job);
    }

    public void processJobs() {
        while (!jobQueue.isEmpty()) {
            Job job = jobQueue.poll();
            job.setWaitingTime(currentTime - job.getArrivalTime());
            job.setTurnaroundTime(job.getWaitingTime() + job.getProcessingTime());
            currentTime += job.getProcessingTime();
            printJobInfo(job);
        }
    }

    private void printJobInfo(Job job) {
        System.out.println("Job ID: " + job.getId());
        System.out.println("Arrival Time: " + job.getArrivalTime());
        System.out.println("Processing Time: " + job.getProcessingTime());
        System.out.println("Waiting Time: " + job.getWaitingTime());
        System.out.println("Turnaround Time: " + job.getTurnaroundTime());
        System.out.println();
    }

    public static void main(String[] args) {
        JobSchedulingSystem scheduler = new JobSchedulingSystem();
        scheduler.addJob(new Job(1, 5, 0));
        scheduler.addJob(new Job(2, 3, 2));
        scheduler.addJob(new Job(3, 8, 4));
        scheduler.addJob(new Job(4, 6, 6));

        scheduler.processJobs();
    }
}
