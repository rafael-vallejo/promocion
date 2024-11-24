package promocion;

import java.util.Scanner;
import java.util.Random;

public class Main {
    private int numeroAleatorio; // Número aleatorio a adivinar
    private int intentosPermitidos; // Número de intentos permitidos
    private int rangoInicio; // Inicio del rango
    private int rangoFin; // Fin del rango

    // Constructor
    public Main(int rangoInicio, int rangoFin, int intentosPermitidos) {
        this.rangoInicio = rangoInicio;
        this.rangoFin = rangoFin;
        this.intentosPermitidos = intentosPermitidos;
        generarNumeroAleatorio();
    }

    // Genera un número aleatorio dentro del rango especificado
    private void generarNumeroAleatorio() {
        Random random = new Random();
        this.numeroAleatorio = random.nextInt(rangoFin - rangoInicio + 1) + rangoInicio;
    }

    // Inicia el juego
    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¡Bienvenido al juego de adivinar el número!");
        System.out.println("Intenta adivinar el número entre " + rangoInicio + " y " + rangoFin + ".");
        System.out.println("Tienes " + intentosPermitidos + " intentos. ¡Buena suerte!");

        int intentosRestantes = intentosPermitidos;
        boolean adivinado = false;

        while (intentosRestantes > 0) {
            System.out.print("Ingresa tu intento: ");
            int intentoJugador;

            // Validación de entrada
            try {
                intentoJugador = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingresa un número válido.");
                continue;
            }

            // Comparar el intento del jugador con el número aleatorio
            if (intentoJugador == numeroAleatorio) {
                System.out.println("¡Felicidades! Has adivinado el número.");
                adivinado = true;
                break;
            } else if (intentoJugador < numeroAleatorio) {
                System.out.println("Tu intento es demasiado bajo.");
            } else {
                System.out.println("Tu intento es demasiado alto.");
            }

            intentosRestantes--;
            System.out.println("Te quedan " + intentosRestantes + " intentos.");
        }

        if (!adivinado) {
            System.out.println("Lo siento, te quedaste sin intentos.");
            System.out.println("El número correcto era: " + numeroAleatorio);
        }

        System.out.println("Gracias por jugar.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Juego de Adivinar el Número ===");
        System.out.println("1. Jugar");
        System.out.println("2. Salir");

        int opcion;
        while (true) {
            System.out.print("Selecciona una opción: ");
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                if (opcion == 1 || opcion == 2) {
                    break;
                } else {
                    System.out.println("Por favor, selecciona una opción válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingresa un número válido.");
            }
        }

        if (opcion == 1) {
            // Configuración del juego
            System.out.print("Ingresa el rango inicial: ");
            int rangoInicio = Integer.parseInt(scanner.nextLine());
            System.out.print("Ingresa el rango final: ");
            int rangoFin = Integer.parseInt(scanner.nextLine());
            System.out.print("Ingresa el número de intentos permitidos: ");
            int intentosPermitidos = Integer.parseInt(scanner.nextLine());

            // Crear instancia del juego y comenzar
            Main juego = new Main(rangoInicio, rangoFin, intentosPermitidos);
            juego.iniciar();
        } else {
            System.out.println("¡Gracias por visitar el juego!");
        }

        scanner.close();
    }
}
