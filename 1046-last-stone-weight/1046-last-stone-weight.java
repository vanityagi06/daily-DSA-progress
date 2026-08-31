class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int s : stones) {
            q.add(s);
        }
        while (q.size() > 1) {
            int y = q.poll();
            int x = q.poll();
            if (x != y) {
                q.add(y - x);
            }
        }
        if (q.isEmpty()) {
            return 0;
        } else {
            return q.peek();
        }
    }
}