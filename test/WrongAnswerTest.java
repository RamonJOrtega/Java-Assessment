package test;

import org.junit.jupiter.api.Test;

import src.WrongAnswer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;



public class WrongAnswerTest {
    private WrongAnswer wrongAnswer;

    @BeforeEach
    public void setUp() {
          wrongAnswer = new WrongAnswer();
    }

    @Test
    public void testCounterWithSingleThread() throws InterruptedException {
        wrongAnswer.incrementToOnHundred();
        assertEquals(10_000, wrongAnswer.getCounter());
    }
    @Test
    public void testCounterWithTwoThreads() throws InterruptedException {
        Thread t1 = new Thread(wrongAnswer::incrementToOnHundred);
        Thread t2 = new Thread(wrongAnswer::incrementToOnHundred);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        
        assertEquals(20_000, wrongAnswer.getCounter());
    }

    @Test
    public void testCounterWithMultipleTrehads() throws InterruptedException {
    int numThreads = 5;
    Thread[] threads = new Thread[numThreads];

    for (int i = 0; i < numThreads; i++) {
        threads[i] = new Thread(wrongAnswer::incrementToOnHundred);
        threads[i].start();
    }

    for (int i = 0; i < numThreads; i++) {
        threads[i].join();
    }

    assertEquals(10_000, numThreads, wrongAnswer.getCounter());
   }
}
