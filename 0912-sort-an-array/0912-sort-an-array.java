class Solution {
    public int[] sortArray(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        mergeSort(nums, l, r);
        return nums;
    }

    public void mergeSort(int[] arr, int l, int r){
        if(l < r){
            int m = (l+r)/2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            merge(arr, l, r, m);
        }
    }

    public void merge(int[] arr, int l, int r, int m){
        int n1 = m + 1 - l;
        int n2 = r - m;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for(int i = 0; i < n1; i++){
            left[i] = arr[l + i];
        }
        for(int j = 0; j < n2; j++){
            right[j] = arr[m + 1 + j];
        }
        int i = 0, j = 0, k = l;

        while(i < n1 && j < n2)
        {
            if(left[i] <= right[j]){
                arr[k] = left[i];
                i++;
            } else{
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while(i < n1){
            arr[k] = left[i];
            i++;
            k++;
        }
        while(j < n2){
            arr[k] = right[j];
            j++;
            k++;
        }
    }
}