package personalsoft;

public class KUniqueCharacters {
    public static void main(String[] args) {
        String str = "3aabacbebebe";
        //String newStr = str.replaceAll("\\s+","");  //to remove spaces
        char c = str.charAt(0);

        int k = Integer.parseInt(String.valueOf(c));
        String newStr = str.substring(1);

        String[] aux = new String[str.length()];
        char[] charArray = newStr.toCharArray();
        int count = 0;

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < newStr.length() - 1; i++) {
            char current = charArray[i];

            if (current == charArray[i + 1]) {
                count++;
                System.out.println(count);
            } else if(current != charArray[i + 1]){

            }

            if (count == 1) {
                System.out.println("here 2 ");
                stringBuilder.append(current);
                System.out.println(current);
                System.out.println(charArray[i + 1]);
                stringBuilder.append(charArray[i + 1]);
                count = 0;
            }

        }
        System.out.println(stringBuilder);

    }
}
