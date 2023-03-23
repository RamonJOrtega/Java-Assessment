package src;
import java.util.List;
import java.util.stream.Collectors;

public class ExampleSolution {
    public List<Integer> removeBigNumbers(List<Integer> data) {
        return data.stream()
            .filter(i -> i <= 10)
            .collect(Collectors.toList());
    }
}
