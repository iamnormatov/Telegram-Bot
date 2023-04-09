package com.company;

import org.glassfish.grizzly.utils.EchoFilter;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BotService extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "t.me/bellissimo_two_bot";
    }

    @Override
    public String getBotToken() {
        return "6156749793:AAGXbK284vrUW_G8Xl0yexruXs1NhxC5g34";
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        String text = message.getText();
        SendMessage returnMessege = new SendMessage();
        if (message.hasText()) {
            if (text.equals("/start")) {
                returnMessege = catchStart(message);
            } else if (text.equals("English") || text.equals("O'zbek") || text.equals("Руский")) {
                returnMessege = catchLanguage(message);
            } else if (text.equals("Toshkent") || text.equals("Namangan") || text.equals("Urganch") || text.equals("Nukus")) {
                returnMessege = catchTake(message);
            } else if (text.equals("Olib ketish")) {
                returnMessege = catchPlace(message);
            } else if (text.equals("Bellissimo ECO")
                    || text.equals("Bellissimo Tashkent City")
                    || text.equals("Bellissimo Magic City")
                    || text.equals("Bellissimo Anhor")) {
                returnMessege = catchProduct(message);
            } else if (text.equals("Back")) {
                returnMessege = catchBack(message);
            } else if (text.equals("Pitsa")) {
                returnMessege = catchPitsa(message);
            } else if (text.equals("Ichimliklar")) {
                returnMessege = catchDrink(message);
            } else if (text.equals("Desert")) {
                returnMessege = catchDesert(message);
            } else if (text.equals("Sous")) {
                returnMessege = catchSous(message);
            } else if (text.equals("Firmenniy sous 3000 so'm")
                    || text.equals("Pishloqli sous 3000 so'm")
                    || text.equals("Barbekyu sous 3000 so'm")
                    || text.equals("Achchiq sous 3000 so'm")) {
                returnMessege = catchAnsver(message);
            } else if (text.equals("Sinnamon Rollar 8 ta 15 000 so'm")
                    || text.equals("Shokoladli Fondan 19 000 so'm")
                    || text.equals("Чизкейк \"Лайм\" 22 000 so'm")
                    || text.equals("Чизкейк \"Шоколадный\" 22 000 so'm")) {
                returnMessege = catchAnsver(message);
            } else if (text.equals("Coca-Cola разливная 8 000 so'm")
                    || text.equals("Fanta разливная 8 000 so'm")
                    || text.equals("\"Cappuccino\" qahvasi 12 000 so'm")
                    || text.equals("\"Latte\" qahvasi 10 000 so'm")) {
                returnMessege = catchAnsver(message);
            } else if (text.equals("Donar Pitsa 65 000 so'mdan")
                    || text.equals("Salsa Pitsa 50 000 so'mdan")
                    || text.equals("Pepperoni Pitsa 60 000 so'mdan")
                    || text.equals("Kombo Pitsa 55 000 so'mdan")) {
                returnMessege = catchAnsver(message);
            } else if (text.equals("Yetkazish")) {
                returnMessege = catchYetkazish(message);
            } else if (text.equals("ComeBack")) {
                returnMessege = catchComeback(message);
            }

        } else if (message.hasContact()) {
            returnMessege = catchLocation(message);
        } else if (message.hasLocation()) {
            returnMessege = theEnd(message);
        } else if (message.hasPhoto()) {
            returnMessege = catchCaution(message);
        }

        try {
            execute(returnMessege);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private SendMessage catchCaution(Message message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(message.getText().toString());
        sendMessage.setText("Ogohlantrish!!!");
        sendMessage.setText("Botga xabar yuboring");
        return sendMessage;
    }

    private SendMessage catchComeback(Message message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText("Ya'na nimadur tanlaymizmi \uD83E\uDD29");

        KeyboardButton pitsa = new KeyboardButton();
        pitsa.setText("Pitsa");

        KeyboardButton drink = new KeyboardButton();
        drink.setText("Ichimliklar");

        KeyboardButton desert = new KeyboardButton();
        desert.setText("Desert");

        KeyboardButton sous = new KeyboardButton();
        sous.setText("Sous");

        KeyboardButton back = new KeyboardButton();
        back.setText("Back");

        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add(pitsa);
        keyboardRow.add(drink);

        KeyboardRow keyboardRow1 = new KeyboardRow();
        keyboardRow1.add(desert);
        keyboardRow1.add(sous);

        KeyboardRow keyboardRow2 = new KeyboardRow();
        keyboardRow2.add(back);

        List<KeyboardRow> rowList = new ArrayList<>();
        rowList.add(keyboardRow);
        rowList.add(keyboardRow1);
        rowList.add(keyboardRow2);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);

        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    private SendMessage catchYetkazish(Message message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText("O'zingizga yaqin filialni tanlang:");

        KeyboardButton eco = new KeyboardButton();
        eco.setText("Bellissimo ECO ");

        KeyboardButton city = new KeyboardButton();
        city.setText("Bellissimo Tashkent City ");

        KeyboardButton magic = new KeyboardButton();
        magic.setText("Bellissimo Magic City ");

        KeyboardButton anhor = new KeyboardButton();
        anhor.setText("Bellissimo Anhor ");

        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add(eco);
        keyboardRow.add(city);

        KeyboardRow keyboardRow1 = new KeyboardRow();
        keyboardRow1.add(magic);
        keyboardRow1.add(anhor);


        List<KeyboardRow> rowList = new ArrayList<>();
        rowList.add(keyboardRow);
        rowList.add(keyboardRow1);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);

        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    private SendMessage theEnd(Message message) {
        Random random = new Random();
        int min = random.nextInt(20, 60);
        SendMessage sendMessage = catchBack(message);
        sendMessage.setText("Buyurtmangizni " + min + " daqiqadan so'ng olib ketishingiz mumkin.");
        return sendMessage;
    }

    private SendMessage catchLocation(Message message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText("Manzilingizni yuboring");

        KeyboardButton location = new KeyboardButton();
        location.setText("Location");
        location.setRequestLocation(true);

        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add(location);

        List<KeyboardRow> rowList = new ArrayList<>();
        rowList.add(keyboardRow);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);

        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    private SendMessage catchAnsver(Message message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText("Telefon raqamingizni quyidagi tarzda \uD83D\uDC47 yuboring yoki kiriting:\n" + "+998 ** *** ****");

        KeyboardButton contact = new KeyboardButton();
        contact.setText("Contact");
        contact.setRequestContact(true);

        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add(contact);

        List<KeyboardRow> rowList = new ArrayList<>();
        rowList.add(keyboardRow);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);

        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    private SendMessage catchSous(Message message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText("Sous turini tanlang:");

        KeyboardButton sous = new KeyboardButton();
        sous.setText("Firmenniy sous 3000 so'm");

        KeyboardButton sous1 = new KeyboardButton();
        sous1.setText("Pishloqli sous 3000 so'm");

        KeyboardButton sous2 = new KeyboardButton();
        sous2.setText("Barbekyu sous 3000 so'm");

        KeyboardButton sous3 = new KeyboardButton();
        sous3.setText("Achchiq sous 3000 so'm");

        KeyboardButton backSous = new KeyboardButton();
        backSous.setText("ComeBack");

        KeyboardRow keyboardRow2 = new KeyboardRow();
        keyboardRow2.add(backSous);

        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add(sous);
        keyboardRow.add(sous1);

        KeyboardRow keyboardRow1 = new KeyboardRow();
        keyboardRow1.add(sous2);
        keyboardRow1.add(sous3);

        List<KeyboardRow> rowList = new ArrayList<>();
        rowList.add(keyboardRow);
        rowList.add(keyboardRow1);
        rowList.add(keyboardRow2);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);

        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    private SendMessage catchDesert(Message message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText("Desert turini tanlang:");

        KeyboardButton sinaman = new KeyboardButton();
        sinaman.setText("Sinnamon Rollar 8 ta 15 000 so'm");

        KeyboardButton fondon = new KeyboardButton();
        fondon.setText("Shokoladli Fondan 19 000 so'm");

        KeyboardButton laym = new KeyboardButton();
        laym.setText("Чизкейк \"Лайм\" 22 000 so'm");

        KeyboardButton coko = new KeyboardButton();
        coko.setText("Чизкейк \"Шоколадный\" 22 000 so'm");

        KeyboardButton backSous = new KeyboardButton();
        backSous.setText("ComeBack");

        KeyboardRow keyboardRow2 = new KeyboardRow();
        keyboardRow2.add(backSous);

        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add(sinaman);
        keyboardRow.add(fondon);

        KeyboardRow keyboardRow1 = new KeyboardRow();
        keyboardRow1.add(laym);
        keyboardRow1.add(coko);

        List<KeyboardRow> rowList = new ArrayList<>();
        rowList.add(keyboardRow);
        rowList.add(keyboardRow1);
        rowList.add(keyboardRow2);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);

        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }


    private SendMessage catchDrink(Message message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText("Ichimlik turini tanlang:");

        KeyboardButton cola = new KeyboardButton();
        cola.setText("Coca-Cola разливная 8 000 so'm");

        KeyboardButton fanta = new KeyboardButton();
        fanta.setText("Fanta разливная 8 000 so'm");

        KeyboardButton cappuccino = new KeyboardButton();
        cappuccino.setText("\"Cappuccino\" qahvasi 12 000 so'm");

        KeyboardButton lattle = new KeyboardButton();
        lattle.setText("\"Latte\" qahvasi 10 000 so'm");

        KeyboardButton backSous = new KeyboardButton();
        backSous.setText("ComeBack");

        KeyboardRow keyboardRow2 = new KeyboardRow();
        keyboardRow2.add(backSous);

        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add(cola);
        keyboardRow.add(fanta);

        KeyboardRow keyboardRow1 = new KeyboardRow();
        keyboardRow1.add(cappuccino);
        keyboardRow1.add(lattle);

        List<KeyboardRow> rowList = new ArrayList<>();
        rowList.add(keyboardRow);
        rowList.add(keyboardRow1);
        rowList.add(keyboardRow2);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);

        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    private SendMessage catchPitsa(Message message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText("Pitsa turini tanlang:");

        KeyboardButton donar = new KeyboardButton();
        donar.setText("Donar Pitsa 65 000 so'mdan");

        KeyboardButton salsa = new KeyboardButton();
        salsa.setText("Salsa Pitsa 50 000 so'mdan");

        KeyboardButton pepperoni = new KeyboardButton();
        pepperoni.setText("Pepperoni Pitsa 60 000 so'mdan");

        KeyboardButton kombo = new KeyboardButton();
        kombo.setText("Kombo Pitsa 55 000 so'mdan");

        KeyboardButton backSous = new KeyboardButton();
        backSous.setText("ComeBack");

        KeyboardRow keyboardRow2 = new KeyboardRow();
        keyboardRow2.add(backSous);

        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add(donar);
        keyboardRow.add(salsa);

        KeyboardRow keyboardRow1 = new KeyboardRow();
        keyboardRow1.add(pepperoni);
        keyboardRow1.add(kombo);

        List<KeyboardRow> rowList = new ArrayList<>();
        rowList.add(keyboardRow);
        rowList.add(keyboardRow1);
        rowList.add(keyboardRow2);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);

        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    private SendMessage catchBack(Message message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText("Hush kelibsiz");

        KeyboardButton language = new KeyboardButton();
        language.setText("English");

        KeyboardButton languageTwo = new KeyboardButton();
        languageTwo.setText("O'zbek");

        KeyboardButton languageThree = new KeyboardButton();
        languageThree.setText("Руский");

        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add(language);
        keyboardRow.add(languageTwo);
        keyboardRow.add(languageThree);

        List<KeyboardRow> rowList = new ArrayList<>();
        rowList.add(keyboardRow);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);

        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    private SendMessage catchProduct(Message message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText("Sizni ko‘rganimizdan xursandmiz, Hurmatli mijoz! Bugun nima buyurtma qilasiz? \uD83C\uDF55");

        KeyboardButton pitsa = new KeyboardButton();
        pitsa.setText("Pitsa");

        KeyboardButton drink = new KeyboardButton();
        drink.setText("Ichimliklar");

        KeyboardButton desert = new KeyboardButton();
        desert.setText("Desert");

        KeyboardButton sous = new KeyboardButton();
        sous.setText("Sous");

        KeyboardButton back = new KeyboardButton();
        back.setText("Back");

        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add(pitsa);
        keyboardRow.add(drink);

        KeyboardRow keyboardRow1 = new KeyboardRow();
        keyboardRow1.add(desert);
        keyboardRow1.add(sous);

        KeyboardRow keyboardRow2 = new KeyboardRow();
        keyboardRow2.add(back);

        List<KeyboardRow> rowList = new ArrayList<>();
        rowList.add(keyboardRow);
        rowList.add(keyboardRow1);
        rowList.add(keyboardRow2);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);

        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    private SendMessage catchPlace(Message message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText("Buyurtmani qayerdan olib ketish siz uchun qulay? Lokatsiyani yoki saqlangan manzilni jo‘nating va biz sizga eng yaqin joylashgan filialni aniqlaymiz \uD83C\uDF55 \uD83D\uDCCD");

        KeyboardButton eco = new KeyboardButton();
        eco.setText("Bellissimo ECO");

        KeyboardButton city = new KeyboardButton();
        city.setText("Bellissimo Tashkent City");

        KeyboardButton magic = new KeyboardButton();
        magic.setText("Bellissimo Magic City");

        KeyboardButton anhor = new KeyboardButton();
        anhor.setText("Bellissimo Anhor");

        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add(eco);
        keyboardRow.add(city);

        KeyboardRow keyboardRow1 = new KeyboardRow();
        keyboardRow1.add(magic);
        keyboardRow1.add(anhor);


        List<KeyboardRow> rowList = new ArrayList<>();
        rowList.add(keyboardRow);
        rowList.add(keyboardRow1);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);

        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    private SendMessage catchTake(Message message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText("Buyurtmangizni mustaqil olib keting \uD83D\uDE4B\u200D♂\uFE0F yoki yetkazish xizmatini tanlang \uD83D\uDE99");

        KeyboardButton olibKetish = new KeyboardButton();
        olibKetish.setText("Olib ketish");

        KeyboardButton yetkazish = new KeyboardButton();
        yetkazish.setText("Yetkazish");

        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add(olibKetish);
        keyboardRow.add(yetkazish);

        List<KeyboardRow> rowList = new ArrayList<>();
        rowList.add(keyboardRow);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);

        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    private SendMessage catchLanguage(Message message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText("Iltimos, siz yashayotgan shaharni tanlang \uD83D\uDC47");

        KeyboardButton toshkentButton = new KeyboardButton();
        toshkentButton.setText("Toshkent");

        KeyboardButton namanganButton = new KeyboardButton();
        namanganButton.setText("Namangan");

        KeyboardButton urganchButton = new KeyboardButton();
        urganchButton.setText("Urganch");

        KeyboardButton nukusButton = new KeyboardButton();
        nukusButton.setText("Nukus");

        KeyboardRow first = new KeyboardRow();
        first.add(toshkentButton);
        first.add(namanganButton);

        KeyboardRow second = new KeyboardRow();
        second.add(urganchButton);
        second.add(nukusButton);

        List<KeyboardRow> rowList = new ArrayList<>();
        rowList.add(first);
        rowList.add(second);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);

        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    private SendMessage catchStart(Message message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText("Выберите язык:");

        KeyboardButton language = new KeyboardButton();
        language.setText("English");

        KeyboardButton languageTwo = new KeyboardButton();
        languageTwo.setText("O'zbek");

        KeyboardButton languageThree = new KeyboardButton();
        languageThree.setText("Руский");

        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add(language);
        keyboardRow.add(languageTwo);
        keyboardRow.add(languageThree);

        List<KeyboardRow> rowList = new ArrayList<>();
        rowList.add(keyboardRow);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);

        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }
}
