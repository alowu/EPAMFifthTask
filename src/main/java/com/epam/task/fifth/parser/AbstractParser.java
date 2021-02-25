package com.epam.task.fifth.parser;

import com.epam.task.fifth.entity.Component;
import com.epam.task.fifth.entity.Composite;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractParser implements Parser{
    private Parser successor;

    public AbstractParser(Parser successor) {
        this.successor = successor;
    }

    protected Parser getSuccessor() {
        return successor;
    }

    protected abstract String getSplitter();

    @Override
    public Component parse(String string) {
        String SPLITTER = getSplitter();
        List<String> list = Arrays.asList(string.split(SPLITTER));

        Composite result = new Composite();

        list.stream().forEach(child->{
            Component component = getSuccessor().parse(child);
            result.add(component);
        });

        return result;
    }
}
