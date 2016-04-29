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
"createdat" timestamptz(6),
"updatedat" timestamptz(6)
);

-- ----------------------------
-- Primary Key structure for table user
-- ----------------------------
ALTER TABLE "public"."users" ADD PRIMARY KEY ("objectid");
