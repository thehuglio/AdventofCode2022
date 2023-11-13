//part 1
public class Main {

    private static final Reader reader = new Reader(new File("data.txt"));
    private static int x = 1,totalcycle = 0,total = 0;
    private static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        System.out.println(reader.data);
        List<Integer> onrunningcycles = new LinkedList<>();
        for (int i = 0; i < (reader.data.size()*2); i += 40) {
            onrunningcycles.add(i);
        }
        for (String s : reader.data) {
            totalcycle++;
            if () {
                addition();
            }
            if (!s.equals("noop")) {
                int add = Integer.parseInt(s.split(" ")[1]);
                totalcycle++;
                if (onrunningcycles.contains(totalcycle)) {
                    addition();
                }
                x += add;
            }
        }
        System.out.println(total);
    }
    private static void addition() {
        total += x * totalcycle
    }
}
