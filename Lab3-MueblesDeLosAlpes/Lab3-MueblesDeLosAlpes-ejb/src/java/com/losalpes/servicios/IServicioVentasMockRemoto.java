/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.servicios;

import com.losalpes.entities.RegistroVenta;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author dito
 */
@Remote
public interface IServicioVentasMockRemoto {
    
    /**
     * Devuelve todas las ventas del sistema
     * @return muebles Lista de muebles
     */
    public List<RegistroVenta> darVentas();
    
}
