# recruiters
MVP para controle do processo de contratação

# Como criar um banco em docker
- Criar nova instancia local chamada mysql-local, escutando na porta 3306 (primeira vez)
sudo docker run -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root --name mysql-local -d mysql
- Conectar por terminal no mysql criado
docker exec -it mysql-local mysql -uroot -proot
- Criar banco por linha de comandos
create database recruiters;
- Usar o banco
use recruiters
- Mostrar as tabelas
show tables;
- Levantar a instancia de docker (após reiniciar)
docker start mysql-local
