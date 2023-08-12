/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domen.Administrator;
import domen.ClanCRTima;
import domen.Kompanija;
import domen.Paket;
import domen.Sastanak;
import domen.StavkaUgovora;
import domen.Ugovor;
import java.util.ArrayList;
import so.administrator.SOGetAllAdministrator;
import so.clanCRTima.SOGetAllClanCRTima;
import so.kompanija.SOGetAllKompanija;
import so.login.SOLogin;
import so.paket.SOGetAllPaket;
import so.sastanak.SOAddSastanak;
import so.sastanak.SODeleteSastanak;
import so.sastanak.SOGetAllSastanak;
import so.sastanak.SOUpdateSastanak;
import so.stavkaUgovora.SOGetAllStavkaUgovora;
import so.ugovor.SOAddUgovor;
import so.ugovor.SODeleteUgovor;
import so.ugovor.SOGetAllUgovor;
import so.ugovor.SOUpdateUgovor;

/**
 *
 * @author PC
 */
public class ServerController {

    private static ServerController instance;

    private ServerController() {
    }

    public static ServerController getInstance() {
        if (instance == null) {
            instance = new ServerController();
        }
        return instance;
    }

    public Administrator login(Administrator administrator) throws Exception {
        SOLogin so = new SOLogin();
        so.templateExecute(administrator);
        return so.getUlogovani();
    }

    public void addSastanak(Sastanak sastanak) throws Exception {
        (new SOAddSastanak()).templateExecute(sastanak);
    }

    public void addUgovor(Ugovor ugovor) throws Exception {
        (new SOAddUgovor()).templateExecute(ugovor);
    }

    public void deleteSastanak(Sastanak sastanak) throws Exception {
        (new SODeleteSastanak()).templateExecute(sastanak);
    }

    public void deleteUgovor(Ugovor ugovor) throws Exception {
        (new SODeleteUgovor()).templateExecute(ugovor);
    }

    public void updateSastanak(Sastanak sastanak) throws Exception {
        (new SOUpdateSastanak()).templateExecute(sastanak);
    }

    public void updateUgovor(Ugovor ugovor) throws Exception {
        (new SOUpdateUgovor()).templateExecute(ugovor);
    }

    public ArrayList<Administrator> getAllAdministrator() throws Exception {
        SOGetAllAdministrator so = new SOGetAllAdministrator();
        so.templateExecute(new Administrator());
        return so.getLista();
    }

    public ArrayList<Sastanak> getAllSastanak() throws Exception {
        SOGetAllSastanak so = new SOGetAllSastanak();
        so.templateExecute(new Sastanak());
        return so.getLista();
    }

    public ArrayList<Kompanija> getAllKompanija() throws Exception {
        SOGetAllKompanija so = new SOGetAllKompanija();
        so.templateExecute(new Kompanija());
        return so.getLista();
    }

    public ArrayList<Paket> getAllPaket() throws Exception {
        SOGetAllPaket so = new SOGetAllPaket();
        so.templateExecute(new Paket());
        return so.getLista();
    }

    public ArrayList<ClanCRTima> getAllClanCRTima() throws Exception {
        SOGetAllClanCRTima so = new SOGetAllClanCRTima();
        so.templateExecute(new ClanCRTima());
        return so.getLista();
    }

    public ArrayList<Ugovor> getAllUgovor(Sastanak s) throws Exception {
        SOGetAllUgovor so = new SOGetAllUgovor();
        
        Ugovor u = new Ugovor();
        u.setSastanak(s);

        so.templateExecute(u);
        return so.getLista();
    }

    public ArrayList<StavkaUgovora> getAllStavkaUgovora(Ugovor u) throws Exception {
        SOGetAllStavkaUgovora so = new SOGetAllStavkaUgovora();

        StavkaUgovora su = new StavkaUgovora();
        su.setUgovor(u);

        so.templateExecute(su);
        return so.getLista();
    }

}
