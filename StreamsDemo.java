import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsDemo {
    public static void main(String[] args) {
        ArrayList<Integer> l = new ArrayList<Integer>();
        l.add(0);
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);

        // Without Streams
        List<Integer> l1 = new ArrayList<Integer>();
        for (Integer I1 : l) {
            if (I1 % 2 == 0) {
                l1.add(I1);
            }
        }

        // with streams
        List<Integer> l2 = l.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        System.out.println(l2);
    }

}

