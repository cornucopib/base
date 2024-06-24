import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

class TaskSorter {
    static void main(String[] args) {
        List<Map<String, String>> tasks = [
                ["status": "in progress", "date": "2023-03-15"],
                ["status": "completed", "date": ""],
                ["status": "overdue", "date": "2023-03-14"],
                ["status": "", "date": "2023-03-15abc"],
                ["status": "in progress", "date": ""]
        ]

        def formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

        // 定义status的优先级
        def statusPriority = ['in progress', 'completed', 'overdue']

        // 创建Comparator，首先根据status排序，再根据date排序
        Comparator<Map<String, String>> comparator = Comparator.comparing({ task ->
            def status = task['status']
            // 如果status为空或只含空格，则视为最低优先级
            int index = status ? statusPriority.indexOf(status) : -1
            index
        }).thenComparing({ task ->
            def dateString = task['date']
            // 如果date为空或无法解析，则返回null
            try {
                LocalDateTime.parse(dateString, formatter)
            } catch (DateTimeParseException e) {
                null
            }
        }, Comparator.nullsLast(Comparator.naturalOrder()))

        // 对tasks列表进行排序
        tasks.sort(comparator)

        // 打印排序后的结果
        tasks.each { task ->
            println(task)
        }
    }
}