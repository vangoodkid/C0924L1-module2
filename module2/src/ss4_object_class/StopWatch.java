package ss4_object_class;

public class StopWatch {
    private long startTime;
    private long endTime;


    public StopWatch() {
        this.startTime = System.currentTimeMillis();
    }


    public long getStartTime() {
        return startTime;
    }


    public long getEndTime() {
        return endTime;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
        this.endTime = 0; // Đặt endTime về 0
    }


    public void stop() {
        this.endTime = System.currentTimeMillis(); // Đặt endTime
    }


    public long getElapsedTime() {
        if (endTime == 0) {
            return System.currentTimeMillis() - startTime;
        }
        return endTime - startTime;
    }

    public static void main(String[] args) {
            StopWatch stopwatch = new StopWatch();
            System.out.println("StopWatch started at: " + stopwatch.getStartTime());

            stopwatch.stop();
            System.out.println("StopWatch stopped at: " + stopwatch.getEndTime());
            System.out.println("Elapsed time: " + stopwatch.getElapsedTime() + " milliseconds");
        }

}

