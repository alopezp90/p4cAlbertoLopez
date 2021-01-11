package daw.albertolopez;

/**
 * @author Alberto López Puertas 
 * <https://github.com/alopezp90>
 */

public class Persona {

    private String nombre;
    private int edad;
    
    /**
     *  Constructor parametrizado de Persona
     * @param nombre nombre de la persona
     * @param edad edad de la persona
     */
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    
    //Metodos Getter y Setter de Persona
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    /**
     * Despierta a la mascota
     * @param pet mascota a despertar
     */
    public void llamar(Animal pet) {
        pet.despertar();
    }
    
    /**
     * Da de comer a la mascota
     * @param pet mascota a alimentar
     * @param cantidadGramos cantidad de comida
     */
    public void alimentar(Animal pet, double cantidadGramos) {
        pet.comer(cantidadGramos);
    }
    
    /**
     * Juega con la mascota.
     * Comprueba que el argumento no sea ilegal, bien porque la mascota sea 
     * demasiado pequeña o porque el argumento salga del rango
     * @param pet mascota con la que jugar
     * @param cantidadMinutos tiempo de juego
     */
    public void jugar(Animal pet, int cantidadMinutos) {
        try {
            pet.jugar(cantidadMinutos);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae);
            //Al menos que pese el doble de lo que puede perder jugando
            if (!iae.getMessage().contains("pequeño") && pet.getPeso() > 240) {
                pet.jugar(180);
                System.out.println("Se jugara el maximo posible.");
            }
        }
    }
    
}
