package test;

import org.junit.jupiter.api.Test;

import src.Example;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class ExampleTest {
    private Example example;

    @BeforeEach
    public void setUp() {
        example = new Example();
    }

    @Test
    public void testRemoveBigNumbers() {
        List<Integer> input = Arrays.asList(1, 5, 11, 8, 15, 3);
        List<Integer> expectedOutput = Arrays.asList(1, 5, 8, 3);

        List<Integer> result = example.removeBigNumbers(input);
        assertEquals(expectedOutput, result);
    }

    @Test
    public void testRemoveBigNumbersEmptyList() {
        List<Integer> input = Arrays.asList();
        List<Integer> expectedOutput = Arrays.asList();

        List<Integer> result = example.removeBigNumbers(input);
        assertEquals(expectedOutput, result);
    }

    @Test
    public void testRemoveBigNumbersAllBig() {
        List<Integer> input = Arrays.asList(11, 20, 25, 15);
        List<Integer> expectedOutput = Arrays.asList();

        List<Integer> result = example.removeBigNumbers(input);
        assertEquals(expectedOutput, result);
    }

    @Test
    public void testRemoveBigNumbersAllSmall() {
        List<Integer> input = Arrays.asList(1, 5, 8, 3);
        List<Integer> expectedOutput = Arrays.asList(1, 5, 8, 3);

        List<Integer> result = example.removeBigNumbers(input);
        assertEquals(expectedOutput, result);
    }
}