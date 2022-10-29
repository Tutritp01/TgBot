package com.tutrit.stoservice.service;

import com.tutrit.stoservice.context.ApplicationContext;
import com.tutrit.stoservice.controller.RequestDispatcher;

import java.util.Scanner;

public class MenuService {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input command _");
        String userInput = scanner.nextLine();
        ApplicationContext.get(RequestDispatcher.class).doDispatch(userInput);

    }
}
