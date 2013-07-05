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
import model.Livro;
import view.LivroEJB;

/**
 *
 * @author Felipe Rocha Ribeiro
 */
@ManagedBean
@RequestScoped
public class LivroMB implements Serializable{

    @EJB
    LivroEJB livroEJB;
    private Livro livro;
    
    public LivroMB() {
        livro = new Livro();
        
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    public void salvar(){
        try {
        livroEJB.salvar(livro);
        livro = new Livro();
        } 
        catch (Exception e) {
        System.out.println(e);
    }
    }
   public List<Livro> findAll(){
        try {
        livro = new Livro();
        return livroEJB.findAll();
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
       //return "aqui vai a tabela";
    }
   public void apagar(Livro livro){
       try {
        livroEJB.apagar(livro);
        } 
        catch (Exception e) {
        System.out.println(e);
    }
    }
   public void editar(Livro livro){
       this.livro = livro;
    }
}
