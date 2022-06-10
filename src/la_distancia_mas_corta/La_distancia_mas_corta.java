
package la_distancia_mas_corta;

import javax.swing.JOptionPane;



public class La_distancia_mas_corta {

    public static void main(String[] args) {
        
    //EMPEZANDO EL PROGRAMA :)
     
    //Definiendo Variable
    int num_nodos;
    
    //Definiendo la matriz de distancias en funcion del numero de nodos
    String M_D[][];
    //Definiendo el tamaño de la matriz M_D
    M_D = new String[num_nodos-1][num_nodos-1];
    
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //Suponiendo que M_D esta rellenada
    //Empezando a modificar nuestra matriz de distancias 
    
        //Definiendo una matriz unidimensional para 
        //filas disponbles y columnas disponibles
        int filas_y_columnas_disponibles[];
        //Inicializando la matriz unidimensional de filas y columnas disponibles
        filas_y_columnas_disponibles=new int[num_nodos-2];
        //Definiendo varios contadores
        int fil_col;
        
        //Bucle de barrido de la matriz M_D
        for(int u = 0;u < num_nodos;u++){
            
            fil_col=0;
            //Obteniendo las filas y columnas disponibles de cada ciclo de u
            //en la matriz filas_y_columnas_disponibles[]
            //==================================================
            for(int k = 0;k <num_nodos;k++){
                
                if(k!=u){
                    filas_y_columnas_disponibles[fil_col]=k;
                    fil_col++;
                } 
            }
            //==================================================
            
            for(int index_f=0;index_f<num_nodos;index_f++){
                
                
                
                for(int index_c=0;index_c<num_nodos;index_c++){
                    
                    
                    
                }
                
            }
            
        }
    
}
