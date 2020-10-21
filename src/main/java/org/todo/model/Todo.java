package org.todo.model;

import java.time.LocalDate;

public class Todo {

    private Integer id;
    private String title;
    private String category;
    private LocalDate dueDate;
    private boolean completed;

    public Todo() {}

    public Todo(String title) {
        this(title, null, null);
    }

    public Todo(String title, String category) {
        this(title, category, null);
    }

    public Todo(String title, LocalDate dueDate) {
        this(title, null, dueDate);
    }

    public Todo(String title, String category, LocalDate dueDate) {
        this.title = title;
        this.category = category;
        this.dueDate = dueDate;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getCategory() {
        return category;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted() {
        this.completed = true;
    }
}
