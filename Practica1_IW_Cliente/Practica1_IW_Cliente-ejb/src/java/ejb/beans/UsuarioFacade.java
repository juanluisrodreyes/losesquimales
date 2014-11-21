/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.beans;

import ejb.entity.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Sihame
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {
    @PersistenceContext(unitName = "Practica1_IW_Cliente-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    // Devuelve un usuario buscando por nombre
    public Usuario findByNombre(String nombre) {
        Usuario usuario = null;
        try{
            usuario = (Usuario) em.createNamedQuery("Usuario.findByNombre").setParameter("nombre", nombre).getSingleResult();
        }catch(NoResultException e){
            System.out.println("No se encontró ningún usuario con el nombre " + nombre + ".");
        }
        return usuario;
    }
}
