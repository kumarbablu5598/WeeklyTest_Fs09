package com.Restaurant.Model;

public class Restaurant {
    private int RestaurantId;
    private String RestaurantName;
    private String RestaurantAddress;
    private String RestaurantNumber;
    private String Specialty;
    private int totalStaff;

    public Restaurant() {

    }

    public Restaurant(int restaurantId, String restaurantName, String restaurantAddress, String restaurantNumber, String specialty, int totalStaff) {
        RestaurantId = restaurantId;
        RestaurantName = restaurantName;
        RestaurantAddress = restaurantAddress;
        RestaurantNumber = restaurantNumber;
        Specialty = specialty;
        this.totalStaff = totalStaff;
    }

    public int getRestaurantId() {
        return RestaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        RestaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return RestaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        RestaurantName = restaurantName;
    }

    public String getRestaurantAddress() {
        return RestaurantAddress;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        RestaurantAddress = restaurantAddress;
    }

    public String getRestaurantNumber() {
        return RestaurantNumber;
    }

    public void setRestaurantNumber(String restaurantNumber) {
        RestaurantNumber = restaurantNumber;
    }

    public String getSpecialty() {
        return Specialty;
    }

    public void setSpecialty(String specialty) {
        Specialty = specialty;
    }

    public int getTotalStaff() {
        return totalStaff;
    }

    public void setTotalStaff(int totalStaff) {
        this.totalStaff = totalStaff;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "RestaurantId=" + RestaurantId +
                ", RestaurantName='" + RestaurantName + '\'' +
                ", RestaurantAddress='" + RestaurantAddress + '\'' +
                ", RestaurantNumber='" + RestaurantNumber + '\'' +
                ", Specialty='" + Specialty + '\'' +
                ", totalStaff=" + totalStaff +
                '}';
    }
}
