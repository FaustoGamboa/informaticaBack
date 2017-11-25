/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import persistence.Medicion;

/**
 *
 * @author Fausto
 */
@Stateless
@Path("persistence.medicion")
public class MedicionFacadeREST extends AbstractFacade<Medicion> {

    @PersistenceContext(unitName = "informaticaBackPU")
    private EntityManager em;

    public MedicionFacadeREST() {
        super(Medicion.class);
    }
    
    @GET
     @Path("/ingreso/{sensor}/{medida}")
    @Produces(MediaType.TEXT_PLAIN)
    public String ingresar(@PathParam("sensor") int arg1, @PathParam("medida") double arg2) {
        Date fecha = new Date();
        int idmedida = 11;
        Medicion entity = new Medicion(idmedida, fecha, arg1, arg2);
        super.create(entity);
        return "ingresados los datos: " + arg1+ " y " +arg2;
    }
    
    @POST
     @Path("/ingreso/{sensor}/{medida}")
    @Produces(MediaType.TEXT_PLAIN)
    public String ingresarpost(@PathParam("sensor") int arg1, @PathParam("medida") double arg2) {
        Date fecha = new Date();
        int idmedida = 11;
        Medicion entity = new Medicion(idmedida, fecha, arg1, arg2);
        super.create(entity);
        return "ingresados los datos: " + arg1+ " y " +arg2;
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Medicion entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Medicion entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Medicion find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Medicion> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Medicion> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
