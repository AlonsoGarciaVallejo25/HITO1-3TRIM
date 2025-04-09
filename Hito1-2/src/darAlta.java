import java.util.ArrayList;
import java.util.Scanner; 

public class darAlta {
    
    // Scanner para leer entrada del usuario
    Scanner sc = new Scanner(System.in);
    
    // Lista que almacenará todos los animales registrados
    ArrayList<Animal> animales = new ArrayList<>();
    
    
    ArrayList<Adopcion> adopciones = new ArrayList<>();
    
    ArrayList<Gato> gatos = new ArrayList<>();
    
    // Método para dar de alta un nuevo animal
    public void darAltaAnimal() {
        System.out.println("¿Qué animal quieres dar de alta (perro o gato)?");
        String tipoAnimal = sc.nextLine().toLowerCase(); // Pedimos el tipo de animal y convierte a minúsculas para evitar errores al comparar

        System.out.println("¿Qué chip va a tener el animal?");
        int chip = Integer.parseInt(sc.nextLine());// Pedimos el chip del perro que usamos parseInt para que nos deje usarlo en el scanner

        // Comprueba si el chip ya existe usamos un foreach para recorrer la lista de los animales para compararlo con el ya realizado
        for (Animal a : animales) {
            if (chip == a.chip) {
                System.out.println("El chip ya está en uso..");
                return; // Salir sin registrar el animal
            }
        }

        //Pedimos el nombre del animal
        System.out.println("Dime el nombre del animal: ");
        String nombre = sc.nextLine();
        //Pedimos la edad del animal
        System.out.println("Dime la edad del animal: ");
        int edad = Integer.parseInt(sc.nextLine());
        //Pedimos la raza del animal
        System.out.println("Dime la raza del animal: ");
        String raza = sc.nextLine();
        //Pedimos si es adoptado o no el animal
        System.out.println("¿Es adoptado o no (true o false)?");
        boolean adoptado = Boolean.parseBoolean(sc.nextLine());

        // Según el tipo de animal, nos lleva a distintos atributos
        if (tipoAnimal.equalsIgnoreCase("perro")) {
        	//Pedimos el tamaño del perro
            System.out.println("Al ser perro, dime cuál es su tamaño (pequeño/mediano/grande): ");
            String tamano = sc.nextLine();
            animales.add(new Perro(chip, nombre, edad, raza, adoptado, tamano)); // Añade un nuevo perro a la lista
        } else if (tipoAnimal.equalsIgnoreCase("gato")) {
            // Pedimos el test de leucemia del gato
            System.out.println("Al ser gato, dime si ha pasado el test de leucemia (true o false): ");
            boolean testleucemia = Boolean.parseBoolean(sc.nextLine());
            
            Gato nuevoGato = new Gato(chip, nombre, edad, raza, adoptado, testleucemia);
            animales.add(nuevoGato); // Añade el nuevo gato a la lista de animales
            gatos.add(nuevoGato); // Añade el nuevo gato a la lista de gatos
        }

    }
    public void listarAnimales() {
    	for(Animal a:animales) {
    		a.mostrar();
    	}
    }

    // Método para buscar un animal por su chip
    public void buscarAnimalConChip() {
        System.out.println("Dime el chip del animal que quieras encontrar: ");
        int chip = Integer.parseInt(sc.nextLine());//Pedimos el chip

        // Recorre la lista de animales buscando coincidencias
        for (Animal a : animales) {
            if (chip == a.chip) {
                a.mostrar(); // Si lo encuentra, muestra su información
                return;
            } else {
                System.out.println("El chip elegido no se encuentra en ningún animal.");
            }
        }
    }
    
    public void hacerAdopcion() {
        System.out.println("Dame el chip del animal que quiera adoptar : ");
        int chip = Integer.parseInt(sc.nextLine());
        boolean AnimalEncontrado = false;

        for (Animal a : animales) {
            if (chip == a.chip) {
                AnimalEncontrado = true;
                if (a.adoptado) {
                    System.out.println("Este animal ya ha sido adoptado.");
                    return;
                } else {
                    System.out.println("Dame tu nombre para adoptar: ");
                    String nombrePersona = sc.nextLine();
                    System.out.println("Dame también tu dni: ");
                    String dniPersona = sc.nextLine();
                    adopciones.add(new Adopcion(chip, nombrePersona, dniPersona));
                    a.adoptado = true; // Marcar como adoptado
                    System.out.println("Ha realizado correctamente la adopcion.");
                    return;
                }
                
            }
        }

        if (!AnimalEncontrado) {
            System.out.println("El animal que desea adoptar no se encuentra disponible.");
        }
    }

    
    public void darBaja() {
    	System.out.println("Dame el chip del animal que quieras dar de baja: ");
    	int chip = Integer.parseInt(sc.nextLine());//Pedimos el chip
    	boolean dadoDeBaja = false;
    	
    	for(int i= 0; i < animales.size(); i++) {
    		if ( animales.get(i).chip == chip) {
    			animales.remove(i);
    			dadoDeBaja = true;
    		}
    	}
    	if(dadoDeBaja) {
    		for (int j= 0; j < adopciones.size();j++) {
    			if(adopciones.get(j).getChip() == chip) {
    				adopciones.remove(j);
    				break;
    			}
    		}
    		System.out.println("El animal ha sido dado de baja correctamente.");
    	} else {
    		System.out.println("El animal que desea dar de baja no se encuentra disponible.");
    	}
    }
    public void crearAnimales() {
    	 animales.add(new Perro(232, "Juanillo", 80, "Sucia", false, "grande"));
    	 animales.add(new Perro(233, "Oswald", 40, "yorkwsithe", false, "mediano"));
    	 animales.add(new Perro(234, "Mariete", 80, "Pastor Alemán", true, "grande"));
    	 animales.add(new Gato(303,"Raul", 30,"Maine Coon", false, true));
    	 animales.add(new Gato(304,"Ruso", 10,"Egipcio", true, true));
    	 animales.add(new Gato(305,"Dani", 40,"Manchado", false, false));
    	 gatos.add(new Gato(303,"Raul", 30,"Maine Coon", false, true));
    	 gatos.add(new Gato(304,"Ruso", 10,"Egipcio", true, true));
    	 gatos.add(new Gato(305,"Dani", 40,"Manchado", false, false));
    }
    
    public void mostrarEstadisticasGatos() {
    	int totalGatos = gatos.size();
    	int gatosConTest = 0;
    	
    	for (int i = 0; i < gatos.size();i++) {
    		if(gatos.get(i).testleucemia) {
    			gatosConTest++;
    		}
    	}
    	System.out.println("Total de gatos : " + totalGatos);
    	System.out.println("Gatos con test de leucemia : " + gatosConTest);
    }

    // Método principal (main): muestra el menú y gestiona la interacción con el usuario
    public static void main(String[] args) {
        darAlta alta = new darAlta(); // Crea una instancia del sistema de alta
        Scanner sc = new Scanner(System.in);
        alta.crearAnimales();
        while (true) {
            // Menú principal
            System.out.println("Gestión de Protectoras Alonso");
            System.out.println("1- Dar de alta a un animal");
            System.out.println("2- Buscar a un animal por su chip");
            System.out.println("3- Hacer una adopcion");
            System.out.println("4- Dar de baja un animal");
            System.out.println("5- Listar animales");
            System.out.println("6- Estadisticas gatos");
            System.out.println("7- Salir");
            
            
            //Pedimos la ocpción que depende de lo que sea hace una cosa
            int opcion = Integer.parseInt(sc.nextLine());

            if (opcion == 1) {
                alta.darAltaAnimal();
            } else if (opcion == 2) {
                alta.buscarAnimalConChip();
            } else if (opcion == 3) {
                alta.hacerAdopcion();
            }  else if (opcion == 4) {
                alta.darBaja();
            }     else if (opcion == 5) {
                alta.listarAnimales();
            }  else if (opcion == 6) {
                alta.mostrarEstadisticasGatos();;
            } else if(opcion == 7) {
            	break; // Salir del bucle
            } else {
                System.out.println("Esa opción no se encuentra disponible");
            }
        }

        sc.close(); // Cierra el Scanner
    }
}
