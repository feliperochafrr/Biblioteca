/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Usuario;

/**
 *
 * @author Felipe Rocha Ribeiro
 */
@Stateless
public class UsuarioEJB {

    @PersistenceContext(name = "BibliotecaPU")
    EntityManager em;
    
    public void salvar(Usuario usuario){
       em.merge(usuario);
    }

    public List<Usuario> findAll(){
        Query query = em.createQuery("SELECT u FROM Usuario u");
        return query.getResultList();
          //Outra forma possivel:
        //        return em.createQuery("SELECT s FROM Setor s").getResultList();
    }
    public void apagar(Usuario usuario){
        usuario = em.merge(usuario);
        em.remove(usuario);
    }

}
