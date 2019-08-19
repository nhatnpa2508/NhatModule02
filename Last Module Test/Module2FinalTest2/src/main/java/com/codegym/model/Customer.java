/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 8/15/2019                     *
 * Time: 1:39 PM                     *
 *************************************
 */

package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false)
    private Long id;

    @NotEmpty
    @Size(min = 2, max = 20)
    private String firstName;

    @NotEmpty
    @Size(min = 2, max = 20)
    private String lastName;

    @NotEmpty
    @Pattern(regexp="^[0][0-9]{9}$",message="length must be 10 and first number must be 0")
    private String phoneNumber;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @Size(min = 5, max = 100)
    private String address;

    public Customer() {
    }

    public Customer(@NotEmpty @Pattern(regexp = "^[a-zA-Z]$", message = "Not have numeric characters") String firstName, @NotEmpty @Pattern(regexp = "^[a-zA-Z]$", message = "Not have numeric characters") String lastName, @NotEmpty @Pattern(regexp = "^[0][0-9]{9}$", message = "length must be 10 and first number must be 0") String phoneNumber, @NotEmpty @Email String email, @NotEmpty @Size(min = 5, max = 100) String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
