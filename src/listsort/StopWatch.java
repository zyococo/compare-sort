package listsort;

/**
 * @author 30038637 Takuya Hasama 08/08/2021
 */
public class StopWatch {

    private double startTime;

    private double endTime;

    public double start() {

        startTime = System.currentTimeMillis();

        return startTime;
    }

    public double stop() {

        endTime = System.currentTimeMillis();

        return endTime;

    }

    public double getElapsedTime() {

        return endTime - startTime;
    }
}
