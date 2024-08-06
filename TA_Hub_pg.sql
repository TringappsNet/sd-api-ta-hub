CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE TABLE "ta_users" (
  "user_id" BIGSERIAL PRIMARY KEY,
  "role_id" integer,
  "first_name" varchar,
  "last_name" varchar,
  "username" varchar ,
  "email" varchar NOT NULL,
  "phone" varchar ,
  "reset_token" varchar,
  "password_hash" varchar ,
  "is_active" BOOLEAN ,
  "invite_token" varchar,
  "g_access_token" varchar,
  "g_access_token_created_at" timestamp,
  "g_token_expires_in" integer,
  "g_id_token" varchar,
  "current_session_id" varchar,
  "last_login_time" timestamp,
  "created_at" timestamp,
  "last_updated" TIMESTAMP
);

CREATE TABLE "ta_roles" (
  "role_id" BIGSERIAL PRIMARY KEY,
  "role" varchar NOT NULL
);

CREATE TABLE "ta_candidate_details" (
  "candidate_id" BIGSERIAL PRIMARY KEY,
  "candidate_name" varchar NOT NULL,
  "candidate_email" varchar NOT NULL,
  "candidate_contact" varchar,
  "technology" varchar,
  "total_experience" varchar,
  "current_ctc" varchar,
  "expected_ctc" varchar,
  "notice_period" varchar,
  "mode_of_work" varchar,
  "current_location" varchar,
  "candidate_status" varchar,
  "comments" varchar,
  "remarks" varchar,
  "recruiter" varchar,
  "recruited_source" varchar,
  "created_date" timestamp NOT NULL,
  "last_updated" TIMESTAMP NOT NULL
);

CREATE TABLE "ta_client_details" (
  "client_id" BIGSERIAL PRIMARY KEY,
  "client_name" varchar NOT NULL,
  "client_spoc_name" varchar,
  "client_spoc_contact" VARCHAR,
  "client_location" varchar,
  "client_logo" bytea,
  "created_at" timestamp NOT NULL,
  "last_updated" TIMESTAMP NOT NULL

);

CREATE TABLE "ta_client_requirements" (
  "job_id" BIGSERIAL PRIMARY KEY,
  "client_id" integer,
  "requirement_start_date" date,
  "client_name" varchar,
  "client_spoc_name" varchar,
  "client_spoc_contact" varchar,
  "account_manager" varchar,
  "account_manager_email" varchar,
  "total_no_of_openings" varchar,
  "salary_budget" float,
  "mode_of_interviews" varchar,
  "tentative_start_date" date,
  "tentative_duration" varchar,
  "approved_by" varchar,
  "approval_status" varchar,
  "approval_token" varchar,
  "created_at" TIMESTAMP NOT NULL,
  "last_updated" TIMESTAMP NOT NULL
);

CREATE TABLE "ta_tasks" (
  "task_id" BIGSERIAL PRIMARY KEY,
  "job_id" INTEGER NOT NULL,
  "job_title" varchar,
  "role_type" varchar,
  "mode_of_work" varchar,
  "work_location" varchar,
  "years_of_experience_required" integer,
  "primary_skill_set" varchar,
  "secondary_skill_set" varchar,
  "client_budget" varchar,
  "assigned_budget" varchar,
  "primary_assignee" varchar,
  "secondary_assignee" varchar,
  "task_status" varchar,
  "backlogs" bool,
  "approval_status" varchar,
  "description" varchar,
  "created_at" TIMESTAMP NOT NULL,
  "last_updated" TIMESTAMP NOT NULL,
  "column_id" varchar
);

CREATE TABLE "ta_task_candidates" (
  "task_candidates_id" BIGSERIAL PRIMARY KEY,
  "task_id" integer NOT NULL,
  "candidate_id" integer UNIQUE NOT NULL,
  "task_candidate_status" varchar,
  "task_candidate_comments" varchar,
  "modified_by" integer NOT NULL,
  "created_at" TIMESTAMP NOT NULL,
  "last_updated" TIMESTAMP NOT NULL

);

CREATE TABLE "ta_task_candidates_status_history" (
  "status_id" BIGSERIAL PRIMARY KEY,
  "task_id" integer NOT NULL,
  "candidate_id" integer NOT NULL,
  "task_candidate_status" varchar,
  "task_candidate_comments" varchar,
  "task_status" varchar,
  "modified_by" integer NOT NULL,
  "last_updated" TIMESTAMP NOT NULL,
  "created_at" TIMESTAMP NOT NULL

);

CREATE TABLE "ta_board" (
  "id" uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
  "columns" varchar NOT NULL

);

CREATE TABLE "ta_task_file_uploads" (
  "doc_id" BIGSERIAL PRIMARY KEY,
  "task_id" integer NOT NULL,
  "candidate_id" integer NOT NULL,
  "uploads" bytea,
  "created_at" TIMESTAMP NOT NULL,
  "last_updated" TIMESTAMP NOT NULL

);


--Views

DROP VIEW IF EXISTS ta_candidate_status_view;

CREATE VIEW ta_candidate_status_view AS
SELECT
    cd.candidate_id,
    cd.candidate_name,
    cd.candidate_email,
    cd.candidate_contact,
    cd.technology,
    cd.total_experience,
    cd.current_ctc,
    cd.expected_ctc,
    cd.notice_period,
    cd.mode_of_work AS candidate_mode_of_work,
    cd.current_location,
	cd.remarks,
	cd.recruiter,
	cd.recruited_source,
    cd.candidate_status,
	td.client_name,
    tc.task_candidate_status,
    tc.task_candidate_comments
FROM
    ta_candidate_details cd
JOIN
    ta_task_candidates tc ON cd.candidate_id = tc.candidate_id
JOIN
    ta_tasks t ON tc.task_id = t.task_id
JOIN
    ta_client_requirements cr ON t.job_id = cr.job_id
JOIN
    ta_client_details td ON cr.client_id = td.client_id;



DROP VIEW IF EXISTS ta_client_jobs_view;

CREATE VIEW ta_client_jobs_view AS
SELECT
    c.client_id,
    c.client_name,
    c.client_spoc_name,
    c.client_spoc_contact,
    c.client_location,
    c.client_logo,
    c.created_at,
    c.last_updated,
    t.task_id,
    t.job_title
FROM
    ta_client_details c
JOIN
    ta_client_requirements cr ON c.client_id = cr.client_id
JOIN
    ta_tasks t ON cr.job_id = t.job_id;



DROP VIEW IF EXISTS ta_task_view;

CREATE VIEW ta_task_view AS
SELECT
    t.task_id,
    t.job_id,
    t.job_title,
    t.role_type,
    t.mode_of_work,
    t.work_location,
    t.years_of_experience_required,
    t.primary_skill_set,
    t.secondary_skill_set,
    t.client_budget,
    t.assigned_budget,
    t.primary_assignee,
    t.secondary_assignee,
    t.task_status,
    t.backlogs,
    t.description,
	t.approval_status,
    t.created_at,
    t.last_updated,
    cd.client_name
FROM
    ta_tasks t
JOIN
    ta_client_requirements cr ON t.job_id = cr.job_id
JOIN
    ta_client_details cd ON cr.client_id = cd.client_id;





ALTER TABLE "ta_users" ADD FOREIGN KEY ("role_id") REFERENCES "ta_roles" ("role_id");

ALTER TABLE "ta_task_candidates" ADD FOREIGN KEY ("task_id") REFERENCES "ta_tasks" ("task_id");

ALTER TABLE "ta_task_candidates" ADD FOREIGN KEY ("candidate_id") REFERENCES "ta_candidate_details" ("candidate_id");

ALTER TABLE "ta_task_candidates" ADD FOREIGN KEY ("modified_by") REFERENCES "ta_users" ("user_id");

ALTER TABLE "ta_task_candidates_status_history" ADD FOREIGN KEY ("candidate_id") REFERENCES "ta_candidate_details" ("candidate_id");

ALTER TABLE "ta_task_candidates_status_history" ADD FOREIGN KEY ("modified_by") REFERENCES "ta_users" ("user_id");

ALTER TABLE "ta_task_candidates_status_history" ADD FOREIGN KEY ("task_id") REFERENCES "ta_tasks" ("task_id");

ALTER TABLE "ta_client_requirements" ADD FOREIGN KEY ("client_id") REFERENCES "ta_client_details" ("client_id");

ALTER TABLE "ta_task_file_uploads" ADD FOREIGN KEY ("task_id") REFERENCES "ta_tasks" ("task_id");

ALTER TABLE "ta_tasks" ADD FOREIGN KEY ("job_id") REFERENCES "ta_client_requirements" ("job_id");