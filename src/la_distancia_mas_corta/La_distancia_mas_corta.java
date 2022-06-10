
package la_distancia_mas_corta;

import java.nio.charset.StandardCharsets;
import javax.swing.JOptionPane;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class La_distancia_mas_corta {

    public static void main(String[] args) {
        
    //EMPEZANDO EL PROGRAMA :)
     
    //Definiendo variable para almacenar el numero de nodos
    int num_nodos;
    num_nodos = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el número de nodos"));
    
    //Definiendo variable de conversion numero ascci a caracter ascci
    char nombre_nodo_1, nombre_nodo_2;
    int codigo_ascci;
    
    //Definiendo variable de almacenamiento de valor de mensaje
    int respuesta;
    
    //Definiendo la matriz de distancias en funcion del numero de nodos
    String M_D[][];
    //Definiendo el tamaño de la matriz M_D
    M_D = new String[num_nodos][num_nodos];

    JOptionPane.showMessageDialog(null, "Matriz de Digrafo");
    
    JOptionPane.showMessageDialog(null,
    "Lo nodos se llamaran automaticamente en orden alfabetico\nPor ejemplo si usted elijio "
    + "4 nodos tendran nombres \"A B C D\n Tomelo en cuenta, pues al ingresar distancias "
            + "debera considerar a los nodos \nde su grafico con un nombre para que"
            + " los resultados coincidan al momento de consultar distancias minimas");
    
    //RELLENANDO LA MATRIZ DE DISTANCIAS
    
    for (int i = 0; i<num_nodos; i++){
        
        for (int j = 0; j<num_nodos; j++){
            
            if(i==j){
                M_D[i][j]= "0";
            }else{
                //Casteando los elementos de nuestros indices para convertirlos en letras
                //del abecedario
                codigo_ascci = i+65;
                nombre_nodo_1 = (char)codigo_ascci;
                codigo_ascci = j+65;
                nombre_nodo_2 = (char)codigo_ascci;

                respuesta = JOptionPane.showOptionDialog(null, "¿Hay direccionamiento del Nodo " + nombre_nodo_1 + " al Nodo " + nombre_nodo_2 + "?", "Ingreso de elementos de la matriz de distancias", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

                switch (respuesta) {
                    //CASO SE ELIJE NO 
                    case 1:
                        M_D[i][j]= "Infinito";
                        break;
                    //CASO SE ELIJE SI
                    case 0:
                        M_D[i][j]=JOptionPane.showInputDialog("Ingrese la distancia del del Nodo " + nombre_nodo_1 + " al Nodo " + nombre_nodo_2 + "?");
                        break;
                    //CASO SE CIERRA LA VENTANA 
                    default:
                        System.exit(0);
                }  
            }
            System.out.println(M_D[i][j]);
        }
    } 
    
    
//===========================================================================================================
    //Luego que M_D esta rellenada
    //Empezando a modificar nuestra matriz de distancias 
    
        //Definiendo una matriz unidimensional para 
        //filas disponbles y columnas disponibles
        int filas_y_columnas_disponibles[];
        
        //Definiendo el tamaño de la matriz unidimensional de filas y columnas disponibles
        filas_y_columnas_disponibles=new int[num_nodos-1];
        
        //Definiendo un contador
        int fil_col;
        
        //Definiendo mas variables...
        int suma_de_elementos=0;
        int valor_elemento_estatico_por_fila = 0,valor_elemento_en_barrido = 0, valor_elemento_interseccion = 0;
        boolean elemento_estatico_por_fila_es_un_numero, elemento_en_barrido_es_un_numero;
        int elemento_interseccion_fila=0,elemento_interseccion_columna=0;
        
        //Definiendo 2 matrices unidimensionales para almacenar las filas y
        //columnas posibles para el elemento interseccion 
        int filas_posibles_interseccion[],columnas_posibles_interseccion[];
        filas_posibles_interseccion = new int[2];
        columnas_posibles_interseccion = new int[2];
        
        //Definiendo valores de verdad para obtener los indices
        //de el elemento interseccion
        boolean v_v_1,v_v_2,v_v_3;
        
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
            
            for(int index_f=0;index_f<=num_nodos-2;index_f++){
                

                
                for(int index_c=0;index_c<=num_nodos-2;index_c++){
                    
                elemento_estatico_por_fila_es_un_numero = true;
                elemento_en_barrido_es_un_numero = true;
                
                    //Comprobando si el elemento estatico por fila es un numero
                    if(M_D[filas_y_columnas_disponibles[index_f]][u].chars().allMatch(Character::isDigit)){
                        valor_elemento_estatico_por_fila = Integer.parseInt(M_D[filas_y_columnas_disponibles[index_f]][u]);
                    }else{
                        elemento_estatico_por_fila_es_un_numero = false;
                    }
                    
                    //Comprobando si el elemento en barrido es un numero
                    if(M_D[u][filas_y_columnas_disponibles[index_c]].chars().allMatch(Character::isDigit)){
                        valor_elemento_en_barrido = Integer.parseInt(M_D[u][filas_y_columnas_disponibles[index_c]]);
                    }else{
                        elemento_en_barrido_es_un_numero = false;
                    }
                    
                    //Almacenando las filas y columnas posibles para el elemento interseccion
                    filas_posibles_interseccion[0]=filas_y_columnas_disponibles[index_f];
                    filas_posibles_interseccion[1]= u;
                    columnas_posibles_interseccion[0]=u;
                    columnas_posibles_interseccion[1]=filas_y_columnas_disponibles[index_c];

                    //OBTENIENDO LOS INDICES DEL ELEMENTO INTERSECCION
                    //=============================================================
                    
                    for(int fil_inter = 0; fil_inter<2;fil_inter++){
                    
                        for(int col_inter=0;col_inter<2;col_inter++){
                            
                            v_v_1 = (filas_posibles_interseccion[fil_inter]!=filas_y_columnas_disponibles[index_f])||(columnas_posibles_interseccion[col_inter]!=u);
                            v_v_2 = (filas_posibles_interseccion[fil_inter]!=u)||(columnas_posibles_interseccion[col_inter]!=filas_y_columnas_disponibles[index_c]);
                            v_v_3 = (filas_posibles_interseccion[fil_inter]!=u)||(columnas_posibles_interseccion[col_inter]!=u);
                                
                            if (v_v_1&&v_v_2&&v_v_3){

                                elemento_interseccion_fila = filas_posibles_interseccion[fil_inter];
                                elemento_interseccion_columna = columnas_posibles_interseccion[col_inter];

                            }
                        }
                    }
                    
                    
                    //=============================================================
                    
                    //Comprobando si el elemento interseccion es un numero
                    //en caso no sea un numero no se hara nada ya que se trata del
                    //infinito
                    if(M_D[elemento_interseccion_fila][elemento_interseccion_columna].chars().allMatch(Character::isDigit)){
                        
                        valor_elemento_interseccion = Integer.parseInt(M_D[elemento_interseccion_fila][elemento_interseccion_columna]);
                        //Comprobando si el valor de los dos elementos que forma el elemento interseccion
                        //son numeros
                        if(elemento_en_barrido_es_un_numero&&elemento_estatico_por_fila_es_un_numero){
                        suma_de_elementos = valor_elemento_estatico_por_fila + valor_elemento_en_barrido;
                            
                            if(suma_de_elementos<valor_elemento_interseccion){
                                M_D[elemento_interseccion_fila][elemento_interseccion_columna] = String.valueOf(suma_de_elementos);
                            }
                        }
                        
                    }else{
                        //Comprobando si el valor de los dos elementos que forma el elemento interseccion
                        //son numeros
                        if(elemento_en_barrido_es_un_numero&&elemento_estatico_por_fila_es_un_numero){
                            
                        suma_de_elementos = valor_elemento_estatico_por_fila + valor_elemento_en_barrido;
                        
                        M_D[elemento_interseccion_fila][elemento_interseccion_columna] = String.valueOf(suma_de_elementos);
                        
                        }
                        
                    }
                  
                }
                
            }
            
        }
    
    //CONSULTA Y SALIDA DE DATOS
    String nodo_de_inicio="", nodo_final="";
    
    int nodo_de_inicio_valor_ascci=0, nodo_final_valor_ascci=0;
    boolean el_caracter_esta_en_el_rango;
    boolean mas_consultas;
    
    mas_consultas=true;
    
        do {

            el_caracter_esta_en_el_rango = false;

            while(!el_caracter_esta_en_el_rango){

            nodo_de_inicio = JOptionPane.showInputDialog("Digite el nombre del nodo de inicio"); 
            nodo_de_inicio=nodo_de_inicio.toUpperCase();
            
            byte[]bytes = nodo_de_inicio.getBytes(StandardCharsets.US_ASCII);

            nodo_de_inicio_valor_ascci = bytes[0];

                if(65>nodo_de_inicio_valor_ascci&&nodo_de_inicio_valor_ascci>64+num_nodos){
                    JOptionPane.showMessageDialog(null, "El nombre que coloco no se encuentra en el rango del numero de nodos(" + num_nodos +")" );
                }else{
                    el_caracter_esta_en_el_rango = true;
                }
            }

            el_caracter_esta_en_el_rango = false;

            while(!el_caracter_esta_en_el_rango){

            nodo_final = JOptionPane.showInputDialog("Digite el nombre del nodo final"); 
            nodo_final = nodo_final.toUpperCase();
            
            byte[]bytes = nodo_final.getBytes(StandardCharsets.US_ASCII);

            nodo_final_valor_ascci = bytes[0];

                if(65>nodo_final_valor_ascci&&nodo_final_valor_ascci>64+num_nodos){
                    JOptionPane.showMessageDialog(null, "El nombre que coloco no se encuentra en el rango del numero de nodos(" + num_nodos +")" );
                }else{

                    if (nodo_final_valor_ascci==nodo_de_inicio_valor_ascci) {
                        JOptionPane.showMessageDialog(null, "El nombre del nodo final debe ser diferente al del nodo de inicio");
                    }else{
                        el_caracter_esta_en_el_rango = true;
                    }
                }

            }      
        
        JOptionPane.showMessageDialog(null, "La distancia minima del nodo \"" + nodo_de_inicio + "\" al nodo \"" + nodo_final + "\" es: " + M_D[nodo_de_inicio_valor_ascci - 65][nodo_final_valor_ascci - 65]);
            
        respuesta = JOptionPane.showOptionDialog(null, "¿Desea realizar mas consultas?", "CONSULTAS?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);    
        
        if(respuesta==1){
            mas_consultas=false;
        }

        } while(mas_consultas);

    }
}
