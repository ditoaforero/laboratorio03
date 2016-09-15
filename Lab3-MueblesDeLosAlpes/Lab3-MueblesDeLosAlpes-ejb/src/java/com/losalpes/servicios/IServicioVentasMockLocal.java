/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.servicios;

import com.losalpes.entities.RegistroVenta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author dito
 */
@Local
public interface IServicioVentasMockLocal {
    
    public List<RegistroVenta> darVentas();

}
