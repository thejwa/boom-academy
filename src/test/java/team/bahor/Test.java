package team.bahor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.SneakyThrows;
import team.bahor.dto.exam.exam.ExamCreateDtoBegin;
import team.bahor.dto.exam.exam.ExamCreateDtoEnd;

import java.util.HashMap;

public class Test {
    @org.junit.jupiter.api.Test
    @SneakyThrows
    public void test1(){
        ExamCreateDtoBegin dtoBegin = new ExamCreateDtoBegin();
        dtoBegin.setDescription("exam create qildim");
        dtoBegin.setTitle("matematika");
        dtoBegin.setCourseId("dfdfdfdfdfd");
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.disable(SerializationFeature.INDENT_OUTPUT);
        System.out.println("objectMapper.writeValueAsString(dtoBegin) = " + objectMapper.writeValueAsString(dtoBegin));
    }

    @org.junit.jupiter.api.Test
    @SneakyThrows
    public void test2(){
        ExamCreateDtoEnd examCreateDtoEnd=new ExamCreateDtoEnd();
        examCreateDtoEnd.setId("26ba7b95-d3b7-458c-9321-8f3878475e45");
        examCreateDtoEnd.setDuration(120000L);
        HashMap<String,Integer> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put(Integer.toString(2),5);
        objectObjectHashMap.put(Integer.toString(3),5);
        examCreateDtoEnd.setQuestionCounts(objectObjectHashMap);
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.disable(SerializationFeature.INDENT_OUTPUT);
        System.out.println("objectMapper.writeValueAsString(examCreateDtoEnd) = " + objectMapper.writeValueAsString(examCreateDtoEnd));
    }
}
