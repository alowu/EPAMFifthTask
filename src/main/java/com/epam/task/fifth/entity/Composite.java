package com.epam.task.fifth.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Composite implements Component {

    private List<Component> children = new ArrayList<>();

    public Composite(List<Component> children) {
        this.children = children;
    }

    public Composite() {
    }

    public void add(Component component) {
        children.add(component);
    }

    public List<Component> get() {
        return children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Composite composite = (Composite) o;
        return children.equals(composite.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(children);
    }

    @Override
    public String toString() {
        return String.valueOf(children);
    }
}