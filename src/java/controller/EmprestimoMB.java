/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.Emprestimo;
import view.EmprestimoEJB;

/**
 *
 * @author Felipe Rocha Ribeiro
 */
@ManagedBean
@RequestScoped
public class EmprestimoMB implements Serializable{

    @EJB
    EmprestimoEJB emprestimoEJB;
    private Emprestimo emprestimo;
    
    public EmprestimoMB() {
        emprestimo = new Emprestimo();
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }
    public void salvar(){
        try {
        emprestimoEJB.salvar(emprestimo);
        emprestimo = new Emprestimo();
        } 
        catch (Exception e) {
        System.out.println(e);
    }
    }
   public List<Emprestimo> findAll(){
        try {
        emprestimo = new Emprestimo();
        return emprestimoEJB.findAll();
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
       //return "aqui vai a tabela";
    }
   public void apagar(Emprestimo emprestimo){
       try {
        emprestimoEJB.apagar(emprestimo);
        } 
        catch (Exception e) {
        System.out.println(e);
    }
    }
   public void editar(Emprestimo empresitmo){
       this.emprestimo = emprestimo;
    }
}
