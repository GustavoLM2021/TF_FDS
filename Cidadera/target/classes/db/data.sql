
INSERT INTO reclamacao (idr,ano,mes,dia,idautor,idbairro,idcategoria,rstatus,titulo,descricao,endereco) VALUES ( 1,2004,12,1,99999,7,666,'encerrado','communism','reds are here','murica');
INSERT INTO reclamacao (idr,ano,mes,dia,idautor,idbairro,idcategoria,rstatus,titulo,descricao,endereco) VALUES ( 2,204,1,4,6666,8,777,'aberto','capitalis',' here','pagman');


INSERT INTO usuario (idusu,name,admin,oficial) VALUES (101856,'ropo',false,false);
INSERT INTO usuario (idusu,name,admin,oficial) VALUES (789433,'lizard',true,false);
INSERT INTO usuario (idusu,name,admin,oficial) VALUES (666666,'doom',false,true);

INSERT INTO comentario (coment,idcoment,idrparent,idautorcoment) VALUES ('Top priority 1b',111,1,33333);
INSERT INTO comentario (coment,idcoment,idrparent,idautorcoment) VALUES ('Top priority 1a',111,1,33333);
INSERT INTO comentario (coment,idcoment,idrparent,idautorcoment) VALUES ('Top priority 2b',111,2,33333);
INSERT INTO comentario (coment,idcoment,idrparent,idautorcoment) VALUES ('Top priority 2a',111,2,33333);