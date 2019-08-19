/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 8/13/2019                     *
 * Time: 2:56 PM                     *
 *************************************
 */

package com.codegym.model;


import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Pattern(regexp="^[H][S][0-9]{3}$",message="length must be 5 and begin by 'HS'")
    private String studentCode;

    @NotEmpty
    @Size(min = 5, max = 40)
    private String fullName;

    @NotEmpty
    @Size(min = 5, max = 5)
    private String classMate;

    private String address;

    @Email
    private String email;

    @NotEmpty
    @Pattern(regexp="^[0][0-9]{9}$",message="length must be 10 and first number must be 0")
    private String phoneNumber;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @DateTimeFormat(pattern = "MM/dd/yyyy",iso = DateTimeFormat.ISO.DATE)
    private Date dateOrderBook;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public Student() {
    }

    public Student(@NotEmpty @Pattern(regexp = "^[H][S][0-9]{3}$", message = "length must be 5 and begin by 'HS'") String studentCode, @NotEmpty @Size(min = 5, max = 40) String fullName, @NotEmpty @Size(min = 5, max = 5) String classMate, String address, @Email String email, @NotEmpty @Pattern(regexp = "^[0][0-9]{9}$", message = "length must be 10 and first number must be 0") String phoneNumber, Date dateOrderBook) {
        this.studentCode = studentCode;
        this.fullName = fullName;
        this.classMate = classMate;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOrderBook = dateOrderBook;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getClassMate() {
        return classMate;
    }

    public void setClassMate(String classMate) {
        this.classMate = classMate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDateOrderBook() {
        return dateOrderBook;
    }

    public void setDateOrderBook(Date dateOrderBook) {
        this.dateOrderBook = dateOrderBook;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
