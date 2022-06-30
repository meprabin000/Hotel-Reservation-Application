package model;

public class FreeRoom extends Room{
    public FreeRoom(String roomNumber, Double price, RoomType type) {
        super(roomNumber, price, type);
        this.price = 0.0;
    }

    @Override
    public String toString() {
        return "FreeRoom{" +
                "roomNumber='" + roomNumber + '\'' +
                ", price=" + price +
                ", type=" + type +
                ", taken=" + taken +
                '}';
    }
}
