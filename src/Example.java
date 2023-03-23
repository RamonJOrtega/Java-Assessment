package src;
import java.util.List;

public class Example {
    public List<Integer> removeBigNumbers(List<Integer> data) {
        for (Integer i : data) {
            if (i > 10) {
                data.remove(i);
            }
        }
        return data;
    }
}
