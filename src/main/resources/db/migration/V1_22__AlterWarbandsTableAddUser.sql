
alter table warband add column user_id INTEGER NOT NULL;


ALTER TABLE warband ADD CONSTRAINT FK_warband_id FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE;

