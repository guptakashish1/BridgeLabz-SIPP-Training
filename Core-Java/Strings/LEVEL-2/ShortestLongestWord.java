import java.util.Scanner;

public class ShortestLongestWord {

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

    public static String[][] getWordLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(getLength(words[i]));
        }
        return result;
    }

    public static int[] findShortestAndLongest(String[][] wordLengths) {
        int minLength = Integer.parseInt(wordLengths[0][1]);
        int maxLength = Integer.parseInt(wordLengths[0][1]);
        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 1; i < wordLengths.length; i++) {
            int len = Integer.parseInt(wordLengths[i][1]);
            if (len < minLength) {
                minLength = len;
                minIndex = i;
            }
            if (len > maxLength) {
                maxLength = len;
                maxIndex = i;
            }
        }

        return new int[]{minIndex, maxIndex};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String[] words = customSplit(input);
        String[][] wordLengths = getWordLengths(words);
        int[] result = findShortestAndLongest(wordLengths);

        System.out.println("Shortest Word: " + wordLengths[result[0]][0]);
        System.out.println("Longest Word: " + wordLengths[result[1]][0]);
        sc.close();
    }
}
