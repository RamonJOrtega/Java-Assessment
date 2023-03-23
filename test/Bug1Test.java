package test;

import org.junit.jupiter.api.Test;

import com.moesol.hr.bugs.Bug1;

import static org.junit.jupiter.api.Assertions.assertNull;

public class Bug1Test {
    @Test
    public void testDefaultRating() {
        Bug1 bug1 = new Bug1();
        Integer rating = bug1.rating();
        assertNull(rating, "Expected default rating to be null");
    }

   
    
}
