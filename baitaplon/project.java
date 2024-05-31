static final String url = // nhập link sql
 public static void main (String [] args) {
 try {
/*  Class.forName (set.sourceforge.// link url) */
     Connection conn = DriverManager.getConnection (url, "Admin", "123456");
  Statement v = conn.createStatement();
  String sql = "SELECT * FROM taotrensql ";
  ResultSet rs = v.executeQuery(sql);
  while (rs.next()) {
   System.out.println ("Mã số sinh viên:" + rs.getString ("mssv");
  }
  rs.close();
  v.close();
  conn.close();
 }
 catch (SQLException e1) {
   e1.printStackTrace();
 }
 catch (Exception e2) {
  e2.printStackTrace();
 }
  
