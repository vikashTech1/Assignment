package com.assignment;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;


public class Assignment1{

    public static void main(String[] args) throws ParseException {

        Scanner s= new Scanner(System.in);

        System.out.println("Enter the option from which you want to Proceed with...");
        System.out.print("Records Based on \n 1.TvShows \n 2.Horror Movies \n 3.Movies from India");
        int choice= s.nextInt();
        System.out.println("Please enter the time period in format DD-MMM-YYYY. \n Start Date");
        String startDate1= s.next();
        // Date startDate = new SimpleDateFormat("dd-MMM-yy").parse(startDate1);
        System.out.println("End Date");
        String endDate2= s.next();
        //Date endDate = new SimpleDateFormat("dd-MMM-yy").parse(endDate2);
        //System.out.println(endDate);
        System.out.println("Please enter the number of Records you want!!");
        int n= s.nextInt();

        String file= "src\\netflix_titles.csv";
        BufferedReader reader= null;
        String line= "";
        int count=0;

        try {
            reader = new BufferedReader(new FileReader(file));

            long startTime = System.currentTimeMillis();
            while( (line = reader.readLine()) != null && count!=n) {

                String[] values = line.split(",");

                if (values[1].replaceAll("\\s", "").toLowerCase(Locale.ROOT).equals("tvshow") && choice == 1) {
                    printData(values);
                    count++;
                }
                else if (choice == 2 && Arrays.asList(values).contains("Horror Movies")){
                    printData(values);
                    count++;
                }
                else if(choice==3 && (Arrays.asList(values).contains("Movie") && Arrays.asList(values).contains("India"))){
                    printData(values);
                    count++;
                }
            }
            long endTime = System.currentTimeMillis();
            System.out.println("Time taken to Show the result: "+(endTime-startTime)+" milli seconds!");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void printData(String[] rows){
        for (String index : rows) {
            System.out.printf("%-10s", index);
        }
        System.out.println();
    }
}
