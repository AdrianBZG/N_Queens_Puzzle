/**
 * @author Adrián Rodríguez Bazaga
 * @email arodriba@ull.edu.es
 * @date 23 March 2016
 * @assignment 6
 */

package junittesting;

import org.junit.BeforeClass;
import org.junit.Test;

import clock.Clock;
import static org.junit.Assert.*;

/**
 * This class tests the methods from the Clock class
 *
 */
public class ClockTest {
  private static Clock testClock = new Clock();
  final static int MAX_LOOP_ITERATIONS = 10000000;
  final static int DELAY_1 = 3000;
  final static int DELAY_2 = 3500;
  
  @BeforeClass
  public static void initClock() {
    testClock.start();
  }
  
  @Test
  public void testObjectBuildingProperly() {
    assertNotNull(testClock);
  }
  
  @Test
  public void testClockInitialValuesAreCorrect() {
    assertEquals(0, testClock.elapsedTime());
  }
  
  @Test
  public void testDelay() {
    try {
      Thread.sleep(DELAY_1);
      testClock.save();
      assertTrue(testClock.elapsedTime() > 0 && testClock.elapsedTime() < DELAY_2);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
  
  @Test
  public void testDifferentSizeProblems() {
    //First loop
    long total = 0;
    for (int i = 0; i < MAX_LOOP_ITERATIONS; i++) {
       total += i;
    }
    System.out.println(total);
    testClock.save();
    
    //Second loop
    Clock auxClock = new Clock();
    auxClock.start();
    total = 0;
    for (int i = 0; i < MAX_LOOP_ITERATIONS / 2; i++) {
       total += i;
    }
    System.out.println(total);
    auxClock.save();
    
    assertTrue(testClock.elapsedTime() > auxClock.elapsedTime());
  }
  
  @Test
  public void testClockCalculatingCorrectly() {
    long total = 0;
    for (int i = 0; i < MAX_LOOP_ITERATIONS; i++) {
       total += i;
    }
    System.out.println(total);
    testClock.save();
    assertTrue(testClock.elapsedTime() > 0);
  }
}
