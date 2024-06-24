package com.cornucopib.base;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ComparatorTest {

    public static void main(String[] args) {
        List<Map<String, String>> result = new ArrayList<>();
        Map<String, String> item = new HashMap<>();
        item.put("status", "in progress");
        item.put("date", "2023-04-15");
        result.add(item);

        Map<String, String> item1 = new HashMap<>();
        item1.put("status", "overdue");
        item1.put("date", "2023-05-15");
        result.add(item1);

        Map<String, String> item2 = new HashMap<>();
        item2.put("status", "completed");
        item2.put("date", "2023-01-15");
        result.add(item2);

        Map<String, String> item3 = new HashMap<>();
        item3.put("status", "in progress");
        item3.put("date", "2023-03-15a");
        result.add(item3);

        Map<String, String> item4 = new HashMap<>();
        result.add(item4);

        Map<String, String> item5 = new HashMap<>();
        item5.put("status", "in progress");
        result.add(item5);

        for (Map<String, String> stringStringMap : result) {
            System.out.println("原始： status:" + stringStringMap.get("status") + " date:" + stringStringMap.get("date"));
        }


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // 定义status的优先级
        List<String> statusPriority = Arrays.asList("in progress", "completed", "overdue");

        // 创建Comparator，首先根据status排序，再根据date排序
        Comparator<Map<String, String>> comparator = Comparator
                .comparing((Map<String, String> task) -> {
                    String status = task.get("status");
                    // 如果status为空或只含空格，则视为最低优先级
                    int index = status != null && !status.trim().isEmpty() ? statusPriority.indexOf(status) : -1;
                    return Integer.valueOf(index);
                })
                .thenComparing((Map<String, String> task) -> {
                    String dateString = task.get("date");
                    // 如果date为空，则返回null，否则解析为LocalDateTime
                    return dateString == null || dateString.isEmpty() ? null : LocalDate.parse(dateString, formatter);
                }, Comparator.nullsLast(Comparator.naturalOrder()));

        // 对tasks列表进行排序
        result.sort(comparator);


        Collections.sort(result, comparator);

        for (Map<String, String> stringStringMap : result) {
            System.out.println("排序后： status:" + stringStringMap.get("status") + " date:" + stringStringMap.get("date"));
        }
    }


}
