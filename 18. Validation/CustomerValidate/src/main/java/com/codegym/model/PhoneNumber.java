/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 7/23/2019                     *
 * Time: 11:45 AM                     *
 *************************************
 */

package com.codegym.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PhoneNumber implements Validator {

    private  String Number;

    @Override
    public boolean supports(Class<?> clazz) {
        return PhoneNumber.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        PhoneNumber phoneNumber = (PhoneNumber) target;
        String number = phoneNumber.getNumber();
        ValidationUtils.rejectIfEmpty(errors,"number","number.empty");
        if (number.length() > 11 || number.length() < 10){
            errors.rejectValue("number","number.length");
        }
        if (!number.startsWith("0")){
            errors.rejectValue("number","number.startsWith");
        }
        if (!number.matches("(^$|[0-9]*$)")){
            errors.rejectValue("number","number.matches");
        }
    }

    public PhoneNumber() {
    }

    public PhoneNumber(String number) {
        Number = number;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }
}
