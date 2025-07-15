
public class CountingSortStudentAges {
    public static void main(String[] args) {
        int[] ages = {12, 14, 11, 13, 10, 12, 13, 11, 10};
        int max = 18;
        int min = 10;
        countingSort(ages, min, max);
        System.out.println("Sorted Student Ages:");
        for (int age : ages) {
            System.out.print(age + " ");
        }
    }

    static void countingSort(int[] arr, int min, int max) {
        int range = max - min + 1;
        int[] count = new int[range];
        for (int age : arr) count[age - min]++;

        int index = 0;
        for (int i = 0; i < range; i++) {
            while (count[i]-- > 0) {
                arr[index++] = i + min;
            }
        }
    }
}
