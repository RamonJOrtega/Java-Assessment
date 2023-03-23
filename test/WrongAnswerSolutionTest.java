package test;

import org.junit.jupiter.api.Test;

import src.WrongAnswerSolution;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;



public class WrongAnswerSolutionTest {
    private WrongAnswerSolution wrongAnswerSolution;

    @BeforeEach
    public void setUp() {
          wrongAnswerSolution = new WrongAnswerSolution();
    }

    @Test
    public void testCounterWithSingleThread() throws InterruptedException {
        wrongAnswerSolution.incrementToOnHundred();
        assertEquals(10_000, wrongAnswerSolution.getCounter());
    }
    @Test
    public void testCounterWithTwoThreads() throws InterruptedException {
        Thread t1 = new Thread(wrongAnswerSolution::incrementToOnHundred);
        Thread t2 = new Thread(wrongAnswerSolution::incrementToOnHundred);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        
        assertEquals(20_000, wrongAnswerSolution.getCounter());
    }

    @Test
    public void testCounterWithMultipleTrehads() throws InterruptedException {
    int numThreads = 5;
    Thread[] threads = new Thread[numThreads];

    for (int i = 0; i < numThreads; i++) {
        threads[i] = new Thread(wrongAnswerSolution::incrementToOnHundred);
        threads[i].start();
    }

    for (int i = 0; i < numThreads; i++) {
        threads[i].join();
    }

    assertEquals(10_000, numThreads, wrongAnswerSolution.getCounter());
   }
}
