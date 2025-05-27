package exp1_s1_grupo3;

import java.util.List;
import java.util.Scanner;

// Clase para validar entradas del usuario
public class Validador {
    
    // Metodo para validar entrada numerica dentro de un rango.
    public static int validarRangoEntero(Scanner sc, String mensaje, int min, int max) {
        int valor = -1;
        boolean valido = false;

        while (!valido) {
            System.out.print(mensaje);
            
            String entrada = sc.nextLine().trim();

            try {
                valor = Integer.parseInt(entrada);
                if (valor >= min && valor <= max) {
                    valido = true;
                } else {
                    System.err.println("Entrada fuera de rango. Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.err.println("Entrada invalida. Ingrese un numero valido.");
            }
        }
        return valor;
    }
    
    // Metodo para validar el ingreso de un RUT o permitir cancelar con 'c'.
    public static String validarRut(Scanner sc, String mensaje) {
        String rut = "";
        boolean rutValido = false;

        while (!rutValido) {
            System.out.print(mensaje);
            rut = sc.nextLine().trim();

            if (rut.equalsIgnoreCase("c")) {
                System.out.println("Registro cancelado.");
                return null;
            }

            if (rut.length() == 12) {
                char ultimo = rut.charAt(11);
                char guion = rut.charAt(10);
                char punto1 = rut.charAt(2);
                char punto2 = rut.charAt(6);

                if ((Character.isDigit(ultimo) || ultimo == 'k' || ultimo == 'K') &&
                    guion == '-' && punto1 == '.' && punto2 == '.') {

                    String parteNumerica = rut.substring(0, 2) + rut.substring(3, 6) + rut.substring(7, 10);

                    try {
                        Integer.parseInt(parteNumerica);
                        rutValido = true;
                    } catch (NumberFormatException e) {
                        System.err.println("Formato de RUT incorrecto. RUT contiene caracteres no numericos en la parte numerica (Ej: 12.345.678-9).");
                    }
                } else {
                    System.err.println("Formato de RUT incorrecto. RUT no sigue el patron correcto con puntos y guion (Ej: 12.345.678-9).");
                }

            } else if (rut.length() == 11) {
                char ultimo = rut.charAt(10);
                char guion = rut.charAt(9);
                char punto1 = rut.charAt(1);
                char punto2 = rut.charAt(5);

                if ((Character.isDigit(ultimo) || ultimo == 'k' || ultimo == 'K') &&
                    guion == '-' && punto1 == '.' && punto2 == '.') {

                    String parteNumerica = rut.substring(0, 1) + rut.substring(2, 5) + rut.substring(6, 9);

                    try {
                        Integer.parseInt(parteNumerica);
                        rutValido = true;
                    } catch (NumberFormatException e) {
                        System.err.println("Formato de RUT incorrecto. RUT contiene caracteres no numericos en la parte numerica (Ej: 12.345.678-9).");
                    }
                } else {
                    System.err.println("Formato de RUT incorrecto. RUT no sigue el patron correcto con puntos y guion (Ej: 12.345.678-9).");
                }

            } else {
                System.err.println("Formato de RUT incorrecto. RUT no contiene 11 o 12 caracteres (Ej: 12.345.678-9).");
            }
        }

        return rut;
    }
    
    // Metodo para validar que se pueda parsear un monto como entero.
    public static int validarMonto(Scanner sc, String mensaje) {
        int monto = -1;

            System.out.print(mensaje);
            String entrada = sc.nextLine().trim();
            
            if (entrada.equalsIgnoreCase("c")){
                System.out.println("Operacion cancelada.");
                return -1;
            }

            try {
                monto = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.err.println("\nEntrada invalida. Ingrese un numero entero.");
                return monto = -2;
            }

        return monto;
    }
    
    // Metodo que verifica si el RUT ya existe en la lista de clientes
    public static boolean esRutDuplicado(String rut, List<Cliente> clientes, String mensaje) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getRut().equalsIgnoreCase(rut)) {
                System.err.println(mensaje);
                return true;
            }
        }
        return false;
    }
}
