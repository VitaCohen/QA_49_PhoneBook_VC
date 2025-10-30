package utils;

import net.datafaker.Faker;

public class ContactFactoryVit {

    static Faker faker = new Faker();

    public static void main(String[] args) {

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String phone = faker.number().digits(14);
        String email = faker.internet().emailAddress();
        String streetAddress = faker.address().fullAddress();
        String descriptionJob = faker.job().position();
        String descriptionRel = faker.relationships().any();
        String descriptionHob = faker.hobby().activity();


        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(phone);
        System.out.println(streetAddress);
        System.out.println(descriptionJob + ", " + descriptionRel + ", " + descriptionHob);

        System.out.println(faker.internet().emailAddress());

    }



}



