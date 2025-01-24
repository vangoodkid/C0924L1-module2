package baithimodule2.service;

import baithimodule2.model.Contact;
import java.util.List;

public interface IContactService {
    void addContact(Contact contact);
    List<Contact> getAllContacts();
    boolean deleteContactById(String id);
    boolean updateContactById(String id);
    Contact getContactById(String id);
}
