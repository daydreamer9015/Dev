package scanner;

import java.util.Scanner;

public class ScannerLab4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.print("문자열을 입력하세요(exit: 종료):");
            String str = scanner.nextLine(); // 한 줄 전체 입력 받기

            System.out.println("입력한 문자열: " + str);

            if (str.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                System.out.println("\nProcess finished with exit code O");
                break;
            }
        }
        scanner.close();
    }
}