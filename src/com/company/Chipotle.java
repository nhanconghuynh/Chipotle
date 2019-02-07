package com.company;

/* Write a program that will allow a robot to assemble 25 burritos.
Use a random generator for each burrito option and build a list of 25 burrito customizations:
Rice: white, brown, none
Meat: chicken, steak, carnidas, chorizo, sofritas, veggies
Beans: pinto, black, none
Salsa: mild, medium, hot, none, all
Veggies: lettuce, fajita veggies, none, all
Cheese: yes/no
Guac: yes/no
Queso: yes/no
Sour cream: yes/no
Start with a minimum of 5 ingredients for a burrito.
If you still have time at the end, you can add more ingredients.
If you finish the project before 3pm then display a price for each burrito.
Pricing will be $3.00 plus .50 for each ingredient.
*/

import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.util.HashMap;

public class Chipotle {

    private static double calculate_price(ArrayList<String> burrito){

    double price=0;

    price = 3 + 0.5 * burrito.size();

    for (String value:burrito){
        if (
        (value.equalsIgnoreCase("no beans")) ||
        (value.equalsIgnoreCase("no salsa")) ||
        (value.equalsIgnoreCase("no additional veggies")) ||
        (value.equalsIgnoreCase("no rice"))
        )
                price = price - 0.5;
    }

    return price;
    }

    private static ArrayList<String> build_burrito(){

    ArrayList<String> burrito = new ArrayList<String>();

    Random index = new Random(),
           rand_rice = new Random(),
            rand_meat = new Random(),
            rand_beans = new Random(),
            rand_salsa = new Random(),
            rand_veggies = new Random(),
            rand_cheese = new Random(),
            rand_guac = new Random(),
            rand_queso = new Random(),
            rand_sour_cream = new Random();


    int index_rice=0,
        index_meat=0,
        index_beans=0,
        index_salsa=0,
        index_veggies=0;

    String[] rice = {"white rice", "brown rice", "no rice"};
    String[] meat = {"chicken", "steak", "carnidas", "chorizo", "sofritas", "veggies"};
    String[] beans = {"pinto beans", "black beans", "no beans"};
    String[] salsa = {"mild salsa" , "medium salsa" , "hot salsa" , "no salsa" , "all"};
    String[] veggies = {"lettuce" , "fajita veggies" , "no additional veggies" , "all"};
    boolean cheese = false,
            guac = false,
            queso = false,
            sour_cream = false;


    index_rice = rand_rice.nextInt(rice.length);
    burrito.add(rice[index_rice]);

    index_meat = rand_rice.nextInt(meat.length);
    burrito.add(meat[index_meat]);

    index_beans = rand_rice.nextInt(beans.length);
    burrito.add(beans[index_beans]);

    index_salsa = rand_salsa.nextInt(salsa.length);
    if (salsa[index_salsa].equalsIgnoreCase("all")) {
        for (int i=0; i<(salsa.length-2); i++)
            burrito.add(salsa[i]);
    }
    else burrito.add(salsa[index_salsa]);

    index_veggies = rand_veggies.nextInt(veggies.length);
    if (veggies[index_veggies].equalsIgnoreCase("all")) {
        for (int i=0; i<(veggies.length-2); i++)
            burrito.add(veggies[i]);
        }
    else burrito.add(veggies[index_veggies]);

    cheese = rand_cheese.nextBoolean();
    if (cheese) burrito.add("add cheese");

    guac = rand_guac.nextBoolean();
    if (guac) burrito.add("add guac");

    queso = rand_queso.nextBoolean();
    if (queso) burrito.add("add queso");

    sour_cream = rand_sour_cream.nextBoolean();
    if (sour_cream) burrito.add("add sour cream");

    return burrito;
    }


    public static void main(String[] args) {
    ArrayList<String> burrito = new ArrayList<String>();
    String formatted = "";
    double price=0;

    System.out.println("Welcome to Virtual Chipotle.  Here is your randomly generated virtual order for 25 burritos:");
    for (int i=1; i<=25; i++) {
        burrito = build_burrito();
        formatted = burrito.toString().replace("[","").replace("]","");
        System.out.println("\n\nBurrito " + i + ": " + formatted);
        price = calculate_price(burrito);
        System.out.print("Price is: $");
        System.out.printf("%.2f",price);
        burrito = new ArrayList<String>();
    }

    }
}
