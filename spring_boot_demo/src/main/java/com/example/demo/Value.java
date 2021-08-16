package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Value {
    private String quote;
    private long id;

    public Value() {}

    public long getId() {
        return id;
    }

    public String getQuote() {
        return quote;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    @Override
    public String toString() {
        return "Value{" +
                "id=" + id +
                ", quote123='" + quote + '\'' +
                '}';
    }
}
