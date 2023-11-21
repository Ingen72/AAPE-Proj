/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telas;

import Dados.AapeDao;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class TelaCadastro extends javax.swing.JFrame {

    /**
     * Creates new form TelaCadastro
     */
    public TelaCadastro() {
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

        txtNome = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtSenha = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JTextField();
        txtCpf = new javax.swing.JTextField();
        txtDataNasc = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Seja bem-vindo!");
        getContentPane().setLayout(null);
        getContentPane().add(txtNome);
        txtNome.setBounds(130, 238, 313, 40);
        getContentPane().add(txtEmail);
        txtEmail.setBounds(130, 305, 313, 40);
        getContentPane().add(txtSenha);
        txtSenha.setBounds(130, 371, 313, 40);
        getContentPane().add(txtTelefone);
        txtTelefone.setBounds(130, 444, 313, 40);
        getContentPane().add(txtCpf);
        txtCpf.setBounds(130, 530, 313, 40);
        getContentPane().add(txtDataNasc);
        txtDataNasc.setBounds(130, 616, 313, 40);

        btnCadastrar.setBackground(new java.awt.Color(0, 0, 0));
        btnCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCadastrar);
        btnCadastrar.setBounds(188, 718, 180, 41);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/telas/TelaCadastro(R).jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 540, 800);

        setSize(new java.awt.Dimension(549, 807));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        // TODO add your handling code here:
         try {
           AapeDao.cadastrarUsuario(txtNome.getText(), txtEmail.getText(), txtSenha.getText(),Integer.parseInt(txtTelefone.getText()),txtCpf.getText(), txtDataNasc.getText());
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso");
            dispose();
            new TelaLogin().setVisible(true);
        } catch (ClassNotFoundException x) {
            JOptionPane.showMessageDialog(null, "Driver JDBC não encontrado " + x.getMessage());
        } catch (SQLException x) {
            if (x.getMessage().contains("Duplicate entry")) {
                JOptionPane.showMessageDialog(null, "Este CPF já está cadastrado ");
            } else {
                JOptionPane.showMessageDialog(null, "Erro na conexão com o banco de dados " + x.getMessage());
            }
        }
        
    }//GEN-LAST:event_btnCadastrarActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtDataNasc;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtSenha;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}