package Q438;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> list = solution.findAnagrams(s,p);
        System.out.println(list);
    }
}

class Solution {
    /**
     * 找到字符串中所有字母的异位词（由相同字母重排列生成的字符串）
     * @param s 源字符串
     * @param p 目标字符串
     * @return 返回子串的起始索引
     */
    public List<Integer> findAnagrams(String s, String p) {
        // 用于记录需要的字符和窗口的字符
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        // 统计need中字符出现的次数
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        // 初始化窗口边界[left,right), 结果列表, valid: window扩大
        int left = 0, right = 0, valid = 0;
        List<Integer> ans = new ArrayList<>();
        while(right < s.length()) {
            // 即将要移入窗口的字符
            char c = s.charAt(right);
            // 扩大窗口
            right++;
            // 窗口内的操作
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            // 减少窗口大小
            while (right - left >= p.length()) {
                // 当窗口满足条件，将left加入ans
                if (valid == need.size()) {
                    ans.add(left);
                }
                // 即将移出的字符
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return ans;
    }
}
