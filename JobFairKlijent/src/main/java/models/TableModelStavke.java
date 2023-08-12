/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.ClientController;
import domen.StavkaUgovora;
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
public class TableModelStavke extends AbstractTableModel {

    private ArrayList<StavkaUgovora> lista;
    private String[] kolone = {"Rb", "Naziv", "Cena"};
    private int rb = 0;

    public TableModelStavke() {
        lista = new ArrayList<>();
    }

    public TableModelStavke(Ugovor u) {
        try {
            lista = ClientController.getInstance().getAllStavkaUgovora(u);
        } catch (Exception ex) {
            Logger.getLogger(TableModelStavke.class.getName()).log(Level.SEVERE, null, ex);
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
        StavkaUgovora su = lista.get(row);

        switch (column) {
            case 0:
                return su.getRbStavke();
            case 1:
                return su.getNazivStavke();
            case 2:
                return su.getCenaStavke() + "din";

            default:
                return null;
        }
    }

    public void dodajStavku(StavkaUgovora su) {
        rb = lista.size();
        su.setRbStavke(++rb);
        lista.add(su);
        fireTableDataChanged();
    }

    public boolean postojiStavka(String nazivStavke) {
        for (StavkaUgovora stavkaUgovora : lista) {
            if (stavkaUgovora.getNazivStavke().equals(nazivStavke)) {
                return true;
            }
        }
        return false;
    }

    public void obrisiStavku(int row) {
        lista.remove(row);

        rb = 0;
        for (StavkaUgovora stavkaUgovora : lista) {
            stavkaUgovora.setRbStavke(++rb);
        }

        fireTableDataChanged();
    }

    public double vratiCenuStavki() {
        double cenaStavki = 0;

        for (StavkaUgovora stavkaUgovora : lista) {
            cenaStavki += stavkaUgovora.getCenaStavke();
        }

        return cenaStavki;
    }

    public ArrayList<StavkaUgovora> getLista() {
        return lista;
    }

}
