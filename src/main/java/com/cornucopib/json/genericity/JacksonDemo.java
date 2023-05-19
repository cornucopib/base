package com.cornucopib.json.genericity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JacksonDemo {
    public static void main(String[] args) throws Exception {
        objectNodeToString();
        stringToObjectNode();
    }

    private static void stringToObjectNode() throws JsonProcessingException {
        // 创建ObjectMapper实例
        ObjectMapper objectMapper = new ObjectMapper();

        // 定义JSON字符串
        String jsonString = "{\"name\":\"John Doe\",\"age\":25,\"books\":[\"Book 1\",\"Book 2\",\"Book 3\"]}";

        // 将JSON字符串转换为ObjectNode
        ObjectNode jsonNode = (ObjectNode) objectMapper.readTree(jsonString);

        String name = jsonNode.get("name").asText();
        // 打印ObjectNode
        System.out.println(name);
    }

    private static void objectNodeToString() throws JsonProcessingException {
        // 创建ObjectMapper实例
        ObjectMapper objectMapper = new ObjectMapper();

        // 创建空的ObjectNode对象
        ObjectNode json = objectMapper.createObjectNode();

        // 添加name属性
        json.put("name", "John Doe");

        // 添加age属性
        json.put("age", 25);

        // 创建书籍列表
        ArrayNode books = objectMapper.createArrayNode();
        books.add("Book 1");
        books.add("Book 2");
        books.add("Book 3");

        // 添加书籍列表属性
        json.set("books", books);

        // 转换为JSON字符串
        String jsonString = objectMapper.writeValueAsString(json);

        // 输出JSON字符串
        System.out.println(jsonString);
    }
}
