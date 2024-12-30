package com.dbc.card.util;

import com.dbc.card.model.ContactData;

public class VCardGenerator {
    public static String generateVCard(ContactData contact) {
        return "BEGIN:VCARD\n" +
               "VERSION:3.0\n" +
               "FN:" + contact.getFullName().getFirstName() + " " + contact.getFullName().getLastName() + "\n" +
               "TEL:" + contact.getPhoneNumber() + "\n" +
               "EMAIL:" + contact.getEmail() + "\n" +
               "ORG:" + contact.getCompany() + "\n" +
               "TITLE:" + contact.getJobTitle() + "\n" +
               "ADR:;;" + contact.getAddress().getStreet() + ";" +
               contact.getAddress().getCity() + ";" +
               contact.getAddress().getZip() + ";" +
               contact.getAddress().getCountry() + "\n" +
               "URL:" + contact.getWebsite() + "\n" +
               "END:VCARD";
    }
}
