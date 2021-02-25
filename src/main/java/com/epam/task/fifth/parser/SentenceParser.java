package com.epam.task.fifth.parser;

import com.epam.task.fifth.entity.Component;
import com.epam.task.fifth.entity.Composite;
import com.epam.task.fifth.entity.Leaf;
import com.epam.task.fifth.entity.LeafType;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser implements Parser {
    private final Pattern PATTERN = Pattern.compile("(\\w+)|(\\[[\\d [\\+\\-\\*\\/]]+\\])");
    private final String BRACKET = "[";

    public SentenceParser() {}

    @Override
    public Component parse(String string) {
        Matcher matcher = PATTERN.matcher(string);
        List<String> list = new ArrayList<>();

        while (matcher.find()){
            list.add(matcher.group());
        }

        Composite result = new Composite();

        list.stream().forEach(lexeme->{
            if (lexeme.startsWith(BRACKET)){
                result.add(new Leaf(lexeme, LeafType.EXPRESSION));
            } else {
                result.add(new Leaf(lexeme, LeafType.WORD));
            }
        });

        return result;
    }
}
