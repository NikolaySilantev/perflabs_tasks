package org.example;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class App
{
    public static void fillTestValue(Test test, Map<Integer, Value> valueMap) {
        if (test.getValue() != null)
            test.setValue(valueMap.get(test.getId()).getValue());

        if (test.getValues() != null)
            for (Test innerTest: test.getValues()) {
                fillTestValue(innerTest, valueMap);
            }
    }

    public static void main( String[] args ) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        String testsFileName = args[0];
        String valuesFileName = args[1];

        File testsFile = new File(testsFileName);
        File valuesFile = new File(valuesFileName);

        String reportFileName = "report.json";

//        File testsFile = new File("src/main/resources/tests.json");
//        File valuesFile = new File("src/main/resources/values.json");

        Map<String, ArrayList<Test>> testsMap = objectMapper.readValue(testsFile, Map.class);
        Map<String, ArrayList<Value>> valuesMap = objectMapper.readValue(valuesFile, Map.class);

        ArrayList<Test> tests = objectMapper.convertValue(testsMap.get("tests"), new TypeReference<ArrayList<Test>>() {
        });
        ArrayList<Value> values = objectMapper.convertValue(valuesMap.get("values"), new TypeReference<ArrayList<Value>>() {
        });

        Map<Integer, Value> integerValueMap = values.stream()
                .collect(Collectors.toMap(Value::getId, Function.identity()));

        for (Test test : tests) {
            fillTestValue(test, integerValueMap);
        }

        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String report = objectMapper.writeValueAsString(tests);

        BufferedWriter writer = new BufferedWriter(new FileWriter(reportFileName));
        writer.write(report);
        writer.close();
    }
}
