package exp1_s1_grupo3;

import java.util.Random;

// Clase que representa una cuenta bancaria del cliente
public class Cuenta {
    // Atributos privados
    private static final Random rand = new Random(); // Generador de numeros aleatorios
    private String numeroCuenta;
    private int saldo;
    
    // Constructor - Crea una cuenta asignandole un numero aleatorio y un saldo inical igual a 0
    public Cuenta (){
        this.numeroCuenta = generarNumeroCuenta();
        this.saldo = 0; //Saldo Inicial
    }
    
    // Metodos getters
    public String getNumeroCuenta(){
        return numeroCuenta;
    }
    
    public int getSaldo(){
        return saldo;
    }
    
    // Metodo para generar numero aleatorio de la cuenta.
    private static String generarNumeroCuenta() {
        StringBuilder cuenta = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            cuenta.append(rand.nextInt(10));
        }
        return cuenta.toString();
    }
    
    // Metodo depositar, permite abonar a la cuenta si el monto > 0
    public boolean depositar (int monto){
        if (monto > 0 ){
            saldo += monto;
            System.out.println("\nDeposito exitoso. Nuevo saldo: $" + saldo + " pesos");
            return true;
        } else {
            System.err.println("\nMonto invalido. Debe ser mayor a 0.");
            return false;
        }
    }
    
    // Metodo girar, permite girar de la cuenta si ahi suficinete saldo y el monto es valido
    public boolean girar (int monto){
        if (monto <= 0){
            System.err.println("\nMonto invalido. Debe ser mayor a 0.");
            return false;
        } 
        
        if (monto > saldo) {
            System.err.println("\nSaldo insufiente. Saldo actual: $" + saldo + " pesos");
            return false;
        }

        saldo -= monto;
        System.out.println("\nGiro exitoso. Nuevo saldo: $" + saldo + " pesos");
        return true;        
    }
    
    // Metodo consultar saldo muestra el saldo actual de la cuenta
    public void consultarSaldo(){
        System.out.println("\nSaldo actual: $" + saldo + " pesos");
    }
}
