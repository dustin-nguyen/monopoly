package com.company;

import java.util.ArrayList;
import java.util.List;

public class CreateLand {
    //  bottom right from screen, error 0,2222222......px
    StratingPoint strating_point = new StratingPoint("Strating Point", 692, 692, 84, 84);

        House mediteranean  = new House("Mediteranean", 40, 608, 692, 84, 58);
        Chest chest1        = new Chest("Chest", 550, 692, 84, 58);
        House baltic        = new House("Baltic", 40, 492, 692, 84, 58);
        Tax railroad1       = new Tax("RailRoad", 200, 434, 692, 84, 58);
        Tax tax             = new Tax("tax",200,376,692,84,58);
        House oriental      = new House("Oriental", 100, 318, 692, 84, 58);
        Chance chance1 = new Chance("Chance", 260, 692, 84, 58);
        House vermon = new House("Vermon", 100, 202, 692, 84, 58);
        House connecticut = new House("Connecticut", 120, 144, 692, 84, 58);

        Jail jail = new Jail("Jail", 84, 692, 84, 84);

        House charles = new House("St.Charles", 140, 84, 608, 84, 58);
        Tax electric = new Tax("Electric", 150, 84, 550, 84, 58);
        House state = new House("States", 140, 84, 492, 84, 58);
        Tax railroad2 = new Tax("RailRoad", 200, 84, 376, 84, 58);
        House jamas = new House("St.James", 120, 84, 318, 84, 58);
        Chest chest2 = new Chest("Chest", 84, 260, 84, 58);
        House tennessee = new House("Tennessee", 120, 84, 202, 84, 58);
        House neyyork = new House("Ney York", 120, 84, 144, 84, 58);

        FreePark freepark = new FreePark("FreeParking", 84, 84, 84, 84);

        House kentucky = new House("Kentucky", 120, 142, 84, 84, 58);
        Chance chance2 = new Chance("Chance", 200, 84, 84, 58);
        House indeana = new House("Indeana", 120, 258, 84, 84, 58);
        House illinois = new House("Illinois", 120, 316, 84, 84, 58);
        Tax railroad3 = new Tax("RailRoad", 200, 374, 84, 84, 58);
        House atlantic = new House("Atlantic", 220, 432, 84, 84, 58);
        Tax water = new Tax("Water", 150, 490, 84, 84, 58);
        House ventor = new House("Ventor", 220, 548, 84, 84, 58);
        House marvin = new House("Marvin", 220, 606, 84, 84, 58);

        GoToJail goToJail = new GoToJail("GoToJail", 692, 84, 84, 84);

        House pacific = new House("Pacific", 300, 692, 142, 84, 58);
        House carolina = new House("Carolina", 300, 692, 200, 84, 58);
        Chest chest3 = new Chest("Chest", 692, 258, 84, 58);
        House pennsylvania = new House("Pennsylvania", 300, 692, 316, 84, 58);
        Tax railroad4 = new Tax("Shortline", 200, 692, 374, 84, 58);
        Chance chance3 = new Chance("Chance", 692, 432, 84, 58);
        House park = new House("Park", 350, 692, 490, 84, 58);
        Tax luxury = new Tax("Luxury", 200, 692, 548, 84, 58);
        House broadwalk = new House("Broadwalk", 350, 692, 606, 84, 58);

/////////////////////////////////////////////////
    public House[] horizontal_house= {mediteranean,baltic,oriental,vermon,connecticut,kentucky,indeana,illinois,atlantic,ventor,marvin};
    public House[] vertical_house  = {charles,state,jamas,tennessee,neyyork,pacific,carolina,pennsylvania,park,broadwalk};
    public Unbuyable[] horizontal_unbuyable = {railroad1,tax,railroad3,water,chest2,chest3,chance1,chance2};
    public Unbuyable[] vertical_unbuyable = {electric,railroad2,railroad4,luxury,chest1,chance3};
}
