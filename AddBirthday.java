package com.company;

import java.io.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class AddBirthday
{

    private ArrayList<LocalDate> birthdays = new ArrayList<>();
    private ArrayList<String> Names = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

    public ArrayList<LocalDate> getBirthdays() {
        return birthdays;
    }

    public ArrayList<String> getNames() {
        return Names;
    }

    //Add a new entry
    public void Add() {

        try {
            System.out.print("Введите год рождения: ");
            int year = scan.nextInt();

            while (year > 2022 || year < 1900)  {
                System.out.print("Неверный год, повторите ввод: ");
                year = scan.nextInt();
            }

            System.out.print("Введите месяц рождения: ");
            int month = scan.nextInt();

            System.out.print("Введите день: ");
            int day = scan.nextInt();

            birthdays.add(LocalDate.of(year, month, day));

            System.out.print("Введите имя сотрудника: ");
            String name = scan.next();

            Names.add(name);

            File file = new File("C:\\Users\\Mishka\\Desktop\\Text.txt");
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            for (int i = 0; i < birthdays.size(); i++)
            {
                fileWriter.write(birthdays.get(i).toString() + " Сотрудник - " + name + "\n");
            }
            fileWriter.flush();
            fileWriter.close();


            System.out.println("Новый день рождения добавлен! :)");
        } catch (InputMismatchException e) {
            System.out.println("Неверный формат данных.");
            Add();
        } catch (DateTimeException e) {
            System.out.println("Введенные вами данные неверны, попробуйте еще раз :)");
            Add();
        } catch (IOError e) {
            System.out.println("IO Error");
        } catch (IOException e) {
            System.out.println("IO Exception");
        }
    }

    //Show all birthdays
    public void ShowBirthdays()
    {

        if (birthdays.size() > 0)
        {
            System.out.println("Все дни рождения: ");
            for (int i = 0; i < birthdays.size(); i++)
            {
                System.out.println("• " + birthdays.get(i) + " Сотрудник - " + Names.get(i));
            }

        } else
            System.out.println("Список пуст.");
    }


    //Show today's birthday
    public void BirthdayToday()
    {

        int Diff = 0;

        //Сегодняшний ДР
        for (int i = 0; i < birthdays.size(); i++)
        {
            if (birthdays.get(i).getDayOfMonth() == LocalDate.now().getDayOfMonth() && birthdays.get(i).getMonth() ==
                    LocalDate.now().getMonth())
            {
                System.out.println("Сегодня есть день рождения! У сотрудника - " + Names.get(i));
                System.out.println(birthdays.get(i));
            }
            else
            {
                System.out.print("");
            }

        }

    }

    //Remove someone's from list
    public void Remove()
    {
        if (birthdays.size() == 0) {
            System.out.println("Удалять некого, список пуст.");
        } else {
            try {

                System.out.print("Введите имя сотрудника для удаления: ");
                String employee = scan.next();
                for (int i = 0; i < Names.size(); i++)
                {
                    if (employee.equals(Names.get(i)))
                    {
                        System.out.println("Сотрудник найден! Удаление...");
                        Names.remove(i);
                        birthdays.remove(i);
                        System.out.println("Удалено.");
                    }
                }

            } catch (InputMismatchException e) {
                System.out.println("Неверный формат данных.");
                Add();
            } catch (DateTimeException e) {
                System.out.println("Введенные вами данные неверны, попробуйте еще раз :)");
                Add();
            }
        }
    }

    public void EditList()
    {
        if (birthdays.size() == 0) {
            System.out.println("Удалять некого, список пуст.");
        } else {

            try {
                System.out.print("Введите имя сотрудника, чьи данные необходимо изменить: ");
                String employee = scan.next();
                int choose;
                LocalDate new_date;
                for (int i = 0; i < Names.size(); i++)
                {
                    if (employee.equals(Names.get(i)))
                    {
                        System.out.println("Сотрудник найден! Что будем менять?\n1 - Имя сотрудника \n2 - " +
                                "Дату рождения сотрудника");
                        choose = scan.nextInt();
                        if (choose <= 2 && choose > 0) {
                            if (choose == 1)
                            {
                                System.out.print("Введите новое имя этого сотрудника: ");
                                String new_name = scan.next();
                                //Names.remove(i);
                                Names.add(i, new_name);
                                System.out.print("Имя сотрудника изменено!\n");
                                break;
                            }
                            if (choose == 2) {
                                System.out.print("Введите год рождения: ");
                                int year = scan.nextInt();

                                while (year > 2022 || year < 1900)  {
                                    System.out.print("Неверный год, повторите ввод: ");
                                    year = scan.nextInt();
                                }

                                System.out.print("Введите месяц рождения: ");
                                int month = scan.nextInt();

                                System.out.print("Введите день: ");
                                int day = scan.nextInt();

                                birthdays.add(i, LocalDate.of(year, month, day));
                            }
                        }

                    }
                }

            } catch (InputMismatchException e) {
                System.out.println("Неверный формат данных.");
                Add();
            } catch (DateTimeException e) {
                System.out.println("Введенные вами данные неверны, попробуйте еще раз :)");
                Add();
            }
        }
    }

}


