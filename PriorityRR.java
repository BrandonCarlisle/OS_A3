



public class PriorityRR implements Algorithm {
    private ArrayList<Task> Queue;
    
    public PriorityRR(ArrayList<Task> queue) {
        this.Queue = queue;
    }
    
    
    public void schedule() {
        ArrayList<Task> scheduledTasks = new ArrayList<Task>();
        
        
        while (this.Queue.size() > 0) {
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
        
        
        if (t.getBurst() > 10) {
            t.setBurst(t.getBurst() - 10);
            this.Queue.set(highestIndex, t);
            
            Task nt = new Task(t.getName() , t.getPriority(), t.getBurst());
            nt.setBurst(10);
            return nt;
        }
        else {
            this.Queue.remove(highestIndex);
            return t;
        }
    }
}