package LeetCode;

public class LengthEncoding {
    public static void main(String[] args) {
        System.out.println(lengthEncoding("aaabbcdddd"));
    }

    private static String lengthEncoding(String s) {
        int count = 1;
        int i = 0;
        int j = i + 1;
        String ans = "";
        while (i < j && j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                count += 1;
                j++;
                continue;
            } else {
                ans += encodeString(count, s.charAt(i));
                count = 1;
                i = j;
                j = i + 1;
                if (i == j) {
                    ans += encodeString(count, s.charAt(i));
                }
            }
            ans += encodeString(count, s.charAt(i));
        }
        return ans;
    }

    private static String encodeString(int count, char a) {
        StringBuilder ans = new StringBuilder();
        for (int j = 0; j < count; j++) {
            ans.append(a);
        }
        return ans.toString();
    }
}
