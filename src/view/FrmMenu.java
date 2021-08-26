package view;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import model.*;

public class FrmMenu extends JFrame {

  public FrmMenu() {
    this.initComponentes();
    this.setVisible(true);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  private JComboBox<String> emails = new JComboBox<String>();
  private JLabel lbName;
  private JLabel lbLastName;
  private JLabel lbDateBirth;
  private JLabel lbEmailIns;
  private JLabel lbEmailPer;
  private JLabel lbNumberPhone;
  private JLabel lbNumberHome;
  private JLabel lbCareer;
  private JTextField jtName;
  private JTextField jtLastName;
  private JTextField jtDateBirth;
  private JTextField jtEmailIns;
  private JTextField jtEmailPer;
  private JTextField jtNumberPhone;
  private JTextField jtNumberHome;
  private JTextField jtCareer;
  private JButton btnInsert;
  private JButton btnUpdate;
  private JButton btnDelete;
  private JButton btnClear;

  public JComboBox<String> getEmails() {
    return emails;
  }

  public JTextField getJtName() {
    return jtName;
  }

  public JTextField getJtLastName() {
    return jtLastName;
  }

  public JTextField getJtDateBirth() {
    return jtDateBirth;
  }

  public JTextField getJtEmailIns() {
    return jtEmailIns;
  }

  public JTextField getJtEmailPer() {
    return jtEmailPer;
  }

  public JTextField getJtNumberPhone() {
    return jtNumberPhone;
  }

  public JTextField getJtNumberHome() {
    return jtNumberHome;
  }

  public JTextField getJtCareer() {
    return jtCareer;
  }

  public JButton getBtnClear() {
    return btnClear;
  }

  public JButton getBtnInsert() {
    return btnInsert;
  }

  public JButton getBtnUpdate() {
    return btnUpdate;
  }

  public JButton getBtnDelete() {
    return btnDelete;
  }

  public JButton getbtnClear() {
    return btnClear;
  }

  public void cargarEmails() throws SQLException {
    StudentDAO stuDAO = new StudentDAO();
    ArrayList<String> listEmailsInst = stuDAO.emailslist();
    int i;
    if (listEmailsInst != null) {
      int size = listEmailsInst.size();
      for (i = 0; i < size; i++) {
        emails.addItem(listEmailsInst.get(i));
      }
    }
  }

  public void cargarEmailsClicked() {
    try {
      emails.removeAllItems();
      emails.addItem("Seleccione estudiante...");
      cargarEmails();
    } catch (SQLException ex) {
      System.out.println(ex);
    }
  }

  public void clear() {
    jtName.setText("");
    jtLastName.setText("");
    jtDateBirth.setText("");
    jtEmailIns.setText("");
    jtEmailPer.setText("");
    jtNumberPhone.setText("");
    jtNumberHome.setText("");
    jtCareer.setText("");
  }

  public void initComponentes() {
    this.setTitle("Pagina Principal");
    this.setSize(800, 350);

    GridLayout lm = new GridLayout(1, 1);

    JPanel jpEmails = new JPanel();
    jpEmails.setLayout(lm);
    cargarEmailsClicked();
    jpEmails.add(emails);
    jpEmails.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    JPanel jpInputs = new JPanel();
    jpInputs.setLayout(new GridLayout(4, 4, 30, 10));

    this.lbName = new JLabel("Nombres:");
    this.jtName = new JTextField();
    this.lbLastName = new JLabel("Apellidos:");
    this.jtLastName = new JTextField();
    this.lbDateBirth = new JLabel("Fecha Nacimiento:");
    this.jtDateBirth = new JTextField();
    this.lbEmailIns = new JLabel("Correo Institucional:");
    this.jtEmailIns = new JTextField();
    this.lbEmailPer = new JLabel("Correo Personal:");
    this.jtEmailPer = new JTextField();
    this.lbNumberPhone = new JLabel("Número Celular:");
    this.jtNumberPhone = new JTextField();
    this.lbNumberHome = new JLabel("Número Fijo:");
    this.jtNumberHome = new JTextField();
    this.lbCareer = new JLabel("Carrera:");
    this.jtCareer = new JTextField();

    jpInputs.add(lbName);
    jpInputs.add(jtName);
    jpInputs.add(lbLastName);
    jpInputs.add(jtLastName);
    jpInputs.add(lbDateBirth);
    jpInputs.add(jtDateBirth);
    jpInputs.add(lbEmailIns);
    jpInputs.add(jtEmailIns);
    jpInputs.add(lbEmailPer);
    jpInputs.add(jtEmailPer);
    jpInputs.add(lbNumberPhone);
    jpInputs.add(jtNumberPhone);
    jpInputs.add(lbNumberHome);
    jpInputs.add(jtNumberHome);
    jpInputs.add(lbCareer);
    jpInputs.add(jtCareer);

    jpInputs.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    JPanel jpButtons = new JPanel();
    jpButtons.setLayout(new GridLayout(2, 2, 50, 10));
    jpButtons.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    this.btnInsert = new JButton("Insertar");
    this.btnUpdate = new JButton("Modificar");
    this.btnDelete = new JButton("Eliminar");
    this.btnClear = new JButton("Limpiar");

    jpButtons.add(btnInsert);
    jpButtons.add(btnUpdate);
    jpButtons.add(btnDelete);
    jpButtons.add(btnClear);

    getContentPane().add(jpEmails, BorderLayout.NORTH);
    getContentPane().add(jpInputs, BorderLayout.CENTER);
    getContentPane().add(jpButtons, BorderLayout.SOUTH);
  }
}