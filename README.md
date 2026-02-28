
# Student Management System  

---

# Lab 1 – Trả lời câu hỏi

## 2. Ràng buộc Khóa Chính (Primary Key)

Khi cố tình thêm một sinh viên có `id` trùng với sinh viên đã tồn tại, Database báo lỗi:

duplicate key value violates unique constraint

### Giải thích

- `id` là Primary Key  
- Primary Key phải duy nhất và không được NULL  
- Database chặn để đảm bảo tính toàn vẹn dữ liệu  
- Nếu cho phép trùng ID, hệ thống sẽ không thể xác định chính xác bản ghi khi UPDATE hoặc DELETE  

---

## 3. Toàn vẹn dữ liệu (Constraints)

Khi thử thêm sinh viên nhưng để trống cột `name`:

- Nếu không có `NOT NULL` constraint → Database không báo lỗi  
- Điều này có thể gây lỗi trong Java như `NullPointerException`  
- Giao diện hiển thị thiếu thông tin  

### Giải pháp

Trong Entity nên khai báo:

@Column(nullable = false)
private String name;

---

## 4. Cấu hình Hibernate

Nếu cấu hình:

spring.jpa.hibernate.ddl-auto=create  
hoặc  
spring.jpa.hibernate.ddl-auto=create-drop  

Thì mỗi lần restart ứng dụng:

- Hibernate sẽ xóa bảng cũ  
- Tạo lại bảng mới  
- Dữ liệu bị mất  

### Cấu hình đúng để giữ dữ liệu

spring.jpa.hibernate.ddl-auto=update  

---

# Lab 4 – Ảnh giao diện

## 1. Trang danh sách sinh viên  
![Trang danh sách sinh viên](images/students.png)

## 2. Trang thêm sinh viên  
![Trang thêm danh sách sinh viên](images/add-students.png)

## 3. Trang xem chi tiết sinh viên  
![Trang xem chi tiết sinh viên](images/students.png)
---

# Lab 5 – Link Deploy

Ứng dụng đã được deploy tại:
https://student-management-uxx0.onrender.com/

---
