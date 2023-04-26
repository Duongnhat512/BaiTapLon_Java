--drop database BaiTapLon

create database BaiTapLon
go
use BaiTapLon
go 
CREATE TABLE KhachHang(
    [maKH] NVARCHAR(15) PRIMARY KEY,
    [tenKH] NVARCHAR(30) NULL,
    [gioiTinh] bit NULL,
    [diaChi] NVARCHAR(50)  NULL,
    [soDienThoai] NVARCHAR(20)  NULL,
    [gmail] NVARCHAR(50)  NULL,
	[loaiKH] NVARCHAR(50)  NULL
);
go
CREATE TABLE [dbo].[NhaCungCap] (
    [maNCC] NVARCHAR(15) PRIMARY KEY,
    [tenNCC] NVARCHAR(50)  NULL,
    [diaChi] NVARCHAR(100)  NULL,
    [soDT] NVARCHAR(20)  NULL,
    [email] NVARCHAR(50)  NULL
);
go
create Table [dbo].PhongBan (
    [maPhong] NVARCHAR(15) PRIMARY KEY,
    [tenPhong] NVARCHAR(50)  NULL
);
go
CREATE TABLE [dbo].[NhanVien] (
    [maNV] NVARCHAR(15) PRIMARY KEY,
    [tenNV] NVARCHAR(50)  NULL,
    [phongBan] NVARCHAR(15)  NULL,
    [soDT] NVARCHAR(20)  NULL,
    [luong] money  NULL,
    [gioiTinh] NVARCHAR(10)  NULL,
	FOREIGN KEY ([phongBan]) REFERENCES PhongBan([maPhong]) ON DELETE SET NULL
);
go
CREATE TABLE SanPham (
    maSP NVARCHAR(15) PRIMARY KEY,
    tenSP NVARCHAR(50) NULL,
    hang NVARCHAR(50) NULL,
    loai NVARCHAR(50) NULL,
    giaNhap money NULL,
    giaBan money NULL,
    slTon INT NULL,
    maNCC NVARCHAR(15) NULL,
    thoiGianBH int NULL,
    chipSet NVARCHAR(50) NULL,
    kheLuuTru NVARCHAR(50) NULL,
    kheMoRong NVARCHAR(50) NULL,
	nhan int null,
	luong int null,
	cache int null,
	dungLuongODia int null,
	cacheDDR NVARCHAR(50) null,
	tuoiThoTB float null,
	loaiRam NVARCHAR(50) null,
	dungLuongRam NVARCHAR(50) null,
	tocDoRam int null,
	FOREIGN KEY (maNCC) REFERENCES NhaCungCap(maNCC) ON DELETE SET NULL
);
go 
CREATE TABLE HoaDon (
    maHD NVARCHAR(15) PRIMARY KEY,
    maKH NVARCHAR(15) REFERENCES KhachHang(maKH) ON DELETE SET NULL,
    maNV NVARCHAR(15) REFERENCES NhanVien(maNV) ON DELETE SET NULL,
    ngayLapHD DATE,
    ngayGiao DATE,
    noiNhanHang NVARCHAR(50),
    tongTien money 
);
go 
CREATE TABLE ChiTietHoaDon (
    maChiTietHD NVARCHAR(15) PRIMARY KEY,
    maHD NVARCHAR(15) null,
    maSP NVARCHAR(15) null,
    soLuong INT null,
	giaBan money null,
    tongTien money null,
    FOREIGN KEY (maSP) REFERENCES SanPham(maSP) ON DELETE SET NULL,
    FOREIGN KEY (maHD) REFERENCES HoaDon(maHD) ON DELETE SET NULL
);
go
CREATE TABLE TaiKhoan(
	TaiKhoan varchar(50) primary key not null,
	MatKhau varchar(50) not null,
	Loai varchar(30),
)

INSERT INTO TaiKhoan values ('admin', '123', 'admin'), 
							('duong', '123', 'nv'),
							('dat', '123', 'nv'),
							('bao', '123', 'nv'),
							('kiet', '123', 'nv'),
							('nhansu', '123', 'ns')

go
INSERT INTO [dbo].[KhachHang] ([maKH], [tenKH], [gioiTinh], [diaChi], [soDienThoai], [gmail],loaiKH)
VALUES 
    ('KH001', N'Nguyễn Thị An', 0, N'123 Đường A, Quận B, TP HCM', '0909123456', 'annguyen@gmail.com',N'Đồng'),
    ('KH002', N'Trần Văn Bình', 1, N'234 Đường C, Quận D, TP HCM', '0909988776', 'binhtran@gmail.com',N'Vàng'),
    ('KH003', N'Lê Thị Cẩm', 0, N'456 Đường E, Quận F, TP HCM', '0909654321', 'camle@gmail.com',N'Bạc'),
    ('KH004', N'Phạm Văn Dũng', 1, N'789 Đường G, Quận H, TP HCM', '0909345678', 'dung.pham@gmail.com',N'Kim Cương'),
    ('KH005', N'Nguyễn Thị Thuỳ', 0, N'101 Đường I, Quận J, TP HCM', '0909786543', 'thuy.nguyen@gmail.com',N'Vàng'),
    ('KH006', N'Trần Thanh Dương', 1, N'222 Đường K, Quận L, TP HCM', '0909988776', 'duong.tran@gmail.com',N'Bạc'),
    ('KH007', N'Lê Thị Mai', 0, N'333 Đường M, Quận N, TP HCM', '0909777777', 'mai.le@gmail.com',N'Kim Cương'),
    ('KH008', N'Nguyễn Hữu Dũng', 1, N'444 Đường O, Quận P, TP HCM', '0909654321', 'dung.nguyen@gmail.com',N'Bạc'),
    ('KH009', N'Trần Văn Hiệp', 1, N'555 Đường Q, Quận R, TP HCM', '0909988776', 'hiep.tran@gmail.com',N'Vàng'),
    ('KH010', N'Phạm Thị Hồng', 0, N'666 Đường S, Quận T, TP HCM', '0909345678', 'hong.pham@gmail.com',N'Đồng'),
    ('KH011', N'Nguyễn Hoàng', 1, N'777 Đường U, Quận V, TP HCM', '0909123456', 'hoang.nguyen@gmail.com',N'Đồng'),
    ('KH012', N'Trần Thị Mỹ', 0, N'888 Đường X, Quận Y, TP HCM', '0909988776', 'my.tran@gmail.com',N'Bạc'),
    ('KH013', N'Lê Minh Đức', 1, N'999 Đường Z, Quận W, TP HCM', '0909777777', 'duc.le@gmail.com',N'Vàng'),
    ('KH014', N'Nguyễn Thị Thu', 0, N'1234 Đường A, Quận B, TP HCM', '0909345678', 'thu.nguyen@gmail.com',N'Kim Cương')
go
insert into dbo.PhongBan 
values ('kt',N'Phòng kế toán'),
('ns',N'Phòng nhân sự'),
('kd',N'Phòng kinh doanh'),
('marketing',N'Phòng Marketing')
go
INSERT INTO [dbo].[NhaCungCap] (maNCC, tenNCC, diaChi, soDT, email)
VALUES 
	('NCC001', 'Công ty Asus', N'Số 123 Đường XYZ, Quận 1, TP. Hồ Chí Minh', '0123456789', 'asus@company.com'),
	('NCC002', 'Công ty Acer', N'Số 456 Đường ABC, Quận 2, TP. Hồ Chí Minh', '0123456789', 'acer@company.com'),
	('NCC003', 'Công ty MSI', N'Số 789 Đường MNO, Quận 3, TP. Hồ Chí Minh', '0123456789', 'msi@company.com'),
	('NCC004', 'Công ty Apple', N'Số 246 Đường KLM, Quận 4, TP. Hồ Chí Minh', '0123456789', 'apple@company.com'),
	('NCC005', 'Công ty Dell',  N'Số 369 Đường PQR, Quận 5, TP. Hồ Chí Minh', '0123456789', 'dell@company.com');

go
INSERT INTO [dbo].[NhanVien] (maNV, tenNV, phongBan, soDT, luong, gioiTinh) 
VALUES 
    ('NV001', N'Nguyễn Văn An', 'kt', '0901234567', 15000000, 1),
    ('NV002', N'Phạm Thị Bình', 'ns', '0902345678', 12000000, 0),
    ('NV003', N'Lê Thị Cẩm Tú','kd', '0903456789', 10000000, 0),
    ('NV004', N'Trần Văn Đức', 'kd', '0904567890', 18000000, 1),
    ('NV005', N'Hoàng Văn Hùng','marketing', '0905678901', 13000000, 1),
    ('NV006', N'Đỗ Thị Kim Chi', 'kd', '0906789012', 11000000, 0),
    ('NV007', N'Nguyễn Thị Đào', 'kd', '0907890123', 16000000, 0),
    ('NV008', N'Bùi Thị Mai', 'kd', '0908901234', 14000000, 0),
    ('NV009', N'Vũ Thị Nga', 'kt', '0909012345', 9000000, 0),
    ('NV010', N'Nguyễn Văn Phong', 'ns', '0900123456', 20000000, 1),
	('NV011', N'Nguyễn Nhất Dương', 'kd', '0900123456', 20000000, 1);
go
INSERT INTO SanPham (maSP, tenSP, hang, loai, giaNhap, giaBan, slTon, maNCC, thoiGianBH, chipSet, kheLuuTru, kheMoRong)
VALUES 
('MB001', 'Mainboard ASUS Prime Z590-A', 'ASUS', 'MainBoard', 7500000, 10000000, 50, 'NCC001', 24, 'Intel Z590', '2 x M.2 2242/2260/2280/22110', '2 x PCIe 4.0/3.0 x16 (x16 or dual x8)'),
('MB002', 'Mainboard MSI MPG B550 Gaming Carbon WiFi', 'MSI', 'MainBoard', 5000000, 7000000, 30, 'NCC003', 24, 'AMD B550', '2 x M.2 slot (Key M)', '2 x PCIe 4.0/3.0 x16 slot'),
('MB003', 'Mainboard Acer Nitro B460', 'Acer', 'MainBoard', 3500000, 5000000, 20, 'NCC002', 24, 'Intel B460', '1 x M.2 slot (2280)', '1 x PCIe 3.0 x16 slot'),
('MB004', 'Mainboard Apple M1', 'Apple', 'mainboard', 10000000, 15000000, 10, 'NCC004', 24, 'Apple M1', '1 x 256GB SSD', '1 x 10 Gigabit Ethernet port'),
('MB005', 'Mainboard Dell OptiPlex 7780', 'Dell', 'MainBoard', 9000000, 12000000, 15, 'NCC005', 24, 'Intel Q470', '2 x M.2 2280 PCIe NVMe, 1 x M.2 2230 for WiFi', '2 x PCIe 3.0 x16, 1 x PCIe 3.0 x1, 1 x PCIe 3.0 x4')
go
INSERT INTO [dbo].[SanPham] (maSP, tenSP, hang, loai, giaNhap, giaBan, slTon, maNCC, nhan, luong, cache)
VALUES 
	('CPU001', 'Intel Core i9-11900K', 'Intel', 'CPU', 10000000, 15000000, 10, 'NCC001', 8, 16, 16),
	('CPU002', 'Intel Core i7-11700K', 'Intel', 'CPU', 7000000, 10000000, 20, 'NCC001', 8, 12, 16),
	('CPU003', 'AMD Ryzen 9 5950X', 'AMD', 'CPU', 13000000, 18000000, 5, 'NCC002', 16, 32, 64),
	('CPU004', 'AMD Ryzen 7 5800X', 'AMD', 'CPU', 8000000, 12000000, 15, 'NCC002', 8, 16, 32),
	('CPU005', 'Intel Core i5-11600K', 'Intel', 'CPU', 5000000, 8000000, 30, 'NCC001', 6, 12, 12),
	('CPU006', 'AMD Ryzen 5 5600X', 'AMD', 'CPU', 4000000, 6000000, 25, 'NCC002', 6, 12, 32),
	('CPU007', 'Intel Core i9-10900K', 'Intel', 'CPU', 9000000, 14000000, 12, 'NCC003', 10, 20, 20),
	('CPU008', 'Intel Core i5-10600K', 'Intel', 'CPU', 4500000, 7000000, 18, 'NCC003', 6, 12, 12),
	('CPU009', 'AMD Ryzen 7 3700X', 'AMD', 'CPU', 5000000, 9000000, 8, 'NCC002', 8, 16, 36),
	('CPU010', 'AMD Ryzen 5 3600X', 'AMD', 'CPU', 3500000, 5500000, 10, 'NCC002', 6, 12, 35);
go
INSERT INTO SanPham(maSP, tenSP, hang, loai, giaNhap, giaBan, slTon, maNCC, dungLuongODia, cacheDDR, tuoiThoTB)
VALUES 
('HD001', N'Ổ cứng Seagate Barracuda', 'Seagate', 'HardDisk', 1200000, 1500000, 50, 'NCC001', 2000, '8MB', 3),
('HD002', N'Ổ cứng Western Digital Black', 'Western Digital', 'HardDisk', 1250000, 1550000, 40, 'NCC002', 4000, '64MB', 3.5),
('HD003', N'Ổ cứng Toshiba P300', 'Toshiba', 'HardDisk', 1300000, 1600000, 60, 'NCC003', 3000, '64MB', 3),
('HD004', N'Ổ cứng Kingston A2000', 'Kingston', 'HardDisk', 1100000, 1400000, 30, 'NCC004', 500, 'N/A', 1.5),
('HD005', N'Ổ cứng SanDisk Ultra 3D', 'SanDisk', 'HardDisk', 1150000, 1450000, 25, 'NCC005', 1000, 'N/A', 2),
('HD006', N'Ổ cứng Crucial MX500', 'Crucial', 'HardDisk', 1350000, 1650000, 20, 'NCC001', 2000, 'N/A', 2.5),
('HD007', N'Ổ cứng Samsung 970 EVO Plus', 'Samsung', 'HardDisk', 2500000, 2800000, 15, 'NCC002', 500, 'N/A', 3),
('HD008', N'Ổ cứng Adata XPG SX8200 Pro', 'Adata', 'HardDisk', 2100000, 2400000, 10, 'NCC003', 1000, 'N/A', 2),
('HD009', N'Ổ cứng Team T-Force Vulcan', 'Team', 'HardDisk', 1000000, 1300000, 35, 'NCC004', 1000, 'N/A', 2),
('HD010', N'Ổ cứng Intel 660p', 'Intel', 'HardDisk', 1900000, 2200000, 45, 'NCC005', 2000, 'N/A', 3)
go
INSERT INTO [dbo].[SanPham] ([maSP], [tenSP], [hang], [loai], [giaNhap], [giaBan], [slTon], [maNCC], [loaiRam], [dungLuongRam], [tocDoRam])
VALUES 
('RAM001', 'Ram Kingston 4GB DDR4', 'Kingston', 'Ram', 700000, 800000, 50, 'NCC001', 'DDR4', 4, 2400),
('RAM002', 'Ram Gskill 8GB DDR4', 'Gskill', 'Ram', 1300000, 1500000, 30, 'NCC001', 'DDR4', 8, 3200),
('RAM003', 'Ram Corsair 16GB DDR4', 'Corsair', 'Ram', 2500000, 2800000, 20, 'NCC001', 'DDR4', 16, 3600),
('RAM004', 'Ram Adata 8GB DDR3', 'Adata', 'Ram', 1100000, 1200000, 40, 'NCC001', 'DDR3', 8, 1600),
('RAM005', 'Ram Crucial 16GB DDR3', 'Crucial', 'Ram', 2000000, 2200000, 25, 'NCC001', 'DDR3', 16, 1866),
('RAM006', 'Ram Kingston 8GB DDR3', 'Kingston', 'Ram', 1200000, 1400000, 35, 'NCC001', 'DDR3', 8, 1600),
('RAM007', 'Ram Gskill 16GB DDR4', 'Gskill', 'Ram', 2700000, 3000000, 15, 'NCC001', 'DDR4', 16, 3200),
('RAM008', 'Ram Corsair 32GB DDR4', 'Corsair', 'Ram', 5000000, 5500000, 10, 'NCC001', 'DDR4', 32, 3600),
('RAM009', 'Ram Adata 4GB DDR3', 'Adata', 'Ram', 600000, 700000, 60, 'NCC001', 'DDR3', 4, 1333),
('RAM010', 'Ram Crucial 8GB DDR4', 'Crucial', 'Ram', 1200000, 1400000, 35, 'NCC001', 'DDR4', 8, 2400);
go
INSERT INTO HoaDon(maHD, maKH, maNV, ngayLapHD, ngayGiao, noiNhanHang, tongTien)
VALUES 
('HD001', 'KH001', 'NV001', '2023-03-01', '2023-03-10',N'Hà Nội', 30800000.00),
 ('HD002', 'KH002', 'NV002', '2023-03-02', '2023-03-11',N'Hải Phòng', 38400000.00),
 ('HD003', 'KH003', 'NV003', '2023-03-03', '2023-03-12',N'Đà Nẵng',82600000.00),
 ('HD004', 'KH004', 'NV004', '2023-03-04', '2023-03-13',N'TP.HCM',18800000.00),
 ('HD005', 'KH005', 'NV005', '2023-03-01', '2023-03-10',N'Hà Nội',10000000.00),
 ('HD006', 'KH006', 'NV006', '2023-03-02', '2023-03-11',N'Hải Phòng',null),
 ('HD007', 'KH007', 'NV007', '2023-03-03', '2023-03-12',N'Đà Nẵng',null),
 ('HD008', 'KH008', 'NV008', '2023-03-04', '2023-03-13',N'TP.HCM',null),
 ('HD009', 'KH009', 'NV009', '2023-03-01', '2023-03-10',N'Hà Nội', 4800000.00),
 ('HD010', 'KH010', 'NV010', '2023-03-02', '2023-03-11',N'Hải Phòng',4100000.00)
 go


INSERT INTO ChiTietHoaDon (maChiTietHD, maSP, soLuong, maHD, giaBan, tongTien)
VALUES  ('CTHD001', 'RAM001', 2, 'HD001', 800000.00,1600000.00),
        ('CTHD002', 'RAM002', 3, 'HD001', 1500000.00,4500000.00),
        ('CTHD003', 'RAM003', 1, 'HD001', 2800000.00,2800000.00),
        ('CTHD004', 'RAM004', 5, 'HD002', 1200000.00,6000000.00),
        ('CTHD005', 'RAM005', 2, 'HD002', 2200000.00,4400000.00),
        ('CTHD006', 'RAM006', 4, 'HD003', 1400000.00,5600000.00),
        ('CTHD007', 'RAM007', 3, 'HD003', 3000000,9000000),
        ('CTHD008', 'RAM008', 1, 'HD004', 5500000.00,5500000.00),
        ('CTHD009', 'RAM009', 2, 'HD004', 700000.00,1400000.00),
        ('CTHD010', 'RAM010', 3, 'HD004', 1400000.00,4200000.00),
	    ('CTHD011', 'RAM001', 2, 'HD001', 800000.00,1600000.00),
		('CTHD012', 'RAM002', 1, 'HD001', 1500000.00,1500000.00),
		('CTHD013', 'RAM003', 3, 'HD001', 2800000.00,8400000.00),
		('CTHD014', 'RAM004', 2, 'HD002', 1200000.00,2400000.00),
		('CTHD015', 'RAM005', 1, 'HD002', 2200000.00,1000000),
		('CTHD016', 'RAM006', 3, 'HD002', 1400000.00,4200000.00),
		('CTHD017', 'RAM007', 4, 'HD003', 3000000.00,12000000.00),
		('CTHD018', 'RAM008', 2, 'HD003', 5500000.00,11000000.00),
		('CTHD019', 'RAM009', 1, 'HD004', 700000.00,700000.00),
		('CTHD020', 'RAM010', 5, 'HD004', 1400000.00,7000000.00),
		('CTHD021', 'HD010', 2, 'HD001', 2200000.00, 4400000.00),
		('CTHD022', 'CPU001', 1, 'HD002', 15000000.00, 15000000.00),
		('CTHD023', 'HD003', 3, 'HD009', 1600000.00, 4800000.00),
		('CTHD024', 'HD009', 2, 'HD010', 1300000.00, 2600000),
		('CTHD025', 'HD001', 1, 'HD010', 2000000, 2000000),
		('CTHD026', 'HD004', 3, 'HD002', 1500000.00, 4500000.00),
		('CTHD027', 'HD001', 2, 'HD001', 4000000, 2000000),
		('CTHD028', 'MB001', 1, 'HD005', 2000000, 2000000),
		('CTHD029', 'CPU001', 3, 'HD003', 6000000, 2000000),
		('CTHD030', 'HD001', 2, 'HD001', 4000000, 2000000)

--
go
create proc capNhapLoai @maKH nvarchar(50)
as
begin
declare @tongTien money
select @tongTien = sum(tongTien) from KhachHang k join HoaDon d on k.maKH = d.maKH where d.maKH = @maKH
if @tongTien is null 
begin 
	set @tongTien =0
end
update KhachHang
set loaiKH = 
case
	when (@tongTien <1000000) then N'Đồng'
	when (@tongTien <10000000) then N'Bạc'
	when (@tongTien <20000000) then N'Vàng'
	else N'Kim Cương'
end
where maKH = @maKH
end

--
