import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class CalculoBonoSueldo {

    //main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //codigo - denominacion -    porcentaje
        String[][] haberes = {
                {"100", "Presentismo", "11"},
                {"101", "Titulo profesional", "30"},
                {"102", "Goras Extraordinarias", "10"},
                {"103", "Horas Nocturnas", "8"},
                {"104", "Kilometros Recorridos", "15"},
                {"105", "Mayor Responsabilidad", "20"},
                {"106", "Kilometros", "15"},
                {"107", "Viaticos", "10"}
        };

        //codigo - denominacion -       porcentaje
        String[][] deducciones = {
                {"200", "Obra Social", "10"},
                {"201", "Jubilacion", "12"},
                {"202", "Sindicato", "3"},
                {"203", "Seguro", "2"},
                {"204", "Austentismo", "5"},
                {"205", "Enfermedad", "10"},
                {"206", "Razones Particulares", "5"},
                {"207", "Comision", "5"}
        };

        //instanciar clase empleado
        Empleado empleado = new Empleado();

        //donde vamos a guardar los empleados
        ArrayList<Empleado> empleados = new ArrayList<>(); //utilizamos esto cuando queremos agregar otro empleados

        //pedimos los datos del empleado y lo guardamoes en empleado
        System.out.println("Ingrese nombre del empleado: ");
        empleado.setNombreEmpleado(sc.nextLine());

        System.out.println("Ingrese DNI del empleado: ");
        empleado.setDni(sc.nextLong());

        //validamos el sueldo>100,000
        double sueldo;
        do {
            System.out.println("Ingrese sueldo basico del empleado: ");
            sueldo = sc.nextDouble();

            if (sueldo <= 100000) {//si es verdadero entra al codicional if
                System.out.println("El sueldo basico debe ser mayor a 100000, intente de nuevo ");
            }
        } while (sueldo <= 100000);//el bucle sigue mientras la consicion sea verdadera


        //una vez validada guardamos el sueldo en empleado
        empleado.setSueldoBasico(sueldo);

        //guardamos empleado a la lisat de empleados
        empleados.add(empleado);

        System.out.println("Empleado cargado con exito!");
        //------------------------------------------------------

        //creamos una lista para guardar los bonos
        ArrayList<BonoSueldo> bonoSueldos = new ArrayList<>();

        //empezamos a crear los bonos de los 12 meses del año
        for (int mes = 0; mes < 12; mes++) {

            //instanciamos cada vez que de una vuelta la clase BonoSueldo
            BonoSueldo bonoSueldo = new BonoSueldo();
            //guardamos cada vez que de una vuelta empleado(no muy revelante)
            bonoSueldo.setEmpleado(empleado);
            //creamos un hashset para itemsAgregados, hacemos esto para que no se repitan los mismos
            HashSet<String> itemsAgregados = new HashSet<>();

            //contadores
            int contadorH = 0; //contador haberes
            int contadorD = 0; //contador deducciones


            //lista donde guardaremos los itemsbonos
            ArrayList<ItemBono> itemBonos = new ArrayList<>();


            while (contadorD < 3 || contadorH < 3) {
                Random random = new Random();
                int numeroX = 100 + random.nextInt(8);
                String numeroStringHaberes = Integer.toString(numeroX);

                if (!itemsAgregados.contains(numeroStringHaberes) && contadorH < 3) {
                    ItemBono itemBono = new ItemBono();
                    boolean itemConfigurado = false;
                    bonoSueldo.setMesLiquidacion(mes + 1);

                    for (String[] habere : haberes) {
                        bonoSueldo.setMesLiquidacion(mes + 1); //guardamos el mes de liquidacion

                        if (numeroStringHaberes.equals(habere[0])) { //si el numeroString es igual al dato que esta en habere[0], entra al condicional

                            itemBono.setCodigoItem(Integer.parseInt(habere[0])); //guarda el codigo del item en el objeto itemBono
                            itemBono.setDenominacionItem(habere[1]); //guarda la denominacion del item en el objeto itemBono
                            itemBono.setPorcentajeItem(Double.parseDouble(habere[2]));//guarda el porcentaje del item en el objeto itemBono
                            itemBono.setMontoItem((sueldo * itemBono.getPorcentajeItem()) / 100); //guarda el monto del item en ek objeto itemBono
                            itemBono.setEsDeduccion(false); //si es haber, el booleano es false, sino, es true
                            itemConfigurado = true; //si el item ya esta configurado, cambia a true
                            break; //rompe el ciclo
                        }
                    }

                    //si el condicional es verdadero entra al if
                    if (itemConfigurado) {

                        itemBonos.add(itemBono); //guardamos el objeto itemBono, en la lista itemsBonos
                        itemsAgregados.add(numeroStringHaberes);//guardamos el numeroString en la lista de itemsAgregados
                        contadorH++; //incrementamos el contador
                    }
                }


                //hacemos lo mismo que lo anterior, pero para deducciones
                int numeroY = 200 + random.nextInt(8);
                String numeroStringDeducciones = Integer.toString(numeroY);

                if (!itemsAgregados.contains(numeroStringDeducciones) && contadorD < 3) {
                    ItemBono itemBono = new ItemBono();
                    boolean itemConfigurado = false;
                    bonoSueldo.setMesLiquidacion(mes + 1);

                    for (String[] deduccione : deducciones) {
                        bonoSueldo.setMesLiquidacion(mes + 1);

                        if (numeroStringDeducciones.equals(deduccione[0])) {
                            itemBono.setCodigoItem(Integer.parseInt(deduccione[0]));
                            itemBono.setDenominacionItem(deduccione[1]);
                            itemBono.setPorcentajeItem(Double.parseDouble(deduccione[2]));
                            itemBono.setMontoItem((sueldo * itemBono.getPorcentajeItem()) / 100);
                            itemBono.setEsDeduccion(true);
                            itemConfigurado = true;
                            break;
                        }
                    }

                    if (itemConfigurado) {
                        itemBonos.add(itemBono);
                        itemsAgregados.add(numeroStringDeducciones);
                        contadorD++;
                    }
                }
            }


            //guardamos los items en bonosueldo del empleado
            bonoSueldo.setItemsBonos(itemBonos);
            //agregamos el bonosueldo a la lista bonoSueldos
            bonoSueldos.add(bonoSueldo);
        }
        //fuera del bucle for

        //agregamos los bonosSueldos a empleado
        empleado.setBonos(bonoSueldos);


        //---------mostramos la tabla----------

        // Iterar por cada bono del empleado
        for (BonoSueldo bono : empleado.getBonos()) {
            System.out.println("==========================================================================");
            System.out.println("Nombre: "+empleado.getNombreEmpleado());
            System.out.println("DNI: "+empleado.getDni());
            System.out.println("Sueldo Basico: "+empleado.getSueldoBasico());
            System.out.println("Mes de liquidación: " + bono.getMesLiquidacion());

            //definimos e inicializamos las variables
            double subtotalHaberes = 0;
            double subtotalDeducciones = 0;


            // Imprimir encabezado de la tabla
            System.out.printf("%-15s %-30s %-15s %-15s%n", " Código", " Denominación", " % Porcentaje", "$ Monto");
            System.out.println("--------------------------------------------------------------------------");

            // Iterar por cada ítem del bono
            for (ItemBono item : bono.getItemsBonos()) { // por cada item de ItemBono, muestra itemsBono de bono

                // Calcular subtotales
                if (item.isEsDeduccion()) { //entra si es true
                    subtotalDeducciones += item.getMontoItem(); //guarda el monto en subtotalDeducciones

                } else {//si es false, entra al else
                    subtotalHaberes += item.getMontoItem();//guarda el monto en subtotalHaberes
                }

                // Imprimir cada ítem en formato de fila
                System.out.printf("%-15d %-30s %-15.2f %-15.2f%n",
                        item.getCodigoItem(),
                        item.getDenominacionItem(),
                        item.getPorcentajeItem(),
                        item.getMontoItem());
            }

            // Imprimir subtotales y neto
            System.out.println("--------------------------------------------------------------------------");
            System.out.printf("%-45s %-15.2f %-15.2f%n", "Subtotal Haberes:", subtotalHaberes, 0.0);
            System.out.printf("%-45s %-15.2f %-15.2f%n", "Subtotal Deducciones:", 0.0, subtotalDeducciones);
            System.out.printf("%-45s %-15.2f %-15.2f%n", "Neto:", subtotalHaberes - subtotalDeducciones, 0.0);
            System.out.println("==========================================================================");
        }
    }

}
