package com.company;

import javax.imageio.IIOException;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        /*
        Магазину нужно сохранять информацию о продажах для каждого сотрудника. Напишите метод
        Map getSalesMap(Reader reader) который принимает Reader содержащий строки вида:
        Алексей 3000
        Дмитрий 9000
        Антон 3000
        Алексей 7000
        Антон 8000
        Метод должен получить все строки из Readera и заполнить и вернуть карту где ключом будет имя сотрудника,
        а значением сумма всех его продаж.
                Пример ввода:
        Алексей 3000
        Дмитрий 9000
        Антон 3000
        Алексей 7000
        Антон 8000
        Пример вывода:
        {Алексей=[10000], Дмитрий=[9000], Антон=[11000]}

         */
        ByteArrayInputStream bais = new ByteArrayInputStream("Алексей 3000\nДмитрий 9000\nАнтон 3000\nАлексей 7000\nАнтон 8000".getBytes());
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(bais));

        System.out.println(getSalesMap(buffReader));
    }

    public static Map<String, Long> getSalesMap(Reader reader) {
        Map<String, Long> map = new HashMap<>();

        Scanner sc = new Scanner(reader);

        while (sc.hasNext()) {
            String name = sc.next();
            Long sum = sc.nextLong();
            map.merge(name, sum, (oldValue, newValue) -> oldValue + newValue);
        }
        return map;
    }

}
