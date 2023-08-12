/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import controller.ServerController;
import domen.Administrator;
import domen.Sastanak;
import domen.Ugovor;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import transfer.Request;
import transfer.Response;
import transferUtil.ResponseStatus;
import transferUtil.Operation;

/**
 *
 * @author PC
 */
public class ThreadClient extends Thread {

    private Socket socket;

    ThreadClient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            while (!socket.isClosed()) {
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                Request request = (Request) in.readObject();
                Response response = handleRequest(request);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Response handleRequest(Request request) {
        Response response = new Response(null, null, ResponseStatus.Success);
        try {
            switch (request.getOperacija()) {
                case Operation.ADD_SASTANAK:
                    ServerController.getInstance().addSastanak((Sastanak) request.getData());
                    break;
                case Operation.ADD_UGOVOR:
                    ServerController.getInstance().addUgovor((Ugovor) request.getData());
                    break;
                case Operation.DELETE_SASTANAK:
                    ServerController.getInstance().deleteSastanak((Sastanak) request.getData());
                    break;
                case Operation.DELETE_UGOVOR:
                    ServerController.getInstance().deleteUgovor((Ugovor) request.getData());
                    break;
                case Operation.UPDATE_SASTANAK:
                    ServerController.getInstance().updateSastanak((Sastanak) request.getData());
                    break;
                case Operation.UPDATE_UGOVOR:
                    ServerController.getInstance().updateUgovor((Ugovor) request.getData());
                    break;
                case Operation.GET_ALL_ADMINISTRATOR:
                    response.setData(ServerController.getInstance().getAllAdministrator());
                    break;
                case Operation.GET_ALL_CLAN_CR_TIMA:
                    response.setData(ServerController.getInstance().getAllClanCRTima());
                    break;
                case Operation.GET_ALL_KOMPANIJA:
                    response.setData(ServerController.getInstance().getAllKompanija());
                    break;
                case Operation.GET_ALL_PAKET:
                    response.setData(ServerController.getInstance().getAllPaket());
                    break;
                case Operation.GET_ALL_SASTANAK:
                    response.setData(ServerController.getInstance().getAllSastanak());
                    break;
                case Operation.GET_ALL_STAVKA_UGOVORA:
                    response.setData(ServerController.getInstance().getAllStavkaUgovora((Ugovor) request.getData()));
                    break;
                case Operation.GET_ALL_UGOVOR:
                    response.setData(ServerController.getInstance().getAllUgovor((Sastanak) request.getData()));
                    break;
                case Operation.LOGIN:
                    Administrator administrator = (Administrator) request.getData();
                    Administrator ulogovani = ServerController.getInstance().login(administrator);
                    response.setData(ulogovani);
                    break;
                default:
                    return null;
            }
        } catch (Exception e) {
            response.setResponseStatus(ResponseStatus.Error);
            response.setException(e);
        }
        return response;
    }

}
