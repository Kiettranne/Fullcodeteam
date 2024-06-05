package baitaplon;

import java.util.Scanner;

 class nhaptt { 
    private String mssv;
    private String hovaten;
    private boolean gt;
    private int ntns;
    private String noisinh;
    private String email;
    private String sdt;
    
    private static final String NAM = "Nam";
    private static final String NU = "Nu";
    
    // Constructor
    public nhaptt() {}

    public nhaptt(String mssv, String hovaten, boolean gt, int ntns, String noisinh, String email, String sdt) {
        this.mssv = mssv;
        this.hovaten = hovaten;
        this.gt = gt;
        this.ntns = ntns;
        this.noisinh = noisinh;
        this.email = email;
        this.sdt = sdt;
    }        
    
    public int tinhTuoi(int namHienTai) {
        return namHienTai - ntns;
    }
    
    public void xuat() {
        System.out.println(mssv + "\t" + hovaten + "\t" + (gt ? NAM : NU) + "\t" + ntns + "\t" + noisinh + "\t" + email + "\t" + sdt);
    }

    // Getter and Setter methods
    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getHovaten() {
        return hovaten;
    }

    public void setHovaten(String hovaten) {
        this.hovaten = hovaten;
    }

    public boolean isGt() {
        return gt;
    }

    public void setGt(boolean gt) {
        this.gt = gt;
    }

    public int getNtns() {
        return ntns;
    }

    public void setNtns(int ntns) {
        this.ntns = ntns;
    }

    public String getNoisinh() {
        return noisinh;
    }

    public void setNoisinh(String noisinh) {
        this.noisinh = noisinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
}

class khaosat {
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
        nhaptt sinhvien = null; // Declare sinhvien here
        
        // Declare other variables
        String mssv = null;
        String hovaten = null;
        boolean gt = false;
        int ntns = 0;
        String noisinh = null;
        String email = null;
        String sdt = null;
        
        while (running) {
            System.out.println("--------------------------------");
            System.out.println("MENU:");
            System.out.println("1. Nhap thong tin sinh vien");
            System.out.println("2. Xac nhan thong tin");
            System.out.println("3. Nhap cau hoi khac");
            System.out.println("4. Thuc hien khao sat");
            System.out.println("5. Thoat");
            System.out.println("--------------------------------");
            int choice = scanner.nextInt();
            System.out.print("Lua chon cua ban: " + choice + "\n");
            scanner.nextLine();  // Đọc bỏ dòng new line sau khi nhập số
            switch (choice) {
                case 1:
                    // Nhập thông tin sinh viên
                    System.out.println("Ma so sinh vien:");
                    mssv = scanner.nextLine();
                    
                    System.out.println("Ho va ten: ");
                    hovaten = scanner.nextLine();
                    
                    System.out.println("Gioi tinh (Nam:true ; Nu: false): ");
                    gt = scanner.nextBoolean();
                    
                    if (gt) {
                        System.out.println("Gioi tinh cua ban la Nam");
                    } else {
                        System.out.println("Gioi tinh cua ban la Nu");
                    }
                    
                    System.out.println("Nhap nam sinh: ");
                    ntns = scanner.nextInt();
                    scanner.nextLine();
                    
                    System.out.println("Nhap noi sinh: ");
                    noisinh = scanner.nextLine();
                    
                    System.out.println("Nhap email: ");
                    email = scanner.nextLine();
                    
                    System.out.println("Nhap so dien thoai: ");
                    sdt = scanner.nextLine();
                    break; // Add break to end case 1
                case 2:
                    // Xác nhận thông tin
                    if (mssv != null && hovaten != null && noisinh != null && email != null && sdt != null) {
                        System.out.println("Xac nhan thong tin tren la dung");
                        sinhvien = new nhaptt(mssv, hovaten, gt, ntns, noisinh, email, sdt);
                        sinhvien.xuat();
                    } else {
                        System.out.println("Chua nhap thong tin sinh vien.");
                    }
                    break;
                case 3:
                    // Thực hiện khảo sát
                    System.out.println("Ban da lua chon 4, moi nhap");
                    ks.thuchienkhaosat();
                    break;
                case 4:
                    // Thoát
                    System.out.println("Ban da lua chon 5");
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
