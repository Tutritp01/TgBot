package com.tutrit.stoservice.contex;

import com.tutrit.stoservice.controller.Command;
import com.tutrit.stoservice.controller.CommandController;
import com.tutrit.stoservice.controller.DataController;
import com.tutrit.stoservice.controller.ExitController;
import com.tutrit.stoservice.controller.NotACommandController;
import com.tutrit.stoservice.controller.RequestDispatcher;
import com.tutrit.stoservice.controller.ResponseResolver;
import com.tutrit.stoservice.controller.UserController;
import com.tutrit.stoservice.repository.UserRepository;
import com.tutrit.stoservice.service.MenuService;
import com.tutrit.stoservice.service.UserService;
import com.tutrit.stoservice.usecase.RegisterUserUseCase;

import java.util.Map;

import static com.tutrit.stoservice.contex.ApplicationContext.get;
import static com.tutrit.stoservice.contex.ApplicationContext.put;

public class ApplicationContextLoader {

    public static void run() {
        put(UserRepository.class, new UserRepository());
        put(UserService.class, new UserService(get(UserRepository.class)));
        put(RegisterUserUseCase.class, new RegisterUserUseCase(get(UserService.class)));
        put(UserController.class, new UserController(get(RegisterUserUseCase.class)));
        put(ResponseResolver.class, new ResponseResolver());
        put(DataController.class, new DataController());
        put(ExitController.class, new ExitController());
        put(NotACommandController.class, new NotACommandController());

        Map<Command, CommandController> commandControllerMap = Map.of(
                get(DataController.class).getCommand(), get(DataController.class),
                get(ExitController.class).getCommand(), get(ExitController.class),
                get(NotACommandController.class).getCommand(), get(NotACommandController.class),
                get(UserController.class).getCommand(), get(UserController.class)
        );

        put(RequestDispatcher.class, new RequestDispatcher(get(ResponseResolver.class), commandControllerMap));
        put(MenuService.class, new MenuService(get(RequestDispatcher.class)));
    }
}
