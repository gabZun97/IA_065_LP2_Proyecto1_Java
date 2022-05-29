/*
Carwash
 */
package Proyecto1_Grupo3;
import java.util.Scanner;
public class Carwash {
    static Scanner in = new Scanner (System.in);
    public static void main(String[] args) {
        // Declaración de variables.
        int opc = 0;
        int Continuar1 = 0;
        do {
            // Mensaje de Bienvenida y Selección
            System.out.print("---------------------------------------------------------");
            System.out.println("\n     BIENVENIDO AL SISTEMA DE INFORMACIÓN CARWASH    ");
            System.out.print("---------------------------------------------------------");
            System.out.println("\n1. Clientes. \n2. Empleados. \n3. Inventario.");
            System.out.print("->");
            opc = in.nextInt();

            // Se evaluará el caso, según la selección y se manda a llamar al Método correspondiente.
            switch (opc){
                case 1: // Clientes
                    int n=0; // cantidad de clientes
                    System.out.print("Ingrese el numero de clientes que va ingresar: ");
                    n = in.nextInt();
                    String [][]cliente = new String [n][6]; // n representa el numero de clientes y los 6 son todos los datos del cliente
                    matrizCliente(cliente);
                    break;
                case 2: // Empleados
                    int m=0; // cantidad de empleados
                    System.out.print("Ingrese el numero de empleados que va ingresar: ");
                    m = in.nextInt();
                    String [][]empleado = new String [m][6]; // m representa el numero de empleados y los 6 son todos los datos del empleado
                    matrizEmpleado(empleado);
                    break;
                case 3: // Inventario
                    int l=0; // cantidad de productos
                    System.out.print("Ingrese el número de productos a ingresar: ");
                    l = in.nextInt();
                    String producto[]=new String [l]; // 3 productos
                    int cantidad[] = new int [1]; // 1 cantidad ingresada
                    matrizInventario(producto, cantidad); // Mandamos como parametros ambos vectores
                    break;
                default:
                    System.out.println("Opcion no válida!");
                    break;
            }

            // Mensaje de confirmación si desea seguir ingresando información
            System.out.print("\nDesea continuar con otro registro? \n1. Continuar = 1 \n2. Terminar = 2\n");
            System.out.print("->");
            Continuar1 = in.nextInt();

        } while (Continuar1 == 1); // Aquí se reptitetodo el programa
    }

    public static void matrizEmpleado(String b[][]) { // La matriz b tiene todos los datos del empleado
        // Declaración de variables.
        in.nextLine(); // Limpia el buffer
        for (int i = 0; i < b.length; i++) {
            System.out.print("Ingrese el nombre completo del empleado: ");
            b[i][0] = in.nextLine(); // Lee en la columna 0

            for (int j = 0; j < 1; j++) {
                System.out.print("Ingrese el correo electrónico: ");
                b[i][1] = in.nextLine(); // Lee en la columna 1
                System.out.print("Ingrese el teléfono: ");
                b[i][2] = in.nextLine(); // Lee en la columna 2
                System.out.print("Ingrese el grado académico actual: ");
                b[i][3] = in.nextLine();  // Lee en la columna 3
                System.out.print("Ingrese el puesto que tiene el empleado: ");
                b[i][4] = in.nextLine(); // Lee en la columna 4
                System.out.print("Ingrese el Salario que gana el empleado (lps): ");
                b[i][5] = in.nextLine(); // Lee en la columna 5
            }
        }
        System.out.println("Imprimiendo:");
        System.out.format("+------------------------------------------+--------------------------------+---------------+-------------------+---------------------+---------------+%n");
        System.out.format("|            Nombre Completo               |    Correo Electrónico          |    Teléfono   |  Grado académico  |  Puesto del gerente |    Salario    |%n");
        System.out.format("+------------------------------------------+--------------------------------+---------------+-------------------+---------------------+---------------+%n");
        for (int i = 0; i < b.length; i++) {
            String formato = "| %-40s | %-29s  | %-13s |  %-16s | %-19s | %-13s |%n"; //FORMATO
            for (int j = 0; j < 1; j++) {
                System.out.format(formato, b[i][0],b[i][1],b[i][2], b[i][3], b[i][4], b[i][5]); // Imprime todos los datos guardados o leidos
            }
            System.out.format("+------------------------------------------+--------------------------------+---------------+-------------------+---------------------+---------------+%n");

        }
        System.out.println("");
    }
    public static void matrizCliente(String a[][]){ // la matriz a guarda todos los datos del cliente
        // Declaración de variables.
        String contratado = ""; // para leer los servicios contratados
        int cont1=0; // Para contar cuantas veces se contrata el servicio de lavado
        int cont2=0; // Para contar cuantas veces se contrata el servicio de Pintado
        int cont3=0;  // Para contar cuantas veces se contrata el servicio de Mantenimiento
        in.nextLine();
        for (int i = 0; i < a.length; i++) { // a.length lleva el calculo del numero de clientes y de el depende cuantas veces se repetira todo el ingreso de datos
            System.out.print("Ingrese el nombre completo del cliente: ");
            a[i][0] = in.nextLine(); // Lee en la columna 0

            for (int j = 0; j < 1; j++) {
                System.out.print("Ingrese el ID: ");
                a[i][1] = in.nextLine(); // Lee en la columna 1
                System.out.print("Ingrese el correo: ");
                a[i][2] = in.nextLine(); // Lee en la columna 2
                System.out.print("Ingrese el teléfono: ");
                a[i][3] = in.nextLine(); // Lee en la columna 3
                System.out.print("Ingrese el número de visitas: ");
                a[i][4] = in.nextLine();  // Lee en la columna 4
                int servicio =0;
                do{ // usamos un ciclo para leer los servicios contratados por si el cliente desa contratar otro servicio
                    System.out.print("Ingrese el servicio contratado por el cliente: \n Lavado \n Pintado \n Mantenimiento\n");
                    System.out.print("->");
                    a[i][5] = in.nextLine(); // Imprime en la columna 5

                    if (servicio==1) {
                        contratado+=a[i][5];
                    }
                    switch (a[i][5]) {
                        case "Lavado":
                            cont1++; // Si ingresa lavado se aumenta el contador
                            break;
                        case "Pintado":
                            cont2++; // Si ingresa Pintado se aumenta el contador
                            break;
                        case "Mantenimiento":
                            cont3++; // Si ingresa Mantenimiento se aumenta el contador
                            break;
                        default:
                            System.out.println("Opción no válida!");
                    }

                    System.out.print("Desea el cliente contratar otro servicio? \n1. Si \n2. No \n");
                    System.out.print("->");
                    servicio = in.nextInt();
                    in.nextLine();
                    System.out.println("");
                }while(servicio==1);

            }
        }

        int i=0;
        for ( i = 0; i < a.length; i++) {
            System.out.println("Imprimiendo:");
            String formato = "| %-40s | %-20s  | %-28s |  %-12s | %-18s | %-27s |%n"; //Formato1
            System.out.format("+------------------------------------------+-----------------------+------------------------------+---------------+--------------------+-----------------------------+%n");
            System.out.format("|            Nombre Completo               |    Identidad          |           Correo             |   Teléfono    |  Número de visitas |    Servicios contratados    |%n");
            System.out.format("+------------------------------------------+-----------------------+------------------------------+---------------+--------------------+-----------------------------+%n");
            for (int j = 0; j < 1; j++) {
                System.out.format(formato, a[i][0],a[i][1],a[i][2], a[i][3], a[i][4], a[i][5]); // Imprimimos los datos leídos
            }
            System.out.format("+------------------------------------------+-----------------------+------------------------------+---------------+--------------------+-----------------------------+%n");
            System.out.println("");
            System.out.println("Clientes antendidos: ");
            System.out.println("Cliente "+ a[i][0]+" atendido con su número "+a[i][4]+" de visita");
        }

        if (cont1>cont2 && cont1>cont3) {  // comparamos los contadores de los tres servicios y el mayor sera el mayor solicitado11
            System.out.println("El servicio más solicitado es el Lavado.");
        }else if (cont2>cont1 && cont2>cont3) {
            System.out.println("El servicio más solicitado es el Pintado.");
        }else if (cont3>cont1 && cont3>cont2) {
            System.out.println("El servicio más solicitado es el Mantenimiento.");
        }
    }
    public static void matrizInventario(String c[], int d[]){ // El vector c guarda los productos, el vector d la cantidad de esos productos
        /*
        El inventario esta interpretado para saber que productos tiene el carwash en existencia para usarse, estar
        estar al tanto que debe comprarse y el que ya se terminó.
        */
        int repetir=0; // Para que repita el ciclo
        in.nextLine();
        System.out.println("---------------------------------------------------------------------------");
        for (int i = 0; i < c.length; i++) { // Hasta < 1 para que solo lea una sola vez
            System.out.print("Ingrese los productos de limpieza: ");
            c[i] = in.nextLine();
            for (int j = 0; j < d.length; j++) { // Hasta < 1 para que solo lea una sola vez
                System.out.print("Ingrese la cantidad de "+c[i]+": ");
                d[j] = in.nextInt();
                if (d[j]>10) { // Si la cantidad ingresada es mayor a 10 hay existencia
                    System.out.println("El producto "+c[i]+" cuenta con "+d[j]+" en existencia.");
                }else if (d[j]<10 && d[j]>5) { // Si la cantidad es mayor a 5 pero menor a 10 está por terminarse
                    System.out.println("El producto "+c[i]+" cuenta con "+d[j]+" y esta por terminarse.");
                }else{ // si es menor a 5 hay que comprar ese producto
                    System.out.println("El producto "+c[i]+" debe comprarse ahora mismo.");
                }
            }
            System.out.println("--------------------------------------------------------------------------");
            in.nextLine();
        }
        System.out.println("Imprimiendo:");
        String formato = "| %-30s | %-16s  |%n"; //Formato

        System.out.format("+--------------------------------+-------------------+%n");
        System.out.format("|            Producto            |    Cantidad       |%n");
        System.out.format("+--------------------------------+-------------------+%n");
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < d.length; j++) {
                System.out.format(formato, c[i], d[j]); // Imprimimos los datos leídos
            }
        }

        System.out.format("+--------------------------------+-------------------+%n");
    }
}
