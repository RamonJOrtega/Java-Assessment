package test;

import org.junit.jupiter.api.Test;

import com.moesol.hr.bugs.Bug1Solution;

import static org.junit.jupiter.api.Assertions.assertNull;

public class Bug1SolutionTest {
    @Test
    public void testDefaultRating() {
        Bug1Solution bug1Solution = new Bug1Solution();
        Integer rating = bug1Solution.rating();
        assertNull(rating, "Expected default rating to be null");
    }

   
    
}
