class Solution {
    public List<Integer> busiestServers(int k, int[] a, int[] l) {
        TreeSet<Integer> s = new TreeSet<>();
        for (int i = 0; i < k; i++) s.add(i);
        
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
        int[] c = new int[k];
        int m = 0;
        
        for (int i = 0; i < a.length; i++) {
            int t = a[i], e = t + l[i];
            
            while (!q.isEmpty() && q.peek()[0] <= t) {
                s.add(q.poll()[1]);
            }
            
            if (s.isEmpty()) continue;
            
            Integer n = s.ceiling(i % k);
            if (n == null) n = s.first();
            
            s.remove(n);
            q.offer(new int[]{e, n});
            c[n]++;
            m = Math.max(m, c[n]);
        }
        
        List<Integer> r = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (c[i] == m) r.add(i);
        }
        
        return r;
    }
}