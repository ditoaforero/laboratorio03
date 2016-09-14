/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.servicios;

import com.losalpes.entities.Mueble;
import com.losalpes.entities.Usuario;
import com.losalpes.excepciones.OperacionInvalidaException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.swing.JOptionPane;

/**
 *
 * @author dito
 */
@Stateless
public class ServicioCatalogoMock implements IServicioCatalogoMockLocal, IServicioCatalogoMockRemote{
    
    
    @EJB
    private IServicioPersistenciaMockLocal persistencia;
    
    public ServicioCatalogoMock() {
    
    }

    @Override
    public void agregarMueble(Mueble mueble){
        try
        {
             persistencia.create(mueble);
        }
        catch (OperacionInvalidaException ex)
        {
           throw new UnsupportedOperationException("Error al agregar Mueble."); 
        }
    }
    
    @Override
    public void eliminarMueble(long id)  {
        try
        {
        Mueble m=(Mueble) persistencia.findById(Mueble.class, id);
        persistencia.delete(m);
        }
        catch (OperacionInvalidaException ex)
        {
           throw new UnsupportedOperationException("Error al eliminar Mueble."); 
        }
    }

    @Override
    public List<Mueble> darMuebles() {
        return(ArrayList<Mueble>) persistencia.findAll(Mueble.class);      
    }

    @Override
    public void removerEjemplarMueble(long id) {
        Mueble m=(Mueble) persistencia.findById(Mueble.class, id);
        int cantidadActual = m.getCantidad();
        if(cantidadActual>0){
            m.setCantidad(cantidadActual-1);
            persistencia.update(m);
        }else{
            JOptionPane.showMessageDialog(null, "No existen mas ejemplares de este mueble");
            System.out.println("No existen mas ejemplares de este mueble");
        }
        
        
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
