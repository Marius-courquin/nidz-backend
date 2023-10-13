CREATE TABLE "users" (
  "id" uuid PRIMARY KEY,
  "last_name" varchar,
  "first_name" varchar,
  "birth_date" date,
  "gender" varchar,
  "avatar" varchar,
  "country" varchar,
  "email" varchar,
  "phone" varchar,
  "created_at" timestamp,
  "updated_at" timestamp,
  "created_by" uuid,
  "updated_by" uuid
);

CREATE TABLE "homes" (
  "id" uuid PRIMARY KEY,
  "owner" uuid,
  "floor" varchar,
  "resident" uuid,
  "num" int,
  "building" uuid,
  "created_at" timestamp,
  "updated_at" timestamp,
  "created_by" uuid,
  "updated_by" uuid
);

CREATE TABLE "users_homes" (
  "home" uuid,
  "user" uuid,
  "role" varchar,
  PRIMARY KEY ("home", "user")
);

CREATE TABLE "buildings" (
  "id" uuid PRIMARY KEY,
  "address" uuid,
  "residence" uuid,
  "number_of_floors" int,
  "has_elevator" boolean,
  "created_at" timestamp,
  "updated_at" timestamp,
  "created_by" uuid,
  "updated_by" uuid
);

CREATE TABLE "addresses" (
  "id" uuid PRIMARY KEY,
  "street" varchar,
  "num" int,
  "city" varchar,
  "post_code" int,
  "country" varchar,
  "latitude" float,
  "longitude" float
);

CREATE TABLE "residences" (
  "id" uuid PRIMARY KEY,
  "name" varchar,
  "description" varchar,
  "syndicate" uuid,
  "created_at" timestamp,
  "updated_at" timestamp,
  "created_by" uuid,
  "updated_by" uuid
);

CREATE TABLE "residences_managers" (
  "manager" uuid,
  "residence" uuid,
  PRIMARY KEY ("manager", "residence")
);

CREATE TABLE "syndicates" (
  "id" uuid PRIMARY KEY,
  "name" varchar,
  "address" uuid,
  "created_at" timestamp,
  "updated_at" timestamp,
  "created_by" uuid,
  "updated_by" uuid
);

CREATE TABLE "users_syndicates" (
  "id" uuid PRIMARY KEY,
  "user" uuid,
  "syndicate" uuid,
  "role" varchar
);

CREATE TABLE "subscriptions" (
  "id" uuid PRIMARY KEY,
  "package" varchar,
  "syndicate" uuid,
  "residence" uuid,
  "created_at" timestamp,
  "updated_at" timestamp,
  "created_by" uuid,
  "updated_by" uuid
);

CREATE TABLE "tickets" (
  "id" uuid PRIMARY KEY,
  "tittle" varchar,
  "description" varchar,
  "status" varchar,
  "type" varchar,
  "assign_to" uuid,
  "urgency" varchar,
  "priority" varchar,
  "solution" varchar,
  "completion_code" int,
  "user" uuid,
  "home" uuid,
  "created_at" timestamp,
  "updated_at" timestamp,
  "created_by" uuid,
  "updated_by" uuid
);

CREATE TABLE "impact_zones" (
  "id" uuid PRIMARY KEY,
  "ticket" uuid,
  "type" varchar,
  "zone" uuid
);

CREATE TABLE "attachments" (
  "id" uuid PRIMARY KEY,
  "ticket" uuid,
  "url" varchar
);

CREATE TABLE "comments" (
  "id" uuid PRIMARY KEY,
  "content" varchar,
  "ticket" uuid,
  "created_at" timestamp,
  "created_by" uuid
);

ALTER TABLE "users" ADD FOREIGN KEY ("created_by") REFERENCES "users" ("id");

ALTER TABLE "users" ADD FOREIGN KEY ("updated_by") REFERENCES "users" ("id");

ALTER TABLE "homes" ADD FOREIGN KEY ("owner") REFERENCES "users" ("id");

ALTER TABLE "homes" ADD FOREIGN KEY ("resident") REFERENCES "users" ("id");

ALTER TABLE "homes" ADD FOREIGN KEY ("building") REFERENCES "buildings" ("id");

ALTER TABLE "homes" ADD FOREIGN KEY ("created_by") REFERENCES "users" ("id");

ALTER TABLE "homes" ADD FOREIGN KEY ("updated_by") REFERENCES "users" ("id");

ALTER TABLE "users_homes" ADD FOREIGN KEY ("home") REFERENCES "homes" ("id");

ALTER TABLE "users_homes" ADD FOREIGN KEY ("user") REFERENCES "users" ("id");

ALTER TABLE "buildings" ADD FOREIGN KEY ("address") REFERENCES "addresses" ("id");

ALTER TABLE "buildings" ADD FOREIGN KEY ("residence") REFERENCES "residences" ("id");

ALTER TABLE "buildings" ADD FOREIGN KEY ("created_by") REFERENCES "users" ("id");

ALTER TABLE "buildings" ADD FOREIGN KEY ("updated_by") REFERENCES "users" ("id");

ALTER TABLE "residences" ADD FOREIGN KEY ("syndicate") REFERENCES "syndicates" ("id");

ALTER TABLE "residences" ADD FOREIGN KEY ("created_by") REFERENCES "users" ("id");

ALTER TABLE "residences" ADD FOREIGN KEY ("updated_by") REFERENCES "users" ("id");

ALTER TABLE "residences_managers" ADD FOREIGN KEY ("manager") REFERENCES "users_syndicates" ("id");

ALTER TABLE "residences_managers" ADD FOREIGN KEY ("residence") REFERENCES "residences" ("id");

ALTER TABLE "syndicates" ADD FOREIGN KEY ("address") REFERENCES "addresses" ("id");

ALTER TABLE "syndicates" ADD FOREIGN KEY ("created_by") REFERENCES "users" ("id");

ALTER TABLE "syndicates" ADD FOREIGN KEY ("updated_by") REFERENCES "users" ("id");

ALTER TABLE "users_syndicates" ADD FOREIGN KEY ("user") REFERENCES "users" ("id");

ALTER TABLE "users_syndicates" ADD FOREIGN KEY ("syndicate") REFERENCES "syndicates" ("id");

ALTER TABLE "subscriptions" ADD FOREIGN KEY ("syndicate") REFERENCES "syndicates" ("id");

ALTER TABLE "subscriptions" ADD FOREIGN KEY ("residence") REFERENCES "residences" ("id");

ALTER TABLE "subscriptions" ADD FOREIGN KEY ("created_by") REFERENCES "users" ("id");

ALTER TABLE "subscriptions" ADD FOREIGN KEY ("updated_by") REFERENCES "users" ("id");

ALTER TABLE "tickets" ADD FOREIGN KEY ("assign_to") REFERENCES "users" ("id");

ALTER TABLE "tickets" ADD FOREIGN KEY ("created_by") REFERENCES "users" ("id");

ALTER TABLE "tickets" ADD FOREIGN KEY ("updated_by") REFERENCES "users" ("id");

ALTER TABLE "impact_zones" ADD FOREIGN KEY ("ticket") REFERENCES "tickets" ("id");

ALTER TABLE "attachments" ADD FOREIGN KEY ("ticket") REFERENCES "tickets" ("id");

ALTER TABLE "comments" ADD FOREIGN KEY ("ticket") REFERENCES "tickets" ("id");

ALTER TABLE "comments" ADD FOREIGN KEY ("created_by") REFERENCES "users" ("id");
