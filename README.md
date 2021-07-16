# Sistema de Votação

Aplicação backend feita utilizando Java 11 e Postgresql.
Apresenta as seguintes funcionalidades: Criar uma pauta, abrir sessão de votação, votar e mostrar o resultado da pauta.

## Criar uma Pauta

> POST /topic/create

Entrada:

    {
		"description": "descrição"
	}


## Abrir Sessão de votação
Os votos só podem ser computado para a pauta caso a sessão de votação esteja aberta. Ela permanece aberta por 1 minuto, e depois fecha automaticamente

> PUT /topic/open-session/{id}

Sendo {id} o id da pauta para a qual se deseja abrir a votação


## Votar

> POST /vote

Entrada:

    {
    	"vote": "voto",
    	"document": "cpf",
    	"topic": id da pauta
    }

O voto só será considerado se escrito "SIM" ou "NÃO", exatamente com essa grafia. 
O cpf também é checado se é válido. 
A pauta deve existir.

## Mostrar o resultado

> GET topic/result/{id}

Sendo {id} o id da pauta para a qual se deseja saber o resultado da votação
