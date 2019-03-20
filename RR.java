

 
public class RR implements Algorithm {
    private ArrayList<Task> Queue;
    
    public RR(ArrayList<Task> queue) {
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
        Task t = this.Queue.get(0);
        
        if (t.getBurst() > 10) {
            t.setBurst(t.getBurst() - 10);
            this.Queue.set(0, t);
            
            Task nt = new Task(t.getName() , t.getPriority(), t.getBurst());
            nt.setBurst(10);
            return nt;
        }
        else {
            this.Queue.remove(0);
            
            return t;
        }
    }
}
