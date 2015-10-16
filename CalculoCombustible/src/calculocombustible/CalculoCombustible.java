/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculocombustible;
import java.util.*;
/**
 *
 * @author neftali
 */
public class CalculoCombustible {

    /**
     * @param args the command line arguments
     */
    public static double ajustarPesos(double pesoAnterior, double valorEsperado, double entradaI){
        double nuevoPeso= pesoAnterior+0.5*valorEsperado*entradaI;
        return (nuevoPeso);
    }
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner Read = new Scanner(System.in);        
        
        //Variables de entrada
        double entrada[] = new double[11];
        //Variable de salida
        double salida;
        //Salida esperada
        double salidaEsperada;
        //Pesos de variables entrada
        double pesos[] = new double[11];
        //Pesos capa oculta
        double W[] = new double[19];
        
        double WX[] = new double[11];
        System.out.println("Ingrese Roce Piso: ");
        entrada[0] = Read.nextDouble();
        
        System.out.println("Ingrese Roce Aire: ");
        entrada[1] = Read.nextDouble();
        
        System.out.println("Ingrese Aerodinamica: ");
        entrada[2] = Read.nextDouble();
        
        System.out.println("Ingrese Peso Vehiculo: ");
        entrada[3] = Read.nextDouble();
        
        System.out.println("Ingrese Tipo Camino: ");
        entrada[4] = Read.nextDouble();
        
        System.out.println("Ingrese Aceleracion: ");
        entrada[5] = Read.nextDouble();
        
        System.out.println("Ingrese Cantidad de frenados: ");
        entrada[6] = Read.nextDouble();
        
        System.out.println("Pendiente: ");
        entrada[7] = Read.nextDouble();
        
        System.out.println("Ingrese Rendimiento: ");
        entrada[8] = Read.nextDouble();
        
        System.out.println("Ingrese Distancia: ");
        entrada[9] = Read.nextDouble();
        
        System.out.println("Ingrese Velocidad: ");
        entrada[10] = Read.nextDouble();
        
        System.out.println("Ingrese Salida Esperada: ");
        salidaEsperada = Read.nextDouble();
        
        //Valores de pesos para variables de entrada
        pesos[0]= 0.06; pesos[1]= 0.06; pesos[2]= 0.06; pesos[3]= 0.06;
        pesos[4]= 0.06; pesos[5]= 0.08; pesos[6]= 0.06; pesos[7]= 0.06;
        pesos[8]= 0.17; pesos[9]= 0.17; pesos[10]= 0.16;
        //Valores peso para  la variable de capa oculta
        W[0]= 0.06; W[1]= 0.06; W[2]= 0.06; W[3]= 0.06; W[4]= 0.06;
        W[5]= 0.08; W[6]= 0.06; W[7]= 0.06; W[8]= 0.17; W[9]= 0.17;
        W[10]= 0.16; W[11]= 0.12; W[12]= 0.2; W[13]= 0.33; W[14]= 0.18;
        W[15]= 0.3; W[16]= 0.5; W[17]= 0.67; W[18]= 0.1;
        
        //Capa de entrada
        /*for(int i= 0; i<11; i++)
        {
            WX[i]= pesos[i]*entrada[i];
            System.out.println("Valor "+i+" es: "+WX[i]);
        }*/
        boolean resultado= false;
        double A,B,C,D,E,F,G,H;
        double WA,WB,WC,WD,WE,WF,WG,WH;
        double factorDeAprendizaje= 0.5;
        
        while(resultado == false){
            //Nivel Uno
            //A= Roce Piso+Roce Aire
            A= WX[0]+WX[1];
            WA= A*W[11];
            //B= aceleracion*Cant.Frenado*Pendiente
            B= WX[5]*WX[6]*WX[7];
            WB= B*W[12];
            //C= Distancia/Velocidad 
            C= WX[9]/WX[10];
            WC= C*W[13];
            //Nivel Dos
            //D= A*Aerodinamica
            D= A/WX[2];
            WD= D*W[14];
            //Nivel tres
            //E= Peso*TipodeCamino
            E= WX[3]*WX[4]*D;
            WE= E*W[15];
            //Nivel Cuatro
            F= E/B;
            WF= F*W[16];
            //Nivel cinco
            G= F/WX[8];
            WG= G*W[17];
            //Nivel seis
            H= G*C;
            
            if(H== salidaEsperada){
                System.out.print("Salida es: "+H);
            }else{
                
            }
        }
        
    }
    
}
