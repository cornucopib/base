package com.cornucopib.base;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

//package compator
//
//import java.time.LocalDate
//import java.time.format.DateTimeFormatter
//
//class Test {
//
//    static void main(String[] args) {
//        List<Map<String, String>> tasks = [
//                ["status": "in progress", "date": "2023-03-15"],
//                ["status": "completed", "date": ""],
//                ["status": "overdue", "date": "2023-03-14"],
//                ["status": "in progress", "date": "abc"],
//                ["status": "in progress", "date": "2023-04-15"],
//                ["status": null, "date": "2023-03-15abc"],
//                ["status": "", "date": "2023-03-15abc"],
//                ["status": "in progress", "date": ""]
//        ]
//
//
//        def formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
//        def statusPriority = ['in progress', 'completed', 'overdue']
//
//        // 辅助函数用于安全地解析日期
//        def parseDate = { dateStr, formatter1 ->
//        {
//            try {
//                return dateStr != null && dateStr != "" ? LocalDate.parse(dateStr, formatter) : null
//            } catch (Exception e) {
//                return null
//            }
//        }
//        }
//
//        // 排序
//        // 排序
//        tasks.sort { a, b ->
//                def statusAIdx = (a.status ?: '').trim().empty ? Integer.MAX_VALUE : statusPriority.indexOf(a.status)
//            def statusBIdx = (b.status ?: '').trim().empty ? Integer.MAX_VALUE : statusPriority.indexOf(b.status)
//
//            // 首先基于status排序
//            if (statusAIdx != statusBIdx) {
//                return statusAIdx <=> statusBIdx
//            }
//
//            // 然后基于date排序
//            def dateA = parseDate(a.date, formatter)
//            def dateB = parseDate(b.date, formatter)
//
//            // 确保无法解析的日期排在所有可解析日期之后
//            if(dateA==null&&dateB==null){
//                return 0
//            }
//            if(dateA==null&&dateB!=null){
//                return 1
//            }
//            if(dateA!=null&&dateB==null){
//                return -1
//            }
//            dateB <=> dateA
//        }
//
//
//        // 打印排序后的结果
//        tasks.each { println(it) }
//    }
//}
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


        Map<String, String> item6 = new HashMap<>();
        item6.put("status", "in progress");
        item6.put("date", "abc");
        result.add(item6);

        Map<String, String> item7 = new HashMap<>();
        item7.put("status", "in progress");
        item7.put("date", "2024-04-15");
        result.add(item7);

        Map<String, String> item8 = new HashMap<>();
        item8.put("status", "completed");
        item8.put("date", "def");
        result.add(item8);

        for (Map<String, String> stringStringMap : result) {
            System.out.println("原始： status:" + stringStringMap.get("status") + " date:" + stringStringMap.get("date"));
        }


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // 定义status的优先级
        List<String> statusPriority = Arrays.asList("in progress", "completed", "overdue");

        // 创建Comparator，首先根据status排序，再根据date排序
        Comparator<Map<String, String>> comparator = Comparator
                // def statusAIdx = (a.status ?: '').trim().empty ? Integer.MAX_VALUE : statusPriority.indexOf(a.status)
                .comparing((Map<String, String> task) -> {
                    String status = task.get("status");
                    // 如果status为空或只含空格，则视为最低优先级
                    int index = status != null && !status.trim().isEmpty() ? statusPriority.indexOf(status) : Integer.MAX_VALUE;
                    return Integer.valueOf(index);
                })
                .thenComparing((Map<String, String> task) -> {
                    // def statusAIdx = (a.status ?: '').trim().empty ? Integer.MAX_VALUE : statusPriority.indexOf(a.status)
                    String dateString = task.get("date");
                    // 如果date为空，则返回null，否则解析为LocalDateTime
                    if(dateString == null || dateString.isEmpty()){
                        return null;
                    }
                    try {
                        return LocalDate.parse(dateString, formatter);
                    }catch (DateTimeParseException e){
                        return null;
                    }
                }, Comparator.nullsLast(Comparator.reverseOrder()));

        // 对tasks列表进行排序
        result.sort(comparator);


        for (Map<String, String> stringStringMap : result) {
            System.out.println("排序后： status:" + stringStringMap.get("status") + " date:" + stringStringMap.get("date"));
        }
    }


}
