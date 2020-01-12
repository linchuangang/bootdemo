package com.lin.bootdemo.enumcode;

public enum BillCustomerEnum {
    FUTAIHUA("1"),
    ARVATO("2"),
    YADA("3"),
    SAIERKANG("4"),
    SHIJIE("5"),
    YAZAKI("6"),
    GUOGUANG("7");

    private String customerCode;

    BillCustomerEnum(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }
}
