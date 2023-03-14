public class OddNumber {
    public static void main(String[] args) {
        System.out.println(oddNumber("Hacker"));
        System.out.println(oddNumber("Rank"));
    }
    private static String oddNumber(String word) {
        var even = new StringBuilder();
        var odd = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            if (i % 2 == 0) even.append(word.charAt(i));
            else odd.append(word.charAt(i));
        }
        return even.append(" ").append(odd).toString();
    }
}
