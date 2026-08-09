class Solution {
    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;
        int left = 0, right = nums.length - 1;
        Random random = new Random();
        
        while (left <= right) {
            int pivotIndex = left + random.nextInt(right - left + 1);
            int pivot = nums[pivotIndex];
            
            int lt = left, i = left, gt = right;
            while (i <= gt) {
                if (nums[i] < pivot) {
                    swap(nums, lt++, i++);
                } else if (nums[i] > pivot) {
                    swap(nums, i, gt--);
                } else {
                    i++;
                }
            }

            if (target >= lt && target <= gt) {
                return nums[target];
            } else if (target < lt) {
                right = lt - 1;
            } else {
                left = gt + 1;
            }
        }
        
        return -1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}