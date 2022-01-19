package com.company;

import java.time.LocalDate;
import java.util.Scanner;

public class MainActivity
{

    public MainActivity()

    {
        AddBirthday adds = new AddBirthday();
        Scanner scan = new Scanner(System.in);
        var birthday = adds.getBirthdays();
        var Names = adds.getNames();


        birthday.add(0, LocalDate.of(2000, 01, 19));
        Names.add(0, "Алексей");

        int x = 0;
        String s = "";
        adds.BirthdayToday();
        while (!"6".equals(s)) {

            System.out.println("-----------------------Меню------------------------");
            System.out.println("• Для добавления нового дня рождения, введите 1");
            System.out.println("• Для отображения всех дней рождений сотрудников, введите 2");
            System.out.println("• Для отображения всего списка сегодняшних и ближайших ДР, введите 3");
            System.out.println("• Для удаления записей из списка ДР, введите 4");
            System.out.println("• Для редактирования записей в журнале, введите 5");
            System.out.println("• Для выхода из приложения введите 6");

            s = scan.next();

            try {
                x = Integer.parseInt(s);
            } catch (NumberFormatException e){
                System.out.println("Неверный ввод");
            }

            switch (x) {
                case 1:
                    adds.Add();
                    break;
                case 2:
                    adds.ShowBirthdays();
                    break;
                case 3:
                    adds.BirthdayToday();
                    break;
                case 4:
                    adds.Remove();
                    break;
                case 5:
                    adds.EditList();
                    break;
            }


        }
        System.out.println("До свидания! Приятно было с вами работать :)");
    }

    private void BirthdayCheck()
    {
        AddBirthday adds = new AddBirthday();
        var birthday = adds.getBirthdays();
        var Names = adds.getNames();
        for (int i = 0; i < birthday.size(); i++)
        {

        }

    }
}
