package daw.albertolopez;

import java.time.LocalDate;

/**
 * @author Alberto López Puertas
 * <https://github.com/alopezp90>
 */
public class Animal {

    private LocalDate fechaNacimiento;
    private String nombre;
    private String tipo;
    private double peso;
    private String estado;

    //Contador de instancias
    private static int contadorInstancias = 0;

    /**
     * Constructor por defecto de Animal.
     * <ul>
     * <li>fechaNacimiento: el momento de la instanciacion</li>
     * <li>nombre: Turrón</li>
     * <li>tipo: null</li>
     * <li>peso: 2200</li>
     * <li>estado: durmiendo</li>
     * </ul>
     */
    public Animal() {
        this.fechaNacimiento = LocalDate.now();
        this.nombre = "Turrón";
        this.tipo = null;
        this.peso = 2200;
        this.estado = "durmiendo";
        contadorInstancias++;
    }

    /**
     * Constructor parametrizado de Animal.
     *
     * @param fechaNacimiento fecha de nacimiento del Animal.
     * @param nombre nombre del Animal.
     * @param tipo tipo de Animal, puede ser: gato, perro, lagarto, cobaya,
     * periquito.
     * @param peso peso del Animal en gramos.
     * @param estado estado del Animal, puede ser: comiendo, durmiendo,
     * despierto/reposo o jugando.
     */
    public Animal(LocalDate fechaNacimiento, String nombre, String tipo, double peso, String estado) {
        this.fechaNacimiento = fechaNacimiento;
        this.nombre = nombre;
        this.tipo = compruebaTipo(tipo);
        this.peso = compruebaPeso(peso);
        this.estado = compruebaEstado(estado);
        contadorInstancias++;
    }

    //Comprueba que el tipo introducido sea valido
    public String compruebaTipo(String tipo) {
        switch (tipo) {
            case "gato":
            case "perro":
            case "lagarto":
            case "cobaya":
            case "periquito":
                return tipo;
            default:
                System.out.println("El tipo no es valido, se ha inicializado nulo.\n"
                        + "Tipos validos: gato, perro, lagarto, cobaya, periquito");
                return null;
        }
    }

    //Comprueba que peso sea siempre positivo
    public double compruebaPeso(double peso) {
        if (peso < 0) {
            peso = -1 * peso;
            System.out.println("El peso introducido es negativo, se ha cambiado "
                    + "por su valor absoluto.");
        }
        return peso;
    }

    //Comprueba que el estado introducido sea valido
    public String compruebaEstado(String estado) {
        switch (estado) {
            case "comiendo":
            case "durmiendo":
                this.estado = estado;
                break;
            case "despierto":
            case "reposo":
            case "despierto/reposo":
                return "despierto/reposo";
            default:
                if (!estado.equals("jugando")) {
                    System.out.println("El estado introducido no es valido, se "
                            + "ha inicializado como 'jugando'.\n"
                            + "Estados validos: comiendo, durmiendo, "
                            + "despierto/reposo, jugando");
                }
        }
        return "jugando";
    }

    //Metodos Getter
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPeso() {
        return peso;
    }

    public String getEstado() {
        return estado;
    }

    public static int getContadorInstancias() {
        return contadorInstancias;
    }

    /**
     * Incrementa el peso del animal.
     *
     * @param cantidadGramos cantidad a aumentar, si es positivo, se toma valor
     * absoluto.
     */
    public void comer(double cantidadGramos) {
        //calcula el valor absoluto del valor
        if (cantidadGramos < 0) {
            cantidadGramos = -1 * cantidadGramos;
        }
        this.peso += cantidadGramos;
    }

    /**
     * Pone al animal a dormir.
     */
    public void dormir() {
        this.estado = "durmiendo";
    }

    /**
     * Despierta al animal.
     */
    public void despertar() {
        this.estado = "despierto/reposo";
    }

    /**
     * Pone al animal en reposo.
     */
    public void descansar() {
        this.estado = "despierto/reposo";
    }

    /**
     * Pone al animal a jugar y cambia su peso en funcion del tiempo de juego.
     *
     * @param cantidadMinutos entre -180 y 180.
     * @throws IllegalArgumentException
     */
    public void jugar(int cantidadMinutos) throws IllegalArgumentException {
        this.estado = "jugando";
        //calcula el valor absoluto
        if (cantidadMinutos < 0) {
            cantidadMinutos = -1 * cantidadMinutos;
        }
        //lanza una excepcion si el valor sale de los limites
        if (cantidadMinutos > 180) {
            throw new IllegalArgumentException("El parametro no puede ser mayor que |180|.");
        } else {
            //calcula la variacion de peso teniendo en cuenta los periodos completos 
            //de 30 min y el posible resto
            int variacion = -20 * cantidadMinutos / 30;
            if (cantidadMinutos % 30 != 0) {
                variacion -= 10;
            }
            if (this.peso + variacion > 0) {
                this.peso += variacion;
            } else {
                throw new IllegalArgumentException("El animal es demasiado pequeño para jugar.");
            }
        }
    }

    //Metodo toString
    @Override
    public String toString() {
        return "Animal:\n"
                + "fechaNacimiento=" + fechaNacimiento + "\n"
                + "nombre=" + nombre + "\n"
                + "tipo=" + tipo + "\n"
                + "peso=" + peso + "\n"
                + "estado=" + estado;
    }

    /**
     * Clona el Animal en un nuevo objeto.
     *
     * @param pet objeto Animal a blonar
     * @return instancia del Animal clonado
     */
    public static Animal clonar(Animal pet) {
        try {
            return new Animal(pet.getFechaNacimiento(),
                    pet.nombre, pet.getTipo(), pet.getPeso(), pet.getEstado());
        } catch (NullPointerException npe) {
            System.out.println("Ha habido un NullPointerException");
            return new Animal();
        }
    }
}
