import java.util.Scanner;

public class CustomSplitCompare {

    public static int getLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (Exception e) {
            return count;
        }
    }

    public static String[] customSplit(String text) {
        int length = getLength(text);
        int spaceCount = 0;

        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') spaceCount++;
        }

        int[] spaceIndexes = new int[spaceCount + 2];
        spaceIndexes[0] = -1;
        int idx = 1;

        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[idx++] = i;
            }
        }

        spaceIndexes[spaceCount + 1] = length;
        String[] words = new String[spaceCount + 1];

        for (int i = 0; i < spaceCount + 1; i++) {
            String word = "";
            for (int j = spaceIndexes[i] + 1; j < spaceIndexes[i + 1]; j++) {
                word += text.charAt(j);
            }
            words[i] = word;
        }

        return words;
    }

    public static boolean compareArrays(String[] a, String[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String[] builtInSplit = input.split(" ");
        String[] customSplit = customSplit(input);
        boolean isSame = compareArrays(builtInSplit, customSplit);

        System.out.println("Built-in split:");
        for (String word : builtInSplit) System.out.println(word);

        System.out.println("Custom split:");
        for (String word : customSplit) System.out.println(word);

        System.out.println("Are both results same: " + isSame);
        sc.close();
    }
}
