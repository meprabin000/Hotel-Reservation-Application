package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reservation {
    Customer customer;
    IRoom room;
    Date checkInDate;
    Date checkOutDate;

    public Reservation(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public IRoom getRoom() {
        return room;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public boolean isReserved(Date checkInDate, Date checkOutDate) {
        if(checkInDate.before(this.checkInDate)) {
            if(checkOutDate.before(this.checkInDate)) return false;
            return true;
        }
        else
        {
            if(checkInDate.before(this.checkOutDate)) return true;
            return false;
        }
    }



    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

        return String.format("Reservation: \nCustomer: %s\nRoom: %s\ncheckInDate: %s\ncheckOutDate: %s\n",
                customer, room, formatter.format(checkInDate), formatter.format(checkOutDate));
    }
}
