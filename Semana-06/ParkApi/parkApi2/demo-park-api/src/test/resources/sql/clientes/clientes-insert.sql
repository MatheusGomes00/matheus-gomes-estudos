insert into USUARIOS (id, username, password, role) values (100, 'pedro@email.com', '$2a$12$TBD0hbc0opCmOptBxjDoMuBb8PScsRU74JGfWgJX3YDOIy47Te9P2', 'ROLE_ADMIN');
insert into USUARIOS (id, username, password, role) values (101, 'julia@email.com', '$2a$12$TBD0hbc0opCmOptBxjDoMuBb8PScsRU74JGfWgJX3YDOIy47Te9P2', 'ROLE_CLIENTE');
insert into USUARIOS (id, username, password, role) values (102, 'ana@email.com', '$2a$12$TBD0hbc0opCmOptBxjDoMuBb8PScsRU74JGfWgJX3YDOIy47Te9P2', 'ROLE_CLIENTE');
insert into USUARIOS (id, username, password, role) values (103, 'matias@email.com', '$2a$12$VQSVztr/M8tcwzcy9jJgFebpqybKpF4FVwM3zilhOAI4yL1iW3rJa', 'ROLE_CLIENTE');

insert into CLIENTES (id, nome, cpf, id_usuario) values (10, 'Julia Romana', '79074426050', 101);
insert into CLIENTES (id, nome, cpf, id_usuario) values (20, 'Ana Cherosa', '55352517047', 102);