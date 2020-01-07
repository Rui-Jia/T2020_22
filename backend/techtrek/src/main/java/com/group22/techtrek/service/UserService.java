package com.group22.techtrek.service;

import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.group22.techtrek.model.Account;
import com.group22.techtrek.model.Transaction;
import com.group22.techtrek.model.User;
import com.group22.techtrek.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    List<User> userList =  new ArrayList<>();

    @Autowired
    RestTemplate restTemplate;

    //get all detail of login user
    public User getFullUserDetails (User user) {

        final String uri = "http://techtrek-api-gateway.ap-southeast-1.elasticbeanstalk.com/customers/{userName}";
           
        Map<String, String> params = new HashMap<String, String>();
        params.put("userName", user.getUserName());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        //headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("Identity","T5");
        headers.set("Token","cb614e38-a8dc-4b14-a656-82d6fed16bd3");
        
        HttpEntity<String> entity = new HttpEntity<String>("body", headers);
        ResponseEntity<User> response = restTemplate.exchange(uri, HttpMethod.GET, entity, User.class, params);
        User userDetails = getUserDetails(response.getBody().getCustomerId());
        if(response.getBody()!=null) {        
            List<Account> accountList = getUserAccount(response.getBody().getCustomerId());
            userDetails.setAccount(accountList);
            userDetails.setUserName(response.getBody().getUserName());
        }
        return userDetails;
    }

    //get user details
    public User getUserDetails (int id) {
        final String uri = "http://techtrek-api-gateway.ap-southeast-1.elasticbeanstalk.com/customers/{customerId}/details";
        Map<String, Integer> params = new HashMap<String, Integer>();
        params.put("customerId", id);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        //headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("Identity","T5");
        headers.set("Token","cb614e38-a8dc-4b14-a656-82d6fed16bd3");
        
        HttpEntity<String> entity = new HttpEntity<String>("body", headers);
        ResponseEntity<User> response = restTemplate.exchange(uri, HttpMethod.GET, entity, User.class, params);
        
        return response.getBody();
    }

    //get account primary details
    public List<Account> getUserAccount (int id) {
        final String uri = "http://techtrek-api-gateway.ap-southeast-1.elasticbeanstalk.com/accounts/deposit/{customerId}";
        Map<String, Integer> params = new HashMap<String, Integer>();
        params.put("customerId", id);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        //headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("Identity","T5");
        headers.set("Token","cb614e38-a8dc-4b14-a656-82d6fed16bd3");
        
        HttpEntity<String> entity = new HttpEntity<String>("body", headers);
        ResponseEntity<List<Account>> response = restTemplate.exchange(uri, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Account>>(){}, params);
        List<Account> accountList = response.getBody();
        for(Account a : accountList) {
            List<Transaction> transactionList = getTransactions(a.getAccountId());

            Account accountDetails = getAccountDetails(a.getAccountId());
            
            a.setAvailableBalance(accountDetails.getAvailableBalance());
            a.setCurrency(accountDetails.getCurrency());
            a.setDateOfBalance(accountDetails.getDateOfBalance());
            a.setAccountNumber(accountDetails.getAccountNumber());
            a.setTransaction(transactionList);
        }
        return accountList;
    }

    //get additional account details
    public Account getAccountDetails (int id) {
        final String uri = "http://techtrek-api-gateway.ap-southeast-1.elasticbeanstalk.com/accounts/deposit/{accountId}/balance?month=1&year=2020";
        Map<String, Integer> params = new HashMap<String, Integer>();
        params.put("accountId", id);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        //headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("Identity","T5");
        headers.set("Token","cb614e38-a8dc-4b14-a656-82d6fed16bd3");
        
        HttpEntity<String> entity = new HttpEntity<String>("body", headers);
        ResponseEntity<Account> response = restTemplate.exchange(uri, HttpMethod.GET, entity, Account.class, params);

        return response.getBody();
    }


    //get all transactions
    public List<Transaction> getTransactions (int id) {
        final String uri = "http://techtrek-api-gateway.ap-southeast-1.elasticbeanstalk.com/transactions/{accountId}?from=01-01-2018&to=01-30-2020";
        Map<String, Integer> params = new HashMap<String, Integer>();
        params.put("accountId", id);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        //headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("Identity","T5");
        headers.set("Token","cb614e38-a8dc-4b14-a656-82d6fed16bd3");
        
        HttpEntity<String> entity = new HttpEntity<String>("body", headers);
        ResponseEntity<List<Transaction>> response = restTemplate.exchange(uri, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Transaction>>(){}, params);

        return response.getBody();
    }
}