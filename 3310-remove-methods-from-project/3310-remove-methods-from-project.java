import java.util.*;

class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        for (int[] e : invocations) g.get(e[0]).add(e[1]);

        boolean[] sus = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(k);
        sus[k] = true;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : g.get(u)) {
                if (!sus[v]) {
                    sus[v] = true;
                    q.offer(v);
                }
            }
        }
        for (int[] e : invocations) {
            if (!sus[e[0]] && sus[e[1]]) {
                List<Integer> res = new ArrayList<>();
                for (int i = 0; i < n; i++) res.add(i);
                return res;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!sus[i]) res.add(i);
        }
        return res;
    }
}