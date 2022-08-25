package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Vasya");
        student.setGroup("2141б");
        student.setEntered(new Date());
        System.out.println("Студент " + student.getName() + " из группы "
                + student.getGroup() + ". Зачислен " + student.getEntered());
    }
}
