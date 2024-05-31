# Giới thiệu sản phẩm

Truy cập link: https://is-208-team5-nine.vercel.app/project

# Sản phẩm

1. BE API: https://ciw-be.onrender.com/swagger-ui/index.html
2. FE: https://company-internal-web.vercel.app/
> [!IMPORTANT]
> *Tài khoản admin*:
> - *email*: admin@gmail.com
> - *password*: 123456

> [!Note]
> - Bởi vì chúng mình đang sử dụng dịch vụ miễn phí để deploy nên tốc độ chạy có thể sẽ hơi chậm. BE cần khoảng 10 phút để khởi động trước khi sử dụng.
> - Nếu có lỗi hoặc vấn đề gì xảy ra, xin hãy liên hệ với chúng mình: nguyenlengocmai000@gmail.com hoặc 21521495@gm.uit.edu.vn

# Hướng dẫn cài đặt và chạy ứng dụng ở local

## Backend

### Tạo database (Đối với lần đầu chạy Backend)

1. **Bước 1:** Tải và cài đặt MySQL Workbench từ trang chủ của MySQL.
2. **Bước 2:** Tạo kết nối:
   - Username: root
   - Password: 123456
3. **Bước 3:** Sử dụng kết nối vừa tạo, chạy file `database.sql` để tạo cơ sở dữ liệu và bảng.

### Chạy Backend

**Chú ý:** Cần thiết lập môi trường Java trước khi chạy

#### Cách 1: Sử dụng các IDE hỗ trợ (IntelliJ IDEA)

1. Mở project Backend bằng IntelliJ IDEA.
2. Chạy ứng dụng từ IDE bằng cách nhấn nút "Run" hoặc "Debug".

#### Cách 2: Sử dụng command

1. Mở terminal hoặc command prompt.
2. Di chuyển vào thư mục chứa mã nguồn của Backend.
3. Chạy lệnh sau để build và chạy ứng dụng:

   ```bash
   ./mvnw spring-boot:run
   ```

> [!Note]
> *Link Swagger (API doc)*: http://localhost:8080/swagger-ui/index.html


## Frontend
1. **Bước 1:** Vào thư mục frontend
2. **Bước 2:** Chỉnh lại giá trị endpoint trong file constants/index.ts
```bash
export const endpoint = "localhost:8080/api/v1";
```
3. **Bước 3:** Import các thư viện cần thiết
```bash
npm install
```
4. **Bước 4:** Build ứng dụng
```bash
npm run build
```
5. **Bước 5:** Build ứng dụng
```bash
npm start
```
> [!Note]
> *Link FE*: http://localhost:80
