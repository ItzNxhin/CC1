package mergeSort;

import java.util.ArrayList;

public class MergeSort {
	int contador;
	
	public MergeSort(int contador) {
		this.contador=contador;
	}
	
	//MÉTODOS

    public int getContador() {
		return contador;
	}


	public void mergeSort(ArrayList<Integer> lista, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(lista, left, mid);  // Clasificar la mitad izquierda
            mergeSort(lista, mid + 1, right);  // Clasificar la mitad derecha

            ordenar(lista, left, mid, right);  // unir las dos mitades
            
            
        }
    }

    public void ordenar(ArrayList<Integer> lista, int left, int mid, int right) {
    	
        //Sublistas en las que se empiezan a ordenar
        ArrayList<Integer> izquierda = new ArrayList<Integer>(lista.subList(left, mid + 1)); 
        ArrayList<Integer> derecha = new ArrayList<Integer>(lista.subList(mid + 1, right + 1)); 

        int i = 0, j = 0;
        int k = left;

        // ordenar las dos sublistas
        while (i < izquierda.size() && j < derecha.size()) {      
        	contador+=3;
            if (izquierda.get(i) <= derecha.get(j)) {
            	contador+=1;
                lista.set(k, izquierda.get(i));
                contador+=1;
                i++;
                contador+=1;
            } else {
                lista.set(k, derecha.get(j));
                contador+=1;
                j++;
                contador+=1;
            }
            k++;
            contador+=1;
        }

        // COPIAR LOS ELEMENTOS DE LA IZQUIERDA
        while (i < izquierda.size()) {
            lista.set(k, izquierda.get(i));
            i++;
            k++;
        }

        // COPIAR LOS ELEMENTOS DELA DERECHA
        while (j < derecha.size()) {
            lista.set(k, derecha.get(j));
            j++;
            k++;
        }
    }
}
