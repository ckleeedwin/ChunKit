/**
 * @(#)TimingMeasureTool.java
 *
 *
 * @author 
 * @version 1.00 2018/4/8
 */

import java.util.concurrent.TimeUnit;

public class TimingMeasureTool
{

  public Long timingMeasure() {
    System.out.println("**********************");
    long time = System.nanoTime();
    return time;

  }
  
  public static void measureResult(Long start, Long end) {
    Long timeElapse = end - start;
    System.out.println("nano second ::" + timeElapse);
    System.out.println("millisecond ::" + timeElapse / 1000000);
    System.out.println("second      ::" + timeElapse / 1000000000);
  }

  public static void sampleMethod() throws InterruptedException {
    TimeUnit.SECONDS.sleep(5);
  }

  public static void main(String[] args) throws InterruptedException {

    TimingMeasureTool p = new TimingMeasureTool();
    Long start = p.timingMeasure();
    sampleMethod();
    Long end = p.timingMeasure();

    measureResult(start, end);

  }
}
