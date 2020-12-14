CREATE TABLE public.demo_ordem_servico (
  id SERIAL NOT NULL PRIMARY KEY,
  cliente_id bigint NOT NULL,
  descricao text NOT NULL,
  preco decimal(10,2) NOT NULL,
  status varchar(20) NOT NULL,
  data_abertura timestamp NOT NULL,
  data_finalizacao timestamp
);

ALTER TABLE demo_ordem_servico
    ADD CONSTRAINT fk_ordem_servico_cliente
        FOREIGN KEY (cliente_id) REFERENCES public.demo_cliente (id);
