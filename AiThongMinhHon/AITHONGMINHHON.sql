USE [AiThongMinhHon]
GO
/****** Object:  Table [dbo].[cauhoi]    Script Date: 4/27/2022 2:44:00 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[cauhoi](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[cau_hoi] [nvarchar](200) NULL,
	[cau_a] [nvarchar](50) NULL,
	[cau_b] [nvarchar](50) NULL,
	[cau_c] [nvarchar](50) NULL,
	[cau_d] [nvarchar](50) NULL,
	[dap_an] [char](1) NULL,
	[dap_an_chi_tiet] [nvarchar](50) NULL,
	[chu_de_id] [int] NULL,
 CONSTRAINT [PK_cauhoi] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[chude]    Script Date: 4/27/2022 2:44:00 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[chude](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ten_chu_de] [nvarchar](50) NULL,
 CONSTRAINT [PK_chude] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[cauhoi] ON 

INSERT [dbo].[cauhoi] ([id], [cau_hoi], [cau_a], [cau_b], [cau_c], [cau_d], [dap_an], [dap_an_chi_tiet], [chu_de_id]) VALUES (1, N'Ngày Debut của BTS', N'17/02/2013', N'12/07/2013', N'13/06/2013', N'16/03/2013', N'C', N'C.13/06/2013', 1)
INSERT [dbo].[cauhoi] ([id], [cau_hoi], [cau_a], [cau_b], [cau_c], [cau_d], [dap_an], [dap_an_chi_tiet], [chu_de_id]) VALUES (2, N'Tên bài hát mới của BIGBANG', N'Still Life', N'Xuân , Hạ , Thu , Đông', N'Zutter', N'Oh Yeah', N'A', N'A.Still Life', 1)
INSERT [dbo].[cauhoi] ([id], [cau_hoi], [cau_a], [cau_b], [cau_c], [cau_d], [dap_an], [dap_an_chi_tiet], [chu_de_id]) VALUES (3, N'WANNABE là tên bài hát của nhóm nào', N'BTS', N'EXO', N'NMIXX', N'ITZY', N'D', N'D.ITZY', 1)
INSERT [dbo].[cauhoi] ([id], [cau_hoi], [cau_a], [cau_b], [cau_c], [cau_d], [dap_an], [dap_an_chi_tiet], [chu_de_id]) VALUES (4, N'Bộ phim đầu tiên của Marvel', N'Thor ', N'Captain American', N'Avenger 1', N'Iron Man', N'D', N'D.Iron Man', 2)
INSERT [dbo].[cauhoi] ([id], [cau_hoi], [cau_a], [cau_b], [cau_c], [cau_d], [dap_an], [dap_an_chi_tiet], [chu_de_id]) VALUES (5, N'Netflix truy cập miễn phí trên hệ điều hành nào', N'IOS', N'Windows', N'Android', N'Linux', N'C', N'C.Android', 2)
INSERT [dbo].[cauhoi] ([id], [cau_hoi], [cau_a], [cau_b], [cau_c], [cau_d], [dap_an], [dap_an_chi_tiet], [chu_de_id]) VALUES (7, N'Ai là thành viên hụt BLACKPINK', N'Haewon (NMIXX)', N'Miyeon (G-IDLE)', N'Karina (aespa)', N'YUQI (G-IDLE)', N'B', N'B.Miyeon (G-IDLE)', 1)
INSERT [dbo].[cauhoi] ([id], [cau_hoi], [cau_a], [cau_b], [cau_c], [cau_d], [dap_an], [dap_an_chi_tiet], [chu_de_id]) VALUES (8, N'Đâu không phải là BIG3 công ty giải trí lớn nhất Hàn Quốc', N'HYBE', N'JYP', N'SM', N'YG', N'A', N'A.HYBE', 1)
INSERT [dbo].[cauhoi] ([id], [cau_hoi], [cau_a], [cau_b], [cau_c], [cau_d], [dap_an], [dap_an_chi_tiet], [chu_de_id]) VALUES (9, N'EXO ban đầu có bao nhiêu thành viên', N'8', N'9', N'10', N'12', N'D', N'D.12', 1)
INSERT [dbo].[cauhoi] ([id], [cau_hoi], [cau_a], [cau_b], [cau_c], [cau_d], [dap_an], [dap_an_chi_tiet], [chu_de_id]) VALUES (10, N'Red Velvet năm 2014 có bao nhiêu thành viên', N'5', N'6', N'4', N'3', N'C', N'C.4', 1)
INSERT [dbo].[cauhoi] ([id], [cau_hoi], [cau_a], [cau_b], [cau_c], [cau_d], [dap_an], [dap_an_chi_tiet], [chu_de_id]) VALUES (11, N'Đâu không phải là hậu bối chung công ty của BIGBANG', N'EXO', N'WINNER', N'iKON', N'BLACKPINK', N'A', N'A.EXO', 1)
INSERT [dbo].[cauhoi] ([id], [cau_hoi], [cau_a], [cau_b], [cau_c], [cau_d], [dap_an], [dap_an_chi_tiet], [chu_de_id]) VALUES (12, N'Ca khúc debut của TWICE', N'Cheer Up', N'Like OOH-AHH', N'Likey', N'Knock Knock', N'B', N'B.Like OOH-AHH', 1)
INSERT [dbo].[cauhoi] ([id], [cau_hoi], [cau_a], [cau_b], [cau_c], [cau_d], [dap_an], [dap_an_chi_tiet], [chu_de_id]) VALUES (13, N'Đâu là ca sĩ solo ', N'Agust D', N'IU', N'Jisoo', N'Bol4', N'B', N'B.IU', 1)
INSERT [dbo].[cauhoi] ([id], [cau_hoi], [cau_a], [cau_b], [cau_c], [cau_d], [dap_an], [dap_an_chi_tiet], [chu_de_id]) VALUES (14, N'G-IDLE thuộc gen mấy', N'3.5', N'4', N'3', N'2', N'A', N'A.3.5', 1)
INSERT [dbo].[cauhoi] ([id], [cau_hoi], [cau_a], [cau_b], [cau_c], [cau_d], [dap_an], [dap_an_chi_tiet], [chu_de_id]) VALUES (15, N'Loạt phim Cậu bé mất tích hiện có mấy phần', N'2', N'3', N'1', N'4', N'D', N'D.4', 2)
INSERT [dbo].[cauhoi] ([id], [cau_hoi], [cau_a], [cau_b], [cau_c], [cau_d], [dap_an], [dap_an_chi_tiet], [chu_de_id]) VALUES (16, N'Black Summer là phim thể loại gì', N'Hành Động', N'Tình Cảm', N'Zombie', N'Tâm Lí', N'C', N'C.Zombie', 2)
INSERT [dbo].[cauhoi] ([id], [cau_hoi], [cau_a], [cau_b], [cau_c], [cau_d], [dap_an], [dap_an_chi_tiet], [chu_de_id]) VALUES (17, N'Train To Busan 2 phát hành vào năm nào', N'2020', N'2016', N'2017', N'2019', N'A', N'A.2020', 2)
INSERT [dbo].[cauhoi] ([id], [cau_hoi], [cau_a], [cau_b], [cau_c], [cau_d], [dap_an], [dap_an_chi_tiet], [chu_de_id]) VALUES (18, N'Ai được coi là Tom Cruise của Hàn Quốc', N'Đức Nam', N'Park Jihoon', N'Jung WooSung', N'Kim JongHae', N'C', N'C.Jung WooSung', 2)
INSERT [dbo].[cauhoi] ([id], [cau_hoi], [cau_a], [cau_b], [cau_c], [cau_d], [dap_an], [dap_an_chi_tiet], [chu_de_id]) VALUES (19, N'Venom của hãng phim nào hiện nay', N'Sony', N'Marvel', N'Netflix', N'DC', N'A', N'A.Sony', 2)
INSERT [dbo].[cauhoi] ([id], [cau_hoi], [cau_a], [cau_b], [cau_c], [cau_d], [dap_an], [dap_an_chi_tiet], [chu_de_id]) VALUES (20, N'Spider man đầu tiên ra đời vào năm nào', N'2002', N'2001', N'2004', N'2007', N'A', N'A.2002', 2)
INSERT [dbo].[cauhoi] ([id], [cau_hoi], [cau_a], [cau_b], [cau_c], [cau_d], [dap_an], [dap_an_chi_tiet], [chu_de_id]) VALUES (21, N'Hiện nay Ant-man có mấy phần phim riêng', N'1', N'2', N'4', N'3', N'B', N'B.2', 2)
INSERT [dbo].[cauhoi] ([id], [cau_hoi], [cau_a], [cau_b], [cau_c], [cau_d], [dap_an], [dap_an_chi_tiet], [chu_de_id]) VALUES (22, N'Phim nào nói về Định lý tiền định (Vòng lặp nhân quả)', N'Iron man 3', N'Dark', N'Dẫu biết', N'My Name', N'B', N'B.Dark', 2)
INSERT [dbo].[cauhoi] ([id], [cau_hoi], [cau_a], [cau_b], [cau_c], [cau_d], [dap_an], [dap_an_chi_tiet], [chu_de_id]) VALUES (23, N'Bộ phim được đánh giá quá cao', N'Squid Game', N'All Of Us Are Dead', N'Avenger 4: End Game', N'Thor 2', N'A', N'A.Squid Game', 2)
INSERT [dbo].[cauhoi] ([id], [cau_hoi], [cau_a], [cau_b], [cau_c], [cau_d], [dap_an], [dap_an_chi_tiet], [chu_de_id]) VALUES (24, N'"Tương lai là sự khởi đầu-Qúa khứ mới là sự kết thúc" là câu nói trong phim nào', N'Dark', N'Space Time', N'Avenger 3: Infinity War', N'Your Name', N'A', N'A.Dark', 2)
INSERT [dbo].[cauhoi] ([id], [cau_hoi], [cau_a], [cau_b], [cau_c], [cau_d], [dap_an], [dap_an_chi_tiet], [chu_de_id]) VALUES (25, N'Arcane là tác phẩm của hãng phim nào', N'Riot', N'JYP', N'Cube', N'Stone', N'A', N'A.Riot', 2)
INSERT [dbo].[cauhoi] ([id], [cau_hoi], [cau_a], [cau_b], [cau_c], [cau_d], [dap_an], [dap_an_chi_tiet], [chu_de_id]) VALUES (26, N'Thiết bị nào sau đây dùng để kết nối mạng', N'Ram', N'Rom', N'Router', N'CPU', N'C', N'C.Router', 3)
INSERT [dbo].[cauhoi] ([id], [cau_hoi], [cau_a], [cau_b], [cau_c], [cau_d], [dap_an], [dap_an_chi_tiet], [chu_de_id]) VALUES (27, N'Hệ thống nhớ của máy tính bao gồm:', N'Bộ nhớ trong, Bộ nhớ ngoài', N'Cache, Bộ nhớ ngoài', N'Bộ nhớ ngoài, ROM', N'Đĩa quang, Bộ nhớ trong', N'A', N'A. Bộ nhớ trong, Bộ nhớ ngoài', 3)
INSERT [dbo].[cauhoi] ([id], [cau_hoi], [cau_a], [cau_b], [cau_c], [cau_d], [dap_an], [dap_an_chi_tiet], [chu_de_id]) VALUES (28, N'Trong mạng máy tính, thuật ngữ Share có ý nghĩa gì', N'Chia sẻ tài nguyên', N'Nhãn hiệu của một thiết bị kết nối mạng', N'Thực hiện lệnh in trong mạng cục bộ', N'Một phần mềm hỗ trợ sử dụng mạng cục bộ', N'A', N'A.Chia sẻ tài nguyên', 3)
INSERT [dbo].[cauhoi] ([id], [cau_hoi], [cau_a], [cau_b], [cau_c], [cau_d], [dap_an], [dap_an_chi_tiet], [chu_de_id]) VALUES (29, N'Bộ nhớ RAM và ROM là bộ nhớ gì', N'Primary memory', N'Receive memory', N'Secondary memory', N'Random access memory.', N'A', N'A.Primary memory', 3)
INSERT [dbo].[cauhoi] ([id], [cau_hoi], [cau_a], [cau_b], [cau_c], [cau_d], [dap_an], [dap_an_chi_tiet], [chu_de_id]) VALUES (31, N'Danh sách các mục chọn trong thực đơn gọi là', N'Menu pad', N'Menu options', N'Menu bar', N'Tất cả đều sai', N'C', N'C.Menu bar', 3)
INSERT [dbo].[cauhoi] ([id], [cau_hoi], [cau_a], [cau_b], [cau_c], [cau_d], [dap_an], [dap_an_chi_tiet], [chu_de_id]) VALUES (32, N'Nếu bạn muốn làm cho cửa sổ nhỏ hơn (không kín màn hình), bạn nên sử dụng nút nào', N'Maximum', N'Minimum', N'Restore down', N'Close', N'C', N'C.Restore down', 3)
INSERT [dbo].[cauhoi] ([id], [cau_hoi], [cau_a], [cau_b], [cau_c], [cau_d], [dap_an], [dap_an_chi_tiet], [chu_de_id]) VALUES (33, N'Trong soạn thảo Word, tổ hợp phím nào cho phép đưa con trỏ về cuối văn bản', N'Shift + End', N'Alt + End', N'Ctrl + End', N'Ctrl + Alt + End', N'C', N'C.Ctrl + End', 3)
INSERT [dbo].[cauhoi] ([id], [cau_hoi], [cau_a], [cau_b], [cau_c], [cau_d], [dap_an], [dap_an_chi_tiet], [chu_de_id]) VALUES (34, N'Giả sử a, b là hai số thực. Biểu thức nào dưới đây viết không đúng theo cú pháp của ngôn ngữ lập trình C', N'(a+=b)', N'(a*=b)', N' (a=b)', N'(a&=b)', N'D', N'D.(a&=b)', 3)
INSERT [dbo].[cauhoi] ([id], [cau_hoi], [cau_a], [cau_b], [cau_c], [cau_d], [dap_an], [dap_an_chi_tiet], [chu_de_id]) VALUES (35, N'Đâu là sai về ngôn ngũ Java', N'Ngôn ngữ java phân biệt chữ hoa,chữ thường', N'Java là ngôn ngữ hướng đối tượng', N'Dấu chấm phẩy dùng để kết thúc câu lệnh', N'Chương trình java chỉ chạy trên hệ điều hành Win', N'D', N'D.Chương trình java chỉ chạy trên hệ điều hành Win', 3)
INSERT [dbo].[cauhoi] ([id], [cau_hoi], [cau_a], [cau_b], [cau_c], [cau_d], [dap_an], [dap_an_chi_tiet], [chu_de_id]) VALUES (36, N' Kích thước của 1 Char là bao nhiêu', N'4 bit', N'8 bit', N'7 bit', N'16 bit', N'A', N'A.4 bit', 3)
INSERT [dbo].[cauhoi] ([id], [cau_hoi], [cau_a], [cau_b], [cau_c], [cau_d], [dap_an], [dap_an_chi_tiet], [chu_de_id]) VALUES (37, N'1 class không thể được khai báo ở chế độ', N'static', N'private', N'default', N'protected', N'C', N'C.Default', 3)
INSERT [dbo].[cauhoi] ([id], [cau_hoi], [cau_a], [cau_b], [cau_c], [cau_d], [dap_an], [dap_an_chi_tiet], [chu_de_id]) VALUES (38, N'Kết quả sau khi biên dịch mã int a = 3.5', N' Compilation error ', N' Runtime error', N'3.5', N'3', N'D', N'D.3', 3)
INSERT [dbo].[cauhoi] ([id], [cau_hoi], [cau_a], [cau_b], [cau_c], [cau_d], [dap_an], [dap_an_chi_tiet], [chu_de_id]) VALUES (39, N'Kết quả khi biên dịch mã int a1 = 5; double a2 = (float)a1r', N' Compilation error ', N'Runtime error', N' No error', N'D.Tất cả đều sai', N'A', N'A. Compilation error', 3)
INSERT [dbo].[cauhoi] ([id], [cau_hoi], [cau_a], [cau_b], [cau_c], [cau_d], [dap_an], [dap_an_chi_tiet], [chu_de_id]) VALUES (40, N'MV debut của aespa', N'Black Mamba', N'Next Level', N'Savage', N'Forever', N'A', N'A.Black Mamba', 1)
INSERT [dbo].[cauhoi] ([id], [cau_hoi], [cau_a], [cau_b], [cau_c], [cau_d], [dap_an], [dap_an_chi_tiet], [chu_de_id]) VALUES (41, N'LOL ra đời năm bao nhiêu', N'2009', N'2010', N'2012', N'2015', N'A', N'A.2009', 4)
SET IDENTITY_INSERT [dbo].[cauhoi] OFF
GO
SET IDENTITY_INSERT [dbo].[chude] ON 

INSERT [dbo].[chude] ([id], [ten_chu_de]) VALUES (1, N'K-POP')
INSERT [dbo].[chude] ([id], [ten_chu_de]) VALUES (2, N'Hollywood')
INSERT [dbo].[chude] ([id], [ten_chu_de]) VALUES (3, N'Công Nghệ')
INSERT [dbo].[chude] ([id], [ten_chu_de]) VALUES (4, N'Game')
SET IDENTITY_INSERT [dbo].[chude] OFF
GO
ALTER TABLE [dbo].[cauhoi]  WITH CHECK ADD  CONSTRAINT [FK_cauhoi_chude] FOREIGN KEY([chu_de_id])
REFERENCES [dbo].[chude] ([id])
GO
ALTER TABLE [dbo].[cauhoi] CHECK CONSTRAINT [FK_cauhoi_chude]
GO
