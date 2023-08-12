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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import session.Session;
import transfer.Request;
import transfer.Response;
import transferUtil.ResponseStatus;
import transferUtil.Operation;

/**
 *
 * @author PC
 */
public class ClientController {

    private static ClientController instance;

    private ClientController() {
    }

    public static ClientController getInstance() {
        if (instance == null) {
            instance = new ClientController();
        }
        return instance;
    }

    public Administrator login(Administrator administrator) throws Exception {
        return (Administrator) sendRequest(Operation.LOGIN, administrator);
    }

    public void addSastanak(Sastanak sastanak) throws Exception {
        sendRequest(Operation.ADD_SASTANAK, sastanak);
    }

    public void addUgovor(Ugovor ugovor) throws Exception {
        sendRequest(Operation.ADD_UGOVOR, ugovor);
    }

    public void deleteSastanak(Sastanak sastanak) throws Exception {
        sendRequest(Operation.DELETE_SASTANAK, sastanak);
    }

    public void deleteUgovor(Ugovor ugovor) throws Exception {
        sendRequest(Operation.DELETE_UGOVOR, ugovor);
    }

    public void updateSastanak(Sastanak sastanak) throws Exception {
        sendRequest(Operation.UPDATE_SASTANAK, sastanak);
    }

    public void updateUgovor(Ugovor ugovor) throws Exception {
        sendRequest(Operation.UPDATE_UGOVOR, ugovor);
    }

    public ArrayList<Administrator> getAllAdministrator() throws Exception {
        return (ArrayList<Administrator>) sendRequest(Operation.GET_ALL_ADMINISTRATOR, null);
    }

    public ArrayList<Sastanak> getAllSastanak() throws Exception {
        return (ArrayList<Sastanak>) sendRequest(Operation.GET_ALL_SASTANAK, null);
    }

    public ArrayList<Ugovor> getAllUgovor(Sastanak s) throws Exception {
        return (ArrayList<Ugovor>) sendRequest(Operation.GET_ALL_UGOVOR, s);
    }

    public ArrayList<Kompanija> getAllKompanija() throws Exception {
        return (ArrayList<Kompanija>) sendRequest(Operation.GET_ALL_KOMPANIJA, null);
    }

    public ArrayList<Paket> getAllPaket() throws Exception {
        return (ArrayList<Paket>) sendRequest(Operation.GET_ALL_PAKET, null);
    }

    public ArrayList<ClanCRTima> getAllClanCRTima() throws Exception {
        return (ArrayList<ClanCRTima>) sendRequest(Operation.GET_ALL_CLAN_CR_TIMA, null);
    }

    public ArrayList<StavkaUgovora> getAllStavkaUgovora(Ugovor u) throws Exception {
        return (ArrayList<StavkaUgovora>) sendRequest(Operation.GET_ALL_STAVKA_UGOVORA, u);
    }

    private Object sendRequest(int operation, Object data) throws Exception {
        Request request = new Request(operation, data);

        ObjectOutputStream out = new ObjectOutputStream(Session.getInstance().getSocket().getOutputStream());
        out.writeObject(request);

        ObjectInputStream in = new ObjectInputStream(Session.getInstance().getSocket().getInputStream());
        Response response = (Response) in.readObject();

        if (response.getResponseStatus().equals(ResponseStatus.Error)) {
            throw response.getException();
        } else {
            return response.getData();
        }

    }
}
