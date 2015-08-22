package org.zeissler.helper;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.gdata.client.Query;
import com.google.gdata.client.contacts.ContactsService;
import com.google.gdata.data.contacts.ContactEntry;
import com.google.gdata.data.contacts.ContactFeed;
import com.google.gdata.data.extensions.Email;
import com.google.gdata.util.ServiceException;

public class GoogleContactsParser {

	public static Map<String, List<Email>> parse(GoogleCredential credential){
		ContactsService contactsService = new ContactsService("PwndChecker");
		contactsService.setOAuth2Credentials(credential);

		contactsService.getRequestFactory().setHeader("User-Agent", "PwndChecker");
		
		Map<String, List<Email>> contactsWithEmails = new HashMap<>();

		try {
			URL feedUrl = new URL("https://www.google.com/m8/feeds/contacts/default/full");

			Query myQuery = new Query(feedUrl);
			myQuery.setMaxResults(1000);

			ContactFeed resultFeed = contactsService.query(myQuery, ContactFeed.class);

			List<ContactEntry> contacts = resultFeed.getEntries();

			for (ContactEntry contact : contacts) {
				if (contact.hasEmailAddresses()) {
					contactsWithEmails.put(contact.getTitle().getPlainText(), contact.getEmailAddresses());
				}
			}
		} catch (IOException | ServiceException e) {
			System.out.println("Could not read google contacts, reason:" + e.getMessage());
			System.exit(1);
		}
		return contactsWithEmails;
	}
	
}
