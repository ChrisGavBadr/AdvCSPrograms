package classwork.cw4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DoubleList {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<String>(Arrays.asList("How", "are", "you", "?"));
        System.out.println("List: " + strings);

        doubleList(strings);
        System.out.println("Doubled List: " + strings);
    }

    private static void doubleList(List<String> strings) {
        int initialSize = strings.size();

        for (int i = 0; i < initialSize; i++)
            strings.add(2*i, strings.get(2*i));
    }
}
