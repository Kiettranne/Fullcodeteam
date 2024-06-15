package baitaplon;
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
public class Main extends JFrame implements ActionListener {
    JButton btnNext, btnSurvey, btnEdit;
    JLabel heading;
    JTextField txtMSSV, txtHovaTen, txtNoiSinh, txtEmail, txtSDT, txtNamSinh;
    JRadioButton rbtnNam, rbtnNu;
    ButtonGroup genderGroup;

    nhaptt sinhvien;

    public Main() {
        setTitle("KHẢO SÁT ONLINE");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        heading = new JLabel("KHẢO SÁT HỌC VIÊN");
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        heading.setForeground(Color.RED);
        heading.setBounds(180, 20, 300, 40);

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

        btnNext = new JButton("Tiếp theo");
        btnNext.setBounds(80, 450, 150, 30);
        btnNext.addActionListener(this);

        btnSurvey = new JButton("Thực hiện khảo sát");
        btnSurvey.setBounds(250, 450, 150, 30);
        btnSurvey.addActionListener(this);

        btnEdit = new JButton("Chỉnh sửa");
        btnEdit.setBounds(420, 450, 150, 30);
        btnEdit.addActionListener(this);
        btnEdit.setEnabled(false); // Tắt nút chỉnh sửa cho đến khi thông tin được nhập

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
        add(btnNext);
        add(btnSurvey);
        add(btnEdit);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNext) {
            // Lấy thông tin từ giao diện
            String mssv = txtMSSV.getText();
            String hovaten = txtHovaTen.getText();
            String noisinh = txtNoiSinh.getText();
            String email = txtEmail.getText();
            String sdt = txtSDT.getText();
            int ntns;
            try {
                ntns = Integer.parseInt(txtNamSinh.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập năm sinh hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            boolean gt = rbtnNam.isSelected();

            // Kiểm tra dữ liệu hợp lệ
            if (mssv.isEmpty() || hovaten.isEmpty() || noisinh.isEmpty() || email.isEmpty() || sdt.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Tạo đối tượng nhaptt
            sinhvien = new nhaptt(mssv, hovaten, gt, ntns, noisinh, email, sdt);

            // Hiển thị thông tin sinh viên
            JOptionPane.showMessageDialog(this, "Thông tin sinh viên:\n" +
                    "MSSV: " + sinhvien.getMssv() + "\n" +
                    "Họ và tên: " + sinhvien.getHovaten() + "\n" +
                    "Giới tính: " + (sinhvien.isGt() ? "Nam" : "Nữ") + "\n" +
                    "Năm sinh: " + sinhvien.getNtns() + "\n" +
                    "Nơi sinh: " + sinhvien.getNoisinh() + "\n" +
                    "Email: " + sinhvien.getEmail() + "\n" +
                    "Số điện thoại: " + sinhvien.getSdt());

            btnEdit.setEnabled(true); // Kích hoạt nút chỉnh sửa sau khi thông tin đã được nhập

        } else if (e.getSource() == btnSurvey) {
            if (sinhvien != null) {
                new SurveyGUI(sinhvien, 1);
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin sinh viên trước.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnEdit) {
            if (sinhvien != null) {
                // Cho phép chỉnh sửa thông tin
                txtMSSV.setText(sinhvien.getMssv());
                txtHovaTen.setText(sinhvien.getHovaten());
                txtNoiSinh.setText(sinhvien.getNoisinh());
                txtEmail.setText(sinhvien.getEmail());
                txtSDT.setText(sinhvien.getSdt());
                txtNamSinh.setText(String.valueOf(sinhvien.getNtns()));
                if (sinhvien.isGt()) {
                    rbtnNam.setSelected(true);
                } else {
                    rbtnNu.setSelected(true);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Không có thông tin để chỉnh sửa.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}

// Lớp SurveyGUI đại diện cho khảo sát
class SurveyGUI extends JFrame implements ActionListener {
    private JButton btnNext;
    private JLabel lblQuestion;
    private JRadioButton option1, option2, option3;
    private ButtonGroup optionGroup;
    private nhaptt sinhvien;
    private int currentQuestion;

    public SurveyGUI(nhaptt sinhvien, int questionNumber) {
        this.sinhvien = sinhvien;
        this.currentQuestion = questionNumber;

        setTitle("KHẢO SÁT");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        lblQuestion = new JLabel(getQuestionText(questionNumber));
        lblQuestion.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblQuestion);

        option1 = new JRadioButton("Rất tốt");
        option2 = new JRadioButton("Bình thường");
        option3 = new JRadioButton("Cần cải thiện");

        optionGroup = new ButtonGroup();
        optionGroup.add(option1);
        optionGroup.add(option2);
        optionGroup.add(option3);

        JPanel radioPanel = new JPanel(new GridLayout(1, 3));
        radioPanel.add(option1);
        radioPanel.add(option2);
        radioPanel.add(option3);
        add(radioPanel);

        btnNext = new JButton("Tiếp theo");
        btnNext.addActionListener(this);
        add(btnNext);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNext) {
            int nextQuestion = currentQuestion + 1;
            if (nextQuestion <= 3) {
                dispose();
                new SurveyGUI(sinhvien, nextQuestion);
            } else {
                JOptionPane.showMessageDialog(this, "KẾT THÚC KHẢO SÁT!\nCẢM ƠN BẠN ĐÃ THAM GIA.");
                dispose();
            }
        }
    }

    private String getQuestionText(int questionNumber) {
        switch (questionNumber) {
            case 1:
                return "Câu 1: Bạn cảm thấy giảng viên của Học viện hàng không Việt Nam như thế nào?";
            case 2:
                return "Câu 2: Cho chúng tôi biết cảm nghĩ của bạn về Học viện hàng không Việt Nam?";
            case 3:
                return "Câu 3: Chương trình đào tạo có quá nặng đối với bạn không? Hãy đánh giá theo mức độ từ 1 đến 5!";
            default:
                return "Câu hỏi không xác định.";
        }
    }
}
