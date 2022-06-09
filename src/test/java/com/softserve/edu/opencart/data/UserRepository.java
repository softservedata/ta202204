package com.softserve.edu.opencart.data;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserRepository {
	
    private static final String TIME_TEMPLATE = "HH_mm_ss_S";

    private UserRepository() {
    }

    public static IUser getDefault() {
        return getHahaha();
    }

    public static IUser getHahaha() {
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
                .setPassword(System.getenv().get("MY_PASSWORD_HAHAHA"))
                .setConfirmPassword(System.getenv().get("MY_PASSWORD_HAHAHA"))
                .setSubscribe(true)
                .setPrivacypolicy(true)
                .setFax("fax")
                .setCompany("company")
                .setAddress2("address2")
                .build();
    }

    public static IUser getAwdrt() {
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
                .setPassword(System.getenv().get("MY_PASSWORD_AWDTR"))// MY_PASSWORD_AWDTR
                .setConfirmPassword(System.getenv().get("MY_PASSWORD_AWDTR"))
                .setSubscribe(true)
                .setPrivacypolicy(true)
                .setFax("fax")
                .setCompany("company")
                .setAddress2("address2")
                .build();
    }

    public static IUser getNewUser() {
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
                .setCountry("United States")
                .setRegion("New York")
                .setPassword(System.getenv().get("PASSWORD"))
                .setConfirmPassword(System.getenv().get("PASSWORD"))
                //.setPassword("password3")
                .setSubscribe(true)
                .setPrivacypolicy(true)
                .setFax("fax3")
                .build();
    }
    
    public static IUser getEmptyNewUser() {
        return User.get()
                .setFirstname("")
                .setLastname("")
                .setEmail("")
                .setTelephone("")
                .setAddress1("")
                .setCity("")
                .setPostcode("")
                .setCountry("United Kingdom")
                .setRegion("Cardiff")
                .setPassword("")
                .setConfirmPassword("")
                .setSubscribe(false)
                .setPrivacypolicy(false)
                .setFax("")
                .setCompany("")
                .setAddress2("")
                .build();
    }

    public static IUser getInvalidUser() {
        return User.get()
                .setFirstname("firstName4")
                .setLastname("lastName4")
                .setEmail("newEmail@gmail.com")
                .setTelephone("telephone4")
                .setAddress1("address14")
                .setCity("city34")
                .setPostcode("postCode4")
                .setCountry("United Kingdom")
                .setRegion("Cardiff")
                .setPassword("hahaha")
                .setConfirmPassword("hahaha")
                .setSubscribe(false)
                .setPrivacypolicy(false)
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
