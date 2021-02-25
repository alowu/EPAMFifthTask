package com.epam.task.fifth.entity;

import java.util.Objects;

public class Leaf implements Component{

    private String lexeme;
    private LeafType type;

    public Leaf(String lexeme, LeafType type) {
        this.lexeme = lexeme;
        this.type = type;
    }

    public String getLexeme() {
        return lexeme;
    }

    public LeafType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Leaf leaf = (Leaf) o;
        return getLexeme().equals(leaf.getLexeme()) && getType() == leaf.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLexeme(), getType());
    }

    @Override
    public String toString() {
        return lexeme;
    }
}
