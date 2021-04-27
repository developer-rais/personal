package com.parking.model;

import com.parking.exception.InvalidCommandException;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class Command {

    private String commandName;
    private List<String> params;

    public Command(String inputLine) throws InvalidCommandException {
        final List<String> tokens = Arrays.stream(inputLine.trim().split(" ")).map(String::trim).
                filter(token -> token.length() > 0).collect(Collectors.toList());
        if (tokens.size() == 0) {
            throw new InvalidCommandException();
        }
        this.commandName = tokens.get(0);
        tokens.remove(0);
        this.params = tokens;
    }


}
