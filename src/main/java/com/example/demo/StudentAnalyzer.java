package com.example.demo;

import java.util.List;

public class StudentAnalyzer {
    /**
     * Phân tích điểm số và trả về số lượng học sinh đạt loại Giỏi.
     * @param scores danh sách điểm số từ 0 đến 10
     * @return số học sinh đạt loại Giỏi (>= 8.0)
     * - Bỏ qua điểm âm hoặc lớn hơn 10 (coi là dữ liệu sai)
     * - Nếu danh sách rỗng, trả về 0
     */
    public int countExcellentStudents(List<Double> scores) {
        // Điều kiện 2: Nếu danh sách rỗng thì trả về 0
        if (scores == null || scores.isEmpty()) {
            return 0;
        }
        
        int count = 0;
        // Vòng lặp 1: Duyệt qua danh sách điểm để lọc học sinh giỏi
        for (Double score : scores) {
            // Điều kiện 1: Nếu điểm nhỏ hơn 0 hoặc lớn hơn 10 thì bỏ qua (validate)
            if (score != null && score >= 0.0 && score <= 10.0) {
                if (score >= 8.0) {
                    count++;
                }
            }
        }
        
        return count;
    }
}