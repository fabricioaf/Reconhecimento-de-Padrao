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
 * @author sham
 */
public class Galeria {
    
    List<Imagem> imagens;

    public Galeria() {
        imagens = new LinkedList<>();
    }

    public List<Imagem> getImagens() {
        return imagens;
    }

    public void setImagens(List<Imagem> imagens) {
        this.imagens = imagens;
    }
    
    public Imagem getImagemById(int id){
        return imagens.get(id);
    }
    
    public void addImagem(Imagem imagem){
        imagens.add(imagem);
    }
    
    public boolean isEmpty(){
        return imagens.isEmpty();
    }
    
    public int getSize(){
        return imagens.size();
    }
    
}
