package com.tutrit.stoservice.service;


import com.tutrit.stoservice.controller.RequestDispatcher;

import java.util.Scanner;

public class MenuService {

    private final RequestDispatcher requestDispatcher;

    public MenuService(final RequestDispatcher requestDispatcher) {
        this.requestDispatcher = requestDispatcher;
    }

    public void run(){
        while(true) {
            requestCommand();
        }
    }

    private void requestCommand() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input command _");
        String userInput = scanner.nextLine();
        requestDispatcher.doDispatch(userInput);
    }
}
