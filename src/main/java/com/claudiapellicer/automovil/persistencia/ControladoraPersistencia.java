
package com.claudiapellicer.automovil.persistencia;

import com.claudiapellicer.automovil.logica.Automovil;
import com.claudiapellicer.automovil.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControladoraPersistencia {
    
    AutomovilJpaController autoJpa = new AutomovilJpaController();

    public void agregarAutomovil(Automovil auto) {
        autoJpa.create(auto);        
    }

    public List<Automovil> traerAuto() {
        return autoJpa.findAutomovilEntities();
        
    }

    public void borrarAuto(int idAuto) {
        try {
            autoJpa.destroy(idAuto);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Automovil traerAuto(int idAuto) {
        return autoJpa.findAutomovil(idAuto);
        
   }

    public void modificarAuto(Automovil auto) {
        try {
            autoJpa.edit(auto);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

 
    
}
