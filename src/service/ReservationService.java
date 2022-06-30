package service;

import model.Customer;
import model.IRoom;
import model.Reservation;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class ReservationService {
    static Collection<Reservation> allReservations;
    static Collection<IRoom> allRooms;

    public ReservationService() {
        allReservations = new ArrayList<>();
        allRooms = new ArrayList<>();
    }

    public static void addRoom(IRoom room) {
        allRooms.add(room);
    }

    public static IRoom getARoom(String roomId) {
        for(IRoom room: allRooms) {
            if(room.getRoomNumber().equals(roomId)) {
                return room;
            }
        }
        return null;
    }

    public static Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
        allReservations.add(reservation);
        return reservation;
    }

    public static Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        Collection<IRoom> availableRooms = new ArrayList<>();
        if (availableRooms.isEmpty()) return null;
        for(Reservation reservation: allReservations) {
            if(!reservation.isReserved(checkInDate, checkOutDate)) availableRooms.add(reservation.getRoom());
        }
        return availableRooms;
    }

    public static Collection<Reservation> getCustomersReservation(Customer customer) {
        Collection<Reservation> availableReservations = new ArrayList<>();
        if(allReservations.isEmpty()) return null;
        for(Reservation reservation: allReservations) {
            if(reservation.getCustomer() == customer) availableReservations.add(reservation);
        }
        return availableReservations.isEmpty() ? null : availableReservations;
    }

    public static Collection<IRoom> getAllRooms() {
        return allRooms;
    }

    public static void printAllReservation() {
        System.out.println(String.format("Printing all reservations [%d]", allReservations.size()));
        for(Reservation reservation: allReservations) {
            System.out.println(reservation);
        }
    }
}
