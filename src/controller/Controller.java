package controller;

import view.*;
import java.awt.event.*;
import javax.swing.*;
import model.*;

public class Controller implements ActionListener {

  private FrmMenu menu;
  private StudentVO stuVO;
  private StudentDAO stuDAO = new StudentDAO();

  public Controller() {
    this.menu = new FrmMenu();
    this.menu.getBtnDelete().addActionListener(this);
    this.menu.getbtnClear().addActionListener(this);
    this.menu.getBtnInsert().addActionListener(this);
    this.menu.getBtnUpdate().addActionListener(this);
    this.menu.getEmails().addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {

    if (menu.getBtnInsert() == e.getSource()) {
      stuVO = new StudentVO(this.menu.getJtName().getText(), this.menu.getJtLastName().getText(),
          this.menu.getJtDateBirth().getText(), this.menu.getJtEmailIns().getText(),
          this.menu.getJtEmailPer().getText(), Long.parseLong(this.menu.getJtNumberPhone().getText()),
          Long.parseLong(this.menu.getJtNumberHome().getText()), this.menu.getJtCareer().getText());

      if (stuDAO.insert(stuVO)) {
        JOptionPane.showMessageDialog(null, "Se almacenó el estudiante", "CONFIRMACIÓN",
            JOptionPane.INFORMATION_MESSAGE);
        this.menu.cargarEmailsClicked();
        this.menu.clear();
      }

    } else if (menu.getBtnDelete() == e.getSource()) {
      JFrame Frame = new JFrame("ELIMINAR");
      if (JOptionPane.showConfirmDialog(Frame,
          "Seguro que quieres eliminar a: " + this.menu.getEmails().getSelectedItem().toString(), "Confirmar",
          JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
        stuDAO.delete(this.menu.getEmails().getSelectedItem().toString());
        this.menu.cargarEmailsClicked();
        this.menu.clear();
      }
    } else if (menu.getEmails() == e.getSource()) {
      try {
        StudentVO stFind = stuDAO.search(this.menu.getEmails().getSelectedItem().toString());
        this.menu.getJtName().setText(stFind.getName());
        this.menu.getJtLastName().setText(stFind.getLastName());
        this.menu.getJtDateBirth().setText(stFind.getDateBirth());
        this.menu.getJtEmailIns().setText(stFind.getEmailIns());
        this.menu.getJtEmailPer().setText(stFind.getEmailPer());
        this.menu.getJtNumberPhone().setText(Long.toString(stFind.getNumberPhone()));
        this.menu.getJtNumberHome().setText(Long.toString(stFind.getNumberHome()));
        this.menu.getJtCareer().setText(stFind.getCareer());
      } catch (Exception ex) {
      }
    } else if (menu.getBtnClear() == e.getSource()) {
      this.menu.clear();
      this.menu.cargarEmailsClicked();
    } else if (menu.getBtnUpdate() == e.getSource()) {

      stuVO = new StudentVO();
      stuVO.setEmailPer(this.menu.getJtEmailPer().getText());
      stuVO.setNumberPhone(Long.parseLong(this.menu.getJtNumberPhone().getText()));
      stuVO.setNumberHome(Long.parseLong(this.menu.getJtNumberHome().getText()));
      stuVO.setCareer(this.menu.getJtCareer().getText());

      if (stuDAO.update(stuVO, this.menu.getEmails().getSelectedItem().toString())) {
        JOptionPane.showMessageDialog(null, "Se actualizó el estudiante", "CONFIRMACIÓN",
            JOptionPane.INFORMATION_MESSAGE);
        this.menu.cargarEmailsClicked();
        this.menu.clear();
      }
    }
  }
}