package Q3;

import java.util.HashMap;
import java.util.Map;

public class main {
    public static void main(String[] args) {
        String s = "abcabcbb";
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring(s));
    }
}

class Solution {
    /**
     * 给定一个字符串s，找出其中不含有重复字符的最长子串的长度
     * @param s：给定字符串
     * @return 最长子串的长度
     */
    public int lengthOfLongestSubstring(String s) {
        // 定义窗口
        Map<Character, Integer> window = new HashMap<>();

        // 定义窗口边界[left, right)
        int left = 0, right = 0;
        int res = 0, tmp = 0;
        while (right < s.length()) {
            // 窗口右边界扩大
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            // 当window中的值大于1时，说明又重复的了，这个时候需要将left收缩到right的位置
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                window.put(d, window.get(d) - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
