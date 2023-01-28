package algoritms.com.erick.algoritms.algorithms;

public class BinarySearch {
    public static void main(String[] args) {
        int[] myArray = {2, 4, 6, 7};
        System.out.println(binSearch(myArray, 6));
        String hola = "5";
        hola.getBytes();
        Integer.parseInt(String.valueOf(hola.charAt(1)));
    }

    public static int binSearch(int[] list, int target) {
        int left = 0;
        int right = list.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (target < list[middle]) {
                right = middle - 1;
            } else if (target > list[middle]) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
