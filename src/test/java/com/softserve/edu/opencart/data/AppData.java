package com.softserve.edu.opencart.data;

import com.softserve.edu.opencart.data.user.IUser;
import com.softserve.edu.opencart.data.user.UserRepository;

public class AppData {

    public static void main(String[] args) {
        //
        // 1. Use Classic Constructor
        /*
        User user = new User( "firstname_01",  "lastname_01",  "email_01",  "telephone_01",  "fax_01",  "company_01",  "address1_01",  "address2_01",  "city_01",  "postcode_01",  "country_01",  "region_01",  "password_01",  true);
        System.out.printf("user.getEmail() = " + user.getEmail());
        */
        //
        // 2. Use Setters
        /*
        User user = new User();
        user.setFirstname("firstname_02");
        user.setLastname("lastname_02");
        user.setEmail("email_02");
        user.setTelephone("telephone_02");
        user.setFax("fax_02");
        user.setCountry("company_02");
        user.setAddress1("address1_02");
        user.setAddress1("address2_02");
        user.setCity("city_02");
        user.setPostcode("postcode_02");
        user.setCountry("country_02");
        user.setRegion("region_02");
        user.setPassword("password_02");
        user.setSubscribe(true);
        System.out.printf("user.getEmail() = " + user.getEmail());
        */
        //
        // 3. Add Fluent Interface
        /*
        User user = new User()
            .setFirstname("firstname_03")
            .setLastname("lastname_03")
            .setEmail("email_03")
            .setTelephone("telephone_03")
            .setFax("fax_03")
            .setCountry("company_03")
            .setAddress1("address1_03")
            .setAddress1("address2_03")
            .setCity("city_03")
            .setPostcode("postcode_03")
            .setCountry("country_03")
            .setRegion("region_03")
            .setPassword("password_03")
            .setSubscribe(true);
        System.out.printf("user.getEmail() = " + user.getEmail());
        */
        // 4. Add Static Factory
        /*
        User user = User.get()
                .setFirstname("firstname_04")
                .setLastname("lastname_04")
                .setEmail("email_04")
                .setTelephone("telephone_04")
                .setFax("fax_04")
                .setCountry("company_04")
                .setAddress1("address1_04")
                .setAddress1("address2_04")
                .setCity("city_04")
                .setPostcode("postcode_04")
                .setCountry("country_04")
                .setRegion("region_04")
                .setPassword("password_04")
                .setSubscribe(true);
        System.out.printf("user.getEmail() = " + user.getEmail());
        */
        //
        // 5. Add Builder
        /*
        User user = User.get()
                .setFirstname("firstname_05")
                .setLastname("lastname_05")
                .setEmail("email_05")
                .setTelephone("company_05")
                .setAddress1("address1_05")
                .setCity("city_05")
                .setPostcode("postcode_05")
                .setCountry("country_05")
                .setRegion("region_05")
                .setPassword("password_05")
                .setSubscribe(true)
                .setFax("fax_05")
                .build();
        System.out.println("user.getEmail() = " + user.getEmail());
        System.out.println("user.getEmail() = " + user.setEmail("")); // Architecture Error
        System.out.println("user.getEmail() = " + user.getEmail());
        */
        //
        // 6. Dependency Inversion
        /*
        IUser user = User.get()
                .setFirstname("firstname_06")
                .setLastname("lastname_06")
                .setEmail("email_06")
                .setTelephone("company_06")
                .setAddress1("address1_06")
                .setCity("city_06")
                .setPostcode("postcode_06")
                .setCountry("country_06")
                .setRegion("region_06")
                .setPassword("password_06")
                .setSubscribe(true)
                .setFax("fax_06")
                .setCompany("company_06")
                .setAddress2("address2_06")
                .build();
        System.out.println("user.getEmail() = " + user.getEmail());
        //System.out.println("user.getEmail() = " + user.setEmail("")); // Compile Error
        System.out.println("user.getEmail() = " + ((User) user).setEmail("")); // Code Smell
        System.out.println("user.getEmail() = " + user.getEmail());
        */
        //
        // 7. Add Repository
        IUser user = UserRepository.getHahaha();
        System.out.println("user.getEmail() = " + user.getEmail());
        System.out.println("user = " + user);
    }

}
