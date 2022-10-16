package com.tutrit.stoservice.parser;

import com.tutrit.stoservice.controller.Command;

/**
 * 1. [Use json] new engineer -json -d {"LN":"One", "FN":"Two", "Fun":"Three", "Cat":"Four", "Edu":"Five", "Exp":"6", "GExp":"7"}"
 * 2. [use Map] save car -d brand=tesla&model=X&generation=I&modification=suv&engine=diesel&year=2008
 * 3. [use flags] save car -brand tesla -model X -generation I -modification suv -engine diesel -year 2008
 * 4. [use interactive mode]
 */
public class UserInputParser  {

    public static UserInput parseUserInput(String command) {
        UserInput userInput = new UserInput();
        if (command.contains(" -d ") && command.contains(" -json ")) {
            userInput.setObjectValues(new JsonBodyProtocol().parseBodyToObjectValues(command));
            userInput.setCommand(extractCommand(command));
        } else if (command.contains(" -d ") && !command.contains(" -json ")) {
            userInput.setObjectValues(new JsonBodyProtocol().parseBodyToObjectValues(command));
        }
        return userInput;
    }

    private static Command extractCommand(String input) {
        return Command.fromString(input.substring(input.indexOf("-")));
    }
}
