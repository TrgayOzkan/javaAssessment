package com.pnc.testAPI;

import com.pnc.utility.Utility;
import io.restassured.RestAssured;

import java.util.Scanner;

import static io.restassured.RestAssured.given;

public class FindCapitalByName {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://restcountries.com";
        RestAssured.basePath = "/v3.1/" ;

        Scanner scan = new Scanner (System.in);
        System.out.println("Enter the country:");
        String country = scan.nextLine();
        System.out.print("Capital city of the given country: ");
        System.out.println(Utility.countryCapital(country));

        System.out.println("Do you want to enter new country name:");
        String result = scan.next();

        for (int i =0; i >= 0; i++){

            if (result.equals("yes")){
                System.out.println("Please enter country name:");
                country = scan.next();
                System.out.print("Capital city of the given country: ");
                System.out.println(Utility.countryCapital(country));
                System.out.println("Do you want to enter new country name:");
                result = scan.next();
            }else if(result.equals("no")){
                break;
            }
        }


    }


}
