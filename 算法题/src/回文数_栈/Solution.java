package 回文数_栈;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
  public static void main(String[] args) {
    int n = 0;
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    System.out.println(isPalindrome(n));
  }

  public static boolean isPalindrome(int x) {
    String s = Integer.toString(x);
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      Character character = s.charAt(i);
      stack.push(character);
    }
    for (int i = 0; i < s.length(); i++) {
      if (stack.pop() != s.charAt(i)) {
        return false;
      }
    }
    return true;
  }
}
