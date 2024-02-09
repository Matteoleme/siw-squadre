
INSERT INTO public.utente (id, cognome, email, nome) VALUES (1, 'Mastranza', 'matteo@email.com', 'Matteo');
INSERT INTO public.utente (id, cognome, email, nome) VALUES (2, 'Rossi', 'mario.rossi@gmail.com', 'Mario');
INSERT INTO public.utente (id, cognome, email, nome) VALUES (4, 'Abete', 'Luca@abete.it', 'Luca');
INSERT INTO public.utente (id, cognome, email, nome) VALUES (52, 'De Laurentiis', 'adl@email.com', 'Aurelio');
INSERT INTO public.utente (id, cognome, email, nome) VALUES (102, 'Scaroni', 'p.scaroni@email.com', 'Paolo');



INSERT INTO public.credenziali (id, utente_id, password, ruolo, username) VALUES (1, 1, '$2a$10$KlUQC1onLonh91ONOIW4/OJrBsJk0FgNwlGUvsn5VgPMogmA4VaHC', 'ADMIN', 'matteo');
INSERT INTO public.credenziali (id, utente_id, password, ruolo, username) VALUES (2, 2, '$2a$10$SLzuRG5smqAN2Ne1Xo7vH.S.Eaxqigub3aWtYqcAy6oyZ5p4CgilW', 'DEFAULT', 'admin');
INSERT INTO public.credenziali (id, utente_id, password, ruolo, username) VALUES (4, 4, '$2a$10$7.k8Wc3JJrbPOIB8uQHl0.zbRcre0enM4tFMzL/0ORfO.Ra.kszIa', 'DEFAULT', 'Pino');
INSERT INTO public.credenziali (id, utente_id, password, ruolo, username) VALUES (52, 52, '$2a$10$L4UFZOO4PY2QrcY4gDpIxeqIel7LJPskkyO..kBErVBkOTKKYwHIC', 'PRESIDENTE', 'adl');
INSERT INTO public.credenziali (id, utente_id, password, ruolo, username) VALUES (102, 102, '$2a$10$JkwwxbfmsK7HvOEqHEN6O.x0T8FRcXkcKGqzehkJ62V/g0l2jtkkO', 'PRESIDENTE', 'p.scaroni');


INSERT INTO public.presidente (data_di_nascita, id, cf, cognome, luogo_nascita, nome) VALUES ('1949-04-24', 2, 'DLRRLA49D24H501Z', 'De Laurentiis', 'Roma', 'Aurelio');
INSERT INTO public.presidente (data_di_nascita, id, cf, cognome, luogo_nascita, nome) VALUES ('1965-02-27', 3, 'FRDTMS65B27Z404S', 'Friedkin', 'San Diego (USA)', 'Thomas Daniel');
INSERT INTO public.presidente (data_di_nascita, id, cf, cognome, luogo_nascita, nome) VALUES ('1957-05-09', 52, 'LTTCLD57E09H501M', 'Lotito', 'Roma', 'Claudio');
INSERT INTO public.presidente (data_di_nascita, id, cf, cognome, luogo_nascita, nome) VALUES ('1978-06-11', 53, 'GVNSNS78H11V220J', 'Sensi', 'Genova', 'Giovannino');
INSERT INTO public.presidente (data_di_nascita, id, cf, cognome, luogo_nascita, nome) VALUES ('1963-12-07', 102, 'GNLFRR63T07L219T', 'Ferrero', 'Torino', 'Gianluca');
INSERT INTO public.presidente (data_di_nascita, id, cf, cognome, luogo_nascita, nome) VALUES ('1978-04-02', 152, 'RVLDNL78D02G283A', 'Iervolino', 'Napoli', 'Danilo');
INSERT INTO public.presidente (data_di_nascita, id, cf, cognome, luogo_nascita, nome) VALUES ('1946-11-28', 202, 'SCRPLA46S28L840U', 'Scaroni', 'Vicenza', 'Paolo');
INSERT INTO public.presidente (data_di_nascita, id, cf, cognome, luogo_nascita, nome) VALUES ('1964-09-25', 252, 'JYOSPT64P25Z401L', 'Saputo', 'Montréal Canada', 'Joey');
INSERT INTO public.presidente (data_di_nascita, id, cf, cognome, luogo_nascita, nome) VALUES ('1991-12-21', 10, 'ZHNSVN91T21Z210F', 'Zhang', 'Nanchino Cina', 'Steven');


INSERT INTO public.squadra (anno_fondazione, id, presidente_id, indirizzo_sede, nome) VALUES (1897, 152, 102, 'Via Druento 175', 'Juventus');
INSERT INTO public.squadra (anno_fondazione, id, presidente_id, indirizzo_sede, nome) VALUES (1926, 2, 2, 'Via del Maio di Porto 9', 'Napoli');
INSERT INTO public.squadra (anno_fondazione, id, presidente_id, indirizzo_sede, nome) VALUES (1927, 202, NULL, 'Viale Tolstoj 4', 'Roma');
INSERT INTO public.squadra (anno_fondazione, id, presidente_id, indirizzo_sede, nome) VALUES (1899, 252, 202, 'Via Aldo Rossi, 8', 'Milan');
INSERT INTO public.squadra (anno_fondazione, id, presidente_id, indirizzo_sede, nome) VALUES (1926, 302, NULL, 'Viale Manfredo Fanti n. 4', 'Fiorentina');
INSERT INTO public.squadra (anno_fondazione, id, presidente_id, indirizzo_sede, nome) VALUES (1909, 352, NULL, ' via Casteldebole 10', 'Bologna');
INSERT INTO public.squadra (anno_fondazione, id, presidente_id, indirizzo_sede, nome) VALUES (1908, 402, NULL, 'Corso Vittorio Emanuele II', 'Inter');
INSERT INTO public.squadra (anno_fondazione, id, presidente_id, indirizzo_sede, nome) VALUES (1900, 403, 52, 'Via di Santa Cornelia 1000', 'Lazio');



INSERT INTO public.giocatore (data_di_nascita, id, squadra_id, cognome, nome, ruolo, nazionalita, fine_tesseramento, inizio_tesseramento) VALUES ('1997-10-02', 55, NULL, 'Abraham', 'Tammy', 'attaccante', 'Inglese', NULL, NULL);
INSERT INTO public.giocatore (data_di_nascita, id, squadra_id, cognome, nome, ruolo, nazionalita, fine_tesseramento, inizio_tesseramento) VALUES ('2001-02-12', 53, 2, 'Kvaratskhelia', 'Khvicha', 'attaccante', 'Georgiana', '2028-06-01', '2022-06-10');
INSERT INTO public.giocatore (data_di_nascita, id, squadra_id, cognome, nome, ruolo, nazionalita, fine_tesseramento, inizio_tesseramento) VALUES ('1976-09-27', 52, NULL, 'Totti', 'Francesco', 'attaccante', 'Italiana', NULL, NULL);
INSERT INTO public.giocatore (data_di_nascita, id, squadra_id, cognome, nome, ruolo, nazionalita, fine_tesseramento, inizio_tesseramento) VALUES ('1998-12-29', 152, 2, 'Osimhen', 'Victor James', 'attaccante', 'Nigeriana', '2025-06-01', '2022-07-20');
INSERT INTO public.giocatore (data_di_nascita, id, squadra_id, cognome, nome, ruolo, nazionalita, fine_tesseramento, inizio_tesseramento) VALUES ('1999-06-10', 102, 252, 'Leão', 'Rafael', 'attaccante', 'Portoghese', '2025-06-01', '2021-01-10');
INSERT INTO public.giocatore (data_di_nascita, id, squadra_id, cognome, nome, ruolo, nazionalita, fine_tesseramento, inizio_tesseramento) VALUES ('1999-04-13', 54, NULL, 'Bastoni', 'Alessandro', 'difensore', 'Italiana', NULL, NULL);
INSERT INTO public.giocatore (data_di_nascita, id, squadra_id, cognome, nome, ruolo, nazionalita, fine_tesseramento, inizio_tesseramento) VALUES ('1995-07-03', 202, 252, 'Maignan', 'Mike', 'portiere', 'Francese', '2025-06-01', '2023-08-28');
INSERT INTO public.giocatore (data_di_nascita, id, squadra_id, cognome, nome, ruolo, nazionalita, fine_tesseramento, inizio_tesseramento) VALUES ('1997-12-19', 252, 252, 'Tomori', 'Fikayo', 'difensore', 'Inglese', '2026-06-30', '2022-08-16');
INSERT INTO public.giocatore (data_di_nascita, id, squadra_id, cognome, nome, ruolo, nazionalita, fine_tesseramento, inizio_tesseramento) VALUES ('1995-04-03', 10, NULL, 'Rabiot', 'Adrien', 'centrocampista', 'Francese', NULL, NULL);
INSERT INTO public.giocatore (data_di_nascita, id, squadra_id, cognome, nome, ruolo, nazionalita, fine_tesseramento, inizio_tesseramento) VALUES ('1988-09-03', 11, NULL, 'Boateng', 'Jerome', 'difensore', 'Tedesco', NULL, NULL);
INSERT INTO public.giocatore (data_di_nascita, id, squadra_id, cognome, nome, ruolo, nazionalita, fine_tesseramento, inizio_tesseramento) VALUES ('1994-08-01', 15, NULL, 'Berardi', 'Domenico', 'attaccante', 'Italiano', NULL, NULL);


SELECT pg_catalog.setval('public.credenziali_seq', 151, true);


SELECT pg_catalog.setval('public.giocatore_seq', 301, true);



SELECT pg_catalog.setval('public.presidente_seq', 301, true);


SELECT pg_catalog.setval('public.squadra_seq', 451, true);



SELECT pg_catalog.setval('public.utente_seq', 151, true);

