package org._jd;

import org._jd.domain.Bus;
import org._jd.domain.BusStation;
import org._jd.domain.CashRegister;
import org._jd.exceptions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Bus> buses = new ArrayList<>(List.of(
                new Bus(1, 28),
                new Bus(5, 32),
                new Bus(15, 24)
        ));

        BusStation busStation = new BusStation(buses);

        CashRegister cashRegister = new CashRegister(busStation, 50);


        Scanner scanner = new Scanner(System.in);
        boolean flag = true;

        while (flag){
            System.out.println("Enter bus number: ");
            String input = scanner.nextLine();
            if (tryParseInt(input)){
                int busNumber = Integer.parseInt(input);

                System.out.println("Insert money: ");
                input = scanner.nextLine();
                if (tryParseDouble(input)){
                    double cash = Double.parseDouble(input);

                    try {
                        System.out.println(cashRegister.sellTicket(busNumber, cash));
                        flag = false;
                    } catch (WrongDataException e){
                        System.err.println(e.getMessage());
                    } catch (NotEnoughMoneyException e){
                        System.err.println(e.getMessage());
                    } catch (TicketNotFoundException e){
                        System.err.println(e.getMessage());
                    } catch (NotEnoughSeatsException e){
                        System.err.println(e.getMessage());
                    } catch (BusNotFoundException e){
                        System.err.println(e.getMessage());
                    }
                    catch (NoMoreTicketsException e){
                        System.err.println(e.getMessage());
                    }

                }
            } else throw new WrongDataException();
        }


    }
    public static boolean tryParseInt(String s){
        try {
            Integer.parseInt(s);
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    public static boolean tryParseDouble(String s){
        try {
            Double.parseDouble(s);
        } catch (NumberFormatException e){
            return false;
        }
        return true;
    }
}