

 
public class FCFS implements Algorithm {
    private ArrayList<Task> Queue;
    
    public FCFS(ArrayList<Task> queue) {
        this.Queue = queue;
    }
    
    public void schedule() {
        ArrayList<Task> scheduledTasks = new ArrayList<Task>();
        
        int qSize = this.Queue.size();
        for (int i = 0; i < qSize; i++) {
            Task nextTask = pickNextTask();
            scheduledTasks.add(nextTask);
        }
        
        for (Task t : scheduledTasks) 
        { 
            int slice = 1;
            CPU.run(t, slice); 
        }
    }
    
    public Task pickNextTask() {
        Task t = Queue.get(0);
        Queue.remove(0);
        return t;
    }
}
