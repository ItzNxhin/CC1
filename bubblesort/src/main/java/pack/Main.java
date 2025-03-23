package pack;

import java.util.ArrayList;
import java.util.Random;

public class Main { 
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        Random x = new Random();
        int y;

        for(int i = 0; i<10; i++){
            lista.add(x.nextInt(11)+1);
        }

        System.out.println(lista);

        for(int i2 = 0; i2<lista.size()-1 ; i2++){
            for(int j = 0 ; j<lista.size()-1; j++){
                int aux = lista.get(j);
                int aux2 = lista.get(j+1);
                if(aux>aux2){   
                    lista.set(j,aux2);
                    lista.set(j+1, aux);
                }
                System.out.println(lista);
            }
        }

        System.out.println(lista);
    }


}