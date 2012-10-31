package org.nbempire.java.callsmanager.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.nbempire.java.callsmanager.domain.Contact;
import org.nbempire.java.callsmanager.service.ContactService;

/**
 * Created by: Nahuel Barrios. On: 03/04/10 at 12:28hs.
 *
 * @author Barrios, Nahuel.
 * @version 1.0
 */
public class ContactServiceImpl implements ContactService {

    /**
     * TODO : JavaDoc : for ContactServiceImpl.get().
     *
     * @param contactId
     *
     * @return {@link Contact}
     */
    public Contact get(Integer contactId) {
        List<Contact> contacts = getAllContacts();
        for (Contact contact : contacts) {
            if (contact.getContactId().intValue() == contactId.intValue()) {
                return contact;
            }
        }
        return null;
    }

    /**
     * TODO : JavaDoc : for ContactServiceImpl.getBy().
     *
     * @param filter
     *
     * @return {@link List<Contact>}
     */
    public List<Contact> getBy(String filter) {
        List<Contact> allContacts = getAllContacts();
        List<Contact> filteredContacts = new ArrayList<Contact>();

        for (Contact contact : allContacts) {
            if (stringHasSequence(contact.getFullName(), filter)) {
                filteredContacts.add(contact);
            }
        }

        return filteredContacts;
    }

    /**
     * TODO : JavaDoc : for ContactServiceImpl.stringHasSequence().
     *
     * @param string
     * @param sequence
     *
     * @return {@link boolean}
     */
    public static boolean stringHasSequence(String string, String sequence) {
        if (string == null || sequence == null) {
            return false;
        }

        String stringLC = string.toLowerCase();

        return stringLC.indexOf(sequence) >= 0;
    }

    /**
     * TODO : JavaDoc : for ContactServiceImpl.getAllContacts().
     *
     * @return {@link List<Contact>}
     */
    public static List<Contact> getAllContacts() {
        List<Contact> ret = new ArrayList<Contact>();
        Contact aContact;
        // TODO : Functionality : The method getAllContacts();

        return ret;
    }

}
