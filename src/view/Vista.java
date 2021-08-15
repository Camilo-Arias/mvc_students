package view;

import java.util.Scanner;
import model.StudentVO;

public class Vista {

  Scanner t = new Scanner(System.in);
  private StudentVO std;

  public int option() {
    int opt = 0;
    String[] menu = { "INSTITUTO LA FLORESTA", "Seleccione tarea a realizar:", "1. Ingresar estudiante",
        "2. Buscar estudiante", "3. Modificar estudiante", "4. Eliminar Estudiante", "5. Ver directorio de estudiantes",
        "6. Salir" };

    for (int i = 0; i < menu.length; i++) {
      System.out.println(menu[i]);
    }

    System.out.println("Opción:\n");
    opt = Integer.parseInt(t.nextLine());
    return opt;
  }

  public StudentVO creaStudentVO() {
    std = new StudentVO();
    System.out.println("Ingresar estudiante");
    System.out.println("Ingresar nombres:\n");
    std.setName(t.nextLine());
    System.out.println("Ingresar apellidos:\n");
    std.setLastName(t.nextLine());
    System.out.println("Ingresar fecha de nacimiento (YYYY-MM-DD):\n");
    std.setDateBirth(t.nextLine());
    System.out.println("Ingresar correo institucional:\n");
    std.setEmailIns(t.nextLine());
    System.out.println("Ingresar correo personal:\n");
    std.setEmailPer(t.nextLine());
    System.out.println("Ingresar número de celular:\n");
    std.setNumberPhone(Long.parseLong(t.nextLine()));
    System.out.println("Ingresar número fijo:\n");
    std.setNumberHome(Long.parseLong(t.nextLine()));
    System.out.println("Ingresar programa:\n");
    std.setCareer(t.nextLine());
    return std;
  }

  public String search(int option) {
    if (option == 2) {
      System.out.println("Buscar estudiante");
    } else if (option == 3) {
      System.out.println("Modificar estudiante");
    } else if (option == 4) {
      System.out.println("Eliminar estudiante");
    }
    System.out.println("Ingresar correo institucional:\n");
    String email = t.nextLine();
    return email;
  }

  public StudentVO updateStudentVO() {
    std = new StudentVO();
    System.out.println("Ingresar correo personal:\n");
    std.setEmailPer(t.nextLine());
    System.out.println("Ingresar número de celular:\n");
    std.setNumberPhone(Long.parseLong(t.nextLine()));
    System.out.println("Ingresar número fijo:\n");
    std.setNumberHome(Long.parseLong(t.nextLine()));
    System.out.println("Ingresar programa:\n");
    std.setCareer(t.nextLine());
    return std;
  }
}