/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.modelo;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author shan
 */
public class AcessoBanco {

    private static AcessoBanco uniqueInstance = null;

    public static AcessoBanco getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new AcessoBanco();
        }
        return uniqueInstance;
    }

    private Usuario usuario = null;
    private List<Papel> papeis = null;

    private AcessoBanco() {
        papeis = new LinkedList<>();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean hasUsuario() {
        if (usuario == null) {
            return false;
        } else {
            return true;
        }
    }

    public List<Papel> getPapeis() {
        return papeis;
    }

    public void setPapeis(List<Papel> papeis) {
        this.papeis = papeis;
    }

}
