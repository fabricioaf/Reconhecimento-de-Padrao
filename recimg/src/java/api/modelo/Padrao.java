/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.modelo;

import java.awt.image.BufferedImage;

/**
 *
 * @author sham
 */
public class Padrao extends Identificador {

    private String nome;
    private BufferedImage padrao;

    public Padrao() {
    }

    public Padrao(int id, String nome, BufferedImage padrao) {
        super(id);
        this.nome = nome;
        this.padrao = padrao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BufferedImage getPadrao() {
        return padrao;
    }

    public void setPadrao(BufferedImage padrao) {
        this.padrao = padrao;
    }

    

}
