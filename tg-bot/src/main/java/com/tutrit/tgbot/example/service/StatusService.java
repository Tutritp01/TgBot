package com.tutrit.tgbot.example.service;


import com.tutrit.tgbot.example.OrderStatus.OrderStatus;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Service
public class StatusService {
       public static void choice (OrderStatus orderStatus){
        SendMessage sendMessage = new SendMessage();
            switch (orderStatus) {
                case REQUEST -> sendMessage.setText("Заявка на ТО");
                case REGISTRATION -> sendMessage.setText("Оформление документов на ТО");
                case IN_PROGRESS -> sendMessage.setText("Мы пытаемся починить твоё ведро");
                case WAITING_FOR_PARTS -> sendMessage.setText("Ты запчасти не видел?");
                case WAITING_FOR_CLIENT_APPROVE -> sendMessage.setText("Псс... Парень, возьми трубку");
                case JOB_IS_DONE -> sendMessage.setText("Вроде починили, но это не точно");
                case ORDER_COMPLETE, CLOSED -> sendMessage.setText("Тебе уже точно сообщили, что все готово");
                default -> sendMessage.setText(";%:?*.... А ты точно записывался на ТО?");
            }
        }
    }


