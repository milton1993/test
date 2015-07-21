package com.mitong.test.guava.objects;

import com.google.common.base.Objects;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 15-7-21
 */
public class ObjectsTest implements Comparable<ObjectsTest> {
    private String author;
    private String title;
    private String publisher;
    private String isbn;
    private String price;

    /**
     * use Objects.toStringHelper to create toString method
     * */
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .omitNullValues()
                .add("author", author)
                .add("title", title)
                .add("pubilsher", publisher)
                .add("isbn", isbn)
                .add("price", price).toString();
    }

    /**
     * use Objects.hashCode to create hashCode method
     * */
    @Override
    public int hashCode() {
        return Objects.hashCode(author, title, isbn);
    }

    @Override
    public int compareTo(ObjectsTest o) {
        return 0;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


}
