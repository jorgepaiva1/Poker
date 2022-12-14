/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jorge
 */
public class Carta {
    String Valor;
    String Palo;
    
    public Carta(String carta){
        Valor= String.valueOf(carta.charAt(0));
        Palo= String.valueOf(carta.charAt(1));
    }
    
    public void setValor(String valor){
        this.Valor=valor;
    }
    public void setPalo(String palo){
            this.Palo=palo;
    }
    public String getValor(){
        return Valor;
    }
    public String getPalo(){
        return Palo;
    }
    
    
    
}
