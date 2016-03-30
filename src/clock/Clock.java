/**
 * @author Adrián Rodríguez Bazaga
 * @email arodriba@ull.edu.es
 * @date 23 March 2016
 * @assignment 6
 */

package clock;

/**
 * This class gets the system current milliseconds when it's start() method is
 * invoked and save it, also saves the current system milliseconds when it's
 * stop() method is called.
 * You are able to invoke elapsedTime() to get the time difference in milliseconds
 * between the ending time and the initial time
 */
public class Clock {

  private long initialTime;         // The time when the start function was invoked
  private long endTime;             // The time when the stop function was invoked
  
  public Clock() {
    initialTime = System.currentTimeMillis();
    endTime = System.currentTimeMillis();
  }
  
  /**
   * This method returns the initial time
   * @return initialTime as long
   */
  private long getInitialTime() {
    return initialTime;
  }
  
  /**
   * This method returns the ending time
   * @return endingTime as long
   */
  private long getEndingTime() {
    return endTime;
  }
  
  /**
   * This method sets the initial time
   * @param time
   */
  private void setInitialTime(long time) {
    initialTime = time;
  }
  
  /**
   * This method sets the ending time
   * @param time
   */
  private void setEndingTime(long time) {
    endTime = time;
  }
  
  /**
   * This method stars the clock by setting the initial time as the System
   * current time in milliseconds
   */
  public void start() {
    setInitialTime(System.currentTimeMillis());
  }
  
  /**
   * This method saves the clock time by setting the ending time as the System
   * current time in milliseconds
   */
  public void save() {
    setEndingTime(System.currentTimeMillis());
  }
  
  /**
   * This method calculates the difference between the ending time and the
   * initial time.
   * @return timeToReturn as long
   */
  public long elapsedTime() {
    long timeToReturn = getEndingTime() - getInitialTime();
    return timeToReturn;
  }
}