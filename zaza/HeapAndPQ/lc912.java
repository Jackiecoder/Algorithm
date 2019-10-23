package HeapAndPQ;

public class lc912 {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            adjust(nums, i, nums.length);
        }
        for(int j = nums.length - 1; j > 0; j--){
            swap(nums, 0, j);
            adjust(nums, 0, j);
        }

        return nums;
    }

    private void adjust(int[] nums, int i, int n) {
        int temp = nums[i];
        for (int k = i*2 + 1; k < n; k = k*2+1) {
            if (k + 1 < n && nums[k+1] > nums[k]) {
                k++;
            }
            if (nums[k] > temp) {
                nums[i] = nums[k];
                i = k;
            } else{
                break;
            }
        }
        nums[i] = temp;
    }

    public void swap(int []arr, int a ,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
