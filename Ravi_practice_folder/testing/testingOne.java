public class testingOne {

    public static void main(String[] args) {
        System.out.println(isPalindrome("...s..."));
    }

    public static boolean isPalindrome(String s) {
        String strOne = "";
        String strTwo = "";
        int i = 0;
        int j = s.length() - 1;
        boolean stra = false;
        boolean strb = true;
        while (i < j) {
            if (isCharacter(s, i) && stra == false && strb == true) {
                if (Character.isUpperCase(s.charAt(i))) {
                    strOne = strOne + Character.toLowerCase(s.charAt(i));
                } else {
                    strOne = strOne + s.charAt(i);
                }
                stra = true;
                strb = false;
                i++;
            }
            if (isCharacter(s, j) && strb == false && stra == true) {
                if (Character.isUpperCase(s.charAt(j))) {
                    strTwo = strTwo + Character.toLowerCase(s.charAt(j));
                } else {
                    strTwo = strTwo + s.charAt(j);
                }
                strb = true;
                stra = false;
                j--;
            }
            if (isCharacter(s, i) == false && stra == false && strb == true) {
                i++;
            }
            if (isCharacter(s, j) == false && strb == false && stra == true) {
                j--;
            }

        }
        System.out.println(strOne);
        System.out.println(strTwo);
        if (strOne.equals(strTwo) || strTwo.equals("")) {
            return true;
        }
        return false;

    }

    public static boolean isCharacter(String s, int i) {
        if ((s.charAt(i) >= 97 && s.charAt(i) <= 122) || (s.charAt(i) >= 65 && s.charAt(i) <= 90)) {
            return true;
        }
        return false;
    }
}
