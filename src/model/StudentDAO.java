package model;

import java.io.*;
import java.sql.*;
import BD.ConnectBd;

public class StudentDAO {

  private ConnectBd sqlite = new ConnectBd();
  private PreparedStatement sentence;
  String sql;

  public void print(StudentVO stu) {
    System.out.println("Nombres: " + stu.getName());
    System.out.println("Apellidos: " + stu.getLastName());
    System.out.println("Fecha nacimiento: " + stu.getDateBirth());
    System.out.println("Correo institucional: " + stu.getEmailIns());
    System.out.println("Correo personal: " + stu.getEmailPer());
    System.out.println("Número de teléfono celular: " + stu.getNumberPhone());
    System.out.println("Número de teléfono fijo: " + stu.getNumberHome());
    System.out.println("Programa académico: " + stu.getCareer());
  }

  public void fileUpload() {
  try {
    FileReader file = new FileReader("infoestudiantes.csv");
    BufferedReader buffer = new BufferedReader(file);
    String line;
    while ((line = buffer.readLine()) != null) {
    String[] tokens = line.replace("\"", "").split(",");
    StudentVO z = new StudentVO(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], Long.parseLong( tokens[5]), Long.parseLong(tokens[6]),tokens[7]);
    this.insert(z);
  }
    buffer.close();
    file.close();
  } catch (FileNotFoundException e) {
    System.out.println(e);
  } catch (IOException e) {
    e.printStackTrace();
  }
  }

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
      if (!sentence.execute()) {
        return true;
      } else {
        return false;
      }
    } catch (SQLException e) {
      System.out.println(e);
      return false;
    }
  }

  public void search(String data) {
    ResultSet dataSqlite = null;
    try {
      sql = "select * from estudiantes where emailIns = ?;";

      sentence = this.sqlite.pStmp(sql);
      sentence.setString(1, data);
      dataSqlite = sentence.executeQuery();

      while (dataSqlite.next()) {
        StudentVO stu = new StudentVO(dataSqlite.getString("name"), dataSqlite.getString("lastName"),
            dataSqlite.getString("dateBirth"), dataSqlite.getString("emailIns"), dataSqlite.getString("emailPer"),
            dataSqlite.getLong("numberPhone"), dataSqlite.getLong("numberHome"), dataSqlite.getString("career"));
        this.print(stu);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void list() {
    ResultSet data = null;
    try {
      sql = "select * from estudiantes;";
      sentence = this.sqlite.pStmp(sql);
      data = sentence.executeQuery();
      System.out.println("El directorio de los estudiantes");
      while (data.next()) {
        StudentVO stu = new StudentVO(data.getString("name"), data.getString("lastName"), data.getString("dateBirth"),
            data.getString("emailIns"), data.getString("emailPer"), data.getLong("numberPhone"),
            data.getLong("numberHome"), data.getString("career"));
        this.print(stu);
      }
    } catch (SQLException e) {
      e.printStackTrace();
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
      if (!sentence.execute()) {
        return true;
      } else {
        return false;
      }
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
      if (!sentence.execute()) {
        return true;
      } else {
        return false;
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  public void close() {
    this.sqlite.stopConnection();
  }
}