package model;

public class Room implements IRoom{

    String roomNumber;
    Double price;
    RoomType type;
    boolean taken;
    public Room(String roomNumber, Double price, RoomType type) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.type = type;
        this.taken = false;
    }

    @Override
    public String getRoomNumber() {
        return roomNumber;
    }

    @Override
    public Double getRoomPrice() {
        return price;
    }

    @Override
    public RoomType getRoomType() {
        return type;
    }

    @Override
    public boolean isFree() {
        return !taken;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public void changeAvailableStatus() {
        this.taken = !this.taken;
    }

    @Override
    public String toString() {
        return String.format("Room number: %d, %s bed, Room Price: $%f", roomNumber, type.name(), price);
    }
}
