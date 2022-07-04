package com.tutrit.tgbot.example.bean;

import com.tutrit.tgbot.example.exception.CommandNotFoundException;
import com.tutrit.tgbot.example.processor.HelpProcessor;
import com.tutrit.tgbot.example.processor.Processor;
import com.tutrit.tgbot.example.processor.SettingsProcessor;
import com.tutrit.tgbot.example.processor.StartProcessor;

public enum Command {
    START("/start", new StartProcessor()),
    HELP("/help", new HelpProcessor()),
    SETTINGS("/settings", new SettingsProcessor());

    private final String command;
    private final Processor processor;

    Command(final String command, final Processor processor) {
        this.command = command;
        this.processor = processor;
    }

    public String getCommand() {
        return command;
    }

    public Processor getProcessor() {
        return processor;
    }

    public static Command getByName(String command) throws CommandNotFoundException {
        if (command.equals("/start")) {
            return START;
        } else if (command.equals("/help")) {
            return HELP;
        } else if (command.equals("/settings")) {
            return SETTINGS;
        }
        throw new CommandNotFoundException(String.format("command \"%s\" is not supported yet", command));
    }

    public static Processor getProcessorByName(String command) throws CommandNotFoundException {
        if (command.equals("/start")) {
            return START.getProcessor();
        } else if (command.equals("/help")) {
            return HELP.getProcessor();
        } else if (command.equals("/settings")) {
            return SETTINGS.getProcessor();
        }
        throw new CommandNotFoundException(String.format("command \"%s\" is not supported yet", command));
    }
}
