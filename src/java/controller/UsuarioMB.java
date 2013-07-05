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
import model.Usuario;
import view.UsuarioEJB;

/**
 *
 * @author Felipe Rocha Ribeiro
 */
@ManagedBean
@RequestScoped
public class UsuarioMB implements Serializable{

    @EJB
    UsuarioEJB usuarioEJB;
    private Usuario usuario;
    
    public UsuarioMB() {
        usuario = new Usuario();
        
    }

    public UsuarioEJB getUsuarioEJB() {
        return usuarioEJB;
    }

    public void setUsuarioEJB(UsuarioEJB usuarioEJB) {
        this.usuarioEJB = usuarioEJB;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void salvar(){
        try {
        usuarioEJB.salvar(usuario);
        usuario = new Usuario();
        } 
        catch (Exception e) {
        System.out.println(e);
    }
    }
   public List<Usuario> findAll(){
        try {
        usuario = new Usuario();
        return usuarioEJB.findAll();
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
       //return "aqui vai a tabela";
    }
   public void apagar(Usuario usuario){
       try {
        usuarioEJB.apagar(usuario);
        } 
        catch (Exception e) {
        System.out.println(e);
    }
    }
   public void editar(Usuario usuario){
       this.usuario = usuario;
    }
}
