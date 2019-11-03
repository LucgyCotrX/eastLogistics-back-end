 
#创建数据库
create database db_east;
#使用该数据库
use db_east;

#创建数据表
#先建立无外键表
#网点信息表
create table network(
n_id int unsigned  auto_increment key comment '编号',
n_province varchar(80)  comment '省份',
n_city varchar(80) not null comment '城市',
n_county varchar(80)  comment '区县',
n_address varchar(200) not null comment '详细地址',
n_in int not null default 0 comment '月揽收量',
n_out int not null default 0 comment '月派件量'
);
insert into network(n_id,n_province,n_city,n_county,n_address) values
(2019001,'广东省','佛山市','南海区','狮山大学城阳光在线广场菜鸟驿站'),
(2019002,'广东省','广州市','番禺区','广州大学城广州大学菜鸟驿站'),
(2019003,'广东省','广州市','南海区','华南师范大学南海校区菜鸟驿站'),
(2019004,null,'北京市','朝阳区','朝阳菜鸟驿站'),
(2019005,'广东省','深圳市','南海区','广东轻工职业学校菜鸟驿站'),
(2019006,'广东省','佛山市','南海区','狮山大学城阳光在线广场菜鸟驿站'),
(2019007,'广东省','广州市','番禺区','广州大学城广州大学菜鸟驿站'),
(2019008,'广东省','佛山市','顺德区','佛山顺德菜鸟驿站'),
(2019009,'广东省','广州市','梅花园区','广州梅花园菜鸟驿站'),
(2019010,'广东省','广州市','中山区','广州市中山菜鸟驿站'),
(2019011,null,'北京市','朝阳区','朝阳第三菜鸟驿站'),
(2019012,'广东省','深圳市','龙岗区','深圳龙岗菜鸟驿站'),
(2019013,'广东省','佛山市','南海区','佛山南海菜鸟驿站'),
(2019014,'广东省','深圳市','龙华区','深圳龙华菜鸟驿站'),
(2019015,'广东省','深圳市','南山区','深圳南山菜鸟驿站'),
(2019016,'广东省','广州市','沙河区','广州沙河菜鸟驿站'),
(2019017,'广东省','佛山市','大沥区','佛山大沥菜鸟驿站'),
(2019018,null,'北京市','朝阳区','朝阳第二菜鸟驿站'),
(2019019,'广东省','深圳市','南海区','广州南海第二菜鸟驿站'),
(2019020,'广东省','佛山市','南海区','广州南海第十菜鸟驿站'),
(2019021,'广东省','广州市','番禺区','广州番禺第十一菜鸟驿站');

#员工登录模块
create table admin(
a_id int unsigned  auto_increment key comment '编号',
a_account varchar(16) not null unique comment '账号',
a_password varchar(32) not null  comment '密码',
a_type varchar(32) not null comment '类型',
a_power tinyint not null comment '权限，管理员0,网点管理1',
a_name varchar(32) not null comment '姓名',
a_sex varchar(8) not null comment '性别',
a_phone char(11) not null comment '电话',
n_id int unsigned comment '网点编号',
CONSTRAINT anId_fk_network foreign key(n_id) references network(n_id)
);
#赋值
insert into admin(a_account,a_password,a_type,a_power,a_name,a_sex,a_phone,n_id) values
('root','root','管理员',0,'林经理','男','13000000000',null),
('network1','network1','网点管理员',1,'中芥','男','13111111111',2019001),
('network2','network2','网点管理员',1,'波妞','女','13333333334',2019002),
('network3','network3','网点管理员',1,'张三','男','15648987854',2019003),
('network4','network4','网点管理员',1,'李世','女','13546878954',2019004),
('network5','network5','网点管理员',1,'王五','男','13222222222',2019005),
('network6','network6','网点管理员',1,'小六','女','13545687954',2019006);



create table staff(
s_id int  unsigned  auto_increment key comment '编号',
s_name varchar(32) not null comment '姓名',
s_sex varchar(8) not null comment '性别',
s_account varchar(20) not null comment '帐号',
s_password varchar(32) not null comment '密码',
n_id int unsigned comment '网点编号',
s_photo blob comment '头像',
s_phone char(11) not null comment '电话',
s_in int not null default 0 comment '月揽收量',
s_out int not null default 0 comment '月派件量',
CONSTRAINT snId_fk_network foreign key(n_id) references network(n_id)
);
insert into staff(s_name,s_sex,s_account,s_password,n_id,s_photo,s_phone) values
('路飞','男','luffy','luffy',2019003,null,'13333333333'),
('陈小明','男','xiaoming','xiaoming',2019004,null,'13444444444'),
('张小红','男','xiaohong','xiaohong',2019005,null,'13545688368'),
('李小亮','男','xiaoliang','xiaoliang',2019006,null,'13456848652'),
('路小飞','男','luffyx','luffyx',2019007,null,'13335478645'),
('陈明','男','ming','ming',2019008,null,'13456548652'),
('张红','男','hong','hong',2019009,null,'13545688368'),
('李亮','男','liang','liang',2019010,null,'13456848652'),
('路大飞','男','luffyd','luffyd',2019011,null,'13255648964'),
('陈大明','男','xiaomingd','xiaomingd',2019012,null,'13546745122'),
('张大红','男','xiaohongd','xiaohongd',2019013,null,'13556548361'),
('李大亮','男','xiaoliangd','xiaoliangd',2019014,null,'13456848652'),
('路中飞','男','luffyz','luffyz',2019015,null,'13352345685'),
('陈中明','男','xiaomingz','xiaomingz',2019016,null,'1323546854'),
('张中红','男','xiaohongz','xiaohongz',2019017,null,'13532145687'),
('李中亮','男','xiaoliangz','xiaoliangz',2019018,null,'13456754213'),
('王五','男','wangwu','wangwu',2019019,null,'13565753214');

create table template(
t_id int unsigned  auto_increment key comment '编号',
t_name varchar(40) not null comment '名称',
t_type varchar(36) not null comment '类型',
s_id int unsigned not null comment '所属业务员',
t_customer varchar(36) not null comment '适用客户',
t_area varchar(200) not null comment '适用地区',
t_weight float(5,2) not null comment '首重重量',
t_price decimal(5,2) not null comment '首重价格',
t_addweight float(5,2)  comment '续重重量',
t_addprice decimal(5,2) comment '续重价格',
constraint tsId_fk_staff foreign key(s_id) references staff(s_id)
);
insert into template(t_name,t_type,s_id,t_customer,t_area,t_weight,t_price,t_addweight,t_addprice) values
('默认模板','b2c',1,'businesses and customers','广州珠三角',10,50.0,null,null),
('o2o模板','o2o',2,'online and offline','佛山',20,100.0,null,null),
('默认模板2','b2c',3,'businesses and customers','佛山',10,50.0,null,null),
('o2o模板2','o2o',4,'online and offline','广州',20,100.0,null,null),
('默认模板3','b2c',5,'businesses and customers','广州',10,50.0,null,null),
('o2o模板4','o2o',17,'online and offline','珠海',20,100.0,null,null),
('默认模板5','b2c',23,'businesses and customers','上海',10,50.0,null,null),
('o2o模板6','o2o',18,'online and offline','深圳',20,100.0,null,null),
('默认模板7','b2c',19,'businesses and customers','深圳',10,50.0,null,null),
('o2o模板8','o2o',20,'online and offline','上海',20,100.0,null,null),
('默认模板9','b2c',21,'businesses and customers','北京',10,50.0,null,null),
('o2o模板10','o2o',22,'online and offline','北京',20,100.0,null,null);

create table customer(
c_id int unsigned  auto_increment key comment '编号',
c_name varchar(32) not null comment '姓名',
c_job varchar(40) not null comment '单位',
c_address varchar(200) not null comment '地址',
c_phone char(11) not null comment '电话',
s_id int unsigned not null comment '对接业务员编号',
c_billnums int comment '预存单号',
t_id int unsigned not null comment '运费模板编号',
c_send int comment '月寄件量',
constraint sId_fk_staff foreign key(s_id) references staff(s_id),
constraint tId_fk_template foreign key(t_id) references template(t_id)
);
insert into customer values
(null,'马文','某宝公司总裁','杭州','13777777777',1,2000,2,12130);
(null,'Logan','某米公司总裁','杭州','13035462021',2,2000,2,12130),
(null,'Peter','某新公司总裁','杭州','13201350152',3,2000,2,12130),
(null,'Steven','某方公司总裁','杭州','13654587895',4,2000,2,12130),
(null,'Angel','某为公司总裁','杭州','13145654565',5,2000,2,12130),
(null,'Jack','某区公司总裁','杭州','13654652123',17,2000,2,12130),
(null,'Bob','某对公司总裁','杭州','13465789878',19,2000,2,12130),
(null,'Smith','某时公司总裁','杭州','13333335465',20,2000,2,12130),
(null,'James','某派公司总裁','杭州','13564485495',21,2000,2,12130),
(null,'Jason','某拍公司总裁','杭州','13645478787',22,2000,2,12130),
(null,'Ben','某中公司总裁','杭州','13645456656',23,2000,2,12130),
(null,'Queen','某轩公司总裁','杭州','13654547878',25,2000,2,12130);

create table report(
r_id int unsigned  auto_increment key comment '编号',
r_name varchar(36) not null comment '名称',
s_id int unsigned not null comment '业务员编号',
c_id int unsigned not null comment '客户编号',
r_statisticstime varchar(100) not null comment '统计时间',
r_createtime datetime not null comment '生成时间',
r_money decimal(5,2) not null comment '金额',
r_status varchar(20) not null comment '结算状态',
constraint rsId_fk_staff foreign key(s_id) references staff(s_id),
constraint rcId_fk_custom foreign key(c_id) references customer(c_id)
);
insert into report values
(null,'2019年7月财务报表',5,1,'2019.07.01/00:00-2019.07.31/23:59','2019-08-01/12:23:00',100.5,'已结算');
(null,'2019年6月财务报表',17,2,'2019.06.01/00:00-2019.06.31/23:59','2019-07-01/12:23:00',100.5,'已结算'),
(null,'2019年5月财务报表',18,3,'2019.05.01/00:00-2019.05.31/23:59','2019-06-01/12:23:00',100.5,'已结算'),
(null,'2019年4月财务报表',19,4,'2019.04.01/00:00-2019.04.31/23:59','2019-05-01/12:23:00',100.5,'已结算'),
(null,'2019年3月财务报表',20,5,'2019.03.01/00:00-2019.03.31/23:59','2019-04-01/12:23:00',100.5,'已结算'),
(null,'2019年2月财务报表',21,6,'2019.02.01/00:00-2019.02.31/23:59','2019-03-01/12:23:00',100.5,'已结算'),
(null,'2019年1月财务报表',22,7,'2019.01.01/00:00-2019.01.31/23:59','2019-02-01/12:23:00',100.5,'已结算'),
(null,'2018年12月财务报表',23,3,'2019.12.01/00:00-2019.12.31/23:59','2019-01-01/12:23:00',100.5,'已结算'),
(null,'2018年11月财务报表',24,2,'2019.11.01/00:00-2019.11.31/23:59','2018-12-01/12:23:00',100.5,'已结算'),
(null,'2018年10月财务报表',25,8,'2019.10.01/00:00-2019.10.31/23:59','2018-11-01/12:23:00',100.5,'已结算'),
(null,'2018年9月财务报表',26,9,'2018.09.01/00:00-2018.09.31/23:59','2018-10-01/12:23:00',100.5,'已结算');

create table waybill(
w_id  int unsigned  auto_increment key comment '编号',
w_status varchar(20) not null comment '运单状态',
w_info varchar(40) not null comment '物流信息',
c_id int unsigned not null comment '所属客户',
w_note varchar(200) comment '留言',
w_weight float(5,2) not null comment '重量',
w_price decimal(5,2) not null comment '资费',
w_type varchar(40) not null comment '内物类型',
s_inid int unsigned not null comment '揽收业务员',
w_intime datetime not null comment '揽收时间',
w_intype varchar(40) not null comment '揽收类型',
s_outid int unsigned  comment '签收业务员',
w_outtime datetime  comment '签收时间',
w_outproof varchar(40)  comment '签收凭证',
w_sname varchar(36) not null comment '寄件人姓名',
w_sphone char(11) not null comment '寄件人手机',
w_spro varchar(80) comment '寄件人省份',
w_scity varchar(80) comment '寄件人城市',
w_scounty varchar(80) comment '寄件人区',
w_saddress varchar(200) not null comment '寄件人详细地址',
w_rname varchar(36) not null comment '收件人姓名',
w_rphone char(11) not null comment '收件人手机',
w_rpro varchar(80) comment '收件人省份',
w_rcity varchar(80) comment '收件人城市',
w_rcounty varchar(80) comment '收件人区',
w_raddress varchar(200) not null comment '收件人详细地址',
constraint wcId_fk_customer foreign key(c_id) references customer(c_id),
constraint wsinId_fk_staff foreign key(s_inid) references staff(s_id),
constraint wsoutId_fk_staff foreign key(s_outid) references staff(s_id)
);
insert into waybill values
(20190820,'已运输','已被收件人签收',1,'我是马文',20.2,42.0,'水果',1,'2019-08-01/12:23:00','协议',2,'2019-08-03/12:30:00','门卫代签','马文','13255555555','广东省','佛山市','南海区','狮山大学城阳光在线广场菜鸟驿站','马辉桐','13266666666','广东省','广州市','番禺区','广州大学城广州大学菜鸟驿站');
(20190821,'已运输','已被收件人签收',2,' ',20.2,42.0,' ',2,'2019-08-01/12:23:00','协议',2,'2019-08-03/12:30:00','门卫代签','Logan','13035462021','广东省','佛山市','南海区','狮山大学城阳光在线广场菜鸟驿站','马辉桐','13266666666','广东省','广州市','番禺区','广州大学城广州大学菜鸟驿站'),

(20190822,'已运输','已被收件人签收',3,' ',20.2,42.0,' ',3,'2019-08-01/12:23:00','协议',2,'2019-08-03/12:30:00','门卫代签','Peter','13201350152','广东省','佛山市','南海区','狮山大学城阳光在线广场菜鸟驿站','马辉桐','13266666666','广东省','广州市','番禺区','广州大学城广州大学菜鸟驿站'),

(20190823,'已运输','已被收件人签收',4,' ',20.2,42.0,' ',4,'2019-08-01/12:23:00','协议',2,'2019-08-03/12:30:00','门卫代签','Steven','13654587895','广东省','佛山市','南海区','狮山大学城阳光在线广场菜鸟驿站','马辉桐','13266666666','广东省','广州市','番禺区','广州大学城广州大学菜鸟驿站'),

(20190824,'已运输','已被收件人签收',5,' ',20.2,42.0,' ',5,'2019-08-01/12:23:00','协议',2,'2019-08-03/12:30:00','门卫代签','Angel','13145654565','广东省','佛山市','南海区','狮山大学城阳光在线广场菜鸟驿站','马辉桐','13266666666','广东省','广州市','番禺区','广州大学城广州大学菜鸟驿站'),

(20190825,'已运输','已被收件人签收',6,' ',20.2,42.0,' ',17,'2019-08-01/12:23:00','协议',2,'2019-08-03/12:30:00','门卫代签','Jack','13654652123','广东省','佛山市','南海区','狮山大学城阳光在线广场菜鸟驿站','马辉桐','13266666666','广东省','广州市','番禺区','广州大学城广州大学菜鸟驿站'),

(20190826,'已运输','已被收件人签收',7,' ',20.2,42.0,' ',18,'2019-08-01/12:23:00','协议',2,'2019-08-03/12:30:00','门卫代签','Bob','13465789878','广东省','佛山市','南海区','狮山大学城阳光在线广场菜鸟驿站','马辉桐','13266666666','广东省','广州市','番禺区','广州大学城广州大学菜鸟驿站'),

(20190827,'已运输','已被收件人签收',8,' ',20.2,42.0,' ',19,'2019-08-01/12:23:00','协议',2,'2019-08-03/12:30:00','门卫代签','Smith','13333335465','广东省','佛山市','南海区','狮山大学城阳光在线广场菜鸟驿站','马辉桐','13266666666','广东省','广州市','番禺区','广州大学城广州大学菜鸟驿站'),

(20190828,'已运输','已被收件人签收',9,' ',20.2,42.0,' ',20,'2019-08-01/12:23:00','协议',2,'2019-08-03/12:30:00','门卫代签','James','13564485495','广东省','佛山市','南海区','狮山大学城阳光在线广场菜鸟驿站','马辉桐','13266666666','广东省','广州市','番禺区','广州大学城广州大学菜鸟驿站'),

(20190829,'已运输','已被收件人签收',10,' ',20.2,42.0,' ',21,'2019-08-01/12:23:00','协议',2,'2019-08-03/12:30:00','门卫代签','Jason','13645478787','广东省','佛山市','南海区','狮山大学城阳光在线广场菜鸟驿站','马辉桐','13266666666','广东省','广州市','番禺区','广州大学城广州大学菜鸟驿站'),

(20190830,'已运输','已被收件人签收',11,' ',20.2,42.0,' ',22,'2019-08-01/12:23:00','协议',2,'2019-08-03/12:30:00','门卫代签','Ben','13645456656','广东省','佛山市','南海区','狮山大学城阳光在线广场菜鸟驿站','马辉桐','13266666666','广东省','广州市','番禺区','广州大学城广州大学菜鸟驿站'),

(20190901,'已运输','已被收件人签收',12,' ',20.2,42.0,' ',23,'2019-08-01/12:23:00','协议',2,'2019-08-03/12:30:00','门卫代签','Queen','13654547878','广东省','佛山市','南海区','狮山大学城阳光在线广场菜鸟驿站','马辉桐','13266666666','广东省','广州市','番禺区','广州大学城广州大学菜鸟驿站');



