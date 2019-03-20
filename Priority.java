


 
public class Priority implements Algorithm {
    private ArrayList<Task> Queue;
    
    public Priority(ArrayList<Task> queue) {
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
        int highest = 0;
        int highestIndex = -1;
        
        for (int i = 0; i < this.Queue.size(); i++) 
        { 
            if(highestIndex == -1) {
                highest = this.Queue.get(i).getPriority();
                highestIndex = 0;
            }
            else {
                int prio = this.Queue.get(i).getPriority();
                if (prio >= highest) {
                    highest = prio;
                    highestIndex = i;
                }
            }
        }
        Task t = this.Queue.get(highestIndex);
        
        this.Queue.remove(highestIndex);
        return t;
    }
}
