package com.entertainment;
import java.util.Objects;

public class Television {
    private Brands brand;
    private static final int MAX_VOLUME = 100;
    private static final int MIN_VOLUME = 0;
    private int volume = 0;
    private final Tuner tuner = new Tuner();

    public Television() {
    }

    public Television(Brands brand) {
        this();
        setBrand(brand);
    }

    public Television(Brands brand, int volume) {
        this(brand);
        setVolume(volume);
    }

    // Getters

    public Brands getBrand() {
        return brand;
    }

    public int getVolume() {
        return volume;
    }

    public int getChannel() {
        return tuner.getChannel();
    }

    // Mutators

    public void setBrand(Brands brand) {
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

    public void setChannel(int channel) {
        tuner.setChannel(channel);
    }

    //Overloaded functions

    public boolean equals(Object tv) {
        boolean result = false;
        if(tv instanceof Television) { //Objects.equals is null safe check
            result = Objects.equals(this.getBrand(), ((Television) tv).getBrand()) &&
                    this.getVolume() == ((Television) tv).getVolume();
        }
        return result;
    }

    public int hashCode() {
        //return getBrand().hashCode() + getVolume();
        return Objects.hash(getBrand(),getVolume());
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