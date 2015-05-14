/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jsign.gui;

import static com.github.jsign.gui.FrmSelecionarCertificadoMscapi.RET_CANCEL;
import static com.github.jsign.gui.FrmSelecionarCertificadoMscapi.RET_OK;
import com.github.jsign.util.CertificateUtils;
import com.github.jsign.util.JFrameUtils;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pablo-moreira
 */
public class DlgSelectCertificate extends javax.swing.JDialog {

		/** A return status code - returned if Cancel button has been pressed */
    public static final int RET_CANCEL = 0;
    /** A return status code - returned if OK button has been pressed */
    public static final int RET_OK = 1;
	
	/**
	 * Creates new form DlgSelectCertificate
	 */
	public DlgSelectCertificate(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCertificates = new javax.swing.JTable();
        tblCertificates.getColumnModel().getColumn(0).setPreferredWidth(188);
        tblCertificates.getColumnModel().getColumn(1).setPreferredWidth(188);
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtCertificateInfo = new javax.swing.JTextArea();
        btnOK = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Lista de certificados:");

        tblCertificates.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Certificado do Usuário", "Certificado do Emissor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCertificates.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblCertificates.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblCertificates.getTableHeader().setReorderingAllowed(false);
        tblCertificates.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCertificatesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCertificates);

        jLabel2.setText("Informações do certificado selecionado:");

        txtCertificateInfo.setEditable(false);
        txtCertificateInfo.setColumns(20);
        txtCertificateInfo.setRows(5);
        jScrollPane2.setViewportView(txtCertificateInfo);

        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnOK)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancel)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnOK))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblCertificatesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCertificatesMouseClicked
		        
		if (!tblCertificates.getSelectionModel().isSelectionEmpty()) {
            
			int row = tblCertificates.getSelectedRow();

			certificado = certificados.get(row);

            if (certificado != null) {

                txtCertificateInfo.setText("");

                String[] items = certificado.getSubjectDN().getName().split(",");

                for (int i=items.length - 1; i >= 0; i--) {
                    txtCertificateInfo.append(items[i].trim() + "\n");
                }
            }
    	}
    }//GEN-LAST:event_tblCertificatesMouseClicked

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        if (certificado == null) {
    		JFrameUtils.showErro("Erro de validação", "Por favor, você deve escolher um certificado!");
    	}
    	else {
    		doClose(RET_OK);
    	}  
    }//GEN-LAST:event_btnOKActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
		doClose(RET_CANCEL);
    }//GEN-LAST:event_btnCancelActionPerformed

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
			java.util.logging.Logger.getLogger(DlgSelectCertificate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(DlgSelectCertificate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(DlgSelectCertificate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(DlgSelectCertificate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
        //</editor-fold>

		/* Create and display the dialog */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				DlgSelectCertificate dialog = new DlgSelectCertificate(new javax.swing.JFrame(), true);
				dialog.addWindowListener(new java.awt.event.WindowAdapter() {
					@Override
					public void windowClosing(java.awt.event.WindowEvent e) {
						System.exit(0);
					}
				});
				dialog.setVisible(true);
			}
		});
	}
	    
    private List<X509Certificate> certificados;
    private X509Certificate certificado;
	private int returnStatus = RET_CANCEL;
	
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblCertificates;
    private javax.swing.JTextArea txtCertificateInfo;
    // End of variables declaration//GEN-END:variables
	
    public X509Certificate getCertificado() {
        return certificado;
    }
    
    public void iniciar(List<X509Certificate> certificados) {
        
    	limpar();
        
        this.certificados = certificados;
        
                
        DefaultTableModel tm = getJTableCertificadosModel();
        tm.setRowCount(0);
                
        for (X509Certificate certificado : certificados) {
        	String nome = CertificateUtils.getCertificadoCN(certificado.getSubjectDN().getName());
        	String emissor = CertificateUtils.getCertificadoCN(certificado.getIssuerX500Principal().getName());
        	tm.addRow(new Object[]{ nome, emissor });
        }

        JFrameUtils.setCenterLocation(this);
        setAlwaysOnTop(true);
        setVisible(true);
    }

    private void limpar() {
    	certificado = null;
    	txtCertificateInfo.setText("");
    }

    private DefaultTableModel getJTableCertificadosModel() {
    	return (DefaultTableModel) tblCertificates.getModel();
    }
	
	/** @return the return status of this dialog - one of RET_OK or RET_CANCEL */
    public int getReturnStatus() {
        return returnStatus;
    }      
    
    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }
}
