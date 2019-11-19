ALTER TABLE todo ADD COLUMN project_id BIGINT REFERENCES project;

CREATE INDEX index_todo_on_project ON todo (project_id);
