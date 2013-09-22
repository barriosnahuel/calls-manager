package org.nbempire.java.callsmanager.domain;

import java.util.List;

/**
 * @author Barrios, Nahuel.
 * @version 1.0
 * @since Apr 3, 2010, 12:24:43 PM
 */
public class Contact {

    private Integer contactId;

    private String name;

    private String secondName;

    private String surname;

    private String email;

    private String celphone;

    private String fullName;

    private List<String> otherTelephones;

    private List<String> otherEmails;

    /**
     * Creates a new {@link Contact} setting his fullName.
     *
     * @param fullName
     */
    public Contact(String fullName) {
        this.fullName = fullName;
    }

    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append("Contact");

        sb.append("{\n email='").append(email).append('\'');
        sb.append("\n, name='").append(name).append('\'');
        sb.append("\n, secondName='").append(secondName).append('\'');
        sb.append("\n, surname='").append(surname).append('\'');

        sb.append("\n}");

        return sb.toString();
    }

    /**
     * @param name
     *         The contact's name.
     * @param surname
     *         The contact's surname.
     */
    public Contact(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getFullName() {
        if (fullName != null) {
            return fullName;
        } else {
            return name + " " + ((secondName != null) ? secondName + " " : "") + surname;
        }
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelphone() {
        return celphone;
    }

    public void setCelphone(String celphone) {
        this.celphone = celphone;
    }

    public List<String> getOtherTelephones() {
        return otherTelephones;
    }

    public void setOtherTelephones(List<String> otherTelephones) {
        this.otherTelephones = otherTelephones;
    }

    public List<String> getOtherEmails() {
        return otherEmails;
    }

    public void setOtherEmails(List<String> otherEmails) {
        this.otherEmails = otherEmails;
    }
}
