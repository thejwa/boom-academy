package team.bahor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.SneakyThrows;
import org.springframework.context.ApplicationContext;
import team.bahor.config.encryption.PasswordEncoderConfigurer;
import team.bahor.dto.exam.answerToExamQuestion.AnswerToExamQuestionCreateDto;
import team.bahor.dto.exam.exam.ExamCreateDtoBegin;
import team.bahor.dto.exam.exam.ExamCreateDtoEnd;
import team.bahor.dto.exam.exam.ExamSolveDto;
import team.bahor.dto.exam.exam.FinishDto;
import team.bahor.dto.exam.examQuestion.ExamQuestionCreateDto;
import team.bahor.repositories.exam.ExamRepository;
import team.bahor.services.exam.exam.ExamServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    @org.junit.jupiter.api.Test
    @SneakyThrows
    public void test1() {
        ExamCreateDtoBegin dtoBegin = new ExamCreateDtoBegin();
        dtoBegin.setDescription("exam create qildim");
        dtoBegin.setTitle("matematika");
        dtoBegin.setCourseId("dfdfdfdfdfd");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.INDENT_OUTPUT);
        System.out.println("objectMapper.writeValueAsString(dtoBegin) = " + objectMapper.writeValueAsString(dtoBegin));
    }

    @org.junit.jupiter.api.Test
    @SneakyThrows
    public void test2() {
        ExamCreateDtoEnd examCreateDtoEnd = new ExamCreateDtoEnd();
        examCreateDtoEnd.setId("f8d99a6d-2fde-42c0-a385-94158e319373");
        examCreateDtoEnd.setDuration(120000L);
        HashMap<String, Integer> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put(Integer.toString(2), 3);
        objectObjectHashMap.put(Integer.toString(3), 3);
        examCreateDtoEnd.setQuestionCounts(objectObjectHashMap);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.INDENT_OUTPUT);
        System.out.println("objectMapper.writeValueAsString(examCreateDtoEnd) = " + objectMapper.writeValueAsString(examCreateDtoEnd));
    }

    @org.junit.jupiter.api.Test
    public void test3() {
        PasswordEncoderConfigurer passwordEncoderConfigurer = new PasswordEncoderConfigurer();
        System.out.println("passwordEncoderConfigurer.passwordEncoder().encode(\"123\") = " + passwordEncoderConfigurer.passwordEncoder().encode("123"));
    }


    @SneakyThrows
    @org.junit.jupiter.api.Test
    public void examQuestionCreateDto() {
        ExamQuestionCreateDto examQuestionCreateDto = new ExamQuestionCreateDto();
        examQuestionCreateDto.setExamId("cf874f95-0c48-44d4-b643-68553ada04cb");
        examQuestionCreateDto.setTitle("100*100");
        examQuestionCreateDto.setType("TEST");
        examQuestionCreateDto.setMark(3);
        List<AnswerToExamQuestionCreateDto> answers = new ArrayList<>();

        AnswerToExamQuestionCreateDto answerToExamQuestionCreateDto1 = new AnswerToExamQuestionCreateDto();
        answerToExamQuestionCreateDto1.setTitle("10000");
        answerToExamQuestionCreateDto1.setCorrect(true);
        answers.add(answerToExamQuestionCreateDto1);

        AnswerToExamQuestionCreateDto answerToExamQuestionCreateDto2 = new AnswerToExamQuestionCreateDto();
        answerToExamQuestionCreateDto2.setTitle("13");
        answerToExamQuestionCreateDto2.setCorrect(false);
        answers.add(answerToExamQuestionCreateDto2);

        AnswerToExamQuestionCreateDto answerToExamQuestionCreateDto3 = new AnswerToExamQuestionCreateDto();
        answerToExamQuestionCreateDto3.setTitle("16");
        answerToExamQuestionCreateDto3.setCorrect(false);
        answers.add(answerToExamQuestionCreateDto3);

        AnswerToExamQuestionCreateDto answerToExamQuestionCreateDto4 = new AnswerToExamQuestionCreateDto();
        answerToExamQuestionCreateDto4.setTitle("35");
        answerToExamQuestionCreateDto4.setCorrect(false);
        answers.add(answerToExamQuestionCreateDto4);

        examQuestionCreateDto.setAnswers(answers);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.INDENT_OUTPUT);
        String s = objectMapper.writeValueAsString(examQuestionCreateDto);
        System.out.println(s);
    }

    @org.junit.jupiter.api.Test
    public void test4() {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        System.out.println("atomicInteger.getAndIncrement() = " + atomicInteger.getAndIncrement());
        System.out.println("atomicInteger.getAndIncrement() = " + atomicInteger.getAndIncrement());
    }

    @org.junit.jupiter.api.Test
    public void test5() {
//        ExamQuestionRepository
    }

    @SneakyThrows
    @org.junit.jupiter.api.Test
    public void test6() {
        ExamSolveDto examSolveDto = new ExamSolveDto();
        examSolveDto.setExamUserId("725b806e-bf74-449b-a1a8-e76e563dfbf1");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.INDENT_OUTPUT);
        System.out.println("objectMapper.writeValueAsString(objectMapper) = " + objectMapper.writeValueAsString(examSolveDto));
    }

    @SneakyThrows
    @org.junit.jupiter.api.Test
    public void test7() {
        ExamSolveDto examSolveDto = new ExamSolveDto();
        examSolveDto.setExamUserId("00f4bf6a-787d-4f3e-93f2-55ac5c2c4bd2");
        examSolveDto.setOrder(1);
        examSolveDto.setNextOrder(6);
        examSolveDto.setMarkedAnswerId("0064c5f4-150c-411d-a024-88034e723470");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.INDENT_OUTPUT);
        System.out.println("objectMapper.writeValueAsString(objectMapper) = " + objectMapper.writeValueAsString(examSolveDto));
    }/*{"examUserId":"b1adca41-1cbb-4b85-ada7-3365097cab72","markedAnswerId":"db679a77-2ced-4bdc-a4a2-50e7826b2475","nextOrder":2}
     */

    @SneakyThrows
    @org.junit.jupiter.api.Test
    public void test8() {
        String dtos = "{\"course_id\":\"1111111111111111111111111111\",\"course_title\":\"Matematika\",\"exam_id\":\"cf874f95-0c48-44d4-b643-68553ada04cb\",\"exam_title\":\"matematika\",\"question_count\":3,\"max_mark\":5,\"percentage\":100,\"exam_question_dtos\":[{\"type\":\"TEST\",\"mark\":2,\"user_mark_answer_title\":\"6\",\"title\":\"3*2\",\"correctly_solved\":1,\"answers\":[{\"exam_question_id\":\"db679a77-2ced-4bdc-a4a2-50e7826b2475\",\"title\":\"6\",\"correct\":1},{\"exam_question_id\":\"db679a77-2ced-4bdc-a4a2-50e7826b2475\",\"title\":\"13\",\"correct\":0},{\"exam_question_id\":\"db679a77-2ced-4bdc-a4a2-50e7826b2475\",\"title\":\"16\",\"correct\":0},{\"exam_question_id\":\"db679a77-2ced-4bdc-a4a2-50e7826b2475\",\"title\":\"35\",\"correct\":0}]},{\"type\":\"TEST\",\"mark\":3,\"user_mark_answer_title\":\"12\",\"title\":\"3*4\",\"correctly_solved\":1,\"answers\":[{\"exam_question_id\":\"482f3593-b2bd-4bd5-beac-3079e7f374c0\",\"title\":\"12\",\"correct\":1},{\"exam_question_id\":\"482f3593-b2bd-4bd5-beac-3079e7f374c0\",\"title\":\"13\",\"correct\":0},{\"exam_question_id\":\"482f3593-b2bd-4bd5-beac-3079e7f374c0\",\"title\":\"16\",\"correct\":0},{\"exam_question_id\":\"482f3593-b2bd-4bd5-beac-3079e7f374c0\",\"title\":\"35\",\"correct\":0}]}]}";
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.INDENT_OUTPUT);
        FinishDto finishDto = objectMapper.readValue(dtos, FinishDto.class);
        System.out.println("finishDto.getCourseId() = " + finishDto.getCourseId());
        System.out.println("finishDto.getCourseTitle() = " + finishDto.getCourseTitle());
        System.out.println("finishDto.getExamId() = " + finishDto.getExamId());

    }
    @org.junit.jupiter.api.Test
    public void test9(){
        Map<String,Integer> map = new HashMap<>();
        map.put("1",3);
        map.put("6",2);
        map.put("3",5);
        map.forEach((k,v)->{
            System.out.println(k+" + "+v);
        });

        Map<String,Integer> map1 = new HashMap<>(map);
    }

}
