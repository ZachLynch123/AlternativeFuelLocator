package com.zachary.lynch.altfuelmap;



public class StationData {
    private String mFuel_type_code;
    private int mId;
    private String mStation_Phone;
    private String mStation_Name;
    private double mLatitude;
    private double mLongitude;
    private String mCity;
    private String mState;
    private String mStreet_address;
    private double mZip;
    private String mCountry;
    private double mHasE85;
    private String mE85;
    private String mElectirc;
    private double mTotal;

    public String getFuel_type_code() {
        return mFuel_type_code;
    }

    public void setFuel_type_code(String fuel_type_code) {
        mFuel_type_code = fuel_type_code;
    }

    public String getStation_Phone() {
        return mStation_Phone;
    }

    public void setStation_Phone(String station_Phone) {
        mStation_Phone = station_Phone;
    }

    public String getStation_Name() {
        return mStation_Name;
    }

    public void setStation_Name(String station_Name) {
        mStation_Name = station_Name;
    }

    public double getLatitude() {
        return mLatitude;
    }

    public void setLatitude(double latitude) {
        mLatitude = latitude;
    }

    public double getLongitude() {
        return mLongitude;
    }

    public void setLongitude(double longitude) {
        mLongitude = longitude;
    }

    public String getCity() {
        return mCity;
    }

    public void setCity(String city) {
        mCity = city;
    }

    public String getState() {
        return mState;
    }

    public void setState(String state) {
        mState = state;
    }

    public String getStreet_address() {
        return mStreet_address;
    }

    public void setStreet_address(String street_address) {
        mStreet_address = street_address;
    }

    public double getZip() {
        return mZip;
    }

    public void setZip(double zip) {
        mZip = zip;
    }

    public String getCountry() {
        return mCountry;
    }

    public void setCountry(String country) {
        mCountry = country;
    }

    public double getHasE85() {
        return mHasE85;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public double getTotal() {
        return mTotal;
    }

    public void setTotal(double total) {
        mTotal = total;
    }

    public void setHasE85(double hasE85) {
        mHasE85 = hasE85;
    }

    public String getE85() {
        return mE85;
    }

    public void setE85(String e85) {
        mE85 = e85;
    }

    public String getElectirc() {
        return mElectirc;
    }

    public void setElectirc(String electirc) {
        mElectirc = electirc;
    }
}
