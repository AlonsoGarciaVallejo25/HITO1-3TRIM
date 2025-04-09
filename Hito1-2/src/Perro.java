// La clase Perro hereda de la clase abstracta Animal
public class Perro extends Animal {

    // Atributo específico de los perros: su tamaño (pequeño, mediano o grande)
    String tamano;

    // Constructor de la clase Perro
    // Llama al constructor de la superclase (Animal) con super()
    public Perro(int chip, String nombre, int edad, String raza, boolean adoptado, String tamano) {
        super(chip, nombre, edad, raza, adoptado); // Inicializa los atributos comunes
        this.tamano = tamano;                      // Inicializa el atributo tamano
    }

    // Implementación del método abstracto mostrar() de la clase Animal imprimiendo los datos de perro
    public void mostrar() {
        System.out.println("Numero de chip: " + chip + ", nombre del animal: " + nombre + ", tiene de edad: " + edad + ". Su raza es: " + raza + ", está adoptado: " + adoptado + " y tiene un tamaño " + tamano + ".");
    }
}
