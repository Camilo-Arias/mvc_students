package model;

import java.sql.*;
import java.util.ArrayList;

import BD.ConnectBd;

public class StudentDAO {

  private ConnectBd sqlite = new ConnectBd();
  private PreparedStatement sentence;
  String sql;

  public boolean insert(StudentVO stu) {
    try {
      sql = "insert into estudiantes (name, lastName, dateBirth, emailIns, emailPer, numberPhone, numberHome, career) values(?,?,?,?,?,?,?,?);";
      sentence = this.sqlite.pStmp(sql);
      sentence.setString(1, stu.getName());
      sentence.setString(2, stu.getLastName());
      sentence.setString(3, stu.getDateBirth());
      sentence.setString(4, stu.getEmailIns());
      sentence.setString(5, stu.getEmailPer());
      sentence.setLong(6, stu.getNumberPhone());
      sentence.setLong(7, stu.getNumberHome());
      sentence.setString(8, stu.getCareer());

      Boolean res = false;
      if (!sentence.execute()) {
        res = true;
      }
      return res;
    } catch (SQLException e) {
      System.out.println(e);
      return false;
    }
  }

  public StudentVO search(String data) {
    ResultSet dataSqlite = null;
    try {
      sql = "select * from estudiantes where emailIns = ?;";

      sentence = this.sqlite.pStmp(sql);
      sentence.setString(1, data);
      dataSqlite = sentence.executeQuery();
      StudentVO stu = null;
      while (dataSqlite.next()) {
        stu = new StudentVO(dataSqlite.getString("name"), dataSqlite.getString("lastName"),
            dataSqlite.getString("dateBirth"), dataSqlite.getString("emailIns"), dataSqlite.getString("emailPer"),
            dataSqlite.getLong("numberPhone"), dataSqlite.getLong("numberHome"), dataSqlite.getString("career"));
      }
      return stu;
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  public ArrayList<String> emailslist() {
    ResultSet data = null;
    ArrayList<String> emailsInst = new ArrayList<String>();
    try {
      sql = "select * from estudiantes;";
      sentence = this.sqlite.pStmp(sql);
      data = sentence.executeQuery();
      while (data.next()) {
        emailsInst.add(data.getString("emailIns"));
      }
      return emailsInst;
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  public boolean update(StudentVO stu, String emailIns) {
    try {
      sql = "update estudiantes set emailPer=?, numberPhone=?, numberHome=?, career=? where emailIns=?;";
      sentence = this.sqlite.pStmp(sql);
      sentence.setString(1, stu.getEmailPer());
      sentence.setLong(2, stu.getNumberPhone());
      sentence.setLong(3, stu.getNumberHome());
      sentence.setString(4, stu.getCareer());
      sentence.setString(5, emailIns);
      Boolean res = false;
      if (!sentence.execute()) {
        res = true;
      }
      return res;
    } catch (SQLException e) {
      System.out.println(e);
      return false;
    }
  }

  public boolean delete(String emailIns) {
    try {
      sql = "delete from estudiantes where emailIns=?;";
      sentence = this.sqlite.pStmp(sql);
      sentence.setString(1, emailIns);
      Boolean res = false;
      if (!sentence.execute()) {
        res = true;
      }
      return res;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }
}