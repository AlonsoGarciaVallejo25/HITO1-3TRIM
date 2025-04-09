
public abstract class Animal {

    // Atributos de animal
    protected int chip;           // Número de chip del animal 
    protected String nombre;      // Nombre del animal
    protected int edad;           // Edad del animal
    protected String raza;        // Raza del animal
    protected boolean adoptado;   // Indica si el animal ya ha sido adoptado (true) o no (false)

    // Constructor para inicializar los atributos del animal
    public Animal(int chip, String nombre, int edad, String raza, boolean adoptado) {
        this.chip = chip;
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
        this.adoptado = adoptado;
    }

    // Método abstracto que debe implementarse en las clases hijas
    // Este método será usado para mostrar los datos del animal.
    public abstract void mostrar();
}
