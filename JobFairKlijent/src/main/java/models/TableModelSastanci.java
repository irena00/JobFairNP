/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.ClientController;
import domen.Sastanak;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PC
 */
public class TableModelSastanci extends AbstractTableModel implements Runnable {

    private ArrayList<Sastanak> lista;
    private String[] kolone = {"ID", "Kompanija", "Datum i vreme", "Tema", "Lokacija"};
    private String parametar = "";

    public TableModelSastanci() {
        try {
            lista = ClientController.getInstance().getAllSastanak();
        } catch (Exception ex) {
            Logger.getLogger(TableModelSastanci.class.getName()).log(Level.SEVERE, null, ex);
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
        Sastanak s = lista.get(row);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");

        switch (column) {
            case 0:
                return s.getSastanakID();
            case 1:
                return s.getKompanija().getNazivKompanije();
            case 2:
                return sdf.format(s.getDatumVreme());
            case 3:
                return s.getTema();
            case 4:
                return s.getLokacija();

            default:
                return null;
        }
    }

    public Sastanak getSelectedSastanak(int row) {
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
            Logger.getLogger(TableModelSastanci.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        refreshTable();
    }

    public void refreshTable() {
        try {
            lista = ClientController.getInstance().getAllSastanak();
            if (!parametar.equals("")) {
                ArrayList<Sastanak> novaLista = new ArrayList<>();
                for (Sastanak s : lista) {
                    if (s.getKompanija().getNazivKompanije().toLowerCase().contains(parametar.toLowerCase())) {
                        novaLista.add(s);
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
