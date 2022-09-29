package br.com.up.zap.repository;

import java.util.ArrayList;

import br.com.up.zap.model.Message;

public class MessageRepository {

    private static MessageRepository giftRepository;

    private ArrayList<Message> gifts = new ArrayList<>();

    public static MessageRepository getInstance(){
        if(giftRepository == null){
            giftRepository = new MessageRepository();
        }
        return giftRepository;
    }

    private MessageRepository(){ }

    public Message getByIndex(int index){
        return gifts.get(index);
    }
    public ArrayList<Message> get(){
        return gifts;
    }
    public void save(Message gift){
        gifts.add(gift);
    }
    public void delete(Message gift){
        gifts.remove(gift);
    }
    public void update(int index, Message gift){
        gifts.set(index,gift);
    }
}
