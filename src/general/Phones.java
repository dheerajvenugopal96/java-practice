package dsa.src.general;

public enum Phones {

    NONE(0,0),
    IPHONE_10(3,31000),
    PIXEL_7A(3,41000),
    S24_ULTRA(4,99000),
    NOTHING_2(2,43000),
    REDMI14_ULTRA(4,27000);

    final int rating;
    final int price;

    Phones(int rating, int price) {
        this.rating = rating;
        this.price = price;
    }
}