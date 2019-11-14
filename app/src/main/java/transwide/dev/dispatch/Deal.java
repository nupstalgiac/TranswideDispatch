package transwide.dev.dispatch;

public class Deal {
    private String Customer, Address, Price, CementQuantity, Remarks, PhoneNumber, CementType, DeliveryTerms;

    public Deal() {
    }

    public Deal(String customer, String address, String price, String cementQuantity, String remarks, String phoneNumber, String cementType, String deliveryTerms) {
        Customer = customer;
        Address = address;
        Price = price;
        CementQuantity = cementQuantity;
        Remarks = remarks;
        PhoneNumber = phoneNumber;
        CementType = cementType;
        DeliveryTerms = deliveryTerms;
    }

    public String getCustomer() {
        return Customer;
    }

    public void setCustomer(String customer) {
        Customer = customer;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getCementQuantity() {
        return CementQuantity;
    }

    public void setCementQuantity(String cementQuantity) {
        CementQuantity = cementQuantity;
    }

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String remarks) {
        Remarks = remarks;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getCementType() {
        return CementType;
    }

    public void setCementType(String cementType) {
        CementType = cementType;
    }

    public String getDeliveryTerms() {
        return DeliveryTerms;
    }

    public void setDeliveryTerms(String deliveryTerms) {
        DeliveryTerms = deliveryTerms;
    }
}

