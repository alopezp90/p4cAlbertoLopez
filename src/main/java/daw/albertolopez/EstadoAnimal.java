package daw.albertolopez;

/**
 * Estados admitidos de Animal.
 */
public enum EstadoAnimal {

    COMIENDO(0, "comiendo"),
    DURMIENDO(1, "durmiendo"),
    DESPIERTO_REPOSO(2, "despierto/reposo"),
    JUGANDO(3, "jugando");
    
    //declaracion de variables
    private int indice;
    private String descripcion;
    
    /**
     * Constructor parametrizado de EstadoAnimal.
     * @param indice int indice del estado
     * @param descripcion String que lo describe
     */
    private EstadoAnimal(int indice, String descripcion) {
        this.indice = indice;
        this.descripcion = descripcion;
    }
    
    //metodos getter
    public int getIndice() {
        return indice;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
}
