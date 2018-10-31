package com.example.tiago.aula3;

import java.util.ArrayList;
import java.util.List;

public class ContactDataSorce {

    public static List<Contact> getContact(int count){
        ArrayList<Contact> contacts = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Contact contact = new Contact(i+1,
                    "FistName" + i,
                    "LastName" + i,
                    (int) Math.random() * 30 + 18,
                    "cenas"+i+"@email.com");

            contacts.add(contact);
        }

        return contacts;
    }

    public static class Contact{
        private long id;
        private String firstName;
        private String LastName;
        private int age;
        private String email;

        public Contact(long id, String firstName, String lastName, int age, String email) {
            this.id = id;
            this.firstName = firstName;
            LastName = lastName;
            this.age = age;
            this.email = email;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return LastName;
        }

        public void setLastName(String lastName) {
            LastName = lastName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getName() {
            return this.firstName + " " + this.LastName;
        }
    }
}
