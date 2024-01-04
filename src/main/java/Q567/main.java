package Q567;

import java.util.HashMap;
import java.util.Map;

public class main {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        Solution solution = new Solution();
        System.out.println(solution.checkInclusion(s1, s2));
    }
}

class Solution {
    /**
     * 判断 s2 是否包含 s1 的排列
     * @param s1 字符串
     * @param s2 字符串
     * @return true or false
     */
    public boolean checkInclusion(String s1, String s2) {
        // 用于记录需要的字符和窗口中的字符及其出现的次数
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        // 统计字符出现的次数
        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;//窗口中满足需要的字符个数
        while (right < s2.length()) {
            // c是即将移入窗口的字符
            char c = s2.charAt(right);
            // 扩大窗口；
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0)+ 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++; // 只有window[c] 和 need[c] 对应的出现次数一致时，次数才会加一
                }
            }
            // 判断左侧窗口是否需要收缩
            while (right - left >= s1.length()) {
                // 更新最小覆盖子串
                if (valid == need.size()) {
                    return true;
                }
                // d是将移出的字符
                char d = s2.charAt(left);
                // 缩小窗口
                left++;
                // 进行窗口内数据的一些列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;// 减少valid，跳出循环继续增大窗口
                    }
                    window.put(d, window.get(d) - 1);// 更新对应的字符数量
                }
            }
        }
        // 未找到符合条件的子串
        return false;
    }
}
