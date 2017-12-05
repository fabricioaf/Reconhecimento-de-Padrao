/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import java.text.DecimalFormat;
import java.util.Arrays;
import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;

/**
 *
 * @author sham
 */
public class Reconhecimento {
    
   private int limiteX;
   private int limiteY;
   private Image imagem;
   private Image amostra;
   private double resultados[];

    public Reconhecimento() {
    }

    public Reconhecimento(Image imagem, Image amostra) {
        this.imagem = imagem;
        this.amostra = amostra;
        limiteX = imagem.getX()- amostra.getX();
        limiteY = imagem.getY() - amostra.getY();
        resultados = new double[limiteX*limiteY]; 
    }

    public double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
   public void reconhecer() {
        PearsonsCorrelation pc = new PearsonsCorrelation();
        int count = 0;
        int index[] = {0,0};
        double valor = 2;
        System.out.print("0: ");
        for(int dy=0;dy<limiteY;dy++){
            for(int dx=0;dx<limiteX;dx++){
                double[] arrayImagem = criarArrayImagem(dx, dy);
                double resultado = pc.correlation(amostra.getValorArray(), arrayImagem);
                System.out.print(String.format("%.2f | ", pc.correlation(arrayImagem, amostra.getValorArray())));
                if(resultado <= valor){
                    valor = resultado;
                    index[0] = dx;
                    index[1] = dy;
                }
                //resultado = round(resultado, 3);
                resultados[count] = resultado;
                
            }
            System.out.print("\n"+count+": ");
            count++;
        }
        System.out.println(String.format("Menor Valor : %.2f  index: %dx %dy ", valor, index[0], index[1]));
        
    }

    private double[] criarArrayImagem(int dx, int dy) {
        int tamanho_x = amostra.getX() + dx;
        int tamanho_y = amostra.getY() + dy;
        double imagemValor[][] = imagem.getValor();
        double[] array = new double[amostra.getX()*amostra.getY()];
        int count = 0;
        for (int y = dy; y < tamanho_y; y++) {
            for(int x = dx; x < tamanho_x; x++){
                array[count] = imagemValor[y][x];
                count++;
            }
        }
        return array;
    }
    
    public void printResultado(){
        double maior = -2;
        double menor = 2;
        int count = 0;
        for(int i=0; i < resultados.length; i++){
            System.out.print(String.format("%.2f | ", resultados[i]));
            if(maior <= resultados[i]){
                maior = resultados[i];
            }
            if(i%40==0){
                System.out.println(count+": ");
                count++;
                
            }
        }
        double copy[] = resultados;
        Arrays.sort(copy);
        
        System.out.println("\nMenor = "+copy[0]);
        System.out.println("Maior = "+maior);
        System.out.println("Maior Final = "+copy[copy.length-1]);
    }
    
}
