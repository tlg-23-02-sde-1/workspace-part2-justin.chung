package com.entertainment;
import java.util.Objects;

public class Television implements Comparable<Television> {
    private String brand;
    private static final int MAX_VOLUME = 100;
    private static final int MIN_VOLUME = 0;
    private int volume = 0;
    private final Tuner tuner = new Tuner();

    public Television() {
    }

    public Television(String brand) {
        this();
        setBrand(brand);
    }

    public Television(String brand, int volume) {
        this(brand);
        setVolume(volume);
    }

    // Getters

    public String getBrand() {
        return brand;
    }

    public int getVolume() {
        return volume;
    }

    public int getChannel() {
        return tuner.getChannel();
    }

    // Mutators

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setVolume(int volume) {
        if(volume <= MAX_VOLUME && volume >= MIN_VOLUME)
            this.volume = volume;
        else
            System.out.println("Volume must be between: " +
                    MAX_VOLUME + "-" +
                    MIN_VOLUME);
    }

    public void changeChannel(int channel) {
        tuner.setChannel(channel);
    }

    //Overloaded functions

//    @Override
//    public boolean equals(Object tv) {
//        boolean result = false;
//        if (this == tv) {
//            result = true;
//        }
//        else if(tv != null && (this.getClass() == tv.getClass())) { //Objects.equals is null safe check
//            Television other = (Television) tv;
//            result = (Objects.equals(this.getBrand(), other.getBrand()) &&
//                    (this.getVolume() == other.getVolume()));
//        }
//        return result;
//    }
//
//    @Override
//    public int hashCode() {
//        //return getBrand().hashCode() + getVolume();
//        return Objects.hash(getBrand(),getVolume());
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Television that = (Television) o;
        return getVolume() == that.getVolume() && Objects.equals(getBrand(), that.getBrand());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrand(), getVolume());
    }

    @Override
    public int compareTo(Television other) {
        int result = this.getBrand().compareTo(other.getBrand());
        if(result == 0){
            result = Integer.compare(this.getVolume(), other.getVolume());
        }
        return result;
    }


    @Override
    public String toString() {
        return getClass().getSimpleName() + "[" +
                "brand=" + getBrand() +
                ", volume=" + getVolume() +
                ", channel=" + getChannel() +
                ']';
    }
}