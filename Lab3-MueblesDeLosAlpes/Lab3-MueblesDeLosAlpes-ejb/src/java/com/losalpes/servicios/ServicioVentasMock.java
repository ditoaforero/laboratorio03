/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.servicios;

import com.losalpes.entities.RegistroVenta;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author dito
 */
@Stateless
public class ServicioVentasMock implements IServicioVentasMockLocal, IServicioVentasMockRemoto {

    
    @EJB
    private IServicioPersistenciaMockLocal persistencia;
    
    @Override
    public List<RegistroVenta> darVentas() {
        return(ArrayList<RegistroVenta>) persistencia.findAll(RegistroVenta.class);  
    }
   
    
}
