package daw.programa;

import daw.albertolopez.Animal;
import daw.albertolopez.EstadoAnimal;
import daw.albertolopez.Persona;
import daw.albertolopez.TipoAnimal;
import java.time.LocalDate;
import java.time.Month;

/**
 * @author Alberto López Puertas 
 * <https://github.com/alopezp90>
 */

public class Prueba {
    public static void main(String[] args) {
        
        Animal a1 = new Animal();
        Animal a2 = new Animal(LocalDate.of(2018, Month.APRIL, 12), "Zoe", TipoAnimal.PERRO, 6800, EstadoAnimal.DURMIENDO);

        Persona p1 = new Persona("Alberto", 30);
        Persona p2 = new Persona("Vico", 25);
        
        System.out.println(a1.toString());
        System.out.println(a2.toString());
        
        Animal a3 = Animal.clonar(a2);
        
        System.out.println(Animal.getContadorInstancias());
        
        p1.llamar(a1);
        p1.llamar(a2);
        p1.llamar(a3);
        
        p2.jugar(a2, 120);
        
        p1.alimentar(a1, 1000);
        System.out.println(a1.getPeso());
        
        p1.jugar(a1, 200);
        System.out.println(a1.getPeso());
    }
}
