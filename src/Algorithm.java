public class Algorithm {

    private Vertex[][] g;
    private int[][] lowest;

    public void test() {
        int k = 5;
        getGraph(k);

        lowest[1][0] = lowest[0][0] + g[0][0].up;
        for (int i = 1; i < k; i++) {
            lowest[0][i] = lowest[0][i - 1] + g[0][i - 1].right;
            lowest[1][i] = lowest[0][i] + g[0][i].up;
        }

        for (int i = 1; i < k - 1; i++) {
            for (int j = 1; j < k; j++) {
                lowest[i][j] = Math.min(lowest[i][j - 1] + g[i][j - 1].right, lowest[i][j]);
            }
            for (int j = k - 2; j >= 0; j--) {
                lowest[i + 1][k - 1] = lowest[i][k - 1] + g[i][k - 1].up;
                lowest[i][j] = Math.min(lowest[i][j + 1] + g[i][j + 1].left, lowest[i][j]);
                lowest[i + 1][j] = lowest[i][j] + g[i][j].up;
            }
        }
    }

    public void getGraph(int k) {
        g = new Vertex[k][k];
        lowest = new int[k][k];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                g[i][j] = new Vertex(11);
            }
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                lowest[i][j] = Integer.MAX_VALUE;
            }
        }
        lowest[0][0] = 0;
    }
}
