/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import java.io.File;

/**
 *
 * @author sham
 */
public class Algoritmos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        File amostraEstrela = new File("image_estrela.jpg");
        File imageEstrela = new File("image_estrela_completa_baixo.jpg");
        Image imagem = new Image(imageEstrela);
        Image amostra = new Image(amostraEstrela);
        
        //imagem.printValor();
        //amostra.printValor();
        //imagem.fatearValorArrayImagem(56, 56, amostra);
        
        
        Reconhecimento reconhecimento = new Reconhecimento(imagem, amostra);
        reconhecimento.reconhecer();
        //reconhecimento.printResultado();
        
    }
    
}
