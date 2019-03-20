


 
public class SJF implements Algorithm {
    private ArrayList<Task> Queue;
    
    public SJF(ArrayList<Task> queue) {
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
        int shortest = 0;
        int shortestIndex = -1;
        for (int i = 0; i < this.Queue.size(); i++) 
        { 
            if(shortestIndex == -1) {
                shortest = this.Queue.get(i).getBurst();
                shortestIndex = 0;
            }
            else {
                int burst = this.Queue.get(i).getBurst();
                if (burst < shortest) {
                    shortest = burst;
                    shortestIndex = i;
                }
            }
        }
        Task t = this.Queue.get(shortestIndex);
        this.Queue.remove(shortestIndex);
        return t;
    }
}
