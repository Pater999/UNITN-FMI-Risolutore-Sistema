/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risolutoresistemamodulifmi;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 *
 * @author matti
 */
public class Risolutore {
    
    private int operatore1;
    private int operatore2;
    private int modulo1;
    private int modulo2;
    private int maxComDiv;
    private int a_b;
    private int k;
    private int euclideX;
    private int euclideY;
    private int risC;
    private int risC1;
    private int risultatoQuadra;
    private int esponente;
    
    public Risolutore(int op1, int op2, int mod1, int mod2)
    {
        operatore1 = op1;
        operatore2 = op2;
        modulo1 = mod1;
        modulo2 = mod2;
    }
    
    public Risolutore(int exp, int op, int mod)
    {
        esponente = exp;
        operatore1 = op;
        modulo1 = mod;
    }
    
    public String risolviSistema()
    {
        String testo = "";
        testo += "COMPATIBILITA' - Verifico che esista almeno una Sol.\n";
        testo += "Compatibile se (m,n) | a - b \n";
        testo += "Quindi: (" + modulo1 + "," + modulo2 + ") | " + operatore1 + "-" + operatore2 + "\n";
        if(this.compatibilità())
        {
            testo += "Poichè " + maxComDiv + " divide " + a_b + " allora \n";
            testo += "Il sistema è compatibile\n";
            testo += "Vale inoltre: a-b = k*(m,n)\n";
            testo += "Ovvero = " + a_b + " = " + k + "(" + modulo1 + "," + modulo2 + ") = " + k + "*" + maxComDiv + "\n";
            testo += "SOLUZIONE PARTICOLARE - Sfrutto l'algoritmo di euclide per trovare \n";
            testo += "x,y | xm + yn = (m,n)\n";
            this.algoritmoEuclide();
            testo += "x = " + euclideX + " y = " + euclideY + "\n";
            testo += "Quindi " + k + "*(" + euclideX + "*" + operatore1 +  "+" + euclideY + "*" + operatore2 + ") = " + k + "*" + "(" + modulo1 + "," + modulo2 + ")" + "\n";
            testo += "Il teorema cinese del resto richiede la forma \n";
            testo += "a + k*m = a + h*m";
            testo += operatore1 + "+" + (k*euclideX) + "*" + modulo1 + "=" + operatore2 + "+" + (k*euclideY) + "*" + modulo2 + "\n";
            this.teoremaCineseResto();
            testo += "Entrambi i membri danno " + risC + " che è soluzione particolare c del sistema";
            this.soluzioneQuadra();
            testo += "Sol(S)= [c]_["+ modulo1 + "," + modulo2 + "]\n";
            testo += "["+ modulo1 + "," + modulo2 + "] = " + modulo1 + "*" + modulo2  + "/" + maxComDiv + " = " + risultatoQuadra + "\n";
            while(!(risC1 >= 0 && risC1 <= risultatoQuadra))
            {
                if (risC1 > 0)
                {
                    risC1 -= risultatoQuadra;
                }
                else
                {
                    risC1 += risultatoQuadra;
                }
            }
            testo += "Quindi Sol(S) = [" + risC + "]" + "_" + "[" + risultatoQuadra + "]\n";
            testo += "Che è: Sol(S) = [" + risC1 + "]" + "_" + "[" + risultatoQuadra + "]\n";
            testo += "Sol(S) = {" + risC1 + " + k" + "*" + risultatoQuadra + " E Z | k E Z }";
        }   
        else
        {
            testo += "Poichè " + maxComDiv + " NON divide " + a_b + " allora \n";
            testo += "Il sistema NON è compatibile\n";
            testo += "Sol(S) = 0";
        }
        return testo;
    }
    
    public String risolviCongruenza()
    {
        String s = "";
        maxComDiv = mcd(operatore1, modulo1);
        s += "Poichè (" + operatore1 + "," + modulo1 + ") = " + maxComDiv + "\n";
        s += String.format("Sappiamo che %1$s è invertibile mod %2$s \n", operatore1, modulo1);
        s += String.format("%1$s E ( Z / %2$s Z ) \n", operatore1, modulo1);
        s += String.format("Se esiste una soluzione x dell'equazione allora deve essere invertibile modulo %1$s", operatore1, modulo1);
        s += String.format("Il numero di elementi è dato dalla funzione di Eulero applicata in %1$s \n", modulo1);
        
        
        
        return s;
    }
    
    
    
    public boolean compatibilità()
    {
        maxComDiv = mcd(modulo1, modulo2);
        a_b = operatore1 - operatore2;
        
        
        if(a_b % maxComDiv == 0)
        {
            k = a_b / maxComDiv;
            return true;
        }
        else
            return false;
    }
    
    public int[] algoritmoEuclide()
    {
        int x, y, coeff1, coeff2, coeff3, coeff4;
        ArrayDeque<Integer> pilaRisultati = new ArrayDeque<Integer>();
        ArrayDeque<Integer> pilaResti = new ArrayDeque<Integer>();
        ArrayDeque<Integer> pilaFattore1 = new ArrayDeque<Integer>();
        ArrayDeque<Integer> pilaFattore2 = new ArrayDeque<Integer>();
        
        pilaFattore1.push(modulo1);
        pilaFattore2.push(modulo2);
        pilaRisultati.push(-1*(modulo1 / modulo2));
        pilaResti.push(modulo1 % modulo2);

        
        while(pilaResti.peek() != maxComDiv)
        {
            pilaFattore1.push(pilaFattore2.peek());
            pilaFattore2.push(pilaResti.peek());
            pilaRisultati.push((pilaFattore1.peek() / pilaFattore2.peek())*-1);
            pilaResti.push(pilaFattore1.peek() % pilaFattore2.peek());
        }
        
        
       


        coeff1 = 1;
        coeff2 = pilaRisultati.pop();

 
        while(pilaRisultati.isEmpty() == false)
        {
           coeff3 = 1;
           coeff4 = pilaRisultati.pop();    
           x = coeff2;
           coeff2 = (coeff2 * coeff4) + coeff1;
           coeff1 = coeff3 * x;
        }
        
        x = coeff1;
        y = coeff2;  
        int[] vettore = new int[2];
        vettore[0] = x;
        vettore[1] = y;
        euclideX = x;
        euclideY = y;
        return vettore; 
    }
    
    
    public int teoremaCineseResto()
    {
        risC = operatore1 + (-1* k *euclideX*modulo1);
        risC1 = operatore2 + (k *euclideY*modulo2);
        
        if (risC == risC1)
        {
            return risC;
        }
        else
        {
            return 0;
        }
    }
    
    public int soluzioneQuadra()
    {
        risultatoQuadra = modulo1*modulo2/maxComDiv;
        return risultatoQuadra;
    }
    
    int mcd(int a, int b) {
        if (b == 0)
            return a;  
        else
            return mcd(b, a % b); 
    }
}
