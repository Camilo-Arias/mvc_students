package model;

public class StudentVO {
  private String name;
  private String lastName;
  private String dateBirth;
  private String emailIns;
  private String emailPer;
  private Long numberPhone;
  private Long numberHome;
  private String career;

  public StudentVO() {}

  public StudentVO(String name, String lastName, String dateBirth, String emailIns, String emailPer, Long numberPhone,
      Long numberHome, String career) {
    this.name = name;
    this.lastName = lastName;
    this.dateBirth = dateBirth;
    this.emailIns = emailIns;
    this.emailPer = emailPer;
    this.numberPhone = numberPhone;
    this.numberHome = numberHome;
    this.career = career;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getDateBirth() {
    return dateBirth;
  }

  public void setDateBirth(String dateBirth) {
    this.dateBirth = dateBirth;
  }

  public String getEmailIns() {
    return emailIns;
  }

  public void setEmailIns(String emailIns) {
    this.emailIns = emailIns;
  }

  public String getEmailPer() {
    return emailPer;
  }

  public void setEmailPer(String emailPer) {
    this.emailPer = emailPer;
  }

  public Long getNumberPhone() {
    return numberPhone;
  }

  public void setNumberPhone(Long numberPhone) {
    this.numberPhone = numberPhone;
  }

  public Long getNumberHome() {
    return numberHome;
  }

  public void setNumberHome(Long numberHome) {
    this.numberHome = numberHome;
  }

  public String getCareer() {
    return career;
  }

  public void setCareer(String career) {
    this.career = career;
  }
}