// Java implementation of the above approach
import java.util.ArrayList;
import java.util.Arrays;

class GFG{

    static class Pair<K, V>
    {
        K first;
        V second;

        public Pair(K first, V second)
        {
            this.first = first;
            this.second = second;
        }
    }

    static int inf = 100000000;

    // Function to find the smallest path
// with exactly K edges
    static int smPath(int s, int d,
                      ArrayList<Pair<Pair<Integer, Integer>, Integer>> ed,
                      int n, int k)
    {

        // Array to store dp
        int[] dis = new int[n + 1];

        // Initialising the array
        Arrays.fill(dis, inf);
        dis[s] = 0;

        // Loop to solve DP
        for(int i = 0; i < k; i++)
        {

            // Initialising next state
            int[] dis1 = new int[n + 1];
            Arrays.fill(dis1, inf);

            // Recurrence relation
            for(Pair<Pair<Integer, Integer>, Integer> it : ed)
                dis1[it.first.second] = Math.min(dis1[it.first.second],
                        dis[it.first.first] +
                                it.second);
            for(int j = 0; j <= n; j++)
                dis[j] = dis1[j];
        }

        // Returning final answer
        if (dis[d] == inf)
            return -1;
        else
            return dis[d];
    }

    // Driver code
    public static void maining (ArrayList<Pair<Pair<Integer, Integer>, Integer>> ed,int n,int d,int k)
    {


        // Calling the function
        System.out.println(smPath(0, d, ed, n, 2));
    }
}

// This code is contributed by sanjeev2552
