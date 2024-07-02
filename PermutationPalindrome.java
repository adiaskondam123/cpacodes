import java.util.*; 
class PermutationPalindrome { 
    public boolean canPermutePalindrome(String s) { 
        Integer bitMask = 0; 
        for (int i = 0; i < s.length(); i++) 
            bitMask ^= 1 << (s.charAt(i) - 'a' + 1); 
            return Integer.bitCount(bitMask) <= 1; 
    } 
    public static void main(String args[]) { 
        Scanner sc = new Scanner(System.in); 
        System.out.println(new PermutationPalindrome().canPermutePalindrome(sc.next())); 
         sc.close();
} 
} 
