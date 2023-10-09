package ra03;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QueueAndLinkedList {
    public static Scanner sc=new Scanner(System.in);
    public static Queue<String> queues=new LinkedList<String>();
    public static void main(String[] args) {

        do {
            System.out.println("********************JAVA-HACKATHON-05-ADVANCE-3-MENU********************\n" +
                    "1. Nhập tên phụ huynh nộp hồ sơ \n" +
                    "2. Phụ huynh tiếp theo \n" +
                    "3. Thoát \n");
            System.out.println("Mời nhập lựa chọn!!!");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    addName();
                    break;
                case 2:
                    getNextParent();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Xin mời chọn lại");
            }
        } while (true);
    }

    public static void addName(){
        System.out.println("Nhập tên phụ huynh muốn thêm");
        String name=sc.nextLine();
        queues.offer(name);
        System.out.println("Danh sách tên phụ huynh");
        for (String q:queues
             ) {
            System.out.printf(q+", ");
        }
        System.out.println();
    }
    public static void getNextParent() {
        if (!queues.isEmpty()) {
            String nextParent = queues.poll();
            System.out.println("Phụ huynh tiếp theo: " + nextParent);
        } else {
            System.out.println("Không có phụ huynh trong danh sách.");
        }
    }
}
