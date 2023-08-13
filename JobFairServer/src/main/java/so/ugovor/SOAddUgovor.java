/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.ugovor;

import db.DBBroker;
import domen.AbstractDomainObject;
import domen.StavkaUgovora;
import domen.Ugovor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import so.AbstractSO;

/**
 * This class represents a specific implementation of the AbstractSO (Abstract Service Object) pattern.
 * 
 * It is designed for adding a new Ugovor (contract) instance to the database.
 * 
 * @see AbstractSO
 * @author Irena Randjelovic
 */
public class SOAddUgovor extends AbstractSO {

	/**
     * Validates that the provided AbstractDomainObject is an instance of the Ugovor class
     * and enforces specific business rules for contract creation.
     *
     * @param ado The AbstractDomainObject to be validated, expected to be a Ugovor instance.
     * @throws Exception if the provided object is not an instance of Ugovor or if the contract does not meet the specified business rules.
     */
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Ugovor)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Ugovor!");
        }

        Ugovor u = (Ugovor) ado;

        if (u.getDatumZakljucenja().after(new Date())) {
            throw new Exception("Datum zakljucenja ugovora ne sme biti posle danasnjeg datuma!");
        }

        if (u.getStavkeUgovora().isEmpty()) {
            throw new Exception("Ugovor mora imati barem jednu stavku!");
        }

        for (StavkaUgovora stavkaUgovora : u.getStavkeUgovora()) {
            if (stavkaUgovora.getCenaStavke() < 10000 || stavkaUgovora.getCenaStavke() > 100000) {
                throw new Exception("Cena stavke mora biti izmedju 10000din i 100000din!");
            }
        }

    }
    
    /**
     * Executes the operation to insert a new Ugovor instance into the database,
     * including associated stavke (items) with generated keys.
     *
     * @param ado The AbstractDomainObject representing the Ugovor object to be added to the database.
     * @throws Exception if there's an error during the database insertion process or setting generated keys.
     */
    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {

        // vracamo ps sa generisanim kljucem
        PreparedStatement ps = DBBroker.getInstance().insert(ado);

        // uzimamo generisani kljuc
        ResultSet tableKeys = ps.getGeneratedKeys();
        tableKeys.next();
        Long ugovorID = tableKeys.getLong(1);

        // setujemo za nas ugovor
        Ugovor u = (Ugovor) ado;
        u.setUgovorID(ugovorID);

        // dodajemo redom stavku po stavku naseg ugovora
        // nakon sto setujemo da potice iz naseg ugovora
        for (StavkaUgovora stavkaUgovora : u.getStavkeUgovora()) {
            stavkaUgovora.setUgovor(u);
            DBBroker.getInstance().insert(stavkaUgovora);
        }

    }

}
