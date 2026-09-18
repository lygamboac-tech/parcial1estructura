
package parcial1;

import java.util.Scanner;

public class Parcial1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int opcion = 1;
        Funciones funciones = new Funciones ();
        
        while (opcion != 0){
            System.out.println("----------- CINE -----------");
            System.out.println("1. Registrar funciòn");
            System.out.println("2. Comprar entrada");
            System.out.println("3. Iniciar labores");
            System.out.println("0. Salir");
            opcion = sc.nextInt();
            sc.nextLine();
            int codigo = 0;
            String nombre;
            String hora;
            int puesto = 0;
            if (opcion < 0 ||  opcion > 3){
                System.out.println("ERROR, digite de nuevo");
                return;
            } 
            
            switch (opcion){
                case 1:
                    System.out.println("Codigo");
                    codigo = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Pelicula:");
                    nombre = sc.nextLine();

                    System.out.println("Hora:");
                    hora = sc.nextLine();
                    
                    funciones.Log(codigo, nombre, hora);
                    
                    break;
                case 2:
                    System.out.println("Codigo");
                    codigo = sc.nextInt();
                    
                    funciones.Buy(codigo);
                    break;
                case 3:
                    funciones.Start();
                    break;
            }
        }
        
    }
    
}
