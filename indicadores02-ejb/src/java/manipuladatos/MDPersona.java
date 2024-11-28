/*

 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package manipuladatos;

import accesodatos.PersonaFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Persona;

/**
 *
 * @author felip
 */
@Stateless
@LocalBean
public class MDPersona {

    @EJB
    private PersonaFacade personaFacade;

    public void registrarPersona(Persona p) {
        personaFacade.create(p);
    }

    public List<Persona> personas() {
        return personaFacade.findAll();
    }

    public void eliminarP(Persona p) {
        Persona personaExistente = personaFacade.find(p.getIdPersona());

        if (personaExistente != null) {
            personaFacade.remove(personaExistente);
        } else {
            System.out.println("La persona no existe en la base de datos.");
            throw new IllegalArgumentException("Persona no encontrada.");
        }
    }
    
    

    /*
    public void actualizarP(Persona p) {
        personaFacade.edit(p);
        
    }
     */
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
