import java.util.Random;

public class Vertex {
    int up;
    int left;
    int right;


    public Vertex(int n) {
        Random rand = new Random();
        up = rand.nextInt(n);
        left = rand.nextInt(n);
        right = rand.nextInt(n);
    }
}
