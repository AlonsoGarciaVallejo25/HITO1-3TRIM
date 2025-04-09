// La clase Gato hereda de la clase abstracta Animal
public class Gato extends Animal {

    // Atributo específico del gato testleucemia
    boolean testleucemia;

    // Constructor de la clase Gato
    // Llama al constructor de la superclase (Animal) con super()
    public Gato(int chip, String nombre, int edad, String raza, boolean adoptado, boolean testleucemia) {
        super(chip, nombre, edad, raza, adoptado);     // Inicializa los atributos comunes del animal
        this.testleucemia = testleucemia;              // Inicializa el testleucemia
    }

    // Implementación del método abstracto mostrar() de la clase Animal e imprime todos los datos del gato
    public void mostrar() {
        System.out.println("Numero de chip: " + chip + ", nombre del animal: " + nombre + ", tiene de edad: " + edad + ". Su raza es: " + raza +  ", está adoptado: " + adoptado + " y su test de leucemia da: " + testleucemia + ".");
    }
}
