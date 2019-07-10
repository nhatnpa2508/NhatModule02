-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: blog
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nameCategories` varchar(50) NOT NULL,
  `creator` varchar(50) NOT NULL DEFAULT 'Admin',
  `dateCreated` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `finalEditor` varchar(50) DEFAULT 'Admin',
  `lastModifiedDate` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'Javascript','rong9x','2019-06-26 00:00:00','rong9x','2019-06-27 11:25:56'),(2,'Java','Admin','2019-06-27 11:29:55','Admin','2019-06-27 11:29:55'),(4,'Python','Admin','2019-06-27 11:30:27','Admin','2019-06-27 11:30:27');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `contents` text NOT NULL,
  `dateCreated` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `lastModifiedDate` datetime DEFAULT CURRENT_TIMESTAMP,
  `idUsers` int(11) DEFAULT NULL,
  `idPosts` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idPosts` (`idPosts`),
  KEY `idUsers` (`idUsers`),
  CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`idPosts`) REFERENCES `posts` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comments_ibfk_2` FOREIGN KEY (`idUsers`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES (1,'noi dung comment','2019-06-27 08:37:08','2019-06-27 08:37:08',1,1),(2,'comment thu 2','2019-06-27 10:59:41','2019-06-27 10:59:41',1,1),(5,'123','2019-06-29 06:37:01','2019-06-29 06:37:01',4,1),(13,'meo tam 1 tuan 2 lan','2019-06-29 08:58:51','2019-06-29 08:58:51',6,2),(14,'good blog','2019-06-29 09:06:50','2019-06-29 09:06:50',6,4),(15,'cmt chinh sua','2019-06-29 09:51:58','2019-06-29 09:51:58',5,2),(16,'meo tam 1 tuan 2 lan','2019-06-29 10:16:50','2019-06-29 10:16:50',8,2),(17,'mèo tắm','2019-07-01 08:05:40','2019-07-01 08:05:40',NULL,NULL),(18,'123','2019-07-01 10:28:02','2019-07-01 10:28:02',6,1),(19,'hải hải hải','2019-07-01 11:48:59','2019-07-01 11:48:59',12,2);
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `posts`
--

DROP TABLE IF EXISTS `posts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `posts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `introduce` text NOT NULL,
  `content` text NOT NULL,
  `image` varchar(255) NOT NULL,
  `creator` varchar(50) NOT NULL DEFAULT 'rong9x',
  `dateCreated` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `finalEditor` varchar(50) DEFAULT NULL,
  `lastModifiedDate` datetime DEFAULT CURRENT_TIMESTAMP,
  `idCategories` int(11) NOT NULL,
  `idUsers` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idCategories` (`idCategories`),
  KEY `idUsers` (`idUsers`),
  CONSTRAINT `posts_ibfk_1` FOREIGN KEY (`idCategories`) REFERENCES `categories` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `posts_ibfk_2` FOREIGN KEY (`idUsers`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posts`
--

LOCK TABLES `posts` WRITE;
/*!40000 ALTER TABLE `posts` DISABLE KEYS */;
INSERT INTO `posts` VALUES (1,'Java (ngôn ngữ lập trình)','Java (phiên âm Tiếng Việt: \"Gia-va\") là một ngôn ngữ lập trình hướng đối tượng (OOP) và dựa trên các lớp (class)[9]. Khác với phần lớn ngôn ngữ lập trình thông thường, thay vì biên dịch mã nguồn thành mã máy hoặc thông dịch mã nguồn khi chạy, Java được thiết kế để biên dịch mã nguồn thành bytecode, bytecode sau đó sẽ được môi trường thực thi (runtime environment) chạy. ','Trước đây, Java chạy chậm hơn những ngôn ngữ dịch thẳng ra mã máy như C và C++, nhưng sau này nhờ công nghệ \"biên dịch tại chỗ\" - Just in time compilation, khoảng cách này đã được thu hẹp, và trong một số trường hợp đặc biệt Java có thể chạy nhanh hơn. Java chạy nhanh hơn những ngôn ngữ thông dịch như Python, Perl, PHP gấp nhiều lần. Java chạy tương đương so với C#, một ngôn ngữ khá tương đồng về mặt cú pháp và quá trình dịch/chạy[10][11]\r\n\r\nCú pháp Java được vay mượn nhiều từ C & C++ nhưng có cú pháp hướng đối tượng đơn giản hơn và ít tính năng xử lý cấp thấp hơn. Do đó việc viết một chương trình bằng Java dễ hơn, đơn giản hơn, đỡ tốn công sửa lỗi hơn.\r\n\r\nTrong Java, hiện tượng rò rỉ bộ nhớ hầu như không xảy ra do bộ nhớ được quản lý bởi Java Virtual Machine (JVM) bằng cách tự động \"dọn dẹp rác\". Người lập trình không phải quan tâm đến việc cấp phát và xóa bộ nhớ như C, C++. Tuy nhiên khi sử dụng những tài nguyên mạng, file IO, database (nằm ngoài kiểm soát của JVM) mà người lập trình không đóng (close) các streams thì rò rỉ dữ liệu vẫn có thể xảy ra. ','https://www.technotification.com/wp-content/uploads/2016/07/Why-is-Java-the-best-programming-Language.png','rong9x','2019-06-26 00:00:00','admin','2019-07-01 11:43:16',2,6),(2,'Học Javascript','Xin giới thiệu với các bạn tổng tất cả các bài viết học Javascript miễn phí dành cho tất cả các đối tượng. Đây là series tự học Javascript hoàn toàn miễn phí, mỗi series được tổng hợp các bài viết phân chia từng bài rất cụ thể và rõ ràng giúp người học có thể follow và học tại nhà.','Như các bạn biết khi học lập trình web nói chung và học về lập trình frontend nói riêng thì bắt buộc bạn phải học javascript, một website thiếu Javascript thì sẽ trở nên cọc cằn, chức năng không đẹp và không thân thiện với người dùng. vì vậy nếu bạn không học JS thì đó quả là một sai lầm và lạc hậu về công nghệ.\r\nNhư các bạn biết khi học lập trình web nói chung và học về lập trình frontend nói riêng thì bắt buộc bạn phải học javascript, một website thiếu Javascript thì sẽ trở nên cọc cằn, chức năng không đẹp và không thân thiện với người dùng. vì vậy nếu bạn không học JS thì đó quả là một sai lầm và lạc hậu về công nghệ.\r\nNhư các bạn biết khi học lập trình web nói chung và học về lập trình frontend nói riêng thì bắt buộc bạn phải học javascript, một website thiếu Javascript thì sẽ trở nên cọc cằn, chức năng không đẹp và không thân thiện với người dùng. vì vậy nếu bạn không học JS thì đó quả là một sai lầm và lạc hậu về công nghệ.','https://techtalk.vn/wp-content/uploads/2018/11/javascript-696x391.png','rong9x','2019-06-26 14:56:53','admin','2019-07-01 11:51:24',1,6),(4,'Java Tutorial','Java is a programming language. Java is used to develop mobile apps, web apps, desktop apps, games and much more.','Java is a programming language. Java is used to develop mobile apps, web apps, desktop apps, games and much more.\r\nJava is a programming language. Java is used to develop mobile apps, web apps, desktop apps, games and much more.\r\nJava is a programming language. Java is used to develop mobile apps, web apps, desktop apps, games and much more.','https://www.technotification.com/wp-content/uploads/2016/07/Why-is-Java-the-best-programming-Language.png','rong9x','2019-06-27 14:41:21',NULL,'2019-06-27 14:41:21',2,1),(5,'PHP 5 Tutorial','PHP is a server scripting language, and a powerful tool for making dynamic and interactive Web pages. PHP is a widely-used, free, and efficient alternative to competitors such as Microsoft\'s ASP.','PHP is a server scripting language, and a powerful tool for making dynamic and interactive Web pages. PHP is a widely-used, free, and efficient alternative to competitors such as Microsoft\'s ASP.\r\nPHP is a server scripting language, and a powerful tool for making dynamic and interactive Web pages. PHP is a widely-used, free, and efficient alternative to competitors such as Microsoft\'s ASP.\r\nPHP is a server scripting language, and a powerful tool for making dynamic and interactive Web pages. PHP is a widely-used, free, and efficient alternative to competitors such as Microsoft\'s ASP.','https://i.udemycdn.com/course/750x422/913448_e6e2.jpg','rong9x','2019-06-27 14:43:31',NULL,'2019-06-27 14:43:31',4,1),(6,'Python là gì','Trong chương này chúng ta sẽ tìm hiểu sơ qua về ngôn ngữ lập trình Python, về lịch sử và một số đặc điểm của nó.','Python là gì?\r\nPython là một ngôn ngữ lập trình bậc cao, thông dịch, hướng đối tượng, đa mục đích và cũng là một ngôn ngữ lập trình động.\r\nCú pháp của Python là khá dễ dàng để học và ngôn ngữ này cũng mạnh mẽ và linh hoạt không kém các ngôn ngữ khác trong việc phát triển các ứng dụng. Python hỗ trợ mẫu đa lập trình, bao gồm lập trình hướng đối tượng, lập trình hàm và mệnh lệnh hoặc là các phong cách lập trình theo thủ tục.\r\nPython không chỉ làm việc trên lĩnh vực đặc biệt như lập trình web, và đó là tại sao ngôn ngữ này là đa mục đích bởi vì nó có thể được sử dụng với web, enterprise, 3D CAD, …\r\nBạn không cần sử dụng các kiểu dữ liệu để khai báo biến bởi vì kiểu của nó là động, vì thế bạn có thể viết a=15 để khai báo một giá trị nguyên trong một biến.\r\nVới Python, việc phát triển ứng dụng và debug trở nên nhanh hơn bởi vì không cần đến bước biên dịch và chu trình edit-test-debug của Python là rất nhanh.\r\nCác đặc điểm của Python\r\nDưới đây là một số đặc điểm chính của Python:\r\n\r\n    Dễ dàng để sử dụng: Python là một ngôn ngữ bậc cao rất dễ dàng để sử dụng. Python có một số lượng từ khóa ít hơn, cấu trúc của Python đơn giản hơn và cú pháp của Python được định nghĩa khá rõ ràng, … Tất cả các điều này là Python thực sự trở thành một ngôn ngữ thân thiện với lập trình viên.\r\n    Bạn có thể đọc code của Python khá dễ dàng. Phần code của Python được định nghĩa khá rõ ràng và rành mạch.\r\n    Python có một thư viện chuẩn khá rộng lớn. Thư viện này dễ dàng tương thích và tích hợp với UNIX, Windows, và Macintosh.\r\n    Python là một ngôn ngữ thông dịch. Trình thông dịch thực thi code theo từng dòng (và bạn không cần phải biên dịch ra file chạy), điều này giúp cho quá trình debug trở nên dễ dàng hơn và đây cũng là yếu tố khá quan trọng giúp Python thu hút được nhiều người học và trở nên khá phổ biến.\r\n    Python cũng là một ngôn ngữ lập trình hướng đối tượng. Ngoài ra, Python còn hỗ trợ các phương thức lập trình theo hàm và theo cấu trúc.','https://i.udemycdn.com/course/750x422/913448_e6e2.jpg','rong9x','2019-07-01 08:46:45','admin','2019-07-01 11:54:49',4,6),(8,'Lịch sử của Python','Python được phát triển bởi Guido Van Rossum vào cuối những năm 80 và đầu những năm 90 tại Viện toán-tin ở Hà Lan. Python kế thừa từ nhiều ngôn ngữ như ABC, Module-3, C, C++, Unix Shell, …','Ngôn ngữ Python được cập nhật khá thường xuyên để thêm các tính năng và hỗ trợ mới. Phiên bản mới nhất hiện nay của Python là Python 3.3 được công bố vào 29/9/2012 với nguyên tắc chủ đạo là \"bỏ cách làm việc cũ nhằm hạn chế trùng lặp về mặc chức năng của Python\".','https://i.udemycdn.com/course/750x422/913448_e6e2.jpg','admin','2019-07-01 11:56:35',NULL,'2019-07-01 11:56:35',4,6);
/*!40000 ALTER TABLE `posts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `role` varchar(15) NOT NULL DEFAULT 'user',
  `salt` varchar(33) NOT NULL,
  `image` varchar(255) NOT NULL DEFAULT 'noavatar.png',
  `creator` varchar(50) DEFAULT 'user',
  `dateCreated` datetime DEFAULT CURRENT_TIMESTAMP,
  `finalEditor` varchar(50) DEFAULT NULL,
  `lastModifiedDate` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'rong9x','123','admin','','null','1','2019-06-25 00:00:00','1','2019-06-25 00:00:00'),(2,'hai','123456','user','ewq','null','1','2019-06-25 00:00:00','1','2019-06-25 00:00:00'),(3,'nhat','BE49682E5883C40D29D44891F0D95FD1','user','ÂGˆ`Õ£','noavatar.png','user','2019-06-27 09:00:15',NULL,NULL),(4,'nhat2508','C203D4DE356528618626901F98F63AC2','admin','ÙâZ9@Ô','noavatar.png','user','2019-06-27 20:45:08',NULL,'2019-06-27 20:45:08'),(5,'nhat123','9A40657B6096C35A88C01062C805F8FB','user','ôn�‘','noavatar.png','user','2019-06-27 20:46:40',NULL,'2019-06-27 20:46:40'),(6,'admin','E56EE12838439FF0DD02C9084C05513A','admin','ÍUßr¢I','noavatar.png','admin','2019-06-27 21:28:40',NULL,'2019-06-27 21:28:40'),(7,'nhat12345','E944FE30055B0B851E95BD47C52FC269','user','?•×‚·§\Z','noavatar.png','user','2019-06-28 15:52:13',NULL,'2019-06-28 15:52:13'),(8,'nhat111','6C542EED3E169766294257439D2F4B5B','user','~e¼Íðò¤','noavatar.png','user','2019-06-29 09:51:28',NULL,'2019-07-01 11:13:40'),(9,'topds110','F4C7031A933FC4EA975C2CC3546E1FFB','user','üU^ÌÕ�','noavatar.png','user','2019-06-30 23:02:59',NULL,'2019-06-30 23:02:59'),(10,'top111','95A014ACA0CA02D2116D8723DFF28C1B','user',' ï‹Jèƒ­','noavatar.png','user','2019-06-30 23:14:50',NULL,'2019-06-30 23:14:50'),(11,'topds111','BF3000964AC06E6B28FDB52E6AA7B7C2','user','‚‡„å–z','noavatar.png','user','2019-06-30 23:29:45',NULL,'2019-06-30 23:29:45'),(12,'nguyenhai','A7A8078E919D939AA0FB0E8B7C2B5804','user','òÆHYƒ´Þ','noavatar.png','user','2019-07-01 11:48:30',NULL,'2019-07-01 11:48:30');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-01 11:59:28
