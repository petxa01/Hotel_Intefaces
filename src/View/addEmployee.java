/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author Gorka
 */
public class addEmployee extends javax.swing.JFrame {

    /**
     * Creates new form addCustomer
     */
    public addEmployee() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Gender = new javax.swing.ButtonGroup();
        JobType = new javax.swing.ButtonGroup();
        nanTextField = new javax.swing.JTextField();
        nameTextField = new javax.swing.JTextField();
        surname1TextField = new javax.swing.JTextField();
        surname2TextField = new javax.swing.JTextField();
        phoneTextField = new javax.swing.JTextField();
        emailTextField = new javax.swing.JTextField();
        surname1Static = new javax.swing.JTextField();
        surname2Static = new javax.swing.JTextField();
        phoneStatic = new javax.swing.JTextField();
        emailStatic = new javax.swing.JTextField();
        genderStatic = new javax.swing.JTextField();
        jobTypeStatic = new javax.swing.JTextField();
        nanStatic = new javax.swing.JTextField();
        nameStatic = new javax.swing.JTextField();
        male = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();
        director = new javax.swing.JRadioButton();
        recepcionist = new javax.swing.JRadioButton();
        cleaner = new javax.swing.JRadioButton();
        chef = new javax.swing.JRadioButton();
        save = new javax.swing.JButton();

        setTitle("Add a new Employee");

        nanTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nanTextFieldActionPerformed(evt);
            }
        });
        nanTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nanTextFieldKeyReleased(evt);
            }
        });

        nameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameTextFieldKeyReleased(evt);
            }
        });

        surname2TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                surname2TextFieldActionPerformed(evt);
            }
        });

        surname1Static.setEditable(false);
        surname1Static.setText("Surname1");
        surname1Static.setEnabled(false);

        surname2Static.setEditable(false);
        surname2Static.setText("Surname2");
        surname2Static.setEnabled(false);

        phoneStatic.setEditable(false);
        phoneStatic.setText("Phone");
        phoneStatic.setEnabled(false);

        emailStatic.setEditable(false);
        emailStatic.setText("Email");
        emailStatic.setEnabled(false);

        genderStatic.setEditable(false);
        genderStatic.setText("Gender");
        genderStatic.setEnabled(false);

        jobTypeStatic.setEditable(false);
        jobTypeStatic.setText("Job Type");
        jobTypeStatic.setEnabled(false);

        nanStatic.setEditable(false);
        nanStatic.setText("NAN:");
        nanStatic.setEnabled(false);
        nanStatic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nanStaticActionPerformed(evt);
            }
        });

        nameStatic.setEditable(false);
        nameStatic.setText("Name:");
        nameStatic.setEnabled(false);

        Gender.add(male);
        male.setSelected(true);
        male.setText("Male");

        Gender.add(female);
        female.setText("Female");

        JobType.add(director);
        director.setSelected(true);
        director.setText("Director");

        JobType.add(recepcionist);
        recepcionist.setText("Recepcionist");

        JobType.add(cleaner);
        cleaner.setText("Cleaner");

        JobType.add(chef);
        chef.setText("Chef");

        save.setText("Save");
        save.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jobTypeStatic)
                    .addComponent(genderStatic)
                    .addComponent(emailStatic)
                    .addComponent(phoneStatic)
                    .addComponent(surname2Static)
                    .addComponent(surname1Static)
                    .addComponent(nameStatic)
                    .addComponent(nanStatic))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(male)
                        .addGap(18, 18, 18)
                        .addComponent(female))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(emailTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                        .addComponent(phoneTextField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(surname2TextField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(surname1TextField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(nameTextField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(nanTextField, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(director)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(recepcionist))
                            .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cleaner)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chef)))
                .addContainerGap(151, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nanStatic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameStatic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(surname1Static, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(surname2Static, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phoneStatic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailStatic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(genderStatic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(male)
                            .addComponent(female))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jobTypeStatic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(director)
                            .addComponent(recepcionist)
                            .addComponent(cleaner)
                            .addComponent(chef)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nanTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(surname1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(surname2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(save)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        nanTextField.getAccessibleContext().setAccessibleName("");
        nanTextField.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nanStaticActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nanStaticActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nanStaticActionPerformed

    private void surname2TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_surname2TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_surname2TextFieldActionPerformed

    private void nanTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nanTextFieldKeyReleased
        // TODO add your handling code here:
        save.setEnabled(false);
        String nan = nanTextField.getText().trim();
        int length = nan.length();
        if (length != 9) {
            fallo[0]=true;
        }else{
            fallo[0]=false;
        }
        boolean fallo2=false;
        for (int i = 0; i < fallo.length; i++) {
            if (fallo[i]) {
                fallo2=true;
            }
        }
        if(!fallo2){
            save.setEnabled(true);
        }
    }//GEN-LAST:event_nanTextFieldKeyReleased

    private void nanTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nanTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nanTextFieldActionPerformed

    private void nameTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameTextFieldKeyReleased
        // TODO add your handling code here:
        save.setEnabled(false);
        String name = nanTextField.getText().trim();
        int length = name.length();
        if (length <1) {
            fallo[1]=true;
        }else{
            fallo[1]=false;
        }
        boolean fallo2=false;
        for (int i = 0; i < fallo.length; i++) {
            if (fallo[i]) {
                fallo2=true;
            }
        }
        if(!fallo2){
            save.setEnabled(true);
        }
    }//GEN-LAST:event_nameTextFieldKeyReleased

    /**
     * @param args the command line arguments
     */
    
    boolean[] fallo= new boolean[6];
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Gender;
    private javax.swing.ButtonGroup JobType;
    public javax.swing.JRadioButton chef;
    public javax.swing.JRadioButton cleaner;
    public javax.swing.JRadioButton director;
    private javax.swing.JTextField emailStatic;
    public javax.swing.JTextField emailTextField;
    public javax.swing.JRadioButton female;
    private javax.swing.JTextField genderStatic;
    private javax.swing.JTextField jobTypeStatic;
    public javax.swing.JRadioButton male;
    private javax.swing.JTextField nameStatic;
    public javax.swing.JTextField nameTextField;
    private javax.swing.JTextField nanStatic;
    public javax.swing.JTextField nanTextField;
    private javax.swing.JTextField phoneStatic;
    public javax.swing.JTextField phoneTextField;
    public javax.swing.JRadioButton recepcionist;
    public javax.swing.JButton save;
    private javax.swing.JTextField surname1Static;
    public javax.swing.JTextField surname1TextField;
    private javax.swing.JTextField surname2Static;
    public javax.swing.JTextField surname2TextField;
    // End of variables declaration//GEN-END:variables
}
