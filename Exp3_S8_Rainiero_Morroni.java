package exp3_s8_rainiero_morroni;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Rai
 */
public class Exp3_S8_Rainiero_Morroni {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sca = new Scanner(System.in);
        int opcion = 0;
        boolean opcionValida;

        //5 asientos por sector. 15 asientos en total. Posicion 0-4: VIP; Posicion 5-9: Platea; Posicion 10-15: Palco.         
        boolean[] asientosReservados = new boolean[15]; //Arreglo para almacenar reserva de asientos.

        LinkedList<String> resumenTotalEntradas = new LinkedList<>(); //LinkedList para almacenar y gestionar detalle de compras.
        int id = 1;

        System.out.println("¡Bienvenido a Teatro Moro!");
        System.out.println(""); //Linea en blanco.
        do {
            opcionValida = false;
            System.out.println("        Menu Principal");
            System.out.println("Ingrese el numero de una opcion para continuar:");
            System.out.println("1. Comprar Entradas.");
            System.out.println("2. Ver entradas compradas.");
            System.out.println("3. Modificar entrada comprada.");
            System.out.println("4. Anular entrada comprada.");
            System.out.println("5. Salir.");
            System.out.println("");//Linea en blanco.
            System.out.println("Valores entradas Publico General");
            System.out.println("Sector VIP: $30.000.-"); //Precio 1
            System.out.println("Sector Platea: $20.000.-"); //Precio 2
            System.out.println("Sector Palco: $10.000.-"); //Precio 3
            System.out.println("");//Linea en blanco.

            // Validacion try-catch para evitar que el programa caiga al ingresar una opcion diferente a un numero.            
            try {
                opcion = sca.nextInt();
                opcionValida = true;
            } catch (InputMismatchException e) {
                sca.next(); //Entrada para evitar bucle infinito.
                System.out.println(""); //Linea en blanco.
            }

            if (opcionValida == true) {
                switch (opcion) {
                    case 1:
                        System.out.println("Accediendo a la seccion de compra de entradas...");

                        int cantidadEntradas = 0;
                        boolean cantidadValida = false;
                        double valorTotalCompraActual = 0;

                        do {
                            System.out.println("Ingrese el numero de entradas que desea comprar:");
                            System.out.println("---Maximo 5 entradas por compra---");
                            try {
                                cantidadEntradas = sca.nextInt();
                                if (cantidadEntradas > 0 && cantidadEntradas <= 5) {
                                    cantidadValida = true;
                                } else {
                                    System.out.println("Ingrese un numero de entradas valido (Entre 1 y 5).");
                                    System.out.println(""); //Linea en blanco.
                                }
                            } catch (InputMismatchException e) {
                                sca.next(); //Entrada para evitar bucle infinito.
                                System.out.println(""); //Linea en blanco.
                            }
                        } while (!cantidadValida);

                        List<String> resumenEntradasCompra = new ArrayList<>();
                        double valorTotalCompra = 0;
                        double precioFinalEntrada;
                        for (int i = 1; i <= cantidadEntradas; i++) {
                            System.out.println("--------------------------------------");
                            System.out.println("Entrada #" + i + ".");
                            System.out.println("            MAPA DE ASIENTOS");
                            System.out.println(""); //Linea en blanco.
                            System.out.println("                                  [ESCENARIO]");
                            System.out.println("                                 A  B  C  D  E");
                            System.out.println("Sector 1 - VIP:                 [1][2][3][4][5]");
                            System.out.println("Sector 2 - Platea:              [1][2][3][4][5]");
                            System.out.println("Sector 3 - Palco:               [1][2][3][4][5]");
                            System.out.println("");//Linea en blanco.

                            int sector = 0;
                            boolean sectorValido;
                            do {
                                System.out.println("Seleccione el SECTOR deseado para la entrada #" + i + ":");
                                System.out.println("1. Sector 1 - VIP");
                                System.out.println("2. Sector 2 - Platea");
                                System.out.println("3. Sector 3 - Palco");
                                System.out.println("Ingrese el numero del sector (1-3): ");

                                // Validacion try-catch para evitar que el programa caiga al ingresar una opcion diferente a un numero.
                                try {
                                    sector = sca.nextInt();
                                    sectorValido = true;
                                } catch (InputMismatchException e) {
                                    sca.next(); //Entrada para evitar bucle infinito.
                                    System.out.println(""); //Linea en blanco.
                                }
                                if (sectorValido = true && (sector < 1 || sector > 3)) {
                                    System.out.println("Ingrese un sector valido (1-3):");
                                    System.out.println(""); //Linea en blanco.
                                }
                            } while (sector < 1 || sector > 3);

                            int numeroAsiento = 0;
                            boolean asientoValido = false;
                            int estadoAsiento = - 1; //Variable para guardar estado del asiento en el array.

                            do {
                                System.out.println("Seleccione el ASIENTO deseado del sector " + sector + " para la entrada # " + i + ".");
                                System.out.println("1. Asiento 1");
                                System.out.println("2. Asiento 2");
                                System.out.println("3. Asiento 3");
                                System.out.println("4. Asiento 4");
                                System.out.println("5. Asiento 5");
                                System.out.println("Ingrese el numero del asiento (1-5): ");
                                try {
                                    numeroAsiento = sca.nextInt();
                                    asientoValido = true;
                                    estadoAsiento = (sector - 1) * 5 + (numeroAsiento - 1);
                                    if (estadoAsiento >= 0 && estadoAsiento < asientosReservados.length && asientosReservados[estadoAsiento]) {
                                        System.out.println("Asiento no disponible. Por favor, seleccione otro asiento.");
                                        System.out.println(""); //Linea en blanco.
                                        asientoValido = false;
                                    }
                                } catch (InputMismatchException e) {
                                    sca.next(); //Entrada para evitar bucle infinito.
                                    System.out.println(""); //Linea en blanco.                                
                                }
                                if (asientoValido && (numeroAsiento < 1 || numeroAsiento > 5)) {
                                    System.out.println("Ingrese un asiento valido (1-5):");
                                    System.out.println(""); //Linea en blanco.
                                    asientoValido = false;
                                }
                            } while (!asientoValido);

                            if (estadoAsiento >= 0 && estadoAsiento < asientosReservados.length) {
                                asientosReservados[estadoAsiento] = true; //Para marcar el asiento valido como seleccionado.
                            }
                            int edad = 0;
                            boolean edadValida = false;
                            double descuento = 0;
                            // 10% descuento Estudiantes (0-17 años).
                            // 15% descuento Tercera Edad (>59 años).
                            do {
                                System.out.println(""); //Linea en blanco.
                                System.out.println("Ingrese la EDAD del espectador #" + i + " , para aplicar nuestros descuentos: ");
                                try {
                                    edad = sca.nextInt();
                                    if (edad >= 0 && edad <= 120) {
                                        edadValida = true;
                                    } else {
                                        System.out.println("Edad no valida. Ingrese una edad entre 0 y 120 años.");
                                        System.out.println(""); //Linea en blanco.
                                    }
                                } catch (InputMismatchException e) {
                                    sca.next(); //Entrada para evitar bucle infinito.
                                    System.out.println("Edad no valida. Ingrese una edad entre 0 y 120 años.");
                                    System.out.println(""); //Linea en blanco.
                                }
                            } while (!edadValida);

                            double precioBaseSector = 0;
                            String nombreSector = "";
                            if (sector == 1) {
                                precioBaseSector = 30000;
                                nombreSector = "VIP";
                            } else if (sector == 2) {
                                precioBaseSector = 20000;
                                nombreSector = "Platea";
                            } else if (sector == 3) {
                                precioBaseSector = 10000;
                                nombreSector = "Palco";
                            }
                            if (edad >= 0 && edad <= 17) {
                                descuento = 0.1; // 10% de descuento
                                System.out.println("Descuento del 10% aplicado.");
                                System.out.println(""); //Linea en blanco.
                            } else if (edad >= 60 && edad <= 120) {
                                descuento = 0.15; // 15% de descuento
                                System.out.println("Descuento del 15% aplicado.");
                                System.out.println(""); //Linea en blanco.
                            } else {
                                System.out.println("No se aplica ningun descuento.");
                                System.out.println(""); //Linea en blanco.
                            }
                            precioFinalEntrada = precioBaseSector * (1 - descuento);
                            valorTotalCompraActual = valorTotalCompraActual + precioFinalEntrada;

                            //Logica para resumir compra en la impresion de boleta.
                            String detalleEntrada = "ID de Reserva #000" + id + "." + " Sector " + nombreSector + ", Asiento " + numeroAsiento + ", Precio: $" + precioFinalEntrada + ". Edad: " + edad + ". Descuento aplicado: " + (descuento * 100) + "%";
                            resumenEntradasCompra.add(detalleEntrada);
                            //Logica para resumir compras al case 2.
                            resumenTotalEntradas.add(detalleEntrada);
                            System.out.println("ID de Reserva #000" + i + "." + ": Asiento " + numeroAsiento + " del sector " + nombreSector + ".");
                            System.out.println("Precio base: $" + precioBaseSector);
                            System.out.println("Precio final: $" + precioFinalEntrada);
                            System.out.println(""); //Linea en blanco.
                            id += 1; //Incremento de ID unico por entrada comprada.
                        }
                        System.out.println("--------------------Boleta de compra--------------------");
                        System.out.println("-----------------------Teatro Moro----------------------");
                        System.out.println("--------------------------------------------------------");
                        for (String detalle : resumenEntradasCompra) {
                            System.out.println(detalle);
                        }
                        System.out.println("--------------------------------------------------------");
                        System.out.println("Total a pagar $: " + valorTotalCompraActual);
                        System.out.println("--------------------------------------------------------");
                        System.out.println(""); //Linea en blanco.
                        System.out.println("¡Gracias por su compra, disfrute su funcion!");
                        System.out.println(""); //Linea en blanco.
                        break;
                    case 2:
                        System.out.println("--------------- Resumen de Entradas ----------------");
                        if (resumenTotalEntradas.isEmpty()) {
                            System.out.println("No se registran compras de entradas en el sistema.");
                        } else {
                            for (int i = 0; i < resumenTotalEntradas.size(); i++) {
                                System.out.println((i + 1) + ". " + resumenTotalEntradas.get(i));
                            }
                        }
                        System.out.println("----------------------------------------------------");
                        System.out.println(""); //Linea en blanco
                        break;
                    case 3:
                        System.out.println("---------------- Modificar Entrada Comprada ---------------");
                        if (resumenTotalEntradas.isEmpty()) {
                            System.out.println("No se registran entradas para modificar en el sistema.");
                            System.out.println("---------------------------------------------------------");
                        } else {
                            System.out.println("----------------------------------------- Reservas Activas -------------------------------------------");
                            for (int i = 0; i < resumenTotalEntradas.size(); i++) {
                                System.out.println((i + 1) + ". " + resumenTotalEntradas.get(i));
                            }
                            System.out.println("------------------------------------------------------------------------------------------------------");

                            int indiceModificar = -1;
                            boolean indiceValido = false;
                            do {
                                System.out.println("Ingrese el numero en la lista de la entrada que desea modificar:");
                                try {
                                    int entradaModificar = sca.nextInt();
                                    indiceModificar = entradaModificar - 1; // Calcula indice en el array de entradas..
                                    if (indiceModificar >= 0 && indiceModificar < resumenTotalEntradas.size()) {
                                        indiceValido = true;
                                    } else {
                                        System.out.println("El numero de la lista ingresado no es valido. Intente nuevamente.");
                                        System.out.println(""); // Linea en blanco
                                    }
                                } catch (InputMismatchException e) {
                                    sca.next(); // Entrada para evitar bucle infinito.
                                    System.out.println("Entrada no valida. Intente nuevamente.");
                                    System.out.println(""); // Linea en blanco
                                }
                            } while (!indiceValido);

                            String entradaOriginal = resumenTotalEntradas.get(indiceModificar); // Para obtener detalles de entrada original.
                            System.out.println(""); // Linea en blanco
                            System.out.println("Modificando la entrada seleccionada: " + entradaOriginal);

                            // Se intenta extraer informacion del String resumenTotalEntradas.
                            int asientoOriginal = -1;
                            int sectorOriginal = -1;
                            int edadOriginal = -1;
                            String idOriginal = "";

                            /*Ejemplo String detalleEntrada para contar las posiciones:
                            "ID de Reserva #000id. Sector 'nombreSector', Asiento 'numeroAsiento'. Precio: $'precioFinalEntrada'. Edad: "edad". Descuento aplicado: '(descuento * 100)' + "%".  
                             */
                            idOriginal = entradaOriginal.substring(0, entradaOriginal.indexOf(".")); //Busca el indice de la primera aparición del carácter "." dentro del string. El punto después de "#0001" está en el índice 19.
                            String sector = entradaOriginal.substring(entradaOriginal.indexOf("Sector ") + 7, entradaOriginal.indexOf(", Asiento")); // Encuentra indice donde empieza el texto "Sector " (21) y se le suman 7 para llegar al indice donde inicia el nombre del sector
                            String asiento = entradaOriginal.substring(entradaOriginal.indexOf("Asiento ") + 8, entradaOriginal.indexOf(", Precio")); // Igual que el anterior.
                            String edad = entradaOriginal.substring(entradaOriginal.indexOf("Edad: ") + 6, entradaOriginal.indexOf(". Descuento")); //Igual que el anterior.

                            asientoOriginal = Integer.parseInt(asiento.trim()); //trim: Para elimina espacios en blanco dentro del String asiento. Integer.parseInt convierte el dato String asiento a int.
                            edadOriginal = Integer.parseInt(edad.trim()); //trim: Para elimina espacios en blanco dentro del String edad. Integer.parseInt convierte el dato String edad a int.

                            //Logica para asignar numero de sector segun su nombre.
                            if (sector.equals("VIP")) {
                                sectorOriginal = 1;
                            } else if (sector.equals("Platea")) {
                                sectorOriginal = 2;
                            } else if (sector.equals("Palco")) {
                                sectorOriginal = 3;
                            }
                            if (sectorOriginal != -1 && asientoOriginal != -1) {
                                int indiceAsientoOriginal = (sectorOriginal - 1) * 5 + (asientoOriginal - 1); //Calculo de indice en el array asientosReservados.            
                                if (indiceAsientoOriginal >= 0 && indiceAsientoOriginal < asientosReservados.length) {
                                    asientosReservados[indiceAsientoOriginal] = false; // Disponibiliza asiento original.
                                    System.out.println("Asiento original (Sector " + sectorOriginal + ", Asiento " + asientoOriginal + ") liberado.");
                                }
                            }
                            // Logica para pedir nuevo sector y asiento.
                            System.out.println(""); // Linea en blanco
                            int nuevoSector = 0;
                            boolean sectorValido = false;
                            do {
                                System.out.println("Seleccione el NUEVO SECTOR deseado:");
                                System.out.println("1. Sector 1 - VIP");
                                System.out.println("2. Sector 2 - Platea");
                                System.out.println("3. Sector 3 - Palco");
                                System.out.println("Ingrese el numero del nuevo sector (1-3): ");
                                try {
                                    nuevoSector = sca.nextInt();
                                    if (nuevoSector >= 1 && nuevoSector <= 3) {
                                        sectorValido = true;
                                    } else {
                                        System.out.println("Ingrese un sector valido (1-3):");
                                        System.out.println(""); // Linea en blanco
                                    }
                                } catch (InputMismatchException e) {
                                    sca.next(); // Entrada para evitar bucle infinito.
                                    System.out.println("Ingrese un sector valido (1-3):");
                                    System.out.println(""); // Linea en blanco
                                }
                            } while (!sectorValido);

                            int nuevoNumeroAsiento = 0;
                            boolean asientoValido = false;
                            int indiceAsientoNuevo = -1;
                            do {
                                System.out.println("Seleccione el NUEVO ASIENTO deseado del sector " + nuevoSector + ":");
                                System.out.println("1. Asiento 1");
                                System.out.println("2. Asiento 2");
                                System.out.println("3. Asiento 3");
                                System.out.println("4. Asiento 4");
                                System.out.println("5. Asiento 5");
                                System.out.println("Ingrese el numero del nuevo asiento (1-5): ");
                                try {
                                    nuevoNumeroAsiento = sca.nextInt();
                                    if (nuevoNumeroAsiento >= 1 && nuevoNumeroAsiento <= 5) {
                                        indiceAsientoNuevo = (nuevoSector - 1) * 5 + (nuevoNumeroAsiento - 1); //Calculo de indice en el array asientosReservados.                                  
                                        if (indiceAsientoNuevo >= 0 && indiceAsientoNuevo < asientosReservados.length) { //Validacion de que el indice calculado este dentro del rango del array.
                                            if (!asientosReservados[indiceAsientoNuevo]) { //Validacion de que el asiento seleccionado este disponible (false).
                                                asientoValido = true; // Reserva el nuevo asiento.
                                            } else {
                                                System.out.println("Asiento no disponible. Seleccione otro asiento.");
                                                System.out.println(""); // Linea en blanco
                                            }
                                        }
                                    }
                                } catch (InputMismatchException e) {
                                    sca.next(); // Entrada para evitar bucle infinito.
                                    System.out.println("Ingrese un asiento valido (1-5):");
                                    System.out.println(""); // Linea en blanco
                                }
                            } while (!asientoValido);
                            asientosReservados[indiceAsientoNuevo] = true; // Reservar el nuevo asiento elegido.
                            // Logica para calculo de nuevo precio del asiento.
                            double nuevoPrecioBaseSector = 0;
                            String nuevoNombreSector = "";
                            if (nuevoSector == 1) {
                                nuevoPrecioBaseSector = 30000;
                                nuevoNombreSector = "VIP";
                            } else if (nuevoSector == 2) {
                                nuevoPrecioBaseSector = 20000;
                                nuevoNombreSector = "Platea";
                            } else if (nuevoSector == 3) {
                                nuevoPrecioBaseSector = 10000;
                                nuevoNombreSector = "Palco";
                            }
                            double descuento = 0;
                            if (edadOriginal >= 0 && edadOriginal <= 17) {
                                descuento = 0.1; // 10%
                            } else if (edadOriginal >= 60 && edadOriginal <= 120) {
                                descuento = 0.15; // 15%
                            }
                            double nuevoPrecioFinal = nuevoPrecioBaseSector * (1 - descuento);

                            // Detalle de nueva entrada.
                            String entradaModificada = idOriginal + ". Sector " + nuevoNombreSector + ", Asiento " + nuevoNumeroAsiento + ", Precio: $" + nuevoPrecioFinal + ". Edad: " + edadOriginal + ". Descuento aplicado: " + (descuento * 100) + "%";
                            resumenTotalEntradas.set(indiceModificar, entradaModificada); // Actualiza la nueva entrada en la lista de entradas.
                            System.out.println(""); //Linea en blanco
                            System.out.println("Entrada modificada con exito.");
                            System.out.println("El nuevo asiento seleccionado es: " + entradaModificada);
                            System.out.println("---------------------------------------------------------");
                        }
                        System.out.println(""); // Linea en blanco al final  
                        break;
                    case 4:
                        System.out.println("--------------- Anulacion de Entradas --------------");
                        if (resumenTotalEntradas.isEmpty()) {
                            System.out.println("No se registran compras de entradas en el sistema.");
                            System.out.println("----------------------------------------------------");
                            System.out.println(""); //Linea en blanco
                        } else {
                            System.out.println("-----------------------------------------Reservas activas--------------------------------------------");
                            for (int i = 0; i < resumenTotalEntradas.size(); i++) {
                                System.out.println((i + 1) + "." + resumenTotalEntradas.get(i));
                            }
                            System.out.println("-----------------------------------------------------------------------------------------------------");

                            boolean idValido = false;
                            int idAnular = -1;
                            do {
                                System.out.println(""); //Linea en blanco
                                System.out.println("Ingrese el numero de la lista de la entrada a anular:");
                                try {
                                    int entradaAnular = sca.nextInt();
                                    idAnular = entradaAnular - 1; // Calcular el indice en el arreglo.

                                    if (idAnular >= 0 && idAnular < resumenTotalEntradas.size()) {
                                        idValido = true;
                                    } else {
                                        System.out.println("El numero de la lista ingresado no es valido. Intente nuevamente.");
                                    }
                                } catch (InputMismatchException e) {
                                    sca.next(); //Entrada para evitar bucle infinito.
                                    System.out.println("El numero de la lista ingresado no es valido. Intente nuevamente.");
                                    System.out.println(""); //Linea en blanco.
                                }
                            } while (!idValido);

                            // Se repite logica del case 3 para disponibilizar el asiento de la entrada anulada.
                            String entradaEliminada = resumenTotalEntradas.get(idAnular);

                            int asientoAnulado = - 1;
                            int sectorAnulado = - 1;
                            try {
                                String sector = entradaEliminada.substring(entradaEliminada.indexOf("Sector ") + 7, entradaEliminada.indexOf(", Asiento"));
                                String asiento = entradaEliminada.substring(entradaEliminada.indexOf("Asiento ") + 8, entradaEliminada.indexOf(", Precio"));
                                asientoAnulado = Integer.parseInt(asiento.trim());

                                if (sector.equals("VIP")) {
                                    sectorAnulado = 1;
                                } else if (sector.equals("Platea")) {
                                    sectorAnulado = 2;
                                } else if (sector.equals("Palco")) {
                                    sectorAnulado = 3;
                                }
                            } catch (InputMismatchException e) {
                                sca.next(); //Entrada para evitar bucle infinito.
                                System.out.println("El numero de la lista ingresado no es valido. Intente nuevamente.");
                                System.out.println(""); //Linea en blanco.
                            }
                            if (sectorAnulado != -1 && asientoAnulado != -1) {
                                int AsientoAnular = (sectorAnulado - 1) * 5 + (asientoAnulado - 1); //Calculo de indice en el array asientosReservados.
                                if (AsientoAnular >= 0 && AsientoAnular < asientosReservados.length) {
                                    asientosReservados[AsientoAnular] = false; // Logica para liberar asiento
                                    System.out.println("El asiento " + asientoAnulado + " del  Sector " + sectorAnulado + ", ahora esta disponible.");
                                } else {
                                    System.out.println("Ingrese un asiento valido (1-5):");
                                }
                                resumenTotalEntradas.remove(idAnular);
                                System.out.println(""); //Linea en blanco
                                System.out.println("---------------------------------------------------------");
                                System.out.println("Se ha anulado la entrada: " + entradaEliminada);
                                System.out.println("---------------------------------------------------------");
                            }
                        }
                        break;
                    case 5:
                        System.out.println("Saliendo del programa...");
                        System.out.println("¡Vuelva pronto!");
                        break;
                    default:
                        System.out.println("Opcion ingresada no valida. Por favor, intente nuevamente.");
                        System.out.println(""); //Linea en blanco.
                }
            }
        } while (opcion != 5);
    }
}
