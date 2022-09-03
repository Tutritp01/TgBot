package com.tutrit.stoservice.service;

import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;

import java.util.Scanner;

public class MenuService {
    public void run(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("input command _");
        String userInput = scanner.nextLine();
        RequestDispatcher requestDispatcher = new RequestDispatcher();
        requestDispatcher.doDispatch(userInput);
    }
}
