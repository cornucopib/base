package com.cornucopib.time;

import java.util.Calendar;
import java.util.Date;

public class TimeDemo {

    public static void main(String[] args) {
        // 创建一个 Calendar 实例
        Calendar calendar = Calendar.getInstance();
        // 获取当前日期
        Date currentDate = new Date();
        System.out.println("当前日期: " + currentDate);
        // 将 Calendar 设置为当前日期
        calendar.setTime(currentDate);
        // 为 Calendar 增加一天
        calendar.add(Calendar.DATE, 1);
        // 获取增加一天后的日期
        Date nextDate = calendar.getTime();
        System.out.println("增加一天后的日期: " + nextDate.getTime());
    }

}
