class TimeMap {
    private Map<String, List<Pair>> m;

    private static class Pair {
        int t;
        String v;

        Pair(int t, String v) {
            this.t = t;
            this.v = v;
        }
    }

    public TimeMap() {
        m = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        m.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!m.containsKey(key)) return "";
        
        List<Pair> list = m.get(key);
        int l = 0, r = list.size() - 1;
        String res = "";
        
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid).t <= timestamp) {
                res = list.get(mid).v;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        
        return res;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */