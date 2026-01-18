# Chương trình Phân tích Điểm Học Sinh

## 📋 Mô tả bài toán

Chương trình Java cung cấp lớp `StudentAnalyzer` với chức năng phân tích điểm số của học sinh, bao gồm:

### 1. Đếm số học sinh Giỏi (`countExcellentStudents`)

Phương thức này đếm số lượng học sinh đạt loại Giỏi (điểm >= 8.0) từ danh sách điểm số:

- **Điểm hợp lệ**: Từ 0.0 đến 10.0
- **Điểm không hợp lệ**: Nhỏ hơn 0 hoặc lớn hơn 10 (sẽ bị bỏ qua)
- **Học sinh Giỏi**: Điểm >= 8.0
- **Danh sách rỗng**: Trả về 0

**Ví dụ:**
```java
StudentAnalyzer analyzer = new StudentAnalyzer();
List<Double> scores = Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0);
int count = analyzer.countExcellentStudents(scores);
// Kết quả: 2 (9.0 và 8.5 đạt loại Giỏi, 7.0 không đạt, 11.0 và -1.0 bị bỏ qua)
```

### 2. Tính điểm trung bình hợp lệ (`calculateValidAverage`)

Phương thức này tính điểm trung bình của các điểm hợp lệ (từ 0.0 đến 10.0):

- Chỉ tính toán các điểm trong khoảng [0.0, 10.0]
- Bỏ qua các điểm không hợp lệ (< 0 hoặc > 10)
- Nếu danh sách rỗng hoặc không có điểm hợp lệ nào, trả về 0.0

**Ví dụ:**
```java
StudentAnalyzer analyzer = new StudentAnalyzer();
List<Double> scores = Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0);
double average = analyzer.calculateValidAverage(scores);
// Kết quả: 8.17 ((9.0 + 8.5 + 7.0) / 3 = 8.166...)
// Điểm 11.0 và -1.0 bị bỏ qua
```

## 🔧 Yêu cầu hệ thống

- **Java**: Version 21 trở lên
- **Maven**: 3.x (hoặc sử dụng Maven Wrapper có sẵn)
- **JUnit**: 5 (đã được tích hợp trong Spring Boot Starter Test)

## 🚀 Cách chạy chương trình

### Sử dụng Maven Wrapper (khuyến nghị)

#### 1. Compile chương trình
```bash
# Trên Windows
.\mvnw.cmd compile

# Trên Linux/Mac
./mvnw compile
```

#### 2. Chạy ứng dụng Spring Boot
```bash
# Trên Windows
.\mvnw.cmd spring-boot:run

# Trên Linux/Mac
./mvnw spring-boot:run
```

### Sử dụng Maven (nếu đã cài đặt Maven)

```bash
mvn compile
mvn spring-boot:run
```

### Chạy chương trình trong IDE

1. Mở project trong IDE (IntelliJ IDEA, Eclipse, VS Code...)
2. Mở file `src/main/java/com/example/demo/DemoApplication.java`
3. Chạy phương thức `main()` hoặc sử dụng Run/Debug

## 🧪 Cách chạy test

### Chạy tất cả test cases

```bash
# Trên Windows
.\mvnw.cmd test

# Trên Linux/Mac
./mvnw test
```

### Chạy test class cụ thể

```bash
# Trên Windows
.\mvnw.cmd test -Dtest=StudentAnalyzerTest

# Trên Linux/Mac
./mvnw test -Dtest=StudentAnalyzerTest
```

### Chạy một test method cụ thể

```bash
# Trên Windows
.\mvnw.cmd test -Dtest=StudentAnalyzerTest#testCountExcellentStudents

# Trên Linux/Mac
./mvnw test -Dtest=StudentAnalyzerTest#testCountExcellentStudents
```

### Chạy test trong IDE

1. Mở file `src/test/java/com/example/demo/StudentAnalyzerTest.java`
2. Click chuột phải vào class hoặc method test
3. Chọn "Run Test" hoặc sử dụng phím tắt

## 📊 Kết quả test

Chương trình bao gồm **17 test cases** được chia thành 2 nhóm:

### Test `countExcellentStudents` (9 test cases)
- ✅ Trường hợp bình thường: Danh sách có điểm hợp lệ và không hợp lệ
- ✅ Trường hợp bình thường: Danh sách toàn bộ hợp lệ
- ✅ Trường hợp biên: Danh sách trống
- ✅ Trường hợp biên: Giá trị 0, 8.0, 10
- ✅ Trường hợp ngoại lệ: Điểm < 0 hoặc > 10

### Test `calculateValidAverage` (8 test cases)
- ✅ Trường hợp bình thường: Mix điểm hợp lệ và không hợp lệ
- ✅ Trường hợp bình thường: Toàn bộ điểm hợp lệ
- ✅ Trường hợp biên: Danh sách trống, giá trị 0, 10
- ✅ Trường hợp ngoại lệ: Điểm không hợp lệ

**Kết quả mong đợi:**
```
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

## 📁 Cấu trúc thư mục

```
demo/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── example/
│   │               └── demo/
│   │                   ├── DemoApplication.java
│   │                   └── StudentAnalyzer.java      # Lớp chính
│   └── test/
│       └── java/
│           └── com/
│               └── example/
│                   └── demo/
│                       └── StudentAnalyzerTest.java  # Test cases
├── pom.xml
├── mvnw                                      # Maven Wrapper (Unix)
└── mvnw.cmd                                  # Maven Wrapper (Windows)
```

## 💡 Ví dụ sử dụng

```java
import com.example.demo.StudentAnalyzer;
import java.util.Arrays;
import java.util.List;

public class Example {
    public static void main(String[] args) {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        
        // Ví dụ 1: Đếm học sinh Giỏi
        List<Double> scores1 = Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0);
        int excellentCount = analyzer.countExcellentStudents(scores1);
        System.out.println("Số học sinh Giỏi: " + excellentCount); // Kết quả: 2
        
        // Ví dụ 2: Tính điểm trung bình
        List<Double> scores2 = Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0);
        double average = analyzer.calculateValidAverage(scores2);
        System.out.println("Điểm trung bình: " + average); // Kết quả: 8.166...
    }
}
```

## 🔍 Các trường hợp xử lý đặc biệt

1. **Điểm null**: Được bỏ qua (không gây lỗi)
2. **Điểm âm hoặc > 10**: Bị bỏ qua, không tính vào kết quả
3. **Danh sách null hoặc rỗng**: Trả về 0 (không gây exception)
4. **Không có điểm hợp lệ nào**: Trả về 0.0 cho phương thức tính trung bình

## 📝 Ghi chú

- Điểm số được lưu dưới dạng `Double` để hỗ trợ điểm thập phân
- Ngưỡng điểm Giỏi: **>= 8.0** (bao gồm cả 8.0)
- Phạm vi điểm hợp lệ: **[0.0, 10.0]** (bao gồm cả biên)

---

**Tác giả**: Demo Project  
**Phiên bản**: 0.0.1-SNAPSHOT
