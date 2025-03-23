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

            mergeSort(lista, left, mid);  // Sort the left half
            mergeSort(lista, mid + 1, right);  // Sort the right half

            ordenar(lista, left, mid, right);  // Merge the two halves
            
            
        }
    }

    public void ordenar(ArrayList<Integer> lista, int left, int mid, int right) {
    	
        //Sublistas en las que se empiezan a ordenar
        ArrayList<Integer> izquierda = new ArrayList<Integer>(lista.subList(left, mid + 1)); // [left, mid]
        ArrayList<Integer> derecha = new ArrayList<Integer>(lista.subList(mid + 1, right + 1)); // [mid + 1, right]

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

        // Copy remaining elements of izquierda
        while (i < izquierda.size()) {
            lista.set(k, izquierda.get(i));
            i++;
            k++;
        }

        // Copy remaining elements of derecha
        while (j < derecha.size()) {
            lista.set(k, derecha.get(j));
            j++;
            k++;
        }
    }
}
