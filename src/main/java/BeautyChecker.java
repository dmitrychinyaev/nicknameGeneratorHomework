public class BeautyChecker {

    public boolean isPalindrome(String text) {
        String reversed = new StringBuilder(text).reverse().toString();
        return text.equals(reversed);
    }

    public boolean isOneLetter(String text) {
        int count = 0;
        char[] textChar = text.toCharArray();
        for (int i = 1; i < textChar.length; i++) {
            if (textChar[0]!=textChar[i]){
                count ++;
            }
        }
        return count==0;
    }

    public boolean isOrderCorrect(String text){
        int count = 0;
        char[] textChar = text.toCharArray();
        for (int i = 0; i < textChar.length - 1; i++) {
            if(textChar[i]>textChar[i+1]){
                count++;
                break;
            }
        }
        return count==0;
    }


}
