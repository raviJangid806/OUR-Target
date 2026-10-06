import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Leetcode {
    public static void main(String[] args) {
        Leetcode l = new Leetcode();
        int[] arr = { 0, 1, 0 };
        System.out.println(l.peakIndexInMountainArray(arr));

    }

    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int max = arr[0];
        int index = 0;
        while (left < right) {

            if (arr[left] > max) {
                max = arr[left];
                index = left;
            }
            left++;
            if (arr[right] > max) {
                max = arr[right];
                index = right;
            }
            right--;
        }
        return index;
    }

    public int compress(char[] chars) {
        if (chars.length == 1) {
            return 1;
        }
        List<Integer> arr = new ArrayList<>(Collections.nCopies(26, 0));
        for (int i = 0; i < chars.length; i++) {
            arr.set(chars[i] - 97, arr.get(chars[i] - 97) + 1);

        }
        String str = "";
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (arr.get(i) > 0) {
                if (arr.get(i) == 1) {
                    count = count + 1;

                } else {
                    count = count + checkNumberOfDigit(arr.get(i)) + 1;
                }
                char c = (char) (i + 97);
                str = str + c;
                str = str + count;
                count = 0;
            }
        }
        System.out.println(str);

        for (int i = 0; i < str.length(); i++) {
            chars[i] = str.charAt(i);
        }
        System.out.println(chars);
        return count;

    }

    public int checkNumberOfDigit(int n) {
        int count = 0;
        while (n > 0) {
            n = n / 10;
            count++;
        }
        return count;
    }
}