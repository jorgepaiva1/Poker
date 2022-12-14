/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author jorge
 */
public class Poker {
    ArrayList <Carta> Mano = new ArrayList<Carta>();
    int[] valores= new int[5];
    
    public Poker(String totalC){
        Carta cartas;
        int contar=0;
        String aux;
        for(int k=0;k<5;k++){
            aux=String.valueOf(totalC.charAt(contar));
            cartas= new Carta(aux.concat(String.valueOf(totalC.charAt(contar+1))));
            Mano.add(cartas);
            contar+=3;
        }
        valores=calculaValores();
    }
    
    public String EscaleraColor(){
        String escalera,color;
        
        escalera= Escalera();
        color=Color();
        
        if(escalera.toLowerCase().equals("escalera")&&color.toLowerCase().equals("color"))
            return "Escalera Color";
        else
            return "NO";
    }   //llama a escalera y color teniendo que cumplir ambos
    
    public String Poker(){
        int poker=1,fin=1;
        
        finpoker:
        for(int k=0;k<2;k++){
            for(int i=0;i<5;i++){
                if(valores[k]==valores[i]&&k!=i){
                    poker++;
                    if(poker==4){
                        poker=1;
                        fin=2;
                        continue finpoker;
                    }
                }
            }
            poker=1;
        }
        if(fin==2)
            return "Poker";
        else
            return "NO";
    }
    
    public String Full(){
        int full=0;
        ordenar();
        
        if(valores[0]==valores[1]&&valores[0]==valores[2]&&valores[3]==valores[4])
            full=3;
        if(valores[0]==valores[1]&&valores[2]==valores[3]&&valores[2]==valores[4])
            full=3;
        
        if(full==3)
            return "Full";
        else 
            return "NO";
        
    }
    
    public String Color(){
        int color=0;
        int cant=1;
        
        for(int k=1;k<5;k++){
            if(Mano.get(0).Palo.equals(Mano.get(k).Palo))
                cant++;
        }
        
        if(cant==5)
            return "Color";
        else
            return "NO";
    }
    
    public String Escalera(){
        int escalera=1;
        ordenar();
        
        for(int k=4;k>0;k--){
            if(valores[k]-1==valores[k-1]){   //compara el valor ultimo con el anterior 
                escalera++;
            }
        }
        
        if(valores[0]+1==valores[1]&&valores[0]+2==valores[2]&&valores[0]+3==valores[3]&&valores[0]+4==valores[4])
            escalera=5;
            
        if(valores[1]+1==valores[2]&&valores[1]+2==valores[3]&&valores[1]+3==valores[4]&&valores[0]==1)
            escalera=5;
        
        if(escalera==5)
            return "Escalera";
        else
            return "NO";
        
    }   //ya anda
            
    public String Trio(){
        int trio=1;
        ordenar();
        for(int k=0;k<4;k++){
            if(valores[k]==valores[k+1]){
                trio++;
                if (trio>=4){
                    trio=0;
                    break;
                }
            }
        }
        
        if((valores[0]!=valores[1]||valores[3]!=valores[4])&&trio==3)
            return "Trio";
        else
            return "NO";
    }
    
    public String ParDoble(){
        int par=0;
        ordenar();
        if(valores[0]==valores[1]&&valores[2]==valores[3]&&valores[0]!=valores[2]&&valores[0]!=valores[4])
            par=7;
        if(valores[1]==valores[2]&&valores[3]==valores[4]&&valores[1]!=valores[3]&&valores[1]!=valores[0])
            par=7;
        if(valores[0]==valores[1]&&valores[3]==valores[4]&&valores[0]!=valores[3]&&valores[0]!=valores[2])
            par=7;
        
        if(par==7)
            return "Pardoble";
        else 
            return "NO";
    }
    
    public String Par(){
        ordenar();
        int[] aux=new int[5];
           
        for(int k=0;k<5;k++){
            aux[k]=0;
            for(int i=0;i<5;i++){
                if(valores[k]==valores[i]&&k!=i){
                    aux[k]++;
                }
            }
        }
        if(aux[0]+aux[1]+aux[2]+aux[3]+aux[4]<3&&aux[0]+aux[1]+aux[2]+aux[3]+aux[4]>0)
            return "Par";
        else
            return "NO";
    }
    
    public String CartaAlta(){
        int mayor=0;
        ordenar();
        
        
            for(int k=0;k<valores.length;k++){
                if(valores[k]>mayor)
                    mayor=valores[k];
            }
            
        if(valores[0]==1)
            return "A";
        else if(mayor==10)
            return "T";
        else if(mayor==11)
            return "J";
        else if(mayor==12)
            return "Q";
        else if(mayor==13)
            return "K";
        else
            return mayor+"";
    }
    
    public void MostrarCartas(){
        
        System.out.println("\nlas cartas son:");// +Mano.get(0).Valor+Mano.get(1).Palo);
        
        for(int k=0;k<5;k++){
            if(k==4)
                System.out.println(Mano.get(k).Valor+Mano.get(k).Palo);
            else
                System.out.print(Mano.get(k).Valor+Mano.get(k).Palo+",");
        }
        //System.out.println("los valores:");  mostrar los valores numericas de las cartas
        /*for(int i=0;i<5;i++){
            System.out.println(valores[i]);
        }*/
    }
    
    public int[] calculaValores(){
        int[] aux=new int[5];
        Carta auxcart;
        
        
        for(int k=0;k<5;k++){
            auxcart=Mano.get(k);
            aux[k]=valorNumerico(auxcart);
        }
            
        return aux;
    }   //en un array se calcula los valores de las cartas
    
    public int valorNumerico(Carta c){
        int i;
        
        switch(c.Valor.toLowerCase()){
            case"a":
                i=1;
               break; 
            case"t":
                i=10;
                break;
            case"j":
                i=11;
                break;
            case"q":
                i=12;
                break;
            case"k":
                i=13;
                break;
            case"1":
            case"2":
            case"3":
            case"4":
            case"5":
            case"6":
            case"7":
            case"8":
            case"9":
                i=Integer.parseInt(c.Valor);
                break;
            default:
                i=0;
        }
        
        return i;
    }   //para calcular cuanto vale en numero
    
    public void ordenar(){
        int aux;
        for (int i=0;i<5;i++){
            for(int k=0;k<5;k++){
                if(valores[i]<valores[k]){
                    aux=valores[i];
                    valores[i]=valores[k];
                    valores[k]=aux;
                }
            }
        }
        
    }
    
    public static void main(String[] args){
        Scanner escanner = new Scanner(System.in);
        String mano;
        String resultado;
        System.out.println("Introduzca las cartas: ");
        mano= escanner.next();
        
        Poker poker = new Poker(mano);
        poker.MostrarCartas();
        
        resultado=poker.EscaleraColor();
        System.out.println("escalera color: "+resultado);
        
        resultado=poker.Poker();
        System.out.println("Poker: "+resultado);
        
        resultado=poker.Full();
        System.out.println("Full: "+resultado);
        
        resultado=poker.Color();
        System.out.println("Color: "+resultado);
        
        resultado=poker.Escalera();
        System.out.println("Escalera: "+resultado);
        
        resultado=poker.Trio();
        System.out.println("Trio: "+resultado);
        
        resultado=poker.ParDoble();
        System.out.println("Par Doble: "+resultado);
        
        resultado=poker.Par();
        System.out.println("Par: "+resultado);
        
        resultado=poker.CartaAlta();
        System.out.println("Carta Alta "+resultado);
        
    }
}
