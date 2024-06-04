package baitaplon;

import java.util.Scanner;

public class nhaptt { 
    String mssv;
    String hovaten;
    boolean gt;
    int ntns;
    String noisinh;
    String email;
    String sdt;
    
    public static final String Nam = "Nam";
    public static final String Nu = "Nu";
    nhaptt() {}
    public void nhaptt(String mssv, String hovaten, boolean gt, int ntns, String noisinh, String email, String sdt) {
        this.mssv = mssv;
        this.hovaten = hovaten;
        this.gt = gt;
        this.ntns = ntns;
        this.noisinh = noisinh;
        this.email = email;
        this.sdt = sdt;
    }        
    int nhaptttinhTuoi(int NamHienTai) {
        return NamHienTai - ntns;
    }
    void xuat() {
        System.out.println(mssv + "\t" + hovaten + "\t" + (gt ? Nam : Nu) + "\t" + ntns + "\t" + noisinh + "\t" + email + "\t" + sdt + "\t");
    }
}

public class khaosat {
    String option1;
    String option2;
    String option3;
    String cauhoi;

   public khaosat() {}
    khaosat(String option1, String option2, String option3, String cauhoi) {}

    void nhapcauhoi(String cauhoi) {
        this.cauhoi = cauhoi;
    }
    khaosat(String option1, String option2, String option3) {
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.cauhoi = cauhoi;
    }
  
    public void nhapcauhoi() { // thuchien khaosat
        Scanner scanner = new Scanner(System.in);
        System.out.println("Moi ban cho so luong cau hoi can dat:");
        int n = scanner.nextInt();
        scanner.nextLine();  // Đọc bỏ dòng new line sau khi nhập số
        for (int i = 1; i <= n; i++) {
            System.out.print("Cau hoi " + i + ": ");
            String cauhoi = scanner.nextLine();
            System.out.println(cauhoi);  // In câu hỏi ra để kiểm tra
        }
        scanner.close();
    }
    public void thuchienkhaosat() {
        Scanner scanner = new Scanner(System.in);
            
            System.out.println("Moi ban nhap cau tra loi:");
            System.out.print("Cau tra loi 1: ");
            String option1 = scanner.nextLine();
            System.out.println("Neu ban muon tiep tuc thi nhap 1, neu dung thi nhap 0: ");
            int v = scanner.nextInt();
            scanner.nextLine();  // Đọc bỏ dòng new line sau khi nhập số
            if (v == 1) {
                System.out.print("Cau tra loi 2: ");
                String option2 = scanner.nextLine();
                System.out.println("Neu ban muon tiep tuc thi nhap 1, neu dung thi nhap 0: ");
                int p = scanner.nextInt();
                scanner.nextLine();  // Đọc bỏ dòng new line sau khi nhập số
                if (p == 1) {
                    System.out.print("Cau tra loi 3: ");
                    String option3 = scanner.nextLine();
                    System.out.println(cauhoi);
                    System.out.println("1. " + option1);
                    System.out.println("2. " + option2);
                    System.out.println("3. " + option3);
                    System.out.print("Chon tu 1 den 3: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine();  // Đọc bỏ dòng new line sau khi nhập số
                    String answer;
                    switch (choice) {
                        case 1:
                            answer = option1;
                            break;
                        case 2:
                            answer = option2;
                            break;
                        case 3:
                            answer = option3;
                            break;
                        default:
                            answer = "Khong co su lua chon dung";
                    }
                    System.out.println("Cau tra loi cua ban la: " + answer);
                } else {
                    System.out.println("Cau tra loi cua ban la: " + option1);
                }
            } else {
                System.out.println("Cau tra loi cua ban la:  " + option1);
            }
        scanner.close();
    }
}
class Main {
		public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        khaosat ks = new khaosat();
        
        while (running) {
            System.out.println("--------------------------------");
            System.out.println("MENU:");
            System.out.println("1. Nhap thong tin sinh vien");
	    System.out.println("2.Xac nhan thong tin");
            System.out.println("3. Nhap cau hoi khac");
            System.out.println("4. Thuc hien khao sat");
            System.out.println("5. Thoat");
            System.out.println("--------------------------------");
	    int choice = scanner.nextInt();
            System.out.print("Lua chon cua ban: " + choice);
            scanner.nextLine();  // Đọc bỏ dòng new line sau khi nhập số
            switch (choice) {
                case 1:
                    // Nhập thông tin sinh viên
                    System.out.println("Ban da lua chon 1 \n ");
                    System.out.println("Ma so sinh vien:");
                    String mssv =  scanner.nextLine();
			    
                    System.out.println("Ho va ten: ");
                    String hovaten = scanner.nextLine();
			    
                    System.out.println("Gioi tinh (Nam:true ; Nu: false): ");
                    boolean gt = scanner.nextBoolean();
			    
                    if ( gt == true) {
                        System.out.println("Gioi tinh cua ban la Nam");
                    } else if (gt == false) {
                        System.out.println("Gioi tinh cua ban la Nu");
                    } else return;
			    
                    System.out.println("Nhap nam sinh: ");
                    int ntns = scanner.nextInt();
                    scanner.nextLine();
			    
                    System.out.println("Nhap noi sinh: ");
                    String noisinh = scanner.nextLine();
                    
                    System.out.println("Nhap email: ");
                    String email = scanner.nextLine();
			    
                    System.out.println("Nhap so dien thoai: ");
                    String sdt = scanner.nextLine();
                    scanner.nextLine();
                case 2:
                    System.out.println("Xac nhan thong tin tren la dung");
                    nhaptt sinhvien = new nhaptt(mssv, hovaten, gt, ntns, noisinh, email, sdt); {}
                    sinhvien1.xuat();
                    break;
                case 3:
                    // Nhập câu hỏi khác
                    System.out.println("Ban da lua chon 2, moi nhap cau hoi:");
                    ks.nhapcauhoi();
                    break;
                case 4:
                    // Thực hiện khảo sát
                    System.out.println("Ban da lua chon 3, moi nhap");
                    ks.thuchienkhaosat();
                    break;
                case 5:
                    // Thoát
                    System.out.println("Ban da lua chon");
                    running = false;
                    System.out.println("Thoat chuong trinh!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le, vui long chon lai.");
                    break;
            }
        }
        scanner.close();
    }
}

