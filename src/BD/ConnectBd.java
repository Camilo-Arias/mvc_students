package BD;

import java.util.logging.*;
import java.sql.*;

public class ConnectBd {
  private Connection conn = null;
  private PreparedStatement sentence;

  public ConnectBd() {
    try {
      Class.forName("org.sqlite.JDBC");
    } catch (ClassNotFoundException ex) {
      ex.printStackTrace();
    }
    try {
      conn = DriverManager.getConnection("jdbc:sqlite:bd_estudiantes.db");
      String create = "CREATE TABLE IF NOT EXISTS estudiantes " + "(NAME TEXT NOT NULL," + " LASTNAME TEXT NOT NULL, "
      + " DATEBIRTH TEXT NOT NULL, " + " EMAILINS TEXT PRIMARY KEY NOT NULL, " + " EMAILPER TEXT NOT NULL, "
      + " NUMBERPHONE INTEGER NOT NULL, " + " NUMBERHOME INTEGER NOT NULL, " + " CAREER TEXT NOT NULL );";
      sentence = this.pStmp(create);
      sentence.executeUpdate();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }


  public PreparedStatement pStmp(String sql) {
    try {
      this.sentence = conn.prepareStatement(sql);
      return this.sentence;
    } catch (Exception e) {
      return null;
    }
  }

  public void stopConnection() {
    try {
      this.sentence.close();
      this.conn.close();
      System.out.println("Hasta pronto");
    } catch (SQLException ex) {
      Logger.getLogger(ConnectBd.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}