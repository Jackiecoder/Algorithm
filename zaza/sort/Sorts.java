import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

public class Sorts {
    public static void main(String[] args){
        Random random = new Random();
        int[] unSort = new int[10000];
        for(int i=0; i<unSort.length; i++){
            unSort[i] = random.nextInt(10000);
        }
        System.out.println("bubble sort:");
        bubble_sort(unSort.clone());
        System.out.println("select sort:");
        select_sort(unSort.clone());
        System.out.println("insert sort:");
        insert_sort(unSort.clone());
        System.out.println("shell sort:");
        shell_sort(unSort.clone());
        System.out.println("merge sort: (recursive)");
        merge_sort(unSort.clone());
        System.out.println("merge sort: (iterative)");
        merge_sort2(unSort.clone());
        System.out.println("quick sort: (recursive)");
        quick_sort(unSort.clone());
        System.out.println("quick sort: (iterative)");
        quick_sort2(unSort.clone());
        System.out.println("heap sort:");
        heap_sort(unSort.clone());
        System.out.println("counting sort:");
        counting_sort(unSort.clone());
        System.out.println("bucket sort:");
        bucket_sort(unSort.clone());
        System.out.println("radix sort:");
        radix_sort(unSort.clone());
    }

    private static boolean checkOrder(int[] nums){
        for(int i=1; i<nums.length; i++){
            if(nums[i] >= nums[i-1])
                continue;
            else {
                System.out.println(i);
                return false;
            }
        }
        return true;
    }

    //O(n^2), O(1)
    private static void bubble_sort(int[] nums){
        for(int i=0; i<nums.length-1; i++){
            for(int j=0; j<nums.length-i-1; j++){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        System.out.println(checkOrder(nums));
    }

    // O(n^2), O(1)
    // less switch than bubble sort
    private static void select_sort(int[] nums){
        for(int i=0; i<nums.length; i++){
            int minIndex = i;
            for(int j=i; j<nums.length; j++){
                if(nums[minIndex] > nums[j])
                    minIndex = j;
            }
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
        System.out.println(checkOrder(nums));
    }

    // O(n^2), O(1)
    private static void insert_sort(int[] nums){
        for(int i=1; i<nums.length; i++) {
            for(int j=i; j>0; j--){
                if(nums[j] < nums[j-1]){
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }
                else break;
            }
        }
        System.out.println(checkOrder(nums));
    }

    // O(n^1.3)
    private static void shell_sort(int[] nums){
        for(int gap=(nums.length/2); gap>=1; gap=(gap/2)){
            for(int i=gap; i<nums.length; i++){
                for(int j=i; j>=gap; j=j-gap){
                    if(nums[j-gap] > nums[j]){
                        int temp = nums[j];
                        nums[j] = nums[j-gap];
                        nums[j-gap] = temp;
                    }
                    else break;
                }
            }
        }
        System.out.println(checkOrder(nums));
    }

    // O(nlogn), O(n),  stable
    // recursive
    private static void merge_sort(int[] nums){
        mSort(nums, 0, nums.length-1);
        System.out.println(checkOrder(nums));
    }
    private static void mSort(int[] nums, int start, int end){
        if(start >= end)
            return;
        int mid = (start+end)/2;
        mSort(nums, start, mid);
        mSort(nums, mid+1, end);
        merge(nums, start, mid+1, end);
    }
    private static void merge(int[] nums, int start1, int start2, int end2){
        int[] temp = new int[end2 - start1 + 1];
        int end1 = start2 - 1;
        int index = 0;
        int s = start1;
        while(start1 <= end1 && start2 <= end2){
            if(nums[start1] > nums[start2]){
                temp[index++] = nums[start2++];
            }
            else{
                temp[index++] = nums[start1++];
            }
        }

        while(start1 <= end1){
            temp[index++] = nums[start1++];
        }
        while(start2 <= end2){
            temp[index++] = nums[start2++];
        }
        for(int t: temp){
            nums[s++] = t;
        }
    }

    // O(nlogn), O(n),  stable
    // iterative
    private static void merge_sort2(int[] nums){
        for(int step=1; step <= nums.length; step=(step*2)) {
            int mRange = step*2;
            for(int i=0; i<nums.length; i=i+mRange){
                merge(nums, i, Math.min(i+step, nums.length-1), Math.min(i+mRange-1, nums.length-1));
            }
        }
        System.out.println(checkOrder(nums));
    }

    // O(nlogn), O(logn),  unstable
    // recursive
    private static void quick_sort(int[] nums){
        qSort(nums, 0, nums.length-1);
        System.out.println(checkOrder(nums));
    }
    private static void qSort(int[] nums, int start, int end){
        if(start >= end)
            return;
        int i = start;
        int j = end;
        int target = nums[start];   // can be the media-of-three (start,mid,end)
        while(i < j){
            while(i < j && nums[j] >= target){
                j--;
            }
            nums[i] = nums[j];
            while(i < j && nums[i] <= target){
                i++;
            }
            nums[j] = nums[i];
        }
        nums[j] = target;
        qSort(nums, start, j-1);
        qSort(nums, j+1, end);
    }

    // O(nlogn), O(logn),  unstable
    // iterative
    private static void quick_sort2(int[] nums){
        Stack<Integer> s = new Stack<>();
        s.push(nums.length -1);
        s.push(0);
        while(!s.empty()){
            int start = s.pop();
            int end = s.pop();
            int target = nums[start];
            int i = start;
            int j = end;
            while(i < j){
                while(i < j && nums[j] >= target){
                    j--;
                }
                nums[i] = nums[j];
                while(i < j && nums[i] <= target){
                    i++;
                }
                nums[j] = nums[i];
            }
            nums[j] = target;
            if(j+1 < end){
                s.push(end);
                s.push(j+1);
            }
            if(start < j-1){
                s.push(j-1);
                s.push(start);
            }
        }
        System.out.println(checkOrder(nums));
    }

    private static void heap_sort(int[] nums){
        for(int i = ((nums.length-1)/2-1); i>=0; i--){
            HeapAdjust(nums, i, nums.length-1);
        }

        for(int i = nums.length-1; i>0; i--){
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            HeapAdjust(nums, 0, i);
        }

        System.out.println(checkOrder(nums));
    }
    private static void HeapAdjust(int[] nums, int i, int n){
        int temp = nums[i];
        for(int j = (2*i+1); j<n; j=(j*2+1) ){
            if(j<n-1 && nums[j] < nums[j+1]){
                j++;
            }
            if(temp >= nums[j]){
                break;
            }
            nums[i] = nums[j];
            i = j;
        }
        nums[i] = temp;
    }

    private static void counting_sort(int[] nums){
        int min = nums[0];
        int max = nums[0];
        for(int i=0; i<nums.length; i++){
            min=Math.min(nums[i], min);
            max=Math.max(nums[i], max);
        }
        int[] arr = new int[max - min +1];
        for(int i=0; i<nums.length; i++){
            arr[nums[i] - min]++;
        }
        int index = 0;
        for(int i = 0; i < arr.length; i++){
            while(arr[i]>0){
                nums[index++] = min + i;
                arr[i]--;
            }
        }
        System.out.println(checkOrder(nums));
    }
    // 找中位数用， bucket里用insert_sort
    private static void bucket_sort(int[] nums){

        System.out.println(checkOrder(nums));
    }

    // 按位数从小到大排序
    private static void radix_sort(int[] nums){

        System.out.println(checkOrder(nums));
    }
}
