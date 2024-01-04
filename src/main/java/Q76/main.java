package Q76;

import java.util.HashMap;
import java.util.Map;

public class main {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        Solution solution = new Solution();
        System.out.println(solution.minWindow(s, t));
    }
}

class Solution {
    /**
     * 求字符串 s 中包含字符串 t 所有字符的最小子串
     * @param s 源字符串
     * @param t 目标字符串
     * @return 满足条件的最小子串
     */
    public String minWindow(String s, String t) {
        // 用于记录需要的字符和窗口中的字符及其出现的次数
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        // 统计字符出现的次数
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;//窗口中满足需要的字符个数
        // 记录最小覆盖子串的起始索引及长度
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            // c是即将移入窗口的字符
            char c = s.charAt(right);
            // 扩大窗口；
            right++;
            // 进行窗口内数据的一些列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0)+ 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++; // 只有window[c] 和 need[c] 对应的出现次数一致时，次数才会加一
                }
            }
            // 判断左侧窗口是否需要收缩
            while (valid == need.size()) {
                // 更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // d是将移出的字符
                char d = s.charAt(left);
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
        // 返回最小覆盖子串
        return len == Integer.MAX_VALUE ?
                "" : s.substring(start, start + len);
    }
}
