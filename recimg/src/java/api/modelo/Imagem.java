/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.modelo;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.Base64;
import javax.imageio.ImageIO;

/**
 *
 * @author sham
 */
public class Imagem extends Identificador {

    private String nome;
    private String tamanho;
    private String tipo;
    private BufferedImage image;
    private InputStream inputStream;

    public Imagem() {
    }

    public Imagem(int id, String nome, String tamanho, String tipo, InputStream inputStream) {
        super(id);
        this.nome = nome;
        this.tamanho = tamanho;
        this.tipo = tipo;
        this.inputStream = inputStream;
        try {
            this.image = ImageIO.read(inputStream);
        } catch (Exception e) {
        }

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public void setImage(InputStream inputStream) {
        try {
            this.image = ImageIO.read(inputStream);
        } catch (Exception e) {
        }
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }
    
    public String getLocalEquivalente(){
        switch(nome){
        case "Imagem Estrela Baixo":
            return "/recimg/static/img/image_estrela_completa_baixo.jpg";
        case "Imagem Estrela Meio":
            return "/recimg/static/img/image_estrela_completa_meio.jpg";
        case "Imagem Estrela Cima":
            return "/recimg/static/img/image_estrela_completa_cima.jpg";
        }
        return "/recimg/static/img/image_estrela_completa.jpg";
        
    }
    
}
