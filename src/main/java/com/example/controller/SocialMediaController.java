package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Account;
import com.example.service.*;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller using Spring. The endpoints you will need can be
 * found in readme.md as well as the test cases. You be required to use the @GET/POST/PUT/DELETE/etc Mapping annotations
 * where applicable as well as the @ResponseBody and @PathVariable annotations. You will
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */
@RestController
public class SocialMediaController {

    @Autowired
    AccountService accountService;
    /*
     * Create a new Account 
     * Endpoint POST localhost:8080/register.
     *  The body will contain a representation of a JSON Account, but will not contain an accountId.
     *
     * The registration will be successful if and only if the username is not blank, the password is at least 4 characters long, and an Account with that username does not already exist.
     * If all these conditions are met, the response body will contain a JSON of the Account, including its accountId.
     * The response status will be 200 OK, which is the default.
     * The new account will be persisted to the database.
     * 
     * If the registration is not successful due to a duplicate username, the response status will be 409. (Conflict)-
     * If the registration is not successful for some other reason, the response status will be 400. (Client error)
     */
    @PostMapping("/register")
    public ResponseEntity<Account> registerUser(@RequestBody Account account) {
        //throws exception if invalid
        Account created = accountService.register(account);
        return ResponseEntity.ok().body(created);
    }
    /*
     * 
     * Verify login 
     * Endpoint POST localhost:8080/login.
     * The request body will contain a JSON representation of an Account.
     *
     * The login will be successful if and only if the username and password provided in the request body JSON match a real account existing on the database.
     * If successful, the response body will contain a JSON of the account in the response body, including its accountId.
     * The response status will be 200 OK.
     * 
     * If the login is not successful, the response status will be 401. (Unauthorized)
     *
     */
    @PostMapping("login")
    public ResponseEntity<Account> login(@RequestBody Account account) {
        Account matching = accountService.getAccountMatchingLogin(account);
        return ResponseEntity.ok().body(matching);
    }
    /*
     * Create new message.
     *
     * Endpoint POST localhost:8080/messages. 
     * The request body will contain a JSON representation of a message, which will be persisted to the database, but will not contain a messageId.
     *
     * The creation of the message will be successful if and only if the messageText is not blank, is not over 255 characters, and postedBy refers to a real, existing user.
     * If successful, the response body will contain a JSON of the message, including its messageId.
     * The response status will be 200.
     * The new message will be persisted to the database.
     * 
     * If the creation of the message is not successful, the response status will be 400. (Client error)
     *
     */
    /*
     * Retrieve all messages.
     *
     * Endpoint GET localhost:8080/messages.
     *
     * The response body will contain a JSON representation of a list containing all messages retrieved from the database.
     * It is expected for the list to simply be empty if there are no messages.
     * The response status will always be 200.
     *
     * 
     */
    
    /*
     * Retrieve a message by its ID.
     *
     * Endpoint GET localhost:8080/messages/{messageId}.
     *
     * The response body will contain a JSON representation of the message identified by the messageId.
     * It is expected for the response body to simply be empty if there is no such message.
     * The response status will always be 200.
     *
     */
    /*
     * Delete a message identified by a message ID.
     *
     * Endpoint DELETE localhost:8080/messages/{messageId}.
     *
     * The deletion of an existing message will remove an existing message from the database.
     * If the message existed, the response body will contain the number of rows updated (1).
     * The response status will be 200.
     * If the message did not exist, the response status will be 200, but the response body will be empty.
     */
    
    /*
     * Update a message text identified by a message ID.
     *
     * Endpoint PATCH localhost:8080/messages/{messageId}.
     * The request body will contain a new messageText values to replace the message identified by messageId. The request body can not be guaranteed to contain any other information.
     *
     * The update of a message will be successful if and only if the message id already exists and the new messageText is not blank and is not over 255 characters.
     * If the update is successful, the response body will contain the number of rows updated (1), and the response status will be 200.
     * The message existing on the database will have the updated messageText.
     * If the update of the message is not successful, the response status will be 400. (Client error)
     *
     */
    /*
     *Retrieve all messages written by a particular user.
     *
     * Endpoint GET localhost:8080/accounts/{accountId}/messages.
     *
     * The response body will contain a JSON representation of a list containing all messages posted by a particular user, which is retrieved from the database.
     * The list will be empty if there are no messages.
     * The response status will always be 200.
     */
    

}
