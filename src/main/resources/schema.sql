-- ----------------------------
-- Table structure for gift
-- ----------------------------
DROP TABLE IF EXISTS "public"."gift";
CREATE TABLE "public"."gift" (
"objectid" varchar(20) COLLATE "default" NOT NULL,
"giftcity" varchar(20) COLLATE "default",
"giftdistrict" varchar(20) COLLATE "default",
"giftname" varchar(100) COLLATE "default",
"giftdescription" varchar(1000) COLLATE "default",
"giftreceivecondition" varchar(255) COLLATE "default",
"giftimage" varchar(150) COLLATE "default",
"giftsmallimage" varchar(150) COLLATE "default",
"giftlikecount" int8,
"isremoved" bool,
"issoldout" bool,
"giftlatitude" numeric,
"giftlongitude" numeric,
"userid" varchar(20) COLLATE "default",
"createdat" timestamptz(0),
"updatedat" timestamptz(0)
);

-- ----------------------------
-- Primary Key structure for table gift
-- ----------------------------
ALTER TABLE "public"."gift" ADD PRIMARY KEY ("objectid");

-- ----------------------------
-- Table structure for trade
-- ----------------------------
DROP TABLE IF EXISTS "public"."trade";
CREATE TABLE "public"."trade" (
"objectid" varchar(20) COLLATE "default" NOT NULL,
"giftid" varchar(20) COLLATE "default",
"posterid" varchar(20) COLLATE "default",
"tradetouserid" varchar(20) COLLATE "default",
"createdat" timestamptz(6),
"updatedat" timestamptz(6)
);

-- ----------------------------
-- Primary Key structure for table trade
-- ----------------------------
ALTER TABLE "public"."trade" ADD PRIMARY KEY ("objectid");

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS "public"."users";
CREATE TABLE "public"."users" (
"objectid" varchar(20) COLLATE "default" NOT NULL,
"email" varchar(50) COLLATE "default",
"userphotourl" varchar(150) COLLATE "default",
"imageurl" varchar(150) COLLATE "default",
"userimage" varchar(150) COLLATE "default",
"city" varchar(20) COLLATE "default",
"area" varchar(20) COLLATE "default",
"intro" varchar(200) COLLATE "default",
"sendgiftcount" int8,
"receivedgiftcount" int8,
"username" varchar(50) COLLATE "default",
"accountname" varchar(50) COLLATE "default",
"authtype" varchar(20) COLLATE "default",
"authid" varchar(50) COLLATE "default",
"authaccesstoken" varchar(300) COLLATE "default",
"authexpirationdate" timestamptz(6),
"createdat" timestamptz(6),
"updatedat" timestamptz(6)
);

-- ----------------------------
-- Primary Key structure for table user
-- ----------------------------
ALTER TABLE "public"."users" ADD PRIMARY KEY ("objectid");


-- ----------------------------
-- Table structure for follow
-- ----------------------------
DROP TABLE IF EXISTS "public"."follow";
CREATE TABLE "public"."follow" (
"objectid" varchar(20) COLLATE "default" NOT NULL,
"giftid" varchar(20) COLLATE "default",
"posterid" varchar(20) COLLATE "default",
"followerid" varchar(20) COLLATE "default",
"createdat" timestamptz(6),
"updatedat" timestamptz(6)
);
-- ----------------------------
-- Primary Key structure for table follow
-- ----------------------------
ALTER TABLE "public"."follow" ADD PRIMARY KEY ("objectid");


-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS "public"."comment";
CREATE TABLE "public"."comment" (
"objectid" varchar(20) COLLATE "default" NOT NULL,
"giftid" varchar(20) COLLATE "default",
"giftname" varchar(100) COLLATE "default",
"isinvitedtrading" bool,
"posterid" varchar(20) COLLATE "default",
"posteraccountname" varchar(50) COLLATE "default",
"commentposterid" varchar(20) COLLATE "default",
"senderaccountname" varchar(50) COLLATE "default",
"type" int8,
"content" varchar(500) COLLATE "default",
"createdat" timestamptz(6),
"updatedat" timestamptz(6)
);
-- ----------------------------
-- Primary Key structure for table comment
-- ----------------------------
ALTER TABLE "public"."comment" ADD PRIMARY KEY ("objectid");


-- ----------------------------
-- Table structure for notification
-- ----------------------------
DROP TABLE IF EXISTS "public"."notification";
CREATE TABLE "public"."notification" (
"objectid" varchar(20) COLLATE "default" NOT NULL,
"giftid" varchar(20) COLLATE "default",
"isread" bool,
"message" varchar(200) COLLATE "default",
"notificationtype" int8,
"posterid" varchar(20) COLLATE "default",
"receivedid" varchar(20) COLLATE "default",
"senderid" varchar(20) COLLATE "default",
"createdat" timestamptz(6),
"updatedat" timestamptz(6)
);
-- ----------------------------
-- Primary Key structure for table notification
-- ----------------------------
ALTER TABLE "public"."notification" ADD PRIMARY KEY ("objectid");


-- ----------------------------
-- Table structure for session
-- ----------------------------
DROP TABLE IF EXISTS "public"."session";
CREATE TABLE "public"."session" (
"objectid" varchar(20) COLLATE "default" NOT NULL,
"restricted" bool,
"sessiontoken" varchar(50) COLLATE "default",
"createdaction" varchar(20) COLLATE "default",
"authprovider" varchar(20) COLLATE "default",
"userid" varchar(20) COLLATE "default",
"createdat" timestamptz(6),
"updatedat" timestamptz(6)
);
-- ----------------------------
-- Primary Key structure for table session
-- ----------------------------
ALTER TABLE "public"."session" ADD PRIMARY KEY ("objectid");


-- ----------------------------
-- Table structure for installation
-- ----------------------------
DROP TABLE IF EXISTS "public"."installation";
CREATE TABLE "public"."installation" (
"objectid" varchar(20) COLLATE "default" NOT NULL,
"gcmsenderid" varchar(100) COLLATE "default",
"devicetoken" varchar(100) COLLATE "default",
"localeidentifier" varchar(20) COLLATE "default",
"badge" int8,
"parseversion" varchar(20) COLLATE "default",
"clientid" varchar(20) COLLATE "default",
"userid" varchar(20) COLLATE "default",
"appidentifier" varchar(50) COLLATE "default",
"appname" varchar(50) COLLATE "default",
"devicetype" varchar(20) COLLATE "default",
"installationid" varchar(50) COLLATE "default",
"appversion" varchar(20) COLLATE "default",
"timezone" varchar(50) COLLATE "default",
"createdat" timestamptz(6),
"updatedat" timestamptz(6)
);
-- ----------------------------
-- Primary Key structure for table installation
-- ----------------------------
ALTER TABLE "public"."installation" ADD PRIMARY KEY ("objectid");