/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.ClientController;
import domen.Ugovor;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PC
 */
public class TableModelUgovori extends AbstractTableModel implements Runnable {

    private ArrayList<Ugovor> lista;
    private String[] kolone = {"ID", "Kompanija", "Udruzenje", "Paket", "Datum zakljucenja",
        "Ukupna cena"};
    private String parametar = "";

    public TableModelUgovori() {
        try {
            lista = ClientController.getInstance().getAllUgovor(null);
        } catch (Exception ex) {
            Logger.getLogger(TableModelUgovori.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int i) {
        return kolone[i];
    }

    @Override
    public Object getValueAt(int row, int column) {
        Ugovor u = lista.get(row);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");

        switch (column) {
            case 0:
                return u.getUgovorID();
            case 1:
                return u.getSastanak().getKompanija().getNazivKompanije();
            case 2:
                return u.getUdruzenje();
            case 3:
                return u.getPaket();
            case 4:
                return sdf.format(u.getDatumZakljucenja());
            case 5:
                return u.getUkupnaCena() + "din";

            default:
                return null;
        }
    }

    public Ugovor getSelectedUgovor(int row) {
        return lista.get(row);
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(10000);
                refreshTable();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(TableModelUgovori.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        refreshTable();
    }

    public void refreshTable() {
        try {
            lista = ClientController.getInstance().getAllUgovor(null);
            if (!parametar.equals("")) {
                ArrayList<Ugovor> novaLista = new ArrayList<>();
                for (Ugovor u : lista) {
                    if (u.getSastanak().getKompanija().getNazivKompanije().toLowerCase().contains(parametar.toLowerCase())) {
                        novaLista.add(u);
                    }
                }
                lista = novaLista;
            }

            fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
