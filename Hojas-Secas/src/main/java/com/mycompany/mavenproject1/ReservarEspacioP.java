/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.mavenproject1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author maxto3161
 */
public class ReservarEspacioP extends javax.swing.JFrame {

    private JComboBox<String> spaceTypeCombo;
    private JSpinner dateSpinner, startTimeSpinner, endTimeSpinner;
    private JButton checkAvailabilityButton, confirmButton, cancelButton;
    private JLabel costLabel, messageLabel;

    /**
     * Creates new form ReservarEspacioP
     */
    public ReservarEspacioP() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        setTitle("Reserva Espacio Común");
        setSize(400, 350);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Tipo de Espacio Común
        gbc.gridx = 0;
        gbc.gridy = 

 1;
        gbc.gridwidth = 1;
        getContentPane().add(new JLabel("Tipo de Espacio Común:"), gbc);

        String[] spaceTypes = {"Salón de Eventos", "Piscina", "Gimnasio"};
        spaceTypeCombo = new JComboBox<>(spaceTypes);
        gbc.gridx = 1;
        gbc.gridy = 1;
        getContentPane().add(spaceTypeCombo, gbc);

        // Fecha
        gbc.gridx = 0;
        gbc.gridy = 2;
        getContentPane().add(new JLabel("Fecha:"), gbc);

        SpinnerDateModel dateModel = new SpinnerDateModel();
        dateSpinner = new JSpinner(dateModel);
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "dd/MM/yyyy");
        dateSpinner.setEditor(dateEditor);
        gbc.gridx = 1;
        gbc.gridy = 2;
        getContentPane().add(dateSpinner, gbc);

        // Hora de Inicio
        gbc.gridx = 0;
        gbc.gridy = 3;
        getContentPane().add(new JLabel("Hora de Inicio:"), gbc);

        SpinnerDateModel startTimeModel = new SpinnerDateModel();
        startTimeSpinner = new JSpinner(startTimeModel);
        JSpinner.DateEditor startTimeEditor = new JSpinner.DateEditor(startTimeSpinner, "HH:mm");
        startTimeSpinner.setEditor(startTimeEditor);
        gbc.gridx = 1;
        gbc.gridy = 3;
        getContentPane().add(startTimeSpinner, gbc);

        // Hora de Fin
        gbc.gridx = 0;
        gbc.gridy = 4;
        getContentPane().add(new JLabel("Hora de Fin:"), gbc);

        SpinnerDateModel endTimeModel = new SpinnerDateModel();
        endTimeSpinner = new JSpinner(endTimeModel);
        JSpinner.DateEditor endTimeEditor = new JSpinner.DateEditor(endTimeSpinner, "HH:mm");
        endTimeSpinner.setEditor(endTimeEditor);
        gbc.gridx = 1;
        gbc.gridy = 4;
        getContentPane().add(endTimeSpinner, gbc);

        // Botón Verificar Disponibilidad
        checkAvailabilityButton = new JButton("Ver Disponibilidad");
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        getContentPane().add(checkAvailabilityButton, gbc);

        // Costo
        costLabel = new JLabel("Costo: $100");
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        getContentPane().add(costLabel, gbc);

        // Botones Confirmar y Cancelar
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        confirmButton = new JButton("Confirmar Reserva");
        cancelButton = new JButton("Cancelar");
        buttonPanel.add(confirmButton);
        buttonPanel.add(cancelButton);
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        getContentPane().add(buttonPanel, gbc);

        // Etiqueta de mensaje
        messageLabel = new JLabel("");
        messageLabel.setForeground(Color.GREEN);
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        getContentPane().add(messageLabel, gbc);

        checkAvailabilityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateReservation()) {
                    messageLabel.setText("Espacio disponible para la fecha y hora seleccionadas.");
                    messageLabel.setForeground(Color.GREEN);
                }
            }
        });

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateReservation()) {
                    messageLabel.setText("Reserva confirmada exitosamente!");
                    messageLabel.setForeground(Color.GREEN);
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        pack();
    }// </editor-fold>                        

    private boolean validateReservation() {
        Date selectedDate = (Date) dateSpinner.getValue();
        Date startTime = (Date) startTimeSpinner.getValue();
        Date endTime = (Date) endTimeSpinner.getValue();

        if (selectedDate.before(new Date())) {
            messageLabel.setText("La fecha seleccionada no puede ser anterior a hoy");
            messageLabel.setForeground(Color.RED);
            return false;
        }

        if (endTime.before(startTime)) {
            messageLabel.setText("La hora de fin debe ser posterior a la hora de inicio");
            messageLabel.setForeground(Color.RED);
            return false;
        }

        return true;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReservarEspacioP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReservarEspacioP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReservarEspacioP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReservarEspacioP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReservarEspacioP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    // End of variables declaration                   
}
