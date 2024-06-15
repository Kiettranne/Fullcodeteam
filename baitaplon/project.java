import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


// Lớp nhaptt đại diện cho thông tin sinh viên
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

    // Getters và Setters
    public String getMssv() { return mssv; }
    public void setMssv(String mssv) { this.mssv = mssv; }
    public String getHovaten() { return hovaten; }
    public void setHovaten(String hovaten) { this.hovaten = hovaten; }
    public boolean isGt() { return gt; }
    public void setGt(boolean gt) { this.gt = gt; }
    public int getNtns() { return ntns; }
    public void setNtns(int ntns) { this.ntns = ntns; }
    public String getNoisinh() { return noisinh; }
    public void setNoisinh(String noisinh) { this.noisinh = noisinh; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getSdt() { return sdt; }
    public void setSdt(String sdt) { this.sdt = sdt; }
}

// Lớp SurveyApp đại diện cho giao diện người dùng
public class SurveyApp extends JFrame implements ActionListener {
    JButton next;
    JButton btnSurvey;
    JLabel heading;
    JTextField txtMSSV, txtHovaTen, txtNoiSinh, txtEmail, txtSDT, txtNamSinh;
    JRadioButton rbtnNam, rbtnNu;
    ButtonGroup genderGroup;

    nhaptt sinhvien;

    public SurveyApp() {
        setTitle("KHẢO SÁT ONLINE");
        setSize(600,600);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        heading = new JLabel("KHẢO SÁT HỌC VIÊN");
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        heading.setForeground(Color.red);
        heading.setBounds(200, 20, 300, 40);

        JLabel lblMSSV = new JLabel("Mã số sinh viên:");
        JLabel lblHovaTen = new JLabel("Họ và tên:");
        JLabel lblNoiSinh = new JLabel("Nơi sinh:");
        JLabel lblEmail = new JLabel("Email:");
        JLabel lblSDT = new JLabel("Số điện thoại:");
        JLabel lblNamSinh = new JLabel("Năm sinh:");
        JLabel lblGioiTinh = new JLabel("Giới tính:");

        lblMSSV.setBounds(80, 100, 100, 30);
        lblHovaTen.setBounds(80, 150, 100, 30);
        lblNoiSinh.setBounds(80, 200, 100, 30);
        lblEmail.setBounds(80, 250, 100, 30);
        lblSDT.setBounds(80, 300, 100, 30);
        lblNamSinh.setBounds(80, 350, 100, 30);
        lblGioiTinh.setBounds(80, 400, 100, 30);

        txtMSSV = new JTextField();
        txtHovaTen = new JTextField();
        txtNoiSinh = new JTextField();
        txtEmail = new JTextField();
        txtSDT = new JTextField();
        txtNamSinh = new JTextField();

        txtMSSV.setBounds(180, 100, 200, 30);
        txtHovaTen.setBounds(180, 150, 200, 30);
        txtNoiSinh.setBounds(180, 200, 200, 30);
        txtEmail.setBounds(180, 250, 200, 30);
        txtSDT.setBounds(180, 300, 200, 30);
        txtNamSinh.setBounds(180, 350, 200, 30);

        rbtnNam = new JRadioButton("Nam");
        rbtnNu = new JRadioButton("Nữ");
        genderGroup = new ButtonGroup();
        genderGroup.add(rbtnNam);
        genderGroup.add(rbtnNu);
        rbtnNam.setBounds(180, 400, 60, 30);
        rbtnNu.setBounds(240, 400, 60, 30);

        next = new JButton("Tiếp theo");
        next.setBounds(400, 300, 150, 30);
        next.addActionListener(this);

        btnSurvey = new JButton("Thực hiện khảo sát");
        btnSurvey.setBounds(400, 350, 150, 30);
        btnSurvey.addActionListener(this);

        add(heading);
        add(lblMSSV);
        add(lblHovaTen);
        add(lblNoiSinh);
        add(lblEmail);
        add(lblSDT);
        add(lblNamSinh);
        add(lblGioiTinh);
        add(txtMSSV);
        add(txtHovaTen);
        add(txtNoiSinh);
        add(txtEmail);
        add(txtSDT);
        add(txtNamSinh);
        add(rbtnNam);
        add(rbtnNu);
        add(next);
        add(btnSurvey);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next) {
            // Lấy thông tin từ giao diện
            String mssv = txtMSSV.getText();
            String hovaten = txtHovaTen.getText();
            String noisinh = txtNoiSinh.getText();
            String email = txtEmail.getText();
            String sdt = txtSDT.getText();
            int ntns = Integer.parseInt(txtNamSinh.getText());
            boolean gt = rbtnNam.isSelected();

            // Kiểm tra dữ liệu hợp lệ
            if (mssv.equals("") || hovaten.equals("") || noisinh.equals("") || email.equals("") || sdt.equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Tạo đối tượng nhaptt
            sinhvien = new nhaptt(mssv, hovaten, gt, ntns, noisinh, email, sdt);

            // Hiển thị thông tin sinh viên
            JOptionPane.showMessageDialog(this, "Thông tin sinh viên:\n" + sinhvien.getMssv() + "\n" + sinhvien.getHovaten() + "\n"
                    + (sinhvien.isGt() ? "Nam" : "Nữ") + "\n" + sinhvien.getNtns() + "\n" + sinhvien.getNoisinh() + "\n" + sinhvien.getEmail() + "\n" + sinhvien.getSdt());

        } else if (e.getSource() == btnSurvey) {
            // Nếu nhấn vào nút Thực hiện khảo sát
            new SurveyAPP("Câu 1: Bạn cảm thấy giảng viên của Học viện hàng không Việt Nam như thế nào?");
        }
    }

    public static void main(String[] args) {
        new SurveyApp();
    }
}

// Lớp SurveyGUI đại diện cho khảo sát
class SurveyAPP extends JFrame implements ActionListener {
    private JButton btnSubmit;
    private JLabel lblQuestion;
    private JRadioButton option1, option2, option3;
    private ButtonGroup optionGroup;

    public SurveyAPP(String question) {
        setTitle("KHẢO SÁT");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(7, 3));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        lblQuestion = new JLabel(question);
        lblQuestion.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblQuestion);

        option1 = new JRadioButton("Rất tốt");
        option2 = new JRadioButton("Bình thường");
        option3 = new JRadioButton("Cần cải thiện");

        optionGroup = new ButtonGroup();
        optionGroup.add(option1);
        optionGroup.add(option2);
        optionGroup.add(option3);

        JPanel radioPanel = new JPanel(new GridLayout(5, 3));
        radioPanel.add(option1);
        radioPanel.add(option2);
        radioPanel.add(option3);
        add(radioPanel);

        btnSubmit = new JButton("Tiếp theo");
        btnSubmit.addActionListener(this);
        add(btnSubmit);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSubmit) {
            new nhapkhaosat("Câu 2: Cho chúng tôi biết cảm nghĩ của bạn về Học viện hàng không Việt Nam?");
        }
    }
    public static void main(String[] args) {
        new SurveyAPP("Câu hỏi khảo sát:");
    }
}

class nhapkhaosat extends JFrame implements ActionListener {
    private JButton btnnhap;
    private JLabel lblQuestion;
    private JTextField o;

    public nhapkhaosat(String question1) {
        setTitle("KHẢO SÁT ONLINE");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(7, 3));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        lblQuestion = new JLabel(question1);
        lblQuestion.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblQuestion);

        o = new JTextField();
        add(o);

        btnnhap = new JButton("Tiếp theo");
        btnnhap.addActionListener(this);
        add(btnnhap);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnnhap) {
            new ketthuc("Câu 3: Chương trình đào tạo có quá nặng đối với bạn không. Hãy đánh giá theo mức độ từ 1 đến 5!");
        }
    }
    public static void main(String[] args) {
        new nhapkhaosat("Câu hỏi khảo sát:");
    }
}

class ketthuc extends JFrame implements ActionListener {
    private JLabel kt;
    private JButton k;
    private JRadioButton k1, k2, k3, k4, k5;
    private ButtonGroup menu;

    public ketthuc (String question2) {
        setTitle("KHẢO SÁT ONLINE");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(7, 3));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        kt = new JLabel(question2);
        kt.setHorizontalAlignment(SwingConstants.CENTER);
        add(kt);

        k1 = new JRadioButton("1");
        k2 = new JRadioButton("2");
        k3 = new JRadioButton("3");
        k4 = new JRadioButton("4");
        k5 = new JRadioButton("5");


        menu = new ButtonGroup();
        menu.add(k1);
        menu.add(k2);
        menu.add(k3);
        menu.add(k4);
        menu.add(k5);

        JPanel radioPanel = new JPanel(new GridLayout(5, 3));
        radioPanel.add(k1);
        radioPanel.add(k2);
        radioPanel.add(k3);
        radioPanel.add(k4);
        radioPanel.add(k5);
        add(radioPanel);

        k = new JButton("Kết thúc");
        k.addActionListener(this);
        add(k);
    }
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "KẾT THÚC KHẢO SÁT!" + "\n" + "CẢM ƠN BẠN ĐÃ KHẢO SÁT");
        this.dispose();
        }
    public static void main(String[] args) {
        new ketthuc("Câu hỏi khảo sát");
    }

}
