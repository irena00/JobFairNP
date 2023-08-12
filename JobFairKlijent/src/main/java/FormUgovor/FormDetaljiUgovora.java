/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormUgovor;

import controller.ClientController;
import domen.Paket;
import domen.Sastanak;
import domen.StavkaUgovora;
import domen.Ugovor;
import forme.MainForm;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import models.TableModelStavke;

/**
 *
 * @author PC
 */
public class FormDetaljiUgovora extends javax.swing.JDialog {

    Ugovor u;
    double ukupnaCena;
    double cenaStavki;

    public FormDetaljiUgovora(JDialog parent, boolean modal, Ugovor u) {
        super(parent, modal);
        initComponents();
        this.u = u;
        setLocationRelativeTo(null);
        setTitle("Detalji ugovora");
        tblStavke.setModel(new TableModelStavke(u));
        cmbSastanak.getModel().setSelectedItem(u.getSastanak());
        cmbUdruzenje.getModel().setSelectedItem(u.getUdruzenje());
        cmbSastanak.setEnabled(false);
        cmbUdruzenje.setEnabled(false);
        popuniPakete();
        cmbPaket.getModel().setSelectedItem(u.getPaket());
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        txtDatumZakljucenja.setText(sdf.format(u.getDatumZakljucenja()));
        formirajCenu();
        txtUkupnaCena.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCena = new javax.swing.JFormattedTextField();
        cmbStavke = new javax.swing.JComboBox<>();
        btnDodajStavku = new javax.swing.JButton();
        btnObrisiStavku = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStavke = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbSastanak = new javax.swing.JComboBox();
        cmbPaket = new javax.swing.JComboBox();
        txtDatumZakljucenja = new javax.swing.JFormattedTextField();
        txtUkupnaCena = new javax.swing.JTextField();
        cmbUdruzenje = new javax.swing.JComboBox();
        btnIzmeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        btnOtkazi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalji ugovora"));

        jLabel1.setText("Sastanak:");

        jLabel2.setText("Paket:");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Stavke ugovora"));

        jLabel6.setText("Stavka ugovora:");

        jLabel7.setText("Cena:");

        txtCena.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        cmbStavke.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Level up", "Radionica razgovor za posao", "Tech talk", "Panel diskusija", "Dodatna promocija" }));

        btnDodajStavku.setText("Dodaj stavku");
        btnDodajStavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajStavkuActionPerformed(evt);
            }
        });

        btnObrisiStavku.setText("Obrisi stavku");
        btnObrisiStavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiStavkuActionPerformed(evt);
            }
        });

        tblStavke.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblStavke);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbStavke, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(65, 65, 65)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCena)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnDodajStavku, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                                .addComponent(btnObrisiStavku, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbStavke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodajStavku)
                    .addComponent(btnObrisiStavku))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setText("Datum zakljucenja:");

        jLabel4.setText("Ukupna cena:");

        jLabel5.setText("Udruzenje:");

        cmbSastanak.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbPaket.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbPaket.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbPaketItemStateChanged(evt);
            }
        });

        txtDatumZakljucenja.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd.MM.yyyy"))));

        cmbUdruzenje.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "EESTEC", "BEST" }));

        btnIzmeni.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnIzmeni.setText("Izmeni ugovor");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        btnObrisi.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnObrisi.setText("Obrisi ugovor");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        btnOtkazi.setText("Otkazi");
        btnOtkazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtkaziActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(52, 52, 52)
                        .addComponent(cmbSastanak, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbPaket, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbUdruzenje, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnOtkazi, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDatumZakljucenja)
                                    .addComponent(txtUkupnaCena, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnIzmeni, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)))))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnIzmeni, btnObrisi, btnOtkazi});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbSastanak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbPaket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbUdruzenje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDatumZakljucenja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtUkupnaCena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIzmeni, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnObrisi)
                    .addComponent(btnOtkazi))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnIzmeni, btnObrisi, btnOtkazi});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOtkaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtkaziActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnOtkaziActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed

        int result = JOptionPane.showConfirmDialog(this, "Da li ste sigurni da zelite da "
                + "obrisete ovaj ugovor?", "Konfirmacija", JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.NO_OPTION) {
            return;
        }

        if (result == JOptionPane.YES_OPTION) {
            try {
                ClientController.getInstance().deleteUgovor(u);
                FormPretragaUgovora fp = (FormPretragaUgovora) getParent();
                fp.refreshTable();
                JOptionPane.showMessageDialog(this, "Uspesno obrisan ugovor.");
                this.dispose();
            } catch (Exception ex) {
                Logger.getLogger(FormDetaljiUgovora.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed

        if (txtDatumZakljucenja.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Morate uneti datum zakljucenja!");
            return;
        }

        try {
            Paket paket = (Paket) cmbPaket.getSelectedItem();
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            Date datumZakljucenja = sdf.parse(txtDatumZakljucenja.getText());

            TableModelStavke tm = (TableModelStavke) tblStavke.getModel();

            u.setPaket(paket);
            u.setDatumZakljucenja(datumZakljucenja);
            u.setUkupnaCena(ukupnaCena);
            u.setStavkeUgovora(tm.getLista());

            ClientController.getInstance().updateUgovor(u);
            FormPretragaUgovora fp = (FormPretragaUgovora) getParent();
            fp.refreshTable();
            JOptionPane.showMessageDialog(this, "Uspesno izmenjen ugovor.");
            this.dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
//            Logger.getLogger(FormDetaljiUgovora.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnIzmeniActionPerformed

    private void btnDodajStavkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajStavkuActionPerformed

        if (txtCena.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Morate uneti cenu stavke!");
            return;
        }

        String nazivStavke = (String) cmbStavke.getSelectedItem();
        double cena = Double.parseDouble(txtCena.getText());

        StavkaUgovora su = new StavkaUgovora(u, -1, nazivStavke, cena);

        TableModelStavke tm = (TableModelStavke) tblStavke.getModel();

        if (tm.postojiStavka(nazivStavke)) {
            JOptionPane.showMessageDialog(this, "Vec ste uneli ovu stavku!");
            return;
        }

        tm.dodajStavku(su);

        formirajCenu();
    }//GEN-LAST:event_btnDodajStavkuActionPerformed

    private void btnObrisiStavkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiStavkuActionPerformed

        int row = tblStavke.getSelectedRow();

        if (row >= 0) {
            TableModelStavke tm = (TableModelStavke) tblStavke.getModel();
            tm.obrisiStavku(row);
            formirajCenu();
        }
    }//GEN-LAST:event_btnObrisiStavkuActionPerformed

    private void cmbPaketItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbPaketItemStateChanged
        if (cmbPaket.getSelectedItem() != null) {
            formirajCenu();
        }
    }//GEN-LAST:event_cmbPaketItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajStavku;
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnObrisiStavku;
    private javax.swing.JButton btnOtkazi;
    private javax.swing.JComboBox cmbPaket;
    private javax.swing.JComboBox cmbSastanak;
    private javax.swing.JComboBox<String> cmbStavke;
    private javax.swing.JComboBox cmbUdruzenje;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblStavke;
    private javax.swing.JFormattedTextField txtCena;
    private javax.swing.JFormattedTextField txtDatumZakljucenja;
    private javax.swing.JTextField txtUkupnaCena;
    // End of variables declaration//GEN-END:variables

    private void popuniPakete() {
        try {
            ArrayList<Paket> paketi = ClientController.getInstance().getAllPaket();

            cmbPaket.removeAllItems();

            for (Paket paket : paketi) {
                cmbPaket.addItem(paket);
            }

        } catch (Exception ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void formirajCenu() {
        Paket paket = (Paket) cmbPaket.getSelectedItem();

        ukupnaCena = paket.getCenaPaketa();

        TableModelStavke tm = (TableModelStavke) tblStavke.getModel();

        cenaStavki = tm.vratiCenuStavki();

        ukupnaCena += cenaStavki;

        txtUkupnaCena.setText(String.valueOf(ukupnaCena) + "din");
    }

}
