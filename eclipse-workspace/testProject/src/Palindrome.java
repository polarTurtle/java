public class Palindrome {
    public static boolean isPalindrome(String word) {
		word = word.toLowerCase();
		int frontCount = 0;
		int backCount = word.length() - 1;
		while (backCount > frontCount) {
			if (word.charAt(backCount) != word.charAt(frontCount))
				return false;
			frontCount++;
			backCount--;
		}

		return true;
    }
    
    public static void main(String[] args) {
        System.out.println(Palindrome.isPalindrome("Deleveled"));
    }
}