package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Message;
import com.example.exception.InvalidMessageException;
import com.example.repository.AccountRepository;
import com.example.repository.MessageRepository;

@Service
public class MessageService {
    private MessageRepository messageRepository;
    private AccountRepository accountRepository;
    @Autowired
    public MessageService(MessageRepository messageRepository, AccountRepository accountRepository) {
        this.messageRepository = messageRepository;
        this.accountRepository = accountRepository;
    }
    /*
     * Create new message.
     *
     *
     * The creation of the message will be successful if and only if the messageText is not blank, is not over 255 characters, and postedBy refers to a real, existing user.
     * @return the created Message, including its messageId.
     * The new message will be persisted to the database.
     * 
     * @throws InvalidMessageException - If the creation of the message is not successful
     *
     */
    public Message create(Message message) {
        validateMessageFormat(message.getMessageText());
        if (accountRepository.findById(message.getPostedBy()).isEmpty()) throw new InvalidMessageException("Referenced user does not exist");
        return messageRepository.save(message);
    }
    public void validateMessageFormat(String text) {
        if (text.length()==0) throw new InvalidMessageException("Text cannot be empty");
        if (text.length()>255) throw new InvalidMessageException("Text length cannot be more than 255 charachters");
    }
    /*
     * @return all messages in database.
     *
     * 
     */
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public boolean messageExists(int messageId) {
        return messageRepository.findById(messageId).isPresent();
    }
    /*
     * @return a message with specified ID.
     * @throws InvalidMessageException if no such message exists
     */
    public Message getMessageById(int messageId) {
        Optional<Message> out = messageRepository.findById(messageId);
        return out.orElseThrow(() -> new InvalidMessageException("Message does not exist"));
    }
    /*
     * Delete a message identified by a message ID.
     *
     * Undefined if no such message exists
     */
    public void deleteMessage(int id) {
        messageRepository.deleteById(id);
    }
    /*
     * @return all messages posted by the specified account
     */
    public List<Message> getUserMessages(int accountId) {
        return messageRepository.findByPostedBy(accountId);
    }
    /*
     * Update a message text identified by a message ID.
     * Replace the messageText of the message in the database.
     *
     * @throws InvalidMessageException - if the messageText is empty or is more than 255 charachters, or messageId does not refer to an existing message in the database
     */
    public void updateMessage(String messageText, int messageId) {
        validateMessageFormat(messageText);
        Message message = getMessageById(messageId);
        message.setMessageText(messageText);
        messageRepository.save(message);
    }
}
