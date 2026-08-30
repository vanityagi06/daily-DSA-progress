class SnapshotArray {
    private List<int[]>[][] history;
    private List<int[]>[] arr;
    private int id = 0;

    public SnapshotArray(int length) {
        arr = new List[length];
        for (int i = 0; i < length; i++) {
            arr[i] = new ArrayList<>();
            arr[i].add(new int[]{0, 0});
        }
    }
    
    public void set(int index, int val) {
        List<int[]> list = arr[index];
        if (list.get(list.size() - 1)[0] == id) {
            list.get(list.size() - 1)[1] = val;
        } else {
            list.add(new int[]{id, val});
        }
    }
    
    public int snap() {
        return id++;
    }
    
    public int get(int index, int snap_id) {
        List<int[]> list = arr[index];
        int l = 0, r = list.size() - 1;
        int res = 0;
        
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (list.get(m)[0] <= snap_id) {
                res = list.get(m)[1];
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return res;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */