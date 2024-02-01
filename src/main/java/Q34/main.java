package Q34;

public class main {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        Solution solution = new Solution();
        System.out.println(solution.searchRange(nums, 8)[0]);
        System.out.println(solution.searchRange(nums, 8)[1]);
    }
}

class Solution {
    /**
     * 二分返回左右边界
     * @param nums ：给定数组
     * @param target ： 目标值
     * @return 左右边界
     */
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        int left = 0, right = nums.length - 1; // 搜索区间 [left,right]
        res[0] = left_bound(nums, target, left, right);
        res[1] = right_bound(nums, target, left, right);
        return res;
    }

    /**
     * 返回左边界
     * @param nums
     * @param target
     * @return
     */
    private int left_bound(int[] nums, int target, int left, int right) {
        int left_bound_value = -1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                right = mid -1; // 收缩右边界
            }
        }
        // 判断是否存在
        if (left < 0 || left > nums.length - 1) return -1;
        left_bound_value = nums[left] == target ? left : -1;
        return left_bound_value;
    }

    /**
     * 返回右边界
     * @param nums
     * @param target
     * @return
     */
    private int right_bound(int[] nums, int target, int left, int right) {
        int right_bound_value = -1;

        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                left = mid + 1; // 收缩左边界
            }
        }
        // 判断是否存在
        if (right < 0 || right > nums.length - 1) return -1;
        right_bound_value = nums[right] == target ? right : -1;
        return right_bound_value;
    }
}