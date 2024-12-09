package Automation;

import java.util.concurrent.atomic.AtomicInteger;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SampleTestCase {

  private AtomicInteger counter = new AtomicInteger(0);

  @Test(dataProvider = "dp", retryAnalyzer = OnceAgain.class)
  public void sampleTestMethod(Player player) {
    if (counter.incrementAndGet() <= 2) {
      System.err.println("Test failed for Input: " + player + " in attempt " + counter.get());
      Assert.fail(player.toString());
    }
    System.err.println("Test passed for Input: " + player + " in attempt " + counter.get());
    counter = new AtomicInteger(0);
  }

  @DataProvider(name = "dp")
  public Object[][] getData() {
    System.err.println("Retrieving Test data");
    return new Object[][]{
        {new Player("Jack", 20)},
        {new Player("Daniel", 25)}
    };
  }

  public static class OnceAgain implements IRetryAnalyzer {

    private int count = 0;

    @Override
    public boolean retry(ITestResult result) {
      return count++ <= 3;
    }
  }


  public static class Player {

    private final String name;
    private final int age;

    public Player(String name, int age) {
      this.name = name;
      this.age = age;
    }

    @Override
    public String toString() {
      return "[name:" + name + ", age:" + age + "]";
    }
  }
}