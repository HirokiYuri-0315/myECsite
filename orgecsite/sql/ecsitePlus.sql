set names utf8;
set foreign_key_checks = 0;
drop database if exists ecsite;

create database if not exists ecsite;
use ecsite;

drop table if exists login_user_transaction;
create table login_user_transaction(
	id int not null primary key auto_increment comment "ID",
	login_id varchar(16) unique comment "ユーザーID",
	login_pass varchar(16) comment "ログインPASS",
	user_name varchar(50) comment "ユーザー名",
	insert_date datetime comment "登録日時",
	update_date datetime
);

drop table if exists login_master_user_transaction;
create table login_master_user_transaction(
	id int not null primary key auto_increment,
	login_id varchar(16) unique,
	login_pass varchar(16),
	user_name varchar(50),
	insert_date datetime,
	update_date datetime
);

drop table if exists item_info_transaction;
create table item_info_transaction(
	id int not null primary key auto_increment comment "商品ID",
	item_name varchar(30) comment "商品名",
	item_price int comment "商品の価格",
	item_stock int comment "商品の在庫数",
	insert_date datetime comment "追加した日時",
	update_date datetime comment "更新した日時",
	image_file_path varchar(100) DEFAULT 'image' comment "画像ファイルパス",
	image_file_name varchar(50) DEFAULT 'img_def.jpg' comment "画像ファイル名",
	item_name_kana varchar(100) comment "商品名かな",
	item_description varchar(255) DEFAULT '未入力' comment "商品詳細",
	category_id int DEFAULT '1' comment "カテゴリID",
	item_release_company varchar(30) DEFAULT '未入力' comment "発売元"
);

drop table if exists user_buy_item_transaction;
create table user_buy_item_transaction(
	id int not null primary key auto_increment comment "履歴ID",
	item_transaction_id int comment "購入商品ID",
	total_price int comment "購入金額",
	total_count int comment "購入個数",
	user_master_id varchar(16) comment "購入ユーザーID",
	pay varchar(30) comment "支払い方法",
	insert_date datetime comment "購入日時",
	delete_date datetime
);

INSERT INTO item_info_transaction(item_name,item_name_kana,item_price,item_stock,item_description,category_id,image_file_name,item_release_company) VALUES
("ノートBook","のーとぶっく",100,50,"よくある普通のノートです。",2,"book_note_empty.png","ぶんぼうぐや"),
("ボールペン","ぼーるぺん",120,100,"使い慣れたボールペンです。",2,"bunbougu_ballpen.png","ぶんぼうぐや"),
("消しゴム","けしごむ",80,100,"ネリケシにはなりにくい消しゴムです。",2,"bunbougu_keshigomu.png","ぶんぼうぐや"),
("色鉛筆","いろえんぴつ",110,100,"落としても折れにくい丈夫な色鉛筆です。",2,"iroenpitsu.png","ぶんぼうぐや"),
("定規","じょうぎ",110,100,"シンプルに使いやすい定規です。",2,"bunbougu_jougi.png","ぶんぼうぐや"),
("怪しいノート","あやしいのーと",110,100,"少年の心をくすぐるかもしれないカッコいいノートです。",2,"note_kurorekishi.png","ぶんぼうぐや"),
("ポストイット","ぽすといっと",110,100,"とっさのメモに役立つポストイットです。",2,"postit_taba.png","ぶんぼうぐや"),
("コンパス","こんぱす",110,100,"キレイな丸を描ける昔ながらのコンパスです。",2,"bunbougu_compass.png","ぶんぼうぐや"),
("クリアファイル","くりあふぁいる",110,100,"様々な場面で役立つカラフルなクリアファイルです。",2,"clear_file.png","ぶんぼうぐや"),
("鉛筆","えんぴつ",110,100,"お子様に使って欲しい昔ながらの鉛筆です。",2,"pen_enpitsu_mark.png","ぶんぼうぐや"),
("シャーペン","しゃーぺん",110,100,"常に一定の太さで文字を書きたい人へ。",2,"seizu_pen.png","ぶんぼうぐや"),
("ホチキス","ほちきす",110,100,"カチッと書類をまとめるのに便利なホチキスです。",2,"bunbougu_hochikisu.png","ぶんぼうぐや"),
("サンプル1","さんぷる1",120,10,"動作確認のためのサンプルです。",1,"img_batsu.jpg","サンプル"),
("サンプル2","さんぷる2",120,10,"動作確認のためのサンプルです。",1,"img_marunaga.jpg","サンプル"),
("サンプル3","さんぷる3",120,10,"動作確認のためのサンプルです。",1,"img_maru.jpg","サンプル"),
("サンプル4","さんぷる4",120,10,"動作確認のためのサンプルです。",1,"img_maruyoko.jpg","サンプル"),
("サンプル5","さんぷる5",110,10,"動作確認のためのサンプルです。",1,"img_batsu.jpg","サンプル"),
("サンプル6","さんぷる6",110,10,"動作確認のためのサンプルです。",1,"img_marunaga.jpg","サンプル"),
("サンプル7","さんぷる7",110,1,"動作確認のためのサンプルです。",1,"img_maru.jpg","サンプル"),
("サンプル8","さんぷる8",110,10,"動作確認のためのサンプルです。",1,"img_maruyoko.jpg","サンプル"),
("サンプル9","さんぷる9",130,10,"動作確認のためのサンプルです。",1,"img_batsu.jpg","サンプル"),
("サンプル10","さんぷる10",130,10,"動作確認のためのサンプルです。",1,"img_marunaga.jpg","サンプル"),
("サンプル11","さんぷる11",130,10,"動作確認のためのサンプルです。",1,"img_maru.jpg","サンプル"),
("サンプル12","さんぷる12",130,10,"動作確認のためのサンプルです。",1,"img_maruyoko.jpg","サンプル"),
("サンプル13","さんぷる13",150,10,"動作確認のためのサンプルです。",1,"img_batsu.jpg","サンプル"),
("サンプル14","さんぷる14",150,10,"動作確認のためのサンプルです。",1,"img_marunaga.jpg","サンプル"),
("サンプル15","さんぷる15",150,10,"動作確認のためのサンプルです。",1,"img_maru.jpg","サンプル"),
("サンプル16","さんぷる16",150,10,"動作確認のためのサンプルです。",1,"img_maruyoko.jpg","サンプル"),
("定規","じょうぎ",110,100,"商品詳細",2,"bunbougu_jougi.png","サンプル");

INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("guest","guest","テストユーザー");
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("taro","123","山田太郎");
INSERT INTO login_master_user_transaction(login_id,login_pass,user_name) VALUES("root","masterAkira","admin");
INSERT INTO login_master_user_transaction(login_id,login_pass,user_name) VALUES("admin","admin","test");


drop table if exists cart_info;
create table cart_info(
	id int not null primary key auto_increment comment "ID",
	item_id int not null comment "商品ID",
	user_id varchar(16) not null comment "ユーザーID",
	total_count int not null comment "個数",
	total_price int not null comment "金額",
	pay varchar(30) comment "支払い方法",
	insert_date datetime comment "追加した日時",
	update_date datetime comment "更新した日時"
);

