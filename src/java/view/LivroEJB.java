/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Livro;

/**
 *
 * @author Felipe Rocha Ribeiro
 */
@Stateless
public class LivroEJB {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(name = "BibliotecaPU")
    EntityManager em;
    
    public void salvar(Livro livro){
       em.merge(livro);
    }

    public List<Livro> findAll(){
        Query query = em.createQuery("SELECT s FROM Livro s");
        return query.getResultList();
          //Outra forma possivel:
        //        return em.createQuery("SELECT s FROM Setor s").getResultList();
    }
    public void apagar(Livro livro){
        livro = em.merge(livro);
        em.remove(livro);
    }
    
    
}
