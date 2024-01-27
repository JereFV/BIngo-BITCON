/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLógica;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jerem
 */
public class Bingo {
    private String generacionNumeros;
    private String sistemaNumerico;
    private int[][][] tableros;
    private boolean[][][] patrones;
    private String[] titulosPatrones;
    private List<Integer> numerosGanadores;
    private int patronSeleccionado;
    private int cantidadNumerosPatron;
    private List<Integer> cartonesGanadores;
   
    public Bingo(){
        generacionNumeros = "";
        sistemaNumerico = "";
        tableros = new int[100][6][6];
        patrones = new boolean[3][6][6];
        titulosPatrones = new String[3];
        numerosGanadores = new ArrayList();
        cantidadNumerosPatron = 0;
        cartonesGanadores = new ArrayList();
    }

    public void setGeneracionNumeros(String generacionNumeros) {
        this.generacionNumeros = generacionNumeros;
    }

    public void setSistemaNumerico(String sistemaNumerico) {
        this.sistemaNumerico = sistemaNumerico;
    }
    
    public void setPatronSeleccionado(int patron) {
        this.patronSeleccionado = patron;
    }
    
    public String getTitulosPatrones(int posicion){
        return titulosPatrones[posicion];
    }
    
    public String getGeneracionNumeros(){
       return generacionNumeros;
    }
    
    public String getTituloPatronElegido(){
        return titulosPatrones[patronSeleccionado];
    } 
    
    //Al reiniciar la partida se remueven los elementos de las listas
    public void limpiarNumerosGanadores(){
        numerosGanadores.removeAll(numerosGanadores);
    }
    
    public void limpiarCartonesGanadores(){
        cartonesGanadores.removeAll(cartonesGanadores);
    }
    
    public void limpiarCantidadElementosPatron(){
        cantidadNumerosPatron = 0;
    }
    
    public void generarTableros(){
        for(int i= 0; i<tableros.length; i++){
            for(int j= 0; j<tableros[i].length; j++){           
                for(int z= 0; z<tableros[i][j].length; z++){
                    /*Se hace un recorrido de la matriz tridimensional y con un switch se asignan los valores
                    de cada celda según la columna*/
                    switch (z){
                        case 0:
                            tableros[i][j][z]= validarRepetidos(i, z, 15, 1);                           
                            break;
                        case 1:
                            tableros[i][j][z]= validarRepetidos(i, z, 16, 16);                            
                            break;
                        case 2:
                            tableros[i][j][z]= validarRepetidos(i, z, 16, 32);                           
                            break;
                        case 3:
                            tableros[i][j][z]= validarRepetidos(i, z, 16, 48);                            
                            break;
                        case 4:
                            tableros[i][j][z]= validarRepetidos(i, z, 16, 64);                            
                            break;
                        case 5:
                            tableros[i][j][z]= validarRepetidos(i, z, 16, 80);                            
                            break;                                                 
                    }                              
                }
            }
        }   
    }
    
    //Método para validar que no existan números repetidos en los cartones
    public int validarRepetidos(int tablero, int columna, int multiplicador, int numeroSuma){
        int numeroTemporal = (int)(Math.random()*multiplicador)+ numeroSuma;
        for(int i=0; i<6; i++){
            if (numeroTemporal == tableros[tablero][i][columna])
                //En caso de encontrar repetidos entra en un ciclo de llamadas al mismo método, hasta generar un número que no esté en el tablero.
                numeroTemporal = validarRepetidos(tablero, columna, multiplicador, numeroSuma);                  
        }
        return numeroTemporal;
    }
    
    //Se guarda el patrón de juego digitado por el usuario desde la vista. Se utilizan booleanos para posterior manejamiento de estos patrones.
    public void guardarPatrones(boolean matriz[][], int posicion, String[] titulos){
        for(int i=0; i<6; i++){
           for(int j=0; j<6; j++){
               patrones[posicion][i][j] = matriz[i][j];            
           } 
        }
        //Se guarda el título de cada patrón en un arreglo
        titulosPatrones[posicion] = titulos[posicion];
    }
    
    //Calcula la cantidad de números que deben coincidir según el patrón seleccionado para considerar a un cartón ganador.
    public void calcularNumerosPatron(){
        for(int i=0; i<patrones[patronSeleccionado].length; i++){
            for(int j=0; j<patrones[patronSeleccionado][i].length; j++){
                if(patrones[patronSeleccionado][i][j])
                    cantidadNumerosPatron++;           
            }
        }
    }
    
    /*Se formatea el número al sistema númerico seleccionado*/
    public String setearValoresCarton(int carton, int fila, int columna){
        String numero = "";      
        switch(sistemaNumerico.split(" ")[0]){
            case "Quinario":
                numero = decimalAQuinario(tableros[carton][fila][columna]);
                break;
            case "Octal":
                numero = decimalAOctal(tableros[carton][fila][columna]);
                break;
            case "Decimal":
                numero = String.valueOf(tableros[carton][fila][columna]);
                break;
            case "Duodecimal":
                numero = decimalADuodecimal(tableros[carton][fila][columna]);
                break;
            case "Hexadecimal":
                numero = decimalAHexadecimal(tableros[carton][fila][columna]);
                break;
        }
        return numero;
    }
    
    //CONVERSIONES DE NÚMEROS A DECIMALES A LOS DEMÁS SISTEMAS NÚMERICOS
    public String decimalAQuinario(int decimal) {
        int residuo;
        String quinario = "";
        char[] caracteresQuinarios = {'0', '1', '2', '3', '4'};
        while (decimal > 0) {
            residuo = decimal % 5;
            char caracter = caracteresQuinarios[residuo];
            quinario = caracter + quinario;
            decimal = decimal / 5;
        }
        return quinario;
    }
    
    public String decimalAOctal(int decimal) {
        int residuo;
        String octal = "";
        char[] caracteresOctales = {'0', '1', '2', '3', '4', '5', '6', '7'};
        while (decimal > 0) {
            residuo = decimal % 8;
            char caracter = caracteresOctales[residuo];
            octal = caracter + octal;
            decimal = decimal / 8;
        }
        return octal;
    }
    
    public String decimalADuodecimal(int decimal) {
        int residuo;
        String duodecimal = "";
        char[] caracteresDuodecimales = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B'};
        while (decimal > 0) {
            residuo = decimal % 12;
            char caracter = caracteresDuodecimales[residuo];
            duodecimal = caracter + duodecimal;
            decimal = decimal / 12;
        }
        return duodecimal;
    }
    
    public String decimalAHexadecimal(int decimal) {
        int residuo;
        String hexadecimal = "";
        char[] caracteresHexadecimales = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        while (decimal > 0) {
            residuo = decimal % 16;
            char caracterHexadecimal = caracteresHexadecimales[residuo];
            hexadecimal = caracterHexadecimal + hexadecimal;
            decimal = decimal / 16;
        }
        return hexadecimal;
    }
    
    //Valida si el número ya salió y además si se encuentra en una de las posiciones en el patrón de juego
    public boolean validarNumeroGanador(int carton, int fila, int columna){
        for(Integer numero: numerosGanadores){
            if(tableros[carton][fila][columna] == numero && patrones[patronSeleccionado][fila][columna])
                return true;
        }
        return false;
    }
    
    /*Valida si el número digitado por el usuario ya fue digitado anteriormente. (cuando la generación de números es manual.*/
    public boolean validarNumeroDigitadoRepetido(int numero){
        for(Integer num: numerosGanadores){
            if(numero == num)                   
                return true;     
        }
        return false;
    }
    
    /*Este método contiene toda la lógica para el manejo de la comparación entre los campos de los cartones y el número generado.
    Además de la validación si hay cartones ganadores en algún momento de la partida.*/
    public String ejecutarRondaJuego(int pnumero){
        String númeroGenerado = "";
        int aciertos = 0, numero;
        boolean repetido = false;
        
        //Genera el número de forma aleatoria, además corrobora que ese número no haya salido anteriormente.
        if(pnumero==0){            
            do{
              numero = (int)(Math.random()*95)+1;
              repetido = false;
              for(Integer num: numerosGanadores){
                if(numero == num){
                    repetido = true;
                    break;
                }                                    
              }  
            }while(repetido);            
        }else
            numero = pnumero;
        //Se agrega el número a la lista
        numerosGanadores.add(numero);
        
        //Recorrido de cartones, buscando si hay ganadores
        for(int i=0;i<tableros.length;i++){
            for(int j=0;j<tableros[i].length;j++){
                for(int z=0;z<tableros[i][j].length;z++){
                    /*Se valida si el valor de la celda conincide con algunos de los números que han salido,
                    además que el número se encuentra en algunas de las posiciones definidas en el patrón por el usuario.*/
                    for(Integer num: numerosGanadores){
                        if(num == tableros[i][j][z] && patrones[patronSeleccionado][j][z]){
                            aciertos++;
                            break;
                        }                                                   
                    }           
                }            
            }
            
            //Si la cantidad de aciertos es igual a la cantidad de posiciones definidas en el patrón, quiere decir que el cartón acaba de ganar.
            if(aciertos == cantidadNumerosPatron)
                cartonesGanadores.add(i);
            aciertos = 0;          
        }
        
        //Devuelve el número generado o digitado en formato decimal y en el formato númerico seleccionado.
        switch(sistemaNumerico.split(" ")[0]){
            case "Quinario":
                númeroGenerado = (generacionNumeros.equals("Automático") ? "Número generado: " : "Número ingresado: ") + "-Formato quinario: " + decimalAQuinario(numero) + "\n" + "-Formato decimal: " + numero;
                break;
            case "Octal":
                númeroGenerado = (generacionNumeros.equals("Automático") ? "Número generado: " : "Número ingresado: ") + "-Formato octal: " + decimalAOctal(numero) + "\n" + "-Formato decimal: " + numero;
                break;
            case "Decimal":
                númeroGenerado = (generacionNumeros.equals("Automático") ? "Número generado: " : "Número ingresado: ") + numero;
                break;
            case "Duodecimal":
                númeroGenerado = (generacionNumeros.equals("Automático") ? "Número generado: " : "Número ingresado: ") + "-Formato duodecimal: " + decimalADuodecimal(numero) + "\n" + "-Formato decimal: " + numero;
                break;
            case "Hexadecimal":
                númeroGenerado = (generacionNumeros.equals("Automático") ? "Número generado: " : "Número ingresado: ") + "-Formato hexadecimal: " + decimalAHexadecimal(numero) + "\n" + "-Formato decimal: " + numero;
                break;
        }
        return númeroGenerado;           
    }
    
    //Valida si hay algún cartón ganador, de lo contrario retorna una cadena vacía
    public String validarCartonesGanadores(){
        String ganadores = "";
        if(cartonesGanadores.size() == 1)
            ganadores = "¡El cartón " + (cartonesGanadores.get(0) + 1000) + " es el ganador!";
        else if(cartonesGanadores.size() > 1){
            ganadores = "¡Hay varios cartones ganadores!: " + "\n";
            for(Integer carton: cartonesGanadores){
                ganadores+= "-" + (carton + 1000) + "\n";
            }
        }
        return ganadores;
    }


    
}
