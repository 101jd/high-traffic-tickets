package org._jd.UI;

import org._jd.domain.Bus;
import org._jd.domain.BusStation;
import org._jd.domain.BusTicketOrder;
import org._jd.domain.CashRegister;
import org._jd.domain.interfaces.Register;
import org._jd.domain.interfaces.Station;
import org._jd.exceptions.*;
import org._jd.repository.DataAccess;
import org._jd.repository.DataAccessImpl;
import org._jd.repository.Repo;
import org._jd.repository.RepoImpl;
import org._jd.service.BusServiceImpl;
import org._jd.service.Service;

import java.util.List;
import java.util.Scanner;

public class UIImpl implements UI {
    private final Scanner scanner = new Scanner(System.in);
    private Repo repo;
    private DataAccess dataAccess;
    private Station station;
    private Register register;
    private Service service;

    private double insertedCash = 0;

    public UIImpl(double cost) {
        this.repo = new RepoImpl();
        this.dataAccess = new DataAccessImpl(repo);
        this.station = new BusStation(List.of(
                new Bus(1, 28),
                new Bus(5, 32),
                new Bus(15, 24)
        ));
        this.register = new CashRegister(station, cost);
        this.service = new BusServiceImpl(register, dataAccess);
        this.insertedCash = 0;
    }

    @Override
    public void insertMoney() {
        System.out.println("Insert money: ");
        String input = scanner.nextLine();
        if (tryParseDouble(input)) {
            insertedCash = Double.parseDouble(input);
        }
    }

        @Override
        public BusTicketOrder buyTicket ( int busNumber){
            return service.sellTicket(busNumber, insertedCash);
        }

    @Override
    public void menu() {

        boolean flag = true;

        while (flag){

            insertMoney();
            System.out.println("Enter bus number: ");
            String input = scanner.nextLine();
            if (tryParseInt(input)){

                if (tryParseDouble(input)){
                    int busNumber = Integer.parseInt(input);
                    try {
                        System.out.println(buyTicket(busNumber));
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

    @Override
    public void init() {
        service.initTickets();
        service.initBuses();
    }

    private boolean tryParseInt (String s){
            try {
                Integer.parseInt(s);
            } catch (NumberFormatException e) {
                return false;
            }
            return true;
        }

        private boolean tryParseDouble (String s){
            try {
                Double.parseDouble(s);
            } catch (NumberFormatException e) {
                return false;
            }
            return true;
        }
    }

