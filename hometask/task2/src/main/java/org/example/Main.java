package org.example;

import org.example.model.Author;
import org.example.model.Book;

public class Main
{
    public static void main( String[] args )
    {
        Author author = new Author("Nikolay", "nikolaisilantevv@gmail.com", 'm');
        Book book = new Book("Task2", author, 100, 1);
        System.out.println(book);
    }
}
