package com.losalpes.beans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.losalpes.entities.RegistroVenta;
import com.losalpes.servicios.IServicioVentasMockLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author dito
 */
@Named(value = "reporteBean")
@Dependent
public class ReporteBean {

    @EJB
    private IServicioVentasMockLocal ventas;
    /**
     * Creates a new instance of ReporteDeVentas
     */
    public ReporteBean() {
    }
    
    /**
     * Devuelve todos los muebles del sistema
     * @return muebles Lista con todos los muebles del sistema
     */
    public List<RegistroVenta> getVentas(){
        System.out.println("Se obtienen las ventas");
        System.out.println(ventas.darVentas());
        return ventas.darVentas();
    }
    
}
