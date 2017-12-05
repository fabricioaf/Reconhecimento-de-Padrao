/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author sham
 */
public class Image {
    private int x;
    private int y;
    private BufferedImage image;
    private double valor[][];
    private double valorArray[];

    public Image() {
    }

    public Image(File file){
        try{
            this.image = ImageIO.read(file);
            this.x = image.getWidth();
            this.y = image.getHeight();
              
            
        }catch(Exception e){
            System.out.println("### Falhas ao abrir File image ###");
        }
        this.valorArray = new double[x*y];
        this.valor = buscaValor();
    }

    private double[][] buscaValor() {
        Raster raster = image.getData();
        double[][] array = new double[y][x];
        double z[] = null;
        int c = 0;
        for(int i=0;i<y;i++){
            for(int j=0;j<x;j++){
                double pixel = raster.getPixel(j, i, z)[0];
                this.valorArray[c] = pixel;
                array[i][j] = pixel;
            }
        }
        System.out.println(String.format("Entradas tamanho( %dx x %dy)", x,y));
        return array;
    }
    
    public void printValor(){
        for(int i=0;i<valor.length;i++){
            System.out.print(i+": ");
            for(int j=0;j<valor[i].length;j++){
                System.out.print(valor[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println(valor.length +" X " + valor[0].length );
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public double[][] getValor() {
        return valor;
    }

    public void setValor(double[][] valor) {
        this.valor = valor;
    }

    public double[] getValorArray() {
        return valorArray;
    }

    public void setValorArray(double[] valorArray) {
        this.valorArray = valorArray;
    }
    
    public double[] fatearValorArrayImagem(int dx, int dy, Image amostra) {
        int tamanho_x = amostra.getX() + dx;
        int tamanho_y = amostra.getY() + dy;
        double[] array = new double[amostra.getX()*amostra.getY()];
        int count = 0;
        for (int cy = dy; cy < tamanho_y; cy++) {
            for(int cx = dx; cx < tamanho_x; cx++){
                array[count] = valor[cy][cx];
                count++;
                System.out.print(valor[cy][cx]+" ");
            }
            System.out.println("");
        }
        return array;
    }
    
}
