-- drop database demo;
-- CREATE DATABASE IF NOT EXISTS demo;
-- USE demo;

select * from carts;

-- ===============================================
-- USERS
-- ===============================================
INSERT INTO users (id, username, password, email, full_name, phone, role, status, created_at, updated_at)
VALUES
(1, 'admin', '1', 'admin@bookstore.com', 'Administrator', '0901000001', 'ADMIN', true, NOW(), NOW()),
(2, 'user1', '123456', 'user1@gmail.com', 'Nguyen Van A', '0901000002', 'USER', true, NOW(), NOW()),
(3, 'user2', '123456', 'user2@gmail.com', 'Tran Thi B', '0901000003', 'USER', true, NOW(), NOW());

-- ===============================================
-- CATEGORIES
-- ===============================================
INSERT INTO categories (id, name, created_at, updated_at)
VALUES
(1, 'Văn học', NOW(), NOW()),
(2, 'Khoa học', NOW(), NOW()),
(3, 'Công nghệ', NOW(), NOW()),
(4, 'Kinh tế', NOW(), NOW()),
(5, 'Tâm lý học', NOW(), NOW()),
(6, 'Thiếu nhi', NOW(), NOW()),
(7, 'Tiểu thuyết', NOW(), NOW()),
(8, 'Lịch sử', NOW(), NOW()),
(9, 'Ngoại ngữ', NOW(), NOW()),
(10, 'Phát triển bản thân', NOW(), NOW());

-- ===============================================
-- BOOKS
-- ===============================================
INSERT INTO books (id, title, author, price, stock, description, image, created_at, updated_at)
VALUES
(1, 'Lão Hạc', 'Nam Cao', 45000, 50, 'Tác phẩm kinh điển của văn học Việt Nam.', 'laohac.jpg', NOW(), NOW()),
(2, 'Dế Mèn Phiêu Lưu Ký', 'Tô Hoài', 55000, 100, 'Truyện thiếu nhi nổi tiếng.', 'demen.jpg', NOW(), NOW()),
(3, 'Tôi Tài Giỏi, Bạn Cũng Thế', 'Adam Khoo', 89000, 80, 'Sách phát triển bản thân nổi tiếng.', 'toitaigioi.jpg', NOW(), NOW()),
(4, 'Lập Trình Java Cơ Bản', 'Nguyễn Văn Hòa', 120000, 40, 'Giáo trình học lập trình Java.', 'java.jpg', NOW(), NOW()),
(5, 'Tâm Lý Học Tội Phạm', 'David Canter', 99000, 30, 'Khám phá hành vi và tư duy tội phạm.', 'tamlytoipham.jpg', NOW(), NOW());

-- ===============================================
-- BOOK_CATEGORY (Many-to-Many)
-- ===============================================
INSERT INTO book_category (book_id, category_id)
VALUES
(1, 2),
(1, 1),
(2, 6),
(3, 10),
(4, 3),
(5, 5);

-- ===============================================
-- PROMOTIONS
-- ===============================================
INSERT INTO promotions (id, name, discount_percent, description, start_date, end_date, created_at, updated_at)
VALUES
(1, 'Giảm giá 10%', 10.0, 'Giảm 10% cho đơn hàng đầu tiên.', NOW(), DATE_ADD(NOW(), INTERVAL 30 DAY), NOW(), NOW()),
(2, 'Giảm giá sinh viên', 15.0, 'Ưu đãi 15% cho sinh viên có thẻ.', NOW(), DATE_ADD(NOW(), INTERVAL 60 DAY), NOW(), NOW());

-- ===============================================
-- CARTS
-- ===============================================
INSERT INTO carts (id, user_id, created_at, updated_at)
VALUES
(1, 1, NOW(), NOW()),
(2, 2, NOW(), NOW()),
(3, 3, NOW(), NOW());

-- ===============================================
-- CART ITEMS
-- ===============================================
INSERT INTO cart_items (id, cart_id, book_id, quantity, created_at, updated_at)
VALUES
(1, 1, 3, 1, NOW(), NOW()),
(2, 1, 4, 2, NOW(), NOW()),
(3, 2, 1, 1, NOW(), NOW());

-- ===============================================
-- ORDERS
-- ===============================================
INSERT INTO orders (id, user_id, status, shipment, note, order_date, payment_method, created_at, updated_at)
VALUES
(1, 2, 'CONFIRMED', 'Hà Nội', 'Giao buổi sáng', NOW(), 'COD', NOW(), NOW()),
(2, 3, 'PENDING', 'TP. Hồ Chí Minh', NULL, NOW(), 'VNPAY', NOW(), NOW());

-- ===============================================
-- ORDER DETAILS
-- ===============================================
INSERT INTO order_details (id, order_id, book_id, quantity, price, created_at, updated_at)
VALUES
(1, 1, 3, 1, 89000, NOW(), NOW()),
(2, 1, 4, 1, 120000, NOW(), NOW()),
(3, 2, 1, 2, 45000, NOW(), NOW());

-- ===============================================
-- ORDER_DETAIL_PROMOTION (Many-to-Many)
-- ===============================================
INSERT INTO order_detail_promotion (order_detail_id, promotion_id)
VALUES
(1, 1),
(2, 2);


-- drop database demo;
-- CREATE DATABASE IF NOT EXISTS demo;
-- USE demo;

select * from carts;

-- ===============================================
-- USERS
-- ===============================================
INSERT INTO users (id, username, password, email, full_name, phone, role, status, created_at, updated_at)
VALUES
(1, 'admin', '1', 'admin@bookstore.com', 'Administrator', '0901000001', 'ADMIN', true, NOW(), NOW()),
(2, 'user1', '123456', 'user1@gmail.com', 'Nguyen Van A', '0901000002', 'USER', true, NOW(), NOW()),
(3, 'user2', '123456', 'user2@gmail.com', 'Tran Thi B', '0901000003', 'USER', true, NOW(), NOW());

-- ===============================================
-- CATEGORIES
-- ===============================================
INSERT INTO categories (id, name, created_at, updated_at)
VALUES
(1, 'Văn học', NOW(), NOW()),
(2, 'Khoa học', NOW(), NOW()),
(3, 'Công nghệ', NOW(), NOW()),
(4, 'Kinh tế', NOW(), NOW()),
(5, 'Tâm lý học', NOW(), NOW()),
(6, 'Thiếu nhi', NOW(), NOW()),
(7, 'Tiểu thuyết', NOW(), NOW()),
(8, 'Lịch sử', NOW(), NOW()),
(9, 'Ngoại ngữ', NOW(), NOW()),
(10, 'Phát triển bản thân', NOW(), NOW());

-- ===============================================
-- BOOKS
-- ===============================================
INSERT INTO books (id, title, author, price, stock, description, image, created_at, updated_at)
VALUES
(1, 'Lão Hạc', 'Nam Cao', 45000, 50, 'Tác phẩm kinh điển của văn học Việt Nam.', 'laohac.jpg', NOW(), NOW()),
(2, 'Dế Mèn Phiêu Lưu Ký', 'Tô Hoài', 55000, 100, 'Truyện thiếu nhi nổi tiếng.', 'demen.jpg', NOW(), NOW()),
(3, 'Tôi Tài Giỏi, Bạn Cũng Thế', 'Adam Khoo', 89000, 80, 'Sách phát triển bản thân nổi tiếng.', 'toitaigioi.jpg', NOW(), NOW()),
(4, 'Lập Trình Java Cơ Bản', 'Nguyễn Văn Hòa', 120000, 40, 'Giáo trình học lập trình Java.', 'java.jpg', NOW(), NOW()),
(5, 'Tâm Lý Học Tội Phạm', 'David Canter', 99000, 30, 'Khám phá hành vi và tư duy tội phạm.', 'tamlytoipham.jpg', NOW(), NOW());

-- ===============================================
-- BOOK_CATEGORY (Many-to-Many)
-- ===============================================
INSERT INTO book_category (book_id, category_id)
VALUES
(1, 2),
(1, 1),
(2, 6),
(3, 10),
(4, 3),
(5, 5);

-- ===============================================
-- PROMOTIONS
-- ===============================================
INSERT INTO promotions (id, name, discount_percent, description, start_date, end_date, created_at, updated_at)
VALUES
(1, 'Giảm giá 10%', 10.0, 'Giảm 10% cho đơn hàng đầu tiên.', NOW(), DATE_ADD(NOW(), INTERVAL 30 DAY), NOW(), NOW()),
(2, 'Giảm giá sinh viên', 15.0, 'Ưu đãi 15% cho sinh viên có thẻ.', NOW(), DATE_ADD(NOW(), INTERVAL 60 DAY), NOW(), NOW());

-- ===============================================
-- CARTS
-- ===============================================
INSERT INTO carts (id, user_id, created_at, updated_at)
VALUES
(1, 1, NOW(), NOW()),
(2, 2, NOW(), NOW()),
(3, 3, NOW(), NOW());

-- ===============================================
-- CART ITEMS
-- ===============================================
INSERT INTO cart_items (id, cart_id, book_id, quantity, created_at, updated_at)
VALUES
(1, 1, 3, 1, NOW(), NOW()),
(2, 1, 4, 2, NOW(), NOW()),
(3, 2, 1, 1, NOW(), NOW());

-- ===============================================
-- ORDERS
-- ===============================================
INSERT INTO orders (id, user_id, status, shipment, note, order_date, payment_method, created_at, updated_at)
VALUES
(1, 2, 'CONFIRMED', 'Hà Nội', 'Giao buổi sáng', NOW(), 'COD', NOW(), NOW()),
(2, 3, 'PENDING', 'TP. Hồ Chí Minh', NULL, NOW(), 'VNPAY', NOW(), NOW());

-- ===============================================
-- ORDER DETAILS
-- ===============================================
INSERT INTO order_details (id, order_id, book_id, quantity, price, created_at, updated_at)
VALUES
(1, 1, 3, 1, 89000, NOW(), NOW()),
(2, 1, 4, 1, 120000, NOW(), NOW()),
(3, 2, 1, 2, 45000, NOW(), NOW());

-- ===============================================
-- ORDER_DETAIL_PROMOTION (Many-to-Many)
-- ===============================================
INSERT INTO order_detail_promotion (order_detail_id, promotion_id)
VALUES
(1, 1),
(2, 2);


