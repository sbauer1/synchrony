package com.synchrony.ui.config;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import java.net.URL;
import java.util.Vector;
import javax.swing.JOptionPane;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * StartupFrame.java
 *
 * Created on 10.10.2010, 21:16:19
 */

/**
 *
 * @author Simon
 */
public class StartupFrame extends javax.swing.JFrame {

    /** Creates new form StartupFrame */
    public StartupFrame() {

       URL urlLogo = getClass().getResource("synchrony-logo.png");
       Image logo = Toolkit.getDefaultToolkit().getImage(urlLogo);
       setIconImage(logo);

       initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        JPanel jPanel1 = new JPanel();
        JLabel jLabel5 = new JLabel();
        JLabel jLabel6 = new JLabel();
        JLabel jLabel1 = new JLabel();
        JLabel jLabel2 = new JLabel();
        JLabel jLabel3 = new JLabel();
        JPanel jPanel5 = new JPanel();
        JScrollPane jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        JButton jButton1 = new JButton();
        JButton jButton3 = new JButton();
        JButton jButton4 = new JButton();
        JPanel jPanel6 = new JPanel();
        JLabel jLabel8 = new JLabel();
        JSeparator jSeparator1 = new JSeparator();
        JLabel jLabel9 = new JLabel();
        pathTextField = new JTextField();
        JButton jButton5 = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new Color(204, 204, 255));

        jLabel5.setFont(new Font("Arial", 1, 40));
        jLabel5.setText("synchrony");

        jLabel6.setFont(new Font("Arial", 2, 18));
        jLabel6.setText("free file synchronisation");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(Alignment.LEADING)
            .addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(115, 115, 115)
                .addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(150, 150, 150)
                .addComponent(jLabel1)
                .addContainerGap(311, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(Alignment.LEADING)
            .addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
                    .addGroup(Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(jLabel6)))
                .addContainerGap())
        );

        jPanel5.setBackground(new Color(204, 204, 255));

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "active", "status", "name", "path"
            }
        ));
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("edit");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("add");
        jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("remove");
        jButton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new Font("Tahoma", 3, 14));
        jLabel8.setText("Status");

        GroupLayout jPanel6Layout = new GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(212, Short.MAX_VALUE))
            .addComponent(jSeparator1, GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(168, Short.MAX_VALUE))
        );

        jLabel9.setFont(new Font("Tahoma", 2, 18));
        jLabel9.setText("WATCHED FOLDERS");

        GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addPreferredGap(ComponentPlacement.RELATED, 260, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(jPanel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton4)
                            .addComponent(jButton1))))
                .addContainerGap())
        );

        jButton5.setText("Browse...");
        jButton5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(Alignment.TRAILING)
                    .addComponent(jPanel5, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(pathTextField, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jButton5)))
                        .addGap(56, 56, 56)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(pathTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton5))
                    .addComponent(jLabel3))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(jPanel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        FileChooser dialog = new FileChooser(new javax.swing.JFrame(),
                true, this);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {

            public void windowClosing(java.awt.event.WindowEvent e) {
            }
        });
    }//GEN-LAST:event_jButton5ActionPerformed

    // add
    private void jButton3ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
        String active = "...";
        String status = "...";
        String name = "...";
        String path = pathTextField.getText();

        if(path.equals("")){
            JOptionPane.showMessageDialog(this,"no path choosen!");
        }else{

	String[] yesNoOptions = { "yes", "cancel" };
	int n = JOptionPane.showOptionDialog(this,
					"add this folder?",// question
					"add folder", // title
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, // icon
					null, yesNoOptions, yesNoOptions[0]);

	if (n == JOptionPane.YES_OPTION) {
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
            Vector newDatas = createDataVector(active, status, name,
					path);
			int count = model.getRowCount();
			model.addRow(newDatas);
			model.setValueAt(active, count, 0);
			model.setValueAt(status, count, 1);
			model.setValueAt(name, count, 2);
			model.setValueAt(path, count, 3);

                        pathTextField.setText("");

        }
        else if (n == JOptionPane.NO_OPTION) {
				show(isEnabled());
			} else if (n == JOptionPane.CANCEL_OPTION)
				;
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    // remove
    private void jButton4ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       
        String[] yesNoOptions = { "yes", "cancel" };
	int n = JOptionPane.showOptionDialog(this,
					"remove this folder?",// question
					"remove folder", // title
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, // icon
					null, yesNoOptions, yesNoOptions[0]);

	if (n == JOptionPane.YES_OPTION) {
               DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
               int selectedRow = jTable1.getSelectedRow();
            
               if(selectedRow == -1){
                JOptionPane.showMessageDialog(this,"no row selected!");
                }else{
                    model.removeRow(selectedRow);
                }
        }
        else if (n == JOptionPane.NO_OPTION) {
				show(isEnabled());
			} else if (n == JOptionPane.CANCEL_OPTION)
				;
      
    }//GEN-LAST:event_jButton4ActionPerformed

    // edit
    private void jButton1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        String[] yesNoOptions = { "yes", "cancel" };
	int n = JOptionPane.showOptionDialog(this,
					"edit this folder?",// question
					"edit folder", // title
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, // icon
					null, yesNoOptions, yesNoOptions[0]);

	if (n == JOptionPane.YES_OPTION) {
               DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
               int selectedRow = jTable1.getSelectedRow();

               if(selectedRow == -1){
                JOptionPane.showMessageDialog(this,"no row selected!");
                }else{
                    String active = jTable1.getValueAt(selectedRow, 0).toString();
                    String status = jTable1.getValueAt(selectedRow, 1).toString();
                    String name = jTable1.getValueAt(selectedRow, 2).toString();
                    String path = pathTextField.getText();

                    model.setValueAt(active, selectedRow, 0);
                    model.setValueAt(status, selectedRow, 1);
                    model.setValueAt(name, selectedRow, 2);
                    model.setValueAt(path, selectedRow, 3);
                }
        }
        else if (n == JOptionPane.NO_OPTION) {
				show(isEnabled());
			} else if (n == JOptionPane.CANCEL_OPTION)
				;


    }//GEN-LAST:event_jButton1ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartupFrame().setVisible(true);
            }
        });
    }

    public JTextField getPathTextField() {
        return pathTextField;
    }

    public static Vector createDataVector(String active, String status, String name,
			String path) {
		Vector vector = new Vector();
		for (int i = 0; i < 2; i++)
			vector.add(0);
		return vector;
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    JTable jTable1;
    JTextField pathTextField;
    // End of variables declaration//GEN-END:variables

}
