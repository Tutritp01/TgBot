package com.tutrit.stoservice.parser;

import com.tutrit.stoservice.controller.Command;

/**
 * 1. [Use json] new engineer -json -d {"LN":"One", "FN":"Two", "Fun":"Three", "Cat":"Four", "Edu":"Five", "Exp":"6", "GExp":"7"}"
 * 2. [use Map] save car -d brand=tesla&model=X&generation=I&modification=suv&engine=diesel&year=2008
 * 3. [use flags] save car -brand tesla -model X -generation I -modification suv -engine diesel -year 2008
 * 4. [use interactive mode]
 */
public class UserInputParser  {

    ProtocolProvider protocolProvider;

    public UserInputParser(final ProtocolProvider protocolProvider) {
        this.protocolProvider = protocolProvider;
    }

    public UserInput parseUserInput(String command) {
        UserInput userInput = new UserInput();
        BodyProtocol protocol = protocolProvider.getProtocol(command);
        userInput.setObjectValues(protocol.parseBodyToObjectValues(command));
        userInput.setCommand(extractCommand(command));
        return userInput;
    }

    private static Command extractCommand(String input) {
        return Command.fromString(input.substring(input.indexOf("-")));
    }
}
