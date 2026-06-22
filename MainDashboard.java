/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.healthcare.view;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

/**
 *
 *
 */
public class MainDashboard extends javax.swing.JFrame {
    
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MainDashboard.class.getName());

    /**
     * Creates new form MainDashboard
     */
    public MainDashboard() {
        this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
    initComponents();
    
    loadDoctorsTable();     
    loadPatientsTable();     
    loadComboBoxes(); 
    loadAppointmentsTable();
        
        
    }
    
     public void loadPatientsTable() {
       java.util.Vector<String> header = new java.util.Vector<>();
       header.add("ID"); header.add("Name"); header.add("Age"); header.add("Gender"); header.add("Phone");
       java.util.Vector<java.util.Vector<String>> data = new java.util.Vector<>();

       try (Connection conn = com.healthcare.database.DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM Patients");
            ResultSet rs = pst.executeQuery()) {
           while (rs.next()) {
               java.util.Vector<String> row = new java.util.Vector<>();
               row.add(rs.getString("patient_id"));
               row.add(rs.getString("name"));
               row.add(rs.getString("age"));
               row.add(rs.getString("gender"));
               row.add(rs.getString("phone"));
               data.add(row);
           }
           tblPatients.setModel(new javax.swing.table.DefaultTableModel(data, header));
       } catch (Exception e) {
           JOptionPane.showMessageDialog(this, "Patients load error: " + e.getMessage());
       }
   }
     public void loadComboBoxes() {
    try (Connection conn = com.healthcare.database.DBConnection.getConnection()) {
        // Load Doctors
        PreparedStatement pstDoc = conn.prepareStatement("SELECT doctor_id, name FROM Doctors");
        ResultSet rsDoc = pstDoc.executeQuery();
        cmbDoctors.removeAllItems();
        while (rsDoc.next()) {
            cmbDoctors.addItem(rsDoc.getString("doctor_id") + " - " + rsDoc.getString("name"));
        }

        // Load Patients
        PreparedStatement pstPat = conn.prepareStatement("SELECT patient_id, name FROM Patients");
        ResultSet rsPat = pstPat.executeQuery();
        cmbPatients.removeAllItems();
        while (rsPat.next()) {
            cmbPatients.addItem(rsPat.getString("patient_id") + " - " + rsPat.getString("name"));
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Dropdown load error: " + e.getMessage());
    }
}
     public void loadAppointmentsTable() {
    java.util.Vector<String> header = new java.util.Vector<>();
    header.add("Appointment ID");
    header.add("Patient ID");
    header.add("Doctor ID");
    header.add("Date");
    header.add("Time");

    java.util.Vector<java.util.Vector<String>> data = new java.util.Vector<>();
    String query = "SELECT * FROM Appointments";

    try (Connection conn = com.healthcare.database.DBConnection.getConnection();
         PreparedStatement pst = conn.prepareStatement(query);
         ResultSet rs = pst.executeQuery()) {

        while (rs.next()) {
            java.util.Vector<String> row = new java.util.Vector<>();
            row.add(rs.getString("appointment_id"));
            row.add(rs.getString("patient_id"));
            row.add(rs.getString("doctor_id"));
            row.add(rs.getString("date"));
            row.add(rs.getString("time"));
            data.add(row);
        }

        
        tblAppointments.setModel(new javax.swing.table.DefaultTableModel(data, header));

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Appointments load error: " + e.getMessage());
    }
}
 
    public void loadDoctorsTable() {
    
    java.util.Vector<String> header = new java.util.Vector<>();
    header.add("ID");
    header.add("Name");
    header.add("Specialization");
    header.add("Phone");

    java.util.Vector<java.util.Vector<String>> data = new java.util.Vector<>();

    String query = "SELECT * FROM Doctors";

    try (Connection conn = com.healthcare.database.DBConnection.getConnection();
         PreparedStatement pst = conn.prepareStatement(query);
         ResultSet rs = pst.executeQuery()) {

        while (rs.next()) {
            java.util.Vector<String> row = new java.util.Vector<>();
            row.add(rs.getString("doctor_id"));
            row.add(rs.getString("name"));
            row.add(rs.getString("specialization"));
            row.add(rs.getString("phone"));
            data.add(row);
        }

        
        tblDoctors.setModel(new javax.swing.table.DefaultTableModel(data, header));

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Table load error: " + e.getMessage());
    }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtDocName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtSpecialization = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDocPhone = new javax.swing.JTextField();
        btnAddDoctor = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDoctors = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtPatientName = new javax.swing.JTextField();
        txtPatientAge = new javax.swing.JTextField();
        txtPatientPhone = new javax.swing.JTextField();
        cmbPatientGender = new javax.swing.JComboBox<>();
        btnAddPatient = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPatients = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cmbPatients = new javax.swing.JComboBox<>();
        cmbDoctors = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        txtTime = new javax.swing.JTextField();
        btnBookAppointment = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblAppointments = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Doctor Name :");

        jLabel2.setText("Specialization :");

        jLabel3.setText("Phone :");

        btnAddDoctor.setText("Add Doctor");
        btnAddDoctor.addActionListener(this::btnAddDoctorActionPerformed);

        tblDoctors.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblDoctors);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddDoctor)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtSpecialization, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                            .addComponent(txtDocName)
                            .addComponent(txtDocPhone))))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDocName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSpecialization, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDocPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(btnAddDoctor)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manage Doctors", jPanel1);

        jLabel4.setText("Name :");

        jLabel5.setText("Age :");

        jLabel6.setText("Gender :");

        jLabel7.setText("Phone :");

        cmbPatientGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        btnAddPatient.setText("Add Patient");
        btnAddPatient.addActionListener(this::btnAddPatientActionPerformed);

        tblPatients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblPatients);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddPatient)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPatientName)
                            .addComponent(txtPatientAge)
                            .addComponent(cmbPatientGender, 0, 172, Short.MAX_VALUE)
                            .addComponent(txtPatientPhone))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPatientName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPatientAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbPatientGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtPatientPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAddPatient)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manage Patients", jPanel2);

        jLabel8.setText("Patient :");

        jLabel9.setText("Doctor :");

        cmbPatients.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbDoctors.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel10.setText("Date :");

        jLabel11.setText("Time :");

        btnBookAppointment.setText("Book Appointment");
        btnBookAppointment.addActionListener(this::btnBookAppointmentActionPerformed);

        tblAppointments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tblAppointments);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBookAppointment)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtTime))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbPatients, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbDoctors, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cmbPatients, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cmbDoctors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(btnBookAppointment)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Book Appointments", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addGap(62, 62, 62))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDoctorActionPerformed
      loadComboBoxes(); 
        String name = txtDocName.getText().trim();
    String spec = txtSpecialization.getText().trim();
    String phone = txtDocPhone.getText().trim();

   
    if (name.isEmpty() || spec.isEmpty() || phone.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Hama field ekama purwanna!", "Validation Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

   
    String query = "INSERT INTO Doctors (name, specialization, phone) VALUES (?, ?, ?)";

    try (Connection conn = com.healthcare.database.DBConnection.getConnection();
         PreparedStatement pst = conn.prepareStatement(query)) {

        pst.setString(1, name);
        pst.setString(2, spec);
        pst.setString(3, phone);

        int rowsInserted = pst.executeUpdate();

        if (rowsInserted > 0) {
            JOptionPane.showMessageDialog(this, "Doctor added successfully!");
            
           
            txtDocName.setText("");
            txtSpecialization.setText("");
            txtDocPhone.setText("");
            
           
            loadDoctorsTable(); 
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Database Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } // TODO add your handling code here:
    }//GEN-LAST:event_btnAddDoctorActionPerformed

    private void btnAddPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPatientActionPerformed
      
        String name = txtPatientName.getText().trim();
    String ageStr = txtPatientAge.getText().trim();
    String gender = cmbPatientGender.getSelectedItem().toString();
    String phone = txtPatientPhone.getText().trim();

    // Validation
    if (name.isEmpty() || ageStr.isEmpty() || gender.isEmpty() || phone.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Hama field ekama purwanna!", "Validation Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Exception Handling with SQL query
    String query = "INSERT INTO Patients (name, age, gender, phone) VALUES (?, ?, ?, ?)";
    try (Connection conn = com.healthcare.database.DBConnection.getConnection();
         PreparedStatement pst = conn.prepareStatement(query)) {

        pst.setString(1, name);
        pst.setInt(2, Integer.parseInt(ageStr)); // String to Int conversion
        pst.setString(3, gender);
        pst.setString(4, phone);

        if (pst.executeUpdate() > 0) {
            JOptionPane.showMessageDialog(this, "Patient added successfully !");
            // Clear Fields
            txtPatientName.setText(""); txtPatientAge.setText(""); cmbPatientGender.setSelectedIndex(-1); txtPatientPhone.setText("");
            loadPatientsTable();
            loadComboBoxes(); 
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Age ekata niyamitha ankshayan yodanna!", "Input Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Database Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } // TODO add your handling code here:
    }//GEN-LAST:event_btnAddPatientActionPerformed

    private void btnBookAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookAppointmentActionPerformed
       if(cmbPatients.getSelectedItem() == null || cmbDoctors.getSelectedItem() == null) {
           JOptionPane.showMessageDialog(this, " Cannot be empty !"); return;
       }
       
       String patientId = cmbPatients.getSelectedItem().toString().split(" - ")[0];
       String doctorId = cmbDoctors.getSelectedItem().toString().split(" - ")[0];
       String date = txtDate.getText().trim();
       String time = txtTime.getText().trim();

       if(date.isEmpty() || time.isEmpty()) {
           JOptionPane.showMessageDialog(this, "Fill date and time!"); return;
       }

       String query = "INSERT INTO Appointments (patient_id, doctor_id, date, time) VALUES (?, ?, ?, ?)";
       try (Connection conn = com.healthcare.database.DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(query)) {
           pst.setInt(1, Integer.parseInt(patientId));
           pst.setInt(2, Integer.parseInt(doctorId));
           pst.setString(3, date);
           pst.setString(4, time);

           if (pst.executeUpdate() > 0) {
               JOptionPane.showMessageDialog(this, "Appointment booked successfully!");
               loadAppointmentsTable(); 
           }
       } catch (Exception e) {
           JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
       } // TODO add your handling code here:
    }//GEN-LAST:event_btnBookAppointmentActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new MainDashboard().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddDoctor;
    private javax.swing.JButton btnAddPatient;
    private javax.swing.JButton btnBookAppointment;
    private javax.swing.JComboBox<String> cmbDoctors;
    private javax.swing.JComboBox<String> cmbPatientGender;
    private javax.swing.JComboBox<String> cmbPatients;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblAppointments;
    private javax.swing.JTable tblDoctors;
    private javax.swing.JTable tblPatients;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtDocName;
    private javax.swing.JTextField txtDocPhone;
    private javax.swing.JTextField txtPatientAge;
    private javax.swing.JTextField txtPatientName;
    private javax.swing.JTextField txtPatientPhone;
    private javax.swing.JTextField txtSpecialization;
    private javax.swing.JTextField txtTime;
    // End of variables declaration//GEN-END:variables
}
