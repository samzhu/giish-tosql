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

DROP TABLE IF EXISTS "public"."trade";
CREATE TABLE "public"."trade" (
"objectid" varchar(20) COLLATE "default" NOT NULL,
"giftid" varchar(20) COLLATE "default",
"posterid" varchar(20) COLLATE "default",
"tradetouserid" varchar(20) COLLATE "default",
"createdat" timestamptz(6),
"updatedat" timestamptz(6)
);