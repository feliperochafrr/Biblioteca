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
import model.Emprestimo;

/**
 *
 * @author Felipe Rocha Ribeiro
 */
@Stateless
public class EmprestimoEJB {

    @PersistenceContext(name = "BibliotecaPU")
    EntityManager em;
    
    
    public void salvar(Emprestimo emprestimo){
       em.merge(emprestimo);
    }

    public List<Emprestimo> findAll(){
        Query query = em.createQuery("SELECT e FROM Emprestimo e");
        return query.getResultList();
          //Outra forma possivel:
        //        return em.createQuery("SELECT s FROM Setor s").getResultList();
    }
    public void apagar(Emprestimo emprestimo){
        emprestimo = em.merge(emprestimo);
        em.remove(emprestimo);
    }
}
