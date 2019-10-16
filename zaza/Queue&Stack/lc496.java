package QueueAndStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class lc496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Map<Integer, Integer> nextGreater = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            int cur = nums2[i];
            while (st.size() > 0 && cur > st.peek()) {
                nextGreater.put(st.pop(), cur);
            }
            st.push(cur);
        }
        while (st.size() > 0) {
            nextGreater.put(st.pop(), -1);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = nextGreater.get(nums1[i]);
        }

        return res;
    }
}
