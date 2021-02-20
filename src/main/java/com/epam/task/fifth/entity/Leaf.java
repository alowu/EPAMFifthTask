package com.epam.task.fifth.entity;

public class Leaf implements Component{

    private String lexeme;

    public Leaf(String lexeme) {
        this.lexeme = lexeme;
    }

    public String getLexeme() {
        return lexeme;
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

        return getLexeme() != null ? getLexeme().equals(leaf.getLexeme()) : leaf.getLexeme() == null;
    }

    @Override
    public int hashCode() {
        return getLexeme() != null ? getLexeme().hashCode() : 0;
    }

    @Override
    public void print() {

    }
}
