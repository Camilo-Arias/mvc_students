package controller;

import model.*;
import view.Vista;

public class Controller {

  Vista vsta = new Vista();
  StudentVO std;
  StudentDAO stDAO;

  public Controller() {
    stDAO = new StudentDAO();
    stDAO.fileUpload();
  }

  public void orders() {
    int option = 0;

    do {
      option = vsta.option();
      switch (option) {
        case 1:
          std = vsta.creaStudentVO();
          if (stDAO.insert(std)) {
            System.out.println("Se agregó el estudiante");
          } else {
            System.out.println("El correo electronico ya se encuentra almacenado");
          }
          break;
        case 2:
          String email = vsta.search(option);
          stDAO.search(email);
          break;
        case 3:
          email = vsta.search(option);
          std = vsta.updateStudentVO();
          if (stDAO.update(std, email)) {
            System.out.println("Se modificó el estudiante");
          } else {
            System.out.println("El estudiante no pudo ser modificádo");
          }
          break;
        case 4:
          email = vsta.search(option);
          if (stDAO.delete(email)) {
            System.out.println("Se eliminó el estudiante");
          } else {
            System.out.println("El correo ingresado no existe");
          }
          break;
        case 5:
          stDAO.list();
          break;
        case 6:
          stDAO.close();
          break;
      }
    } while (option != 6);
  }
}