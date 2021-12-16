package com.example.hotel_management;

public class tableview {

        String id;
        String dest;
        String name;
        String email;
        String phone;
        String idproof ;
        String Check_in;



    String Checkout;
        String room_no;
        String totalprice;


        public tableview(String id,String dest,String name,String email,String phone,String idproof,String Check_in,String Checkout,String room_no,String totalprice)
        {
            this.id=id;
            this.dest=dest;
            this.name=name;
            this.email=email;
            this.phone=phone;
            this.idproof=idproof;
            this.Check_in=Check_in;
            this.Checkout=Checkout;
            this.room_no=room_no;
            this.totalprice=totalprice;
        }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdproof() {
        return idproof;
    }

    public void setIdproof(String idproof) {
        this.idproof = idproof;
    }

    public String getCheck_in() {
        return Check_in;
    }

    public void setCheck_in(String check_in) {
        Check_in = check_in;
    }

    public String getCheckout() {
        return Checkout;
    }

    public void setCheckout(String checkout) {
        Checkout = checkout;
    }



    public String getRoom_no() {
        return room_no;
    }

    public void setRoom_no(String room_no) {
        this.room_no = room_no;
    }

    public String getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(String totalprice) {
        this.totalprice = totalprice;
    }
}
