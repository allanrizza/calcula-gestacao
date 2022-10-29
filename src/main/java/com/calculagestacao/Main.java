package com.calculagestacao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.print("Digite a data do início da getação [dd/MM/yyyy]: ");
        String data1 = scan.nextLine();
        LocalDate dataInicio = LocalDate.parse(data1, dtf);
        System.out.print("Digite a data atual [dd/MM/yyyy]: ");
        String data2 = scan.nextLine();
        LocalDate dataFim = LocalDate.parse(data2, dtf);
        Long semanas = null;
        Long dias = null;
        Long aux = 0L;
        Long diasEntre = ChronoUnit.DAYS.between(dataInicio, dataFim);

        while(semanas == null && dias == null) {
            if (diasEntre % 7L != 0L) {
                diasEntre = diasEntre - 1L;
                aux = aux + 1L;
            } else {
                semanas = diasEntre / 7L;
                dias = aux;
            }
        }

        String singularPlural;
        if (dias > 1L) {
            singularPlural = " dias";
        } else {
            singularPlural = " dia";
        }

        System.out.println("Já se passaram " + semanas + " semanas e " + dias + singularPlural + " de gestação.");
        scan.close();
    }
}
