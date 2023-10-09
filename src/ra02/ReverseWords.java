package ra02;

import java.util.Scanner;
import java.util.Stack;

public class ReverseWords {
   public static Scanner sc=new Scanner(System.in);

   public static Stack<String> stack=new Stack<>();
    public static void main(String[] args) {

        do {
            System.out.println("********************JAVA-HACKATHON-05-ADVANCE-2-MENU********************\n" +
                    "1. Nhập câu \n" +
                    "2. Đảo ngược câu \n" +
                    "3. Thoát \n");
            System.out.println("Mời nhập lựa chọn!!!");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    inputData();
                    break;
                case 2:
                    reverseWord();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Xin mời chọn lại");
            }
        } while (true);
    }
    public static void inputData() {
        System.out.println("Nhập câu muốn đảo ngược: ");
        String sentence = sc.nextLine();
        String[] words = sentence.split(" ");
        for (String word : words) {
            stack.push(word);
        }
    }
    public static void reverseWord() {
        System.out.println("Câu sau khi đảo ngược là: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

}
