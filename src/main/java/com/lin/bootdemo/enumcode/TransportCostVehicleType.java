package com.lin.bootdemo.enumcode;

public enum TransportCostVehicleType {

    LAND("陆运"),
    AIRWAY("空运"),
    RAILWAY("铁运"),
    EXPRESS("快速");

    private String vehicleType;

    TransportCostVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
}
