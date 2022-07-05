package com.softserve.edu.opencart.data.user;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class UserRepositorySingleton {
    private static volatile UserRepositorySingleton instance = null;
    //
    private final String TIME_TEMPLATE = "HH_mm_ss_S";

    private UserRepositorySingleton() {
    }

    public static UserRepositorySingleton get() {
        if (instance == null) {
            synchronized (UserRepositorySingleton.class) {
                if (instance == null) {
                    instance = new UserRepositorySingleton();
                }
            }
        }
        return instance;
    }

    public IUser getDefault() {
        return hahaha();
    }

    public IUser hahaha() {
        return User.get()
                .setFirstname("hahaha")
                .setLastname("hahaha")
                .setEmail("hahaha@gmail.com")
                .setTelephone("hahaha")
                .setAddress1("address1")
                .setCity("city_5")
                .setPostcode("postcode")
                .setCountry("country")
                .setRegion("region")
                .setPassword(System.getenv().get("PASSWORD"))
                .setConfirmPassword("PASSWORD")
                .setSubscribe(true)
                .setPrivacypolicy(true)
                .setFax("fax")
                .setCompany("company")
                .setAddress2("address2")
                .build();
    }

    public IUser awdrt() {
        return User.get()
                .setFirstname("my")
                .setLastname("hahaha")
                .setEmail("xdknxusqvjeovowpfk@awdrt.com")
                .setTelephone("hahaha")
                .setAddress1("address1")
                .setCity("city_5")
                .setPostcode("postcode")
                .setCountry("country")
                .setRegion("region")
                .setPassword(System.getenv().get("PASSWORD"))// MY_PASSWORD_AWDTR
                .setConfirmPassword("PASSWORD")
                .setSubscribe(true)
                .setPrivacypolicy(true)
                .setFax("fax")
                .setCompany("company")
                .setAddress2("address2")
                .build();
    }

    public IUser newUser() {
        String currentTime = new SimpleDateFormat(TIME_TEMPLATE).format(new Date());
        String newEmail = "temp" + currentTime + "@gmail.com";
        System.out.println("newEmail = " + newEmail); // TODO Log
        return User.get()
                .setFirstname("firstName3")
                .setLastname("lastName3")
                .setEmail(newEmail)
                .setTelephone("telephone3")
                .setAddress1("address13")
                .setCity("city3")
                .setPostcode("postCode3")
                .setCountry("Ukraine")
                .setRegion("Kyiv")
                .setPassword(System.getenv().get("PASSWORD"))
                //.setPassword("password3")
                .setConfirmPassword("PASSWORD")
                .setSubscribe(true)
                .setPrivacypolicy(true)
                .setFax("fax3")
                .build();
    }

    public IUser invalidUser() {
        return User.get()
                .setFirstname("firstName4")
                .setLastname("lastName4")
                .setEmail("newEmail@a.aa")
                .setTelephone("telephone4")
                .setAddress1("address14")
                .setCity("city34")
                .setPostcode("postCode4")
                .setCountry("Ukraine4")
                .setRegion("Kyiv4")
                .setPassword("hahaha")
                .setConfirmPassword("hahaha")
                .setSubscribe(true)
                .setPrivacypolicy(true)
                .setFax("fax4")
                .build();
    }

    /*-
    public List<IUser> fromCsv(String filename) {
        return User.getByLists(new CSVReader(filename).getAllCells());
    }

    public List<IUser> fromCsv() {
        return fromCsv("users.csv");
    }

    public List<IUser> fromExcel(String filename) {
        return User.getByLists(new ExcelReader(filename).getAllCells());
    }

    public List<IUser> fromExcel() {
        return fromExcel("users.xlsx");
    }
    */
}