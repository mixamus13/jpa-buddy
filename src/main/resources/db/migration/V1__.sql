CREATE TABLE article
(
    id               BIGINT NOT NULL,
    title            VARCHAR(100),
    article_text     VARCHAR(3000),
    publication_date date,
    CONSTRAINT pk_article PRIMARY KEY (id)
);

CREATE TABLE article_authors
(
    article_id BIGINT NOT NULL,
    authors_id BIGINT NOT NULL,
    CONSTRAINT pk_article_authors PRIMARY KEY (article_id, authors_id)
);

CREATE TABLE author
(
    id    BIGINT       NOT NULL,
    name  VARCHAR(255) NOT NULL,
    age   BIGINT,
    email VARCHAR(70),
    bio   VARCHAR(255),
    CONSTRAINT pk_author PRIMARY KEY (id)
);

CREATE TABLE award
(
    id        BIGINT NOT NULL,
    author_id BIGINT,
    CONSTRAINT pk_award PRIMARY KEY (id)
);

CREATE TABLE comment
(
    id         BIGINT       NOT NULL,
    text       VARCHAR(255) NOT NULL,
    article_id BIGINT,
    author_id  BIGINT,
    details    VARCHAR,
    CONSTRAINT pk_comment PRIMARY KEY (id)
);

CREATE INDEX idx_article_title ON article (title);

ALTER TABLE award
    ADD CONSTRAINT FK_AWARD_ON_AUTHOR FOREIGN KEY (author_id) REFERENCES author (id);

ALTER TABLE comment
    ADD CONSTRAINT FK_COMMENT_ON_ARTICLE FOREIGN KEY (article_id) REFERENCES article (id);

ALTER TABLE comment
    ADD CONSTRAINT FK_COMMENT_ON_AUTHOR FOREIGN KEY (author_id) REFERENCES author (id);

ALTER TABLE article_authors
    ADD CONSTRAINT fk_artaut_on_article FOREIGN KEY (article_id) REFERENCES article (id);

ALTER TABLE article_authors
    ADD CONSTRAINT fk_artaut_on_author FOREIGN KEY (authors_id) REFERENCES author (id);