CREATE TABLE public.demo_cliente (
  id SERIAL NOT NULL PRIMARY KEY,
  nome varchar(60) NOT NULL,
  email varchar(255) NOT NULL,
  telefone varchar(20) NOT NULL,
  cpf varchar(11) NOT NULL
);
