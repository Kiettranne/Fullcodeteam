package baitaplon;
import java.util.Scanner;


 class project {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap gioi tinh (Nam/Nu): ");
        String gioiTinh = scanner.nextLine();
        boolean isMale = gioiTinh.equalsIgnoreCase("Nam");

        if (isMale) {
            System.out.println("Anh");
        } else {
            System.out.println("Chi");
        }

        scanner.close();
    }
}

