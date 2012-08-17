package org.nbempire.java.callsmanager.domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.nbempire.java.boc6.model.persist.Persistable;

/**
 * @author Barrios, Nahuel.
 * @version 1.0
 * @since Mar 19, 2010, 12:55:35 PM
 */
public class Call implements Persistable {

    private Contact contact;
    private String outputDirectory;
    private Date date;
    private String subject;
    private List<Task> tasks;
    private String pathToExport;

    public Call() {
        this.tasks = new ArrayList<Task>();
        this.date = Calendar.getInstance().getTime();
    }

    @Override
    public String toString() {

        StringBuffer sb = new StringBuffer();
        // .append("\n").append("Contact email:\t").append(contact.getEmail())
        // TODO: Functionality: cuando se haya implementado lo de los contactos, agregar que imprima tambien el email.
        sb.append("Date:\t\t").append(date).append("\n").append("Call with:\t").append(contact.getFullName())
                .append("\n").append("Subject:\t").append(subject).append("\n").append("Tasks:");

        for (Task task : tasks) {
            sb.append("\n\t").append(task).append("\n\t--");

        }

        return sb.toString();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public String getOutputDirectory() {
        return outputDirectory;
    }

    public void setOutputDirectory(String path) {
        this.outputDirectory = path;
    }

    public void setPathToExport(String pathToExport) {
        this.pathToExport = pathToExport;
    }

    public String getPersistPath() {
        return this.pathToExport;
    }

    public String getStringToPersist() {
        return this.toString();
    }

}
