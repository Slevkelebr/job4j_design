package ru.job4j.io.chat;

import java.util.List;
import java.util.Objects;

/**
 * Класс определяет работу консольного чата.
 * @author Frolov Sergey (Slevkelebr@yandex.ru)
 * @version 0.1
 * @since 01.09.2020
 */

public class StartChat {

    private static final String STOP = "стоп";
    private static final String FINISH = "завершить";
    private static final String CONTINUE = "продолжить";
    /**
     * Состояние чата 0 - чат активен (т.е. в чат отправляются сообщения в ответ на пользовательское сообщение),
     * 1 - чат не активен (т.е. пользователь может отправлять сообщения в чат, но не будет получать ответа).
     */
    private int stateResponse = 0;
    /**
     * Режим работы чата.
     */
    private boolean chatState = true;
    

    /**
     * Цикл чата, прохоид опрос пользователя и получение ответа из списка.
     * @param user ответ от пользователя.
     * @param text список возможных ответов.
     */
    private void chatLoop(User user, Read text, Logger logger) {
        System.out.println("Вы запустили консольный чат.");
        System.out.println("Что бы остановить чат введите - " + STOP);
        System.out.println("Что бы продолжить чат введите - " + CONTINUE);
        System.out.println("Что бы завершить чат введите - " + FINISH);
        System.out.println("Пожалуйста введите слово-фразу, чтобы начать общаться:");
        do {
            String answerUser = user.answer();
            statusCheck(answerUser);
            String answerChat = randomAnswer(text.readFile());
            if (!answerChat.equals("")) {
                System.out.println(answerChat);
            }
            logger.writeLog(answerUser, answerChat);
        } while (this.chatState);

    }

    /**
     * Проверка режима чата и изменения его активности.
     * @param answer сообщение от пользователя.
     */
    private void statusCheck (String answer) {
        if (STOP.equals(answer)) {
            this.stateResponse = 1;
            this.chatState =  true;
        }
        if (FINISH.equals(answer)) {
            System.out.println("Чат закрыт.");
            this.chatState = false;
        }
        if (CONTINUE.equals(answer)) {
            this.stateResponse = 0;
            this.chatState = true;
        }
    }

    /**
     * Рандомный ответ для пользователя из списка.
     * @param text список готовых ответов.
     */
    private String randomAnswer (List<String> text) {
        String result = "";
        if (this.chatState && this.stateResponse == 0) {
            int index = (int) (Math.random() * (text.size() - 1));
            result = text.get(index);
        }
        return result;
    }

    public static void main(String[] args) {
        StartChat chat = new StartChat();
        UserAnswer userAnswer = new UserAnswer();
        LoggerChat logger = new LoggerChat("c:\\projects\\job4j_design\\chapter_001\\log.txt");
        ReadTxt txt = new ReadTxt((Objects.requireNonNull(ReadTxt.class.getClassLoader().getResource("text.txt"))).getFile());
        chat.chatLoop(userAnswer, txt, logger);
    }

}
