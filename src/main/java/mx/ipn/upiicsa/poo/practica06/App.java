package mx.ipn.upiicsa.poo.practica06;

import java.util.Scanner;

import mx.ipn.upiicsa.poo.practica06.UI.CommandControl;
import mx.ipn.upiicsa.poo.practica06.UI.Menu;

public class App {
    public static void main(String[] args) {
        // Verifica si hay argumentos, si no, permite al usuario elegir un modo de operación
        if (args.length == 0) {
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("Seleccione modo de uso:");
                System.out.println("-m -> menú");
                System.out.println("-p -> uso de argumentos");
    
                String modo = scanner.next();
    
                // Limpia el salto de línea pendiente
                scanner.nextLine();
    
                // Ejecuta la calculadora en modo menú
                if (modo.equals("-m")) {
                    new Menu().mostrarMenu();
                // Ejecuta la calculadora en modo de argumentos y pide los argumentos necesarios
                } else if (modo.equals("-p")) {
                    System.out.println("Ingrese la operación y los números separados por espacios (Ejemplo: -re 9.9):");
                    String input = scanner.nextLine().trim();
    
                    // Convierte la entrada en un arreglo de argumentos y llama a modoComando
                    String[] userArgs = input.split("\\s+");
                    CommandControl.modoComando(userArgs);
                } else {
                    System.out.println("Opción no válida.");
                }
            }
        } else {
            // Si hay argumentos, se ejecuta en modo comando directamente
            CommandControl.modoComando(args);
        }
    }
}
