package com.company.resumewebapp.form;

import javax.validation.constraints.NotNull;

public class SearchByUserForm {
    @NotNull(message = "Search Box is Null!")
    private String query;

    public SearchByUserForm() {
    }

    public SearchByUserForm(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    public String toString() {
        return "SearchByUserForm{" +
                "query='" + query + '\'' +
                '}';
    }
}
