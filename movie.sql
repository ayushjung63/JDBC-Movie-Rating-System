create table movie
(
    id             bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name           varchar(255) not null,
    genre          varchar(255),
    rating         numeric,
    watched_status bool
);

select * from movie;

INSERT INTO movie (name, genre, rating, watched_status)
VALUES
    ('Inception', 'Sci-Fi', 8.8, true),
    ('The Godfather', 'Crime', 9.2, true),
    ('Spirited Away', 'Animation', 8.6, false),
    ('Parasite', 'Thriller', 8.6, true),
    ('The Dark Knight', 'Action', 9.0, false);