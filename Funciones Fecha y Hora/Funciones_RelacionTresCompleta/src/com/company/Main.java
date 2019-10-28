package com.company;

import java.util.Scanner;

public class Main {
//21. Escribe una función “diasMes”, a la que le pasamos un mes (en formato numérico 1=Enero, 2=Febrero, etc.) y
//    nos dice el número de días que tiene ese mes.

    public static int diasMes(int numeroMes)
    {
        int dias;

        switch(numeroMes)
        {
            case 1:
                dias = 31;
                break;
            case 2:
                dias = 28;
                break;
            case 3:
                dias = 31;
                break;
            case 4:
                dias = 30;
                break;
            case 5:
                dias = 31;
                break;
            case 6:
                dias = 30;
                break;
            case 7:
                dias = 31;
                break;
            case 8:
                dias = 31;
                break;
            case 9:
                dias = 30;
                break;
            case 10:
                dias = 31;
                break;
            case 11:
                dias = 30;
                break;
            case 12:
                dias = 31;
                break;
            default:
                dias = 0;
                break;
        }
        return dias;
    }

    public static int diasMesBisiesto(int numeroMes)
    {
        int dias;

        switch(numeroMes)
        {
            case 1:
                dias = 31;
                break;
            case 2:
                dias = 29;
                break;
            case 3:
                dias = 31;
                break;
            case 4:
                dias = 30;
                break;
            case 5:
                dias = 31;
                break;
            case 6:
                dias = 30;
                break;
            case 7:
                dias = 31;
                break;
            case 8:
                dias = 31;
                break;
            case 9:
                dias = 30;
                break;
            case 10:
                dias = 31;
                break;
            case 11:
                dias = 30;
                break;
            case 12:
                dias = 31;
                break;
            default:
                dias = 0;
                break;
        }
        return dias;
    }

//    22. Debido a que en los años bisiestos el mes de Febrero tiene 29 días en lugar de 28, necesitaremos también dar
//    el año para conseguir el resultado correcto. Escribe la función “diasMes2” a la que le pasas un mes y un año
//    (ambos enteros) y te dice cuántos días tiene ese mes, teniendo en cuenta si el año es bisiesto o no (NOTA: Podéis
//    usar la función “Bisiesto” que hicimos con anterioridad).

    public static int diasMes2(int numeroMes, int anno)
    {
        int dias;
        boolean bisiesto;
        bisiesto = false;

        if(anno % 4 == 0 && anno % 100 != 0 || anno % 400 == 0)
        {
            bisiesto = true;
        }

        if(!bisiesto) //bisiesto == false
        {
            dias = diasMes(numeroMes);
        }
        else
        {
            dias = diasMesBisiesto(numeroMes);
        }

        return dias;
    }

//    23. Escribe una función “diasTranscurridos” a la que le pasamos tres enteros, el día, el mes y el año, y nos
//    dice cuántos días han pasado desde el inicio del año hasta ese día. Así, el 1 de enero será el día 1 y el 31 de
//    diciembre será el 365 ó 366 dependiendo de si el año es bisiesto o no.

    public static int diasTranscurridos(int dia, int numeroMes, int anno)
    {
        int i, diasPasados;
        diasPasados = 0;

        for(i = 1; i < numeroMes; i++)
        {
            diasPasados = diasPasados + diasMes2(i,anno);
        }

        diasPasados = diasPasados + dia;

        return diasPasados;
    }

//    24. Escribe una función “diasTranscurridos1980” a la que le pasamos un día, mes y año y nos diga cuántos
//    días han transcurrido desde el 01/01/1980 hasta ese día.

    public static int diasTranscurridos1980(int dia, int numeroMes, int anno)
    {
        int i, diasPasados, annoInicio;
        diasPasados = 0;
        annoInicio = 1980;

        while(annoInicio < anno)
        {
            for(i = 1; i <= 12; i++)
            {
                diasPasados = diasPasados + diasMes2(i,annoInicio);
            }
            annoInicio++;
        }
        diasPasados = diasPasados + diasTranscurridos(dia,numeroMes,anno);

        return diasPasados;
    }

//    25. Escribe una función “diasEntreFechas” a la que le pasamos 6 enteros.
//    Un día, mes y año y otro día, mes y año, y nos dice cuántos días han pasado entre ambas fechas.

    public static int diasEntreFechas(int dia, int numeroMes, int anno, int diaDos, int numeroMesDos, int annoDos)
    {
        int dias, primerAnno, segundoAnno;

        if(anno < annoDos)
        {
            primerAnno = diasTranscurridos1980(dia,numeroMes,anno);
            segundoAnno = diasTranscurridos1980(diaDos,numeroMesDos,annoDos);
        }
        else
        {
            primerAnno = diasTranscurridos1980(diaDos,numeroMesDos,annoDos);
            segundoAnno = diasTranscurridos1980(dia,numeroMes,anno);
        }

        dias = segundoAnno - primerAnno;

        return dias;

    }

//    26. Teniendo en cuenta que el 01/01/1980 era martes, haz una función “diaSemanaFecha” que nos devuelva qué día de
//    la semana corresponde a la fecha (día, mes y año) que le pasamos en 3 parámetros. Nos devolverá un entero que
//    corresponderá al día de la semana (1=lunes, 2=martes, etc.).

    public static String diaSemanaTexto(int diaSemana)
    {
        String diaSemanaTexto;

        switch(diaSemana)
        {
            case 1:
                diaSemanaTexto = "Lunes";
                break;
            case 2:
                diaSemanaTexto = "Martes";
                break;
            case 3:
                diaSemanaTexto = "Miércoles";
                break;
            case 4:
                diaSemanaTexto = "Jueves";
                break;
            case 5:
                diaSemanaTexto = "Viernes";
                break;
            case 6:
                diaSemanaTexto = "Sábado";
                break;
            case 7:
                diaSemanaTexto = "Domingo";
                break;
            default:
                diaSemanaTexto = "Incorrecto.";
        }
        return diaSemanaTexto;
    }

    public static String diaSemanaFecha(int dia, int numeroMes, int anno)
    {
        int i, diasTotales, diaSemana;
        String diaFinal;
        diaSemana = 2;
        diasTotales = diasTranscurridos1980(dia,numeroMes,anno);

        for(i = 2; i <= diasTotales; i++)
        {
            if(diaSemana < 7)
            {
                diaSemana++;
            }
            else
            {
                diaSemana = 1;
            }
        }

        diaFinal = diaSemanaTexto(diaSemana);
        return diaFinal;
    }

    //SEGUNDA PARTE
//    30. Escribe una función “horaASegundos” a la que le pasas 3 parámetros enteros (hora, minutos y segundos) y
//    te devuelve el total de segundos.

    public static int horaSegundos(int horas, int minutos, int segundos)
    {
        int horaASegundos, minutosASegundos, segundosTotales;

        //Paso las horas a segundos:

        horaASegundos = horas * 60 * 60;

        //Paso los minutos a segundos:

        minutosASegundos = minutos * 60;

        //Sumo todos los segundos:

        segundosTotales = horaASegundos + minutosASegundos + segundos;

        return segundosTotales;
    }

//    31. Escribe una función “escribeHoraBonita” a la que le pasas tres parámetros
//            (hora, minutos y segundos) y te escribe por pantalla la hora en formato “HH:MM:SS”.

    public static void escribeHoraBonita(int horas, int minutos, int segundos)
    {
        if (horas < 10)
        {
            System.out.print("0" + horas + ":");
        }
        else
        {
            System.out.print(horas + ":");
        }
        if (minutos < 10)
        {
            System.out.print("0" + minutos + ":");
        }
        else
        {
            System.out.print(minutos + ":");
        }
        if (segundos < 10)
        {
            System.out.print("0" + segundos);
        }
        else
        {
            System.out.print(segundos);
        }
    }
//32. Escribe una función “escribeSegundosBonito” a la que le pasas un parámetro que corresponde al número de segundos y
//    te escribe por pantalla la hora en formato “HH:MM:SS”.

    public static void escribeSegundosBonitos(int segundos)
    {
        int minutos, minutosTotal, segundosTotal, horasTotal;

        segundosTotal = segundos % 60;
        minutos = segundos / 60;

        horasTotal = minutos / 60;
        minutosTotal = minutos % 60;

        escribeHoraBonita(horasTotal,minutosTotal,segundosTotal);

    }

//    33. Escribe una función “segundosTranscurridos” a la que le pasas 2 horas (en total, 6
//   parámetros: hora, minutos y segundos para cada una de las dos horas) y te dice
//    cuántos segundos han transcurrido entre una y otra.

    public static int segundosTranscurridos(int horas, int minutos, int segundos, int horasDos, int minutosDos, int segundosDos)
    {
        int segundosPrimero, segundosSegundo, segundosTotales;

        segundosPrimero = horaSegundos(horas,minutos,segundos);
        segundosSegundo = horaSegundos(horasDos,minutosDos,segundosDos);

        if(segundosPrimero < segundosSegundo)
        {
            segundosTotales = segundosSegundo - segundosPrimero;
        }
        else
        {
            segundosTotales = segundosPrimero - segundosSegundo;
        }

        return segundosTotales;
    }

//    34. Escribe una función “segundosTranscurridos1980” a la que le pasas 6 parámetros: día,
//    mes, año, hora, minutos y segundos y te dice cuántos segundos han transcurrido
//    desde el 1 de enero de 1980.

    public static int segundosTranscurridos1980(int dias, int numeroMes, int anno, int horas, int minutos, int segundos)
    {
        int diaTotales, tiempoTotal, segundosTranscurridos;
        diaTotales = 0;
        tiempoTotal = 0;
        segundosTranscurridos = 0;

        diaTotales = diasTranscurridos1980(dias,numeroMes,anno);
        tiempoTotal = horaSegundos(horas,minutos,segundos);

        segundosTranscurridos = (diaTotales * 24 * 60 * 60) + tiempoTotal;

        return segundosTranscurridos;
    }

    public static void main(String[] args) {
        int opcion, numeroMes, anno, dia, diaDos, numeroMesDos, annoDos, horas, minutos, segundos, horasDos, minutosDos, segundosDos;

        Scanner sc = new Scanner(System.in);

        System.out.println("MENÚ");
        System.out.println("------");
        System.out.println("1. Ejercicio 21.");
        System.out.println("2. Ejercicio 22.");
        System.out.println("3. Ejercicio 23.");
        System.out.println("4. Ejercicio 24.");
        System.out.println("5. Ejercicio 25.");
        System.out.println("6. Ejercicio 26.");
        System.out.println("7. Ejercicio 30.");
        System.out.println("8. Ejercicio 31.");
        System.out.println("9. Ejercicio 32.");
        System.out.println("10. Ejercicio 33.");
        System.out.println("11. Ejercicio 34.");
        opcion = sc.nextInt();

        switch (opcion)
        {
            case 1:
                System.out.println("Escriba un mes en formato númerico, es decir, Enero = 1, Febrero = 2, etc.");
                numeroMes = sc.nextInt();

                System.out.println("El mes elegido tiene " + diasMes(numeroMes) + " días.");
                break;
            case 2:
                System.out.println("Escriba un mes en formato númerico (Enero = 1, Febrero = 2, etc.)");
                numeroMes = sc.nextInt();

                System.out.println("Escriba un año.");
                anno = sc.nextInt();

                System.out.println("El mes elegido del año indicado tiene " + diasMes2(numeroMes,anno) + " días.");
                break;
            case 3:
                System.out.println("Escriba un día en formato númerico.");
                dia = sc.nextInt();

                System.out.println("Escriba un mes en formato númerico (Enero = 1, Febrero = 2, etc.).");
                numeroMes = sc.nextInt();

                System.out.println("Escriba un año.");
                anno = sc.nextInt();

                System.out.println("Han transcurrido " + diasTranscurridos(dia,numeroMes,anno) + " días.");
                break;
            case 4:
                System.out.println("Escriba un día en formato númerico.");
                dia = sc.nextInt();

                System.out.println("Escriba un mes en formato númerico (Enero = 1, Febrero = 2, etc.).");
                numeroMes = sc.nextInt();

                System.out.println("Escriba un año.");
                anno = sc.nextInt();

                System.out.println("Han transcurrido " + diasTranscurridos1980(dia,numeroMes,anno) + " días desde el 1 de Enero de 1980.");
                break;
            case 5:
                System.out.println("Escriba un día en formato númerico.");
                dia = sc.nextInt();

                System.out.println("Escriba un mes en formato númerico (Enero = 1, Febrero = 2, etc.).");
                numeroMes = sc.nextInt();

                System.out.println("Escriba un año.");
                anno = sc.nextInt();

                System.out.println("Escriba un día en formato númerico.");
                diaDos = sc.nextInt();

                System.out.println("Escriba un mes en formato númerico (Enero = 1, Febrero = 2, etc.).");
                numeroMesDos = sc.nextInt();

                System.out.println("Escriba un año.");
                annoDos = sc.nextInt();

                System.out.println("Han transcurrido " + diasEntreFechas(dia,numeroMes,anno,diaDos,numeroMesDos,annoDos) + " días entre las dos fechas que introdujo.");
                break;
            case 6:
                System.out.println("Escriba un día en formato númerico.");
                dia = sc.nextInt();

                System.out.println("Escriba un mes en formato númerico (Enero = 1, Febrero = 2, etc.).");
                numeroMes = sc.nextInt();

                System.out.println("Escriba un año.");
                anno = sc.nextInt();

                System.out.println("La fecha introducida cayó en " + diaSemanaFecha(dia,numeroMes,anno));
                break;
            case 7:
                System.out.println("Escriba las horas.");
                horas = sc.nextInt();

                System.out.println("Escriba los minutos.");
                minutos = sc.nextInt();

                System.out.println("Escriba los segundos.");
                segundos = sc.nextInt();

                System.out.println("El total de segundos es: " + horaSegundos(horas,minutos,segundos));
                break;
            case 8:
                System.out.println("Escriba las horas.");
                horas = sc.nextInt();

                System.out.println("Escriba los minutos.");
                minutos = sc.nextInt();

                System.out.println("Escriba los segundos.");
                segundos = sc.nextInt();

                escribeHoraBonita(horas,minutos,segundos);
                break;
            case 9:
                System.out.println("Escriba los segundos.");
                segundos = sc.nextInt();

                escribeSegundosBonitos(segundos);
                break;
            case 10:
                System.out.println("Escriba las horas.");
                horas = sc.nextInt();

                System.out.println("Escriba los minutos..).");
                minutos = sc.nextInt();

                System.out.println("Escriba los segundos.");
                segundos = sc.nextInt();

                System.out.println("Escriba las horas.");
                horasDos = sc.nextInt();

                System.out.println("Escriba los minutos.");
                minutosDos = sc.nextInt();

                System.out.println("Escriba los segundos.");
                segundosDos = sc.nextInt();

                System.out.println("Han transcurrido " + segundosTranscurridos(horas,minutos,segundos,horasDos,minutosDos,segundosDos) + " segundos entre ambas horas.");

                break;
            case 11:
                System.out.println("Escriba el día.");
                dia = sc.nextInt();

                System.out.println("Escriba el mes en formato numérico.");
                numeroMes = sc.nextInt();

                System.out.println("Escriba el año.");
                anno = sc.nextInt();

                System.out.println("Escriba las horas.");
                horas = sc.nextInt();

                System.out.println("Escriba los minutos.");
                minutos = sc.nextInt();

                System.out.println("Escriba los segundos.");
                segundos = sc.nextInt();

                System.out.println("Han transcurrido " + segundosTranscurridos1980(dia,numeroMes,anno,horas,minutos,segundos) + " segundos en total.");
                break;
        }
    }
}
