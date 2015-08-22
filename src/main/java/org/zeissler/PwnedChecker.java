package org.zeissler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.zeissler.dto.PwndResult;
import org.zeissler.helper.GoogleContactsParser;
import org.zeissler.helper.RestTemplateHelper;
import org.zeissler.oauth.GoogleOAuther;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.gdata.data.extensions.Email;

public class PwnedChecker {

	public static void main(String[] args) {

		RestTemplate restTemplate = RestTemplateHelper.prepareRestTemplate();

		Map<String, List<PwndResult>> results = new HashMap<String, List<PwndResult>>();

		GoogleCredential credential = GoogleOAuther.doAuth();
		
		Map<String, List<Email>> contactsWithEmails = GoogleContactsParser.parse(credential);

		System.out.println("Loaded "+ contactsWithEmails.size() + " contacts, will now query haveibeenpwned.com");
		
		for (Map.Entry<String, List<Email>> entry : contactsWithEmails.entrySet()) {
			for(Email email : entry.getValue()){
				System.out.print(".");
				String url = "https://haveibeenpwned.com/api/v2/breachedaccount/" + email.getAddress();
				try {
					PwndResult[] apiResults = restTemplate.getForObject(url, PwndResult[].class);
					results.put(email.getAddress(), new ArrayList<PwndResult>(Arrays.asList(apiResults)));
				} catch (RestClientException e) {
					continue;
				}
			}
		}
		System.out.println("");

		for (Map.Entry<String, List<PwndResult>> entry : results.entrySet()) {
			System.out.println("\n" + entry.getKey() + "");
			for (PwndResult apiResult : entry.getValue()) {
				System.out.println("-> " + apiResult.getName());
			}
		}
	}
}
