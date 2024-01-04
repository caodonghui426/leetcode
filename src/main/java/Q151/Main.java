package Q151;

public class Main {
    public static void main(String[] args) {
        String s = "  hello world  ";
        Solution solution = new Solution();
        String ans = solution.reverseWords(s);
        System.out.println(ans);
    }
}
class Solution {
    public String reverseWords(String s) {
        String[] values = s.split(" ");
        String ans = "";
        for (int i = 0; i < values.length; i++) {
            if (ans.length() == 0) {
                if (values[i].length() > 0) {
                    ans = values[i];
                }
            } else {
                if (values[i].length() > 0) {
                    ans = values[i] + " " + ans;
                }
            }
        }
        return ans;
    }
}