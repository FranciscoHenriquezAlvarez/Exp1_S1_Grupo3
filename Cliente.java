package exp1_s1_grupo3;

// Clase que representa a un cliente del banco
public class Cliente {
    // Atributos privados
    private String rut;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String domicilio;
    private String comuna;
    private String telefono;
    private Cuenta cuenta;
    private String contrasena;
    
    // Constructor - Crea automaticamente una cuenta bancaria con saldo 0
    public Cliente (String rut, String nombre, String apellidoPaterno, 
            String apellidoMaterno, String domicilio, String comuna, 
            String telefono, String contrasena){
        this.rut = rut;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.domicilio = domicilio;
        this.comuna = comuna;
        this.telefono = telefono;
        this.cuenta = new Cuenta();
        this.contrasena = contrasena;
    }
    
    // Metodos getters
    public String getRut(){
        return rut;
    }  
    
    public String getNombre(){
        return nombre;
    }
    
    public String getApellidoPaterno(){
        return apellidoPaterno;
    }
    
    public String getApellidoMaterno(){
        return apellidoMaterno;
    }
    
    public Cuenta getCuenta(){
        return cuenta;
    } 
    
    public String getContrasena(){
        return contrasena;
    }  
    
    // Metodo para mostrar los datos del cliente
    public void mostrarDatos(){
        System.out.println("\nNombre completo del cliente: " + nombre + " " + apellidoPaterno + " " + apellidoMaterno);
        System.out.println("Rut del cliente: " + rut);
        System.out.println("Domicilio: " + domicilio + ", comuna: " + comuna);
        System.out.println("Telefono: " + telefono);
        System.out.println("Numero de cuenta: " + cuenta.getNumeroCuenta());
        System.out.println("Saldo actual: " + cuenta.getSaldo() + " pesos");
    }    
}
