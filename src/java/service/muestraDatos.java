/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import persistence.Medicion;
import persistence.MedicionFacade;

/**
 *
 * @author Fausto
 */
@WebService(serviceName = "muestraDatos")
public class muestraDatos {

    @EJB
    private MedicionFacade ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "create")
    @Oneway
    public void create(@WebParam(name = "entity") Medicion entity) {
        ejbRef.create(entity);
    }

    @WebMethod(operationName = "edit")
    @Oneway
    public void edit(@WebParam(name = "entity") Medicion entity) {
        ejbRef.edit(entity);
    }

    @WebMethod(operationName = "remove")
    @Oneway
    public void remove(@WebParam(name = "entity") Medicion entity) {
        ejbRef.remove(entity);
    }

    @WebMethod(operationName = "find")
    public Medicion find(@WebParam(name = "id") Object id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAll")
    public List<Medicion> findAll() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRange")
    public List<Medicion> findRange(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "count")
    public int count() {
        return ejbRef.count();
    }

    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "getmedicion")
    public double getmedicion() {
        //TODO write your implementation code here:
        double retorno;
        int numel = count();
        Medicion medida = find(numel);
        retorno = medida.getValorMedida();
        return retorno;
    }
    
}
