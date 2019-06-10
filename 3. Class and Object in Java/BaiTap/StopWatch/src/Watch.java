public class Watch {
    long startTime, endTime;

    public long getEndTime() {
        this.endTime = System.currentTimeMillis();
        return this.endTime;
    }
    public long getStartTime() {
        this.startTime = System.currentTimeMillis();
        return this.startTime;
    }
    public long getElapsedTime(){
        return (this.endTime - this.startTime);
    }

}
