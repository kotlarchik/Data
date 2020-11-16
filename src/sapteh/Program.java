package sapteh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Program {
    public static void main(String[] args) throws IOException, ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите дату экзамена:");
        String inputDate = br.readLine();

        Date dateNow = calendar.getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String format = dateFormat.format(dateNow);

        DateFormat dateFormatInput = new SimpleDateFormat("dd.MM.yyyy");
        Date dateExam = dateFormatInput.parse(inputDate);

        int quantityDay = (int)((dateExam.getTime() - dateNow.getTime())/1000/24/60/60);
        if (quantityDay > 0)
        switch (quantityDay) {
            case 1 -> System.out.println("День до экзамена.");
            case 2, 3, 4 -> System.out.println(quantityDay + " дня до экзамена.");
            case 5, 6, 7, 8, 9, 10 -> System.out.println(quantityDay + " дней до экзамена.");
            case 0 -> System.out.println("Экзамен сегодня");
            default -> System.out.println(quantityDay +" Дней до экзамена");
        } else
            switch (quantityDay) {
                case -1 -> System.out.println("Экзамен был вчера.");
                case -2, -3, -4 -> System.out.println("Экзамен был " + quantityDay + " дня назад.");
                case -5, -6, -7, -8, -9, -10 -> System.out.println("Экзамен был " + quantityDay + " дней назад.");
                case  0 -> System.out.println("Экзамен сегодня");
                default -> System.out.println(quantityDay + " Дней после экзамена");
            }
    }
}