-- MySQL dump 10.13  Distrib 8.0.28, for macos11 (arm64)
--
-- Host: localhost    Database: BookClubDB
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `BookParam`
--

DROP TABLE IF EXISTS `BookParam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `BookParam` (
  `paramId` int NOT NULL,
  `bookId` int NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=116 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `BookParam`
--

LOCK TABLES `BookParam` WRITE;
/*!40000 ALTER TABLE `BookParam` DISABLE KEYS */;
INSERT INTO `BookParam` VALUES (1,3,21),(7,3,22),(1,4,23),(8,4,24),(9,4,25),(1,5,26),(7,5,27),(1,6,28),(9,6,29),(1,7,30),(10,7,31),(1,8,32),(9,8,33),(8,8,34),(1,9,35),(9,9,36),(7,9,37),(1,10,38),(7,10,39),(9,10,40),(11,10,41),(1,11,42),(9,11,43),(1,12,44),(7,12,45),(1,13,46),(9,13,47),(14,14,48),(8,14,49),(1,15,50),(9,15,51),(15,15,52),(8,16,53),(14,16,54),(1,17,55),(7,17,56),(16,17,57),(1,18,58),(9,18,59),(15,18,60),(1,19,61),(9,19,62),(17,21,65),(9,21,66),(17,20,67),(9,20,68),(1,22,69),(10,22,70),(18,23,71),(9,23,72),(1,24,73),(9,24,74),(15,24,75),(1,25,76),(9,25,77),(1,26,78),(10,26,79),(1,27,80),(21,27,81),(20,27,82),(22,27,83),(23,27,84),(24,28,85),(9,28,86),(7,28,87),(25,29,88),(7,29,89),(1,30,90),(8,30,91),(9,30,92),(1,31,93),(9,31,94),(26,32,97),(13,33,98),(9,33,99),(12,33,100),(1,34,101),(27,34,102),(7,34,103),(1,35,104),(13,35,105),(1,1,106),(14,45,114),(31,45,115);
/*!40000 ALTER TABLE `BookParam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Books`
--

DROP TABLE IF EXISTS `Books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Books` (
  `bookId` int NOT NULL AUTO_INCREMENT,
  `bookName` varchar(255) NOT NULL,
  `author` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `publishYear` int NOT NULL,
  `synopsis` varchar(255) NOT NULL,
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`bookId`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Books`
--

LOCK TABLES `Books` WRITE;
/*!40000 ALTER TABLE `Books` DISABLE KEYS */;
INSERT INTO `Books` VALUES (1,'骆驼祥子','老舍（舒庆春）',1933,'《骆驼祥子》讲述的是中国北平城里的一个年轻好强、充满生命活力的人力车夫祥子三起三落的人生经历。','/bookImg/2e4d442378714d25bf8d9271c334eb70.jpg'),(3,'乱世佳人','(美)玛格丽特·米切尔',2010,'玛格丽特·米切尔编著的《乱世佳人(上下译文 名著精选)》称得上有史以来 经典的爱情巨著之一 ，由费雯丽和克拉克·盖博主演的影片亦成为影 “不可逾越的”的 的爱情片经典。小说以美国 南北战争为背景，主线是好强、任性的庄园主小姐斯佳丽纠缠在几个男人之间的爱恨情仇，与之相伴的还 有社会历史的重大变迁，旧日熟悉的一切的一去不返 ……《乱世佳人》既是一首人类爱情的唱，又是一 幅反映社会政治、经济、道德诸多方面巨大而深刻变 化的宏大历史画卷。','/bookImg/f28ff3445bc849ea9f28d4c9364149af.jpg'),(4,'童年','马克西姆·高尔基',1913,'该作讲述了阿廖沙（高尔基的乳名）三岁到十岁这一时期的童年生活，生动地再现了19世纪七八十年代沙俄下层人民的生活状况，写出了高尔基对苦难的认识，对社会人生的独特见解，字里行间涌动着一股生生不息的热望与坚强。','/bookImg/7649ddc0a5d144119f51b9c756421026.jpg'),(5,'巴黎圣母院','维克多·雨果',1831,'小说以离奇和对比手法写了一个发生在15世纪法国的故事：巴黎圣母院副主教克洛德道貌岸然、蛇蝎心肠，先爱后恨，迫害吉ト赛女郎埃斯梅拉达。面目丑陋、心地善良的敲钟人卡西莫多为救女郎舍身。小说揭露了宗教的虚伪，宣告禁欲主义的破产，歌颂了下层劳动人民的善良、友爱、舍己为人，反映了雨果的人道主义思想。','/bookImg/425794b96c5f44ba88ce29c2a5157ea5.jpg'),(6,'红与黑','(法)司汤达',1830,'作品讲述主人公于连是小业主的儿子，凭着聪明才智，在当地市长家当家庭教师时与市长夫人勾搭成奸，事情败露后逃离市长家，进了神学院。经神学院院长举荐，到巴黎给极端保王党中坚人物拉莫尔侯爵当私人秘书，很快得到侯爵的赏识和重用。','/bookImg/797310bf81534387812255e56a5e60ac.jpg'),(7,'战争与和平','(俄)列夫·尼古拉耶维奇·托尔斯泰',1869,'该作以1812年的卫国战争为中心，反映从1805到1820年间的重大历史事件。以鲍尔康斯、别祖霍夫、罗斯托夫和库拉金四大贵族的经历为主线，在战争与和平的交替描写中把众多的事件和人物串联起来。作者将“战争”与“和平”的两种生活、两条线索交叉描写，构成一部百科全书式的壮阔史诗。','/bookImg/d09f48f5ebc345f7b4401fd4d783e69d.jpg'),(8,'大卫·科波菲尔','(英)查尔斯·狄更斯',1849,'小说讲述了主人公大卫从幼年至中年的生活历程，以“我”的出生为源，将朋友的真诚与阴暗、爱情的幼稚与冲动、婚姻的甜美与琐碎、家人的矛盾与和谐汇聚成一条溪流，在命运的河床上缓缓流淌，最终融入宽容壮美的大海。其间夹杂各色人物与机缘。语言诙谐风趣，展示了19世纪中叶英国的广阔画面，反映了狄更斯希望人间充满善良正义的理想。','/bookImg/c22bdd7eb7674b20bef17a6cedfaff8a.jpg'),(9,'悲惨世界','(法)维克多·雨果',1862,'故事的主线围绕主人公土伦苦刑犯冉·阿让（Jean Valjean）的个人经历，融进了法国的历史、革命、战争、道德哲学、法律、正义、宗教信仰。','/bookImg/47a4f85c0b924c5d9e6742bd487372ad.jpg'),(10,'呼啸山庄','(英)艾米莉·勃朗特',1847,'小说描写吉卜赛弃儿希斯克利夫被山庄老主人收养后，因受辱和恋爱不遂，外出致富。回来后，对与其女友凯瑟琳结婚的地主林顿及其子女进行报复的故事。全篇充满强烈的反压迫、争幸福的斗争精神，又始终笼罩着离奇、紧张的浪漫气氛。','/bookImg/4ec54938cfcf4f2a9a8310bb8e1ce07b.png'),(11,'安娜·卡列尼娜','(俄)列夫·托尔斯泰',1877,'作品讲述了贵族妇女安娜追求爱情幸福，却在卡列宁的虚伪、渥伦斯基的冷漠和自私面前碰得头破血流，最终落得卧轨自杀、陈尸车站的下场。庄园主列文反对土地私有制，抵制资本主义制度，同情贫苦农民，却又无法摆脱贵族习气而陷入无法解脱的矛盾之中。矛盾的时期、矛盾的制度、矛盾的人物、矛盾的心理，使全书在矛盾的漩涡中颠簸。这部小说是新旧交替时期紧张惶恐的俄国社会的写照。','/bookImg/64b600f3fd5f4f268a380e2f23ca4d59.png'),(12,'绿山墙的安妮','(加)露西·莫德·蒙哥马利',1904,'讲述了纯真善良、热爱生活的女主人公小安妮，自幼失去父母，11岁时被绿山墙的马修和玛丽拉兄妹领养，但她个性鲜明，富于幻想，而且自尊自强，凭借自己的刻苦勤奋，不但得到领养人的喜爱，也赢得老师和同学的关心和友谊。','/bookImg/423c15b680ce4843869788ae3c3811a4.png'),(13,'鲁滨逊漂流记','(英)丹尼尔·笛福',1719,'该作主要讲述了主人公鲁滨逊·克鲁索出生于一个中产阶级家庭，一生志在遨游四海的故事。一次在去非洲航海的途中遇到风暴，只身漂流到一个无人的荒岛上，开始了一段与世隔绝的生活。他凭着强韧的意志与不懈的努力，在荒岛上顽强地生存下来，在岛上生活了28年2个月零19天后，最终得以返回故乡。','/bookImg/31f59081e060426ea8665618c1d09efc.png'),(14,'假如给我三天光明','(美)海伦·凯勒',2003,'《假如给我三天光明》是美国当代作家海伦·凯勒的散文代表作。该文的前半部分主要写了海伦变成盲聋人后的生活，后半部分则介绍了海伦的求学生涯。同时也介绍她体会不同的丰富多彩的生活以及她的慈善活动等等。','/bookImg/d868c2e7949246b195dc55aa4ccffccb.png'),(15,'傲慢与偏见','(英)简·奥斯汀',1797,'小说描写了小乡绅班纳特五个待字闺中的千金，主角是二女儿伊丽莎白。她在舞会上认识了达西，但是耳闻他为人傲慢，一直对他心生排斥，经历一番周折，伊丽莎白解除了对达西的偏见，达西也放下傲慢，有情人终成眷属。','/bookImg/155fd0664d3044b896b64658c92cc719.jpg'),(16,'朝花夕拾','鲁迅',1926,'此文集作为“回忆的记事”，多侧面地反映了作者鲁迅青少年时期的生活，形象地反映了他的性格和志趣的形成经过。','/bookImg/4cfb4921f3384b48a119f198e930fa40.png'),(17,'西游记','吴承恩',1592,'全书主要描写了孙悟空出世及大闹天宫后，遇见了唐僧、猪八戒、沙僧和白龙马，西行取经，一路上历经艰险，降妖除魔，经历了九九八十一难，终于到达西天见到如来佛祖，最终五圣成真的故事。该小说以“玄奘取经”这一历史事件为蓝本，经作者的艺术加工，深刻地描绘出明代百姓的社会生活状况。','/bookImg/6cf8ca92c0454f7f9e91135d6b075b98.png'),(18,'简·爱','夏洛蒂·勃朗特',1847,'《简·爱》中简·爱的人生追求有两个基本旋律：富有激情、幻想、反抗和坚持不懈的精神；对人间自由幸福的渴望和对更高精神境界的追求。','/bookImg/e9b63bc03ac24bdf84706956fc41fb3c.png'),(19,'红楼梦','曹雪芹',1784,'小说以贾、史、王、薛四大家族的兴衰为背景，以富贵公子贾宝玉为视角，以贾宝玉与林黛玉、薛宝钗的爱情婚姻悲剧为主线，描绘了一些举止见识出于须眉之上的闺阁佳人的人生百态，展现了真正的人性美和悲剧美，可以说是一部从各个角度展现女性美以及中国古代社会世态百相的史诗性著作。','/bookImg/21cb16d178dc468b94bb6fbedd56b06f.jpg'),(20,'水浒传','施耐庵',1614,'《水浒传》是一部长篇英雄传奇，是中国古代长篇小说的代表作之一，是以宋江起义故事为线索创作出来的。宋江起义发生在北宋徽宗时期，《宋史》的《徽宗本纪》、《侯蒙传》、《张叔夜传》等都有记载。','/bookImg/fc05d442fa2347faa032c4eaa3fcd8e3.png'),(21,'三国演义','罗贯中',1522,'三国演义》可大致分为黄巾起义、董卓之乱、群雄逐鹿、三国鼎立、三国归晋五大部分，描写了从东汉末年到西晋初年之间近百年的历史风云，以描写战争为主，诉说了东汉末年的群雄割据混战和魏、蜀、吴三国之间的政治和军事斗争，最终司马炎一统三国，建立晋朝的故事。','/bookImg/93fe8cc1ceea4d9887b75019e70e460d.png'),(22,'高老头','【法】巴尔扎克',1834,'该讲述主人公高老头是法国大革命时期起家的面粉商人，中年丧妻，他把自己所有的爱都倾注在两个女儿身上，为了让她们挤进上流社会，从小给她们良好的教育，且出嫁时给了她们每人80万法郎的陪嫁，可他的两个女儿生活放荡，挥金如土，他的爱轻而易举就被金钱至上的原则战胜了。','/bookImg/6e10c17e6cbc4dc0bcd8e8c17847d9ae.png'),(23,'老人与海','【美】欧内斯特·米勒尔·海明威',1951,'该作围绕一位老年古巴渔夫，与一条巨大的马林鱼在离岸很远的湾流中搏斗而展开故事的讲述。尽管海明威笔下的老人是悲剧性的，但他身上却有着尼采“超人”的品质，泰然自若地接受失败，沉着勇敢地面对死亡，这些“硬汉子”体现了海明威的人生哲学和道德理想，即人类不向命运低头，永不服输的斗士精神和积极向上的乐观人生态度。','/bookImg/e2d61d1c0ceb436d8f73046c9c91e797.png'),(24,'飘','【美】玛格丽特·米切尔',1936,'小说以亚特兰大以及附近的一个种植园为故事场景，描绘了内战前后美国南方人的生活。作品刻画了那个时代的许多南方人的形象，占中心位置的斯嘉丽、瑞德、艾希礼、梅兰妮等人是其中的典型代表。','/bookImg/918246d6b2c74244973f2455ee7cae76.png'),(25,'汤姆·索亚历险记','【美】马克·吐温',1876,'小说的故事发生在19世纪上半世纪美国密西西比河畔的一个普通小镇上。主人公汤姆·索亚天真活泼、敢于探险、追求自由，不堪忍受束缚个性、枯燥乏味的生活，幻想干一番英雄事业。','/bookImg/7a9461927f7049608da96cb8fc7f0c87.png'),(26,'复活','【俄】列夫·托尔斯泰',1899,'该书取材于一件真实事件，主要描写男主人公聂赫留朵夫引诱姑妈家女仆玛丝洛娃，使她怀孕并被赶出家门。后来，她沦为妓女，因被指控谋财害命而受审判。男主人公以陪审员的身份出庭，见到从前被他引诱的女人，深受良心谴责。他为她奔走伸冤，并请求同她结婚，以赎回自己的罪过。上诉失败后，他陪她流放西伯利亚。他的行为感动了她，使她重新爱他。但为了不损害他的名誉和地位，她最终没有和他结婚而同一个革命者结为伉俪。','/bookImg/31cdd4e8ad2244f0a5819f7246e19a21.png'),(27,'钢铁是怎样炼成的','尼古拉·奥斯特洛夫斯基',1933,'小说通过记叙保尔·柯察金的成长道路告诉人们，一个人只有在革命的艰难困苦中战胜敌人也战胜自己，只有在把自己的追求和祖国、人民的利益联系在一起的时候，才会创造出奇迹，才会成长为钢铁战士。','/bookImg/504ac0b5c4ac441ba142ad411e7b014c.png'),(28,'浮士德','约翰·沃尔夫冈·冯·歌德',1832,'《浮士德（Faust）》是德国作家约翰·沃尔夫冈·冯·歌德创作的一部长达12111行的诗剧，第一部出版于1808年，共二十五场，不分幕。第二部共二十七场，分五幕。\n体裁：诗剧\n','/bookImg/1f3b759cd67f4f20a31515181803a7e7.png'),(29,'飞鸟集','【印度】泰戈尔',1916,'：《飞鸟集》是印度诗人泰戈尔创作的诗集，它包括325首清丽的无标题小诗，首次出版于1916年。这些诗的基本题材多为极其常见事物，不外乎小草、落叶、飞鸟、星辰、河流等等。','/bookImg/6d7cd883e01748c0aa26b2f39e69746f.png'),(30,'我的大学','马克西姆·高尔基',1923,'该书中作者描写了他青年时代的生活经历。从这个被真实记述下来的过程中，可以看出青少年时代的高尔基对小市民习气的深恶痛绝，对自由的热烈追求，对美好生活的强烈向往。','/bookImg/e3f611f1c7c64a53940fdd0368bd5ba0.png'),(31,'活着','余华',1992,'《活着》讲述了在大时代背景下，随着内战、三反五反、大跃进、文化大革命等社会变革，徐福贵的人生和家庭不断经受着苦难，到了最后所有亲人都先后离他而去，仅剩下年老的他和一头老牛相依为命。','/bookImg/67369a93e0fd4a77b27655d41f8a7a5f.png'),(32,'物种起源','【英】查尔斯·达尔文',1859,'书中，达尔文根据20多年积累的对古生物学、生物地理学、形态学、胚胎学和分类学等许多领域的大量研究资料，以自然选择为中心，从变异性、遗传性、人工选择、生存竞争和适应等方面论证物种起源和生命自然界的多样性与统一性。','/bookImg/6a57ae085516457a9ca3d59b960ac8b8.png'),(33,'安徒生童话','(丹麦)安徒生',1872,'《安徒生童话》是丹麦作家安徒生创作的童话集，共由166篇故事组成。该作爱憎分明，热情歌颂劳动人民、赞美他们的善良和纯洁的优秀品德；无情地揭露和批判王公贵族们的愚蠢、无能、贪婪和残暴。其中较为闻名的故事有：《小人鱼》《丑小鸭》《卖火柴的小女孩》、《拇指姑娘》等。','/bookImg/b6242a14abb7499e8344ef65f5c812a6.png'),(34,'海底两万里','儒勒·凡尔纳',1870,'该小说主要讲述了博物学家和生物学家阿龙纳斯、其仆人康塞尔和鱼叉手尼德·兰一起随鹦鹉螺号潜艇船长尼摩周游海底的故事。','/bookImg/40b75a1de9b6419a9c5e9940629eb0f6.png'),(35,'木偶奇遇记','【意】卡洛·科洛迪',1880,'作品讲述当仁慈木匠皮帕诺睡觉的时候，梦见一位蓝色的天使赋予他最心爱的木偶匹诺曹生命，于是小木偶开始了他的冒险。如果他要成为真正的男孩，他必须通过勇气、忠心以及诚实的考验。在历险中，他因贪玩而逃学，因贪心而受骗，还因此变成了驴子。最后，他掉进一只大鲸鱼的腹中，意外与皮帕诺相逢……经过这次历险，匹诺曹终于长大了，他变得诚实、勤劳、善良，成为了一个真真正正的男孩。','/bookImg/a536a4761fff471ea40c1ed542b97dff.png'),(45,'人间词话','王国维',1909,'王国维根据其文艺观，把多种多样的艺术境界划分为三种基本形态：“上焉者，意与境浑；其次，或以境胜；或以意胜。”王国维比较科学地分析了“景”与“情”的关系和产生的各种现象，在中国文学批评史上第一次提出了“造境”与“写境”，“理想”与“写实”的问题。','/bookImg/b39d8b330441476cb3d06bb277d99c2c.jpg');
/*!40000 ALTER TABLE `Books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Collects`
--

DROP TABLE IF EXISTS `Collects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Collects` (
  `bookId` int NOT NULL,
  `userId` int NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=113 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Collects`
--

LOCK TABLES `Collects` WRITE;
/*!40000 ALTER TABLE `Collects` DISABLE KEYS */;
INSERT INTO `Collects` VALUES (3,40,29),(1,40,30),(6,40,31),(1,22,41),(3,22,42),(6,22,43),(4,22,44),(7,22,45),(20,38,49),(15,38,50),(22,38,51),(7,38,52),(32,38,53),(1,41,60),(3,41,61),(10,41,62),(1,38,63),(26,38,65),(3,38,66),(1,42,75),(7,42,76),(6,42,77),(4,42,78),(22,42,79),(14,42,80),(16,42,81),(10,42,82),(40,38,83),(42,38,91),(6,50,108),(7,50,109),(45,42,110),(1,52,111),(3,52,112);
/*!40000 ALTER TABLE `Collects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ManageMenu`
--

DROP TABLE IF EXISTS `ManageMenu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ManageMenu` (
  `menuId` int NOT NULL AUTO_INCREMENT,
  `authName` varchar(255) NOT NULL,
  `fatherId` int DEFAULT NULL,
  `path` varchar(255) NOT NULL,
  `children` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`menuId`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ManageMenu`
--

LOCK TABLES `ManageMenu` WRITE;
/*!40000 ALTER TABLE `ManageMenu` DISABLE KEYS */;
INSERT INTO `ManageMenu` VALUES (1,'用户管理',0,'/',NULL),(2,'权限管理',0,'/',NULL),(3,'书籍管理',0,'/',NULL),(4,'消息管理',0,'/',NULL),(5,'数据统计',0,'/',NULL),(6,'用户列表',1,'/layout/users',NULL),(7,'角色列表',2,'/layout/roles',NULL),(8,'权限列表',2,'/layout/rights',NULL),(9,'书籍列表',3,'/layout/books',NULL),(10,'分类参数',3,'/layout/params',NULL),(11,'书籍分类',3,'/layout/categories',NULL),(12,'消息列表',4,'/layout/msgs',NULL),(13,'数据报表',5,'/layout/datas',NULL);
/*!40000 ALTER TABLE `ManageMenu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Msg`
--

DROP TABLE IF EXISTS `Msg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Msg` (
  `msgId` int NOT NULL AUTO_INCREMENT,
  `msg` varchar(255) NOT NULL,
  `msgUserId` int NOT NULL,
  `msgUserName` varchar(255) NOT NULL,
  `msgTime` datetime NOT NULL,
  PRIMARY KEY (`msgId`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Msg`
--

LOCK TABLES `Msg` WRITE;
/*!40000 ALTER TABLE `Msg` DISABLE KEYS */;
INSERT INTO `Msg` VALUES (1,'五一劳动节快乐！',1,'Codexps','2022-05-01 23:57:44'),(8,'congratulation',41,'exert','2022-05-02 00:25:34'),(12,'欢迎各位老师和同学！',50,'Tom','2022-05-08 10:05:48');
/*!40000 ALTER TABLE `Msg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Params`
--

DROP TABLE IF EXISTS `Params`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Params` (
  `paramId` int NOT NULL AUTO_INCREMENT,
  `param` varchar(255) NOT NULL,
  PRIMARY KEY (`paramId`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Params`
--

LOCK TABLES `Params` WRITE;
/*!40000 ALTER TABLE `Params` DISABLE KEYS */;
INSERT INTO `Params` VALUES (1,'长篇小说'),(7,'浪漫主义'),(8,'自传体'),(9,'现实主义'),(10,'批判现实主义'),(11,'哥特式'),(12,'寓言集'),(13,'童话'),(14,'散文'),(15,'女性主义'),(16,'神魔'),(17,'长篇章回体小说'),(18,'中篇小说'),(19,'哲学著作'),(20,'理性主义'),(21,'英雄主义'),(22,'献身主义'),(23,'社会主义'),(24,'诗剧'),(25,'诗集'),(26,'唯物主义'),(27,'科幻'),(31,'文学评论');
/*!40000 ALTER TABLE `Params` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Roles`
--

DROP TABLE IF EXISTS `Roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Roles` (
  `adminId` int NOT NULL,
  `role` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `explain` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Roles`
--

LOCK TABLES `Roles` WRITE;
/*!40000 ALTER TABLE `Roles` DISABLE KEYS */;
INSERT INTO `Roles` VALUES (0,'user','普通用户：使用普通功能'),(1,'admin','管理员：管理普通用户、书籍、留言'),(2,'superAdmin','超级管理员：管理所有用户、权限、书籍、留言');
/*!40000 ALTER TABLE `Roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Users`
--

DROP TABLE IF EXISTS `Users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Users` (
  `userId` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `sex` varchar(255) NOT NULL,
  `admin` int NOT NULL,
  `motto` varchar(255) NOT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Users`
--

LOCK TABLES `Users` WRITE;
/*!40000 ALTER TABLE `Users` DISABLE KEYS */;
INSERT INTO `Users` VALUES (1,'1091382138@qq.com','xps001010','Codexps','male',2,'加油',NULL),(22,'123','123','1','male',1,'123',NULL),(23,'444@qq.com','1','3','male',1,'1',NULL),(24,'12313@qq.com','2313123','123123','male',1,'121314124',NULL),(27,'123123@qq.com','23123123','342343','female',1,'123123123','23123123'),(28,'123444@qq.com','213123','34234234','secret',1,'123124214214',NULL),(30,'12312312@qq.com','123123123','213123','male',0,'123123123',NULL),(31,'1231232312@qq.com','123123123','213123','male',0,'123123123',NULL),(32,'313131@qq.com','xssadadsad','1231233','male',0,'123123123',NULL),(33,'131231231@qq.com','2133123123','12312321312','male',0,'213123123',NULL),(34,'xps@qq.com','1','6','male',0,'213123','/avatar/7101eddc454d43c6a17ba30e41bbe80c.jpg'),(36,'112333@qq.com','xpsss','sadd','male',0,'sdadsda',NULL),(37,'1@qq.com','1','6','male',0,'1','/avatar/78ceb096329744079b2c82b1d12bd33f.jpg'),(38,'3@qq.com','2','小猪猪','female',0,'坚持','/avatar/6fdcb6a78257405eb713f256a010beb7.jpg'),(40,'xc25475527@qq.com','111','xps','male',0,'333','/avatar/3264e1d9b2b141d7b9166acdfe0cc70d.jpg'),(41,'1484978792@qq.com','hsy2001526','exert','female',1,'just do it','/avatar/b16b234328a04616b55b3c31d165c492.jpg'),(42,'66666@qq.com','123456','小熊','male',0,'芜湖！','/avatar/b5b6fc0255554e6287e2ffe2f5b4d9ea.jpg'),(50,'888@qq.com','666','Tom','female',1,'有志者事竟成。','/avatar/20f080439ab34098a89607b1e38096cf.png'),(52,'333@gmail.com','123456','bruin','male',0,'jiayou',NULL);
/*!40000 ALTER TABLE `Users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-11-04 16:04:17
