package burbuja;

import java.util.ArrayList;

public class Burbuja { 
    private int contador;

    public Burbuja() {
        contador = 0;
    }

    //Metodo de ordenamiento
    public void ordenar(ArrayList<Integer> lista) {
        //For para cada elemento
        for(int i2 = 0; i2<lista.size()-1 ; i2++){
            contador++;
            //For para ir subiendo de indice
            for(int j = 0 ; j<lista.size()-1; j++){
                contador++;
                int aux = lista.get(j);
                int aux2 = lista.get(j+1);
                //Comparar el indice con el indice superior
                if(aux>aux2){ 
                    //Cambiar posición  
                    lista.set(j,aux2);
                    lista.set(j+1, aux);
                    contador+=3;
                }
            }
        }
    }

    public int getContador() {
        return contador;
    }
}