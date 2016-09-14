/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.servicios;

import com.losalpes.entities.Mueble;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.losalpes.excepciones.OperacionInvalidaException;

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
    public void agregarMueble(Mueble mueble) {
        boolean found = false;
        Mueble item;
        
       
        persistencia.create(mueble);
      
    }
    
    
    public void agregarItem(Mueble mueble)
    {
        boolean found = false;
        Mueble item;
        for(int i= 0, max= inventario.size(); i < max; i++)
        {
            item = (Mueble)inventario.get(i);
            if (item.getReferencia() == mueble.getReferencia())
            {
                item.incrementarCantidad();
                found = true;
                break;
            }
        }

        // Si el item no se encuentra se agrega al inventario
        if (!found)
        {
            inventario.add(mueble);
            mueble.incrementarCantidad();
        }

        // Actualiza el inventario
        recalcularInventarioTotal();
    }
    
    

    @Override
    public void eliminarMueble(long id)  {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Mueble> darMuebles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removerEjemplarMueble(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
