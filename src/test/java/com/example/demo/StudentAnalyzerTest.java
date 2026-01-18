package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

public class StudentAnalyzerTest {

    @Test
    public void testCountExcellentStudents() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        
        // Trường hợp bình thường: Danh sách có nhiều điểm hợp lệ và không hợp lệ
        assertEquals(2, analyzer.countExcellentStudents(Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0)));
        
        // Trường hợp biên: Danh sách trống
        assertEquals(0, analyzer.countExcellentStudents(Collections.emptyList()));
        
        // Trường hợp bình thường: Danh sách toàn bộ hợp lệ
        assertEquals(3, analyzer.countExcellentStudents(Arrays.asList(8.0, 9.5, 8.5, 7.5)));
        
        // Trường hợp biên: Danh sách chỉ chứa giá trị 8.0 (đúng ngưỡng)
        assertEquals(1, analyzer.countExcellentStudents(Arrays.asList(8.0)));
        
        // Trường hợp biên: Danh sách chỉ chứa giá trị 10
        assertEquals(1, analyzer.countExcellentStudents(Arrays.asList(10.0)));
        
        // Trường hợp biên: Danh sách chỉ chứa giá trị 0
        assertEquals(0, analyzer.countExcellentStudents(Arrays.asList(0.0)));
        
        // Trường hợp ngoại lệ: Có điểm < 0 hoặc > 10 (bỏ qua)
        assertEquals(0, analyzer.countExcellentStudents(Arrays.asList(-5.0, -1.0, 11.0, 15.0)));
        
        // Trường hợp ngoại lệ: Mix điểm hợp lệ và không hợp lệ
        assertEquals(2, analyzer.countExcellentStudents(Arrays.asList(9.0, -1.0, 8.5, 11.0, 7.9, -5.0)));
        
        // Trường hợp biên: Điểm 7.9 (không đạt)
        assertEquals(0, analyzer.countExcellentStudents(Arrays.asList(7.9, 7.5, 6.0)));
    }

    @Test
    public void testCalculateValidAverage() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        
        // Trường hợp bình thường: Danh sách có nhiều điểm hợp lệ và không hợp lệ
        // (9.0 + 8.5 + 7.0) / 3 = 24.5 / 3 = 8.166...
        assertEquals(8.17, analyzer.calculateValidAverage(Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0)), 0.01);
        
        // Trường hợp biên: Danh sách trống
        assertEquals(0.0, analyzer.calculateValidAverage(Collections.emptyList()), 0.001);
        
        // Trường hợp bình thường: Danh sách toàn bộ hợp lệ
        // (8.0 + 9.5 + 7.5) / 3 = 25.0 / 3 = 8.333...
        assertEquals(8.33, analyzer.calculateValidAverage(Arrays.asList(8.0, 9.5, 7.5)), 0.01);
        
        // Trường hợp biên: Danh sách chỉ chứa giá trị 0
        assertEquals(0.0, analyzer.calculateValidAverage(Arrays.asList(0.0)), 0.001);
        
        // Trường hợp biên: Danh sách chỉ chứa giá trị 10
        assertEquals(10.0, analyzer.calculateValidAverage(Arrays.asList(10.0)), 0.001);
        
        // Trường hợp ngoại lệ: Có điểm < 0 hoặc > 10 (bỏ qua)
        assertEquals(0.0, analyzer.calculateValidAverage(Arrays.asList(-5.0, -1.0, 11.0, 15.0)), 0.001);
        
        // Trường hợp ngoại lệ: Mix điểm hợp lệ và không hợp lệ
        // (9.0 + 8.5 + 7.0) / 3 = 8.166...
        assertEquals(8.17, analyzer.calculateValidAverage(Arrays.asList(9.0, -1.0, 8.5, 11.0, 7.0, -5.0)), 0.01);
        
        // Trường hợp biên: Một điểm duy nhất
        assertEquals(5.5, analyzer.calculateValidAverage(Arrays.asList(5.5)), 0.001);
    }
}
