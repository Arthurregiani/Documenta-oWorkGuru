# Documentação UML
Este documento contém diagramas UML criados com PlantUML. Cada seção inclui o código fonte do diagrama em PlantUML e, em seguida, a imagem correspondente ao diagrama.

## Diagrama de Interação
```plantuml
@startuml
actor Empregador as E
actor Candidato as C
participant "Sistema" as S
participant "Banco de Dados" as DB

== Criação de Conta ==
E -> S : Solicitar criação de conta (dados de empresa)
S -> DB : Inserir dados do empregador
DB --> S : Confirmação de criação de conta
S --> E : Conta criada com sucesso

C -> S : Solicitar criação de conta (dados do candidato)
S -> DB : Inserir dados do candidato
DB --> S : Confirmação de criação de conta
S --> C : Conta criada com sucesso

== Login ==
E -> S : Solicitar login (dados de autenticação)
S -> DB : Verificar dados de login do empregador
DB --> S : Confirmação de autenticação
S --> E : Login realizado com sucesso

C -> S : Solicitar login (dados de autenticação)
S -> DB : Verificar dados de login do candidato
DB --> S : Confirmação de autenticação
S --> C : Login realizado com sucesso

== Publicação de Vaga ==
E -> S : Publicar Vaga
S -> DB : Inserir dados da vaga
DB --> S : Confirmação de publicação
S --> E : Vaga publicada com sucesso

== Busca de Vaga ==
C -> S : Buscar vagas
S -> DB : Consultar vagas disponíveis
DB --> S : Retornar lista de vagas
S --> C : Exibir vagas encontradas

== Candidatura a Vaga ==
C -> S : Candidatar-se à vaga
S -> DB : Registrar candidatura do candidato
DB --> S : Confirmação de candidatura
S --> C : Candidatura realizada com sucesso

== Feedback da Candidatura ==
E -> S : Atualizar status da candidatura
S -> DB : Atualizar status na candidatura
DB --> S : Confirmação de atualização
S --> C : Notificação de atualização do status

@enduml
```
![Diagrama de Interação](./Diagrama%20de%20Interação.png)

## Diagrama de Classes
```plantuml
@startuml

class Usuario {
    + id: INT
    + email: VARCHAR(45)
    + senha: VARCHAR(45)
    + realizarCadastro(): void
    + realizarLogin(): void
    + editarPerfil(): void
}

class Pessoa {
    + nome: VARCHAR(45)
    + cpf: VARCHAR(14)
    + candidatarSeParaVaga(vaga: Vaga): void
    + procurarPorVaga(): List<Vaga>
}

class Empresa {
    + nomeEmpresa: VARCHAR(45)
    + cnpj: VARCHAR(14)
    + cadastrarVaga(vaga: Vaga): void
    + selecionarCandidatos(vaga: Vaga): List<Pessoa>
    + editarVagas(vaga: Vaga): void
}

class Vaga {
    + id: INT
    + titulo: VARCHAR(45)
    + areaAtuacao: VARCHAR(45)
    + salario: DECIMAL
    + status: VARCHAR(20)
    + descricao: VARCHAR(500)
}

class Candidatura {
    + id: INT
    + dataCandidatura: DATE
    + status: VARCHAR(20)
    + atualizarStatus(novoStatus: VARCHAR): void
}

Usuario <|-- Pessoa
Usuario <|-- Empresa

Pessoa "1" -- "0..*" Candidatura
Empresa "1" -- "0..*" Vaga
Vaga "1" -- "0..*" Candidatura

@enduml
```
![Diagrama de Classes](./Diagrama%20de%20Classes.png)


## Diagrama de Atividades
```plantuml
@startuml
start

:Login;
:Procurar por vaga;
if (Vaga encontrada?) then (sim)
    :Visualizar detalhes da vaga;
    :Candidatar-se para vaga;
    if (Candidatura realizada?) then (sim)
        :Aguardar resposta da empresa;
        if (Resposta recebida?) then (sim)
            :Visualizar status da candidatura;
        else (não)
            :Status "Aguardando resposta";
        endif
    else (não)
        :Erro ao candidatar-se;
    endif
else (não)
    :Exibir mensagem de vaga não encontrada;
endif

stop
@enduml
```
![Diagrama de Atividades](./Diagrama%20de%20Atividades.png)

## Diagrama de Casos de Uso
```plantuml
@startuml
actor Pessoa
actor Empresa

rectangle WorkGuru {
    usecase "Realizar Cadastro" as UC_Cadastro
    usecase "Realizar Login" as UC_Login
    usecase "Editar Perfil" as UC_EditarPerfil
    usecase "Procurar Vaga" as UC_ProcurarVaga
    usecase "Candidatar-se para Vaga" as UC_CandidatarVaga
    usecase "Visualizar Status da Candidatura" as UC_VisualizarStatus
    usecase "Cadastrar Vaga" as UC_CadastrarVaga
    usecase "Editar Vaga" as UC_EditarVaga
    usecase "Selecionar Candidatos" as UC_SelecionarCandidatos

    Pessoa --> UC_Cadastro
    Pessoa --> UC_Login
    Pessoa --> UC_EditarPerfil
    Pessoa --> UC_ProcurarVaga
    Pessoa --> UC_CandidatarVaga
    Pessoa --> UC_VisualizarStatus

    Empresa --> UC_Cadastro
    Empresa --> UC_Login
    Empresa --> UC_EditarPerfil
    Empresa --> UC_CadastrarVaga
    Empresa --> UC_EditarVaga
    Empresa --> UC_SelecionarCandidatos

    UC_CandidatarVaga .> UC_ProcurarVaga : <<include>>
    UC_VisualizarStatus .> UC_CandidatarVaga : <<extend>>
    UC_EditarVaga .> UC_CadastrarVaga : <<extend>>
}
@enduml
```
![Diagrama de Casos de uso](./Diagrama%20de%20casos%20de%20uso.png)

## Diagrama Estrutural
```plantuml
@startuml

entity endereco {
    + id : INT
    --
    logradouro : VARCHAR(100)
    numero : INT
    complemento : VARCHAR(45)
    bairro : VARCHAR(45)
    cidade : VARCHAR(45)
    estado : VARCHAR(2)
    pais : VARCHAR(50)
}

entity empresa {
    + id : INT
    --
    nome_empresa : VARCHAR(45)
    cnpj : VARCHAR(14)
    telefone : VARCHAR(20)
    descricao : VARCHAR(500)
    link_site : VARCHAR(45)
    usuario_id : INT
    endereco_id : INT
}

entity usuario {
    + id : INT
    --
    email : VARCHAR(45)
    senha : VARCHAR(45)
    tipo_usuario : VARCHAR(1)
}

entity pessoa {
    + id : INT
    --
    nome : VARCHAR(45)
    cpf : VARCHAR(14)
    telefone : VARCHAR(20)
    status : VARCHAR(45)
    data_nascimento : DATE
    genero : VARCHAR(10)
    usuario_id : INT
    endereco_id : INT
}

entity formacao {
    + id : INT
    --
    nome_instituicao : VARCHAR(45)
    curso : VARCHAR(45)
    grau : VARCHAR(20)
    periodo_inicio : DATE
    periodo_fim : DATE
    pessoa_id : INT
}

entity historico_profissional {
    + id : INT
    --
    nome_empresa : VARCHAR(60)
    periodo_inicio : DATE
    periodo_fim : DATE
    cargo : VARCHAR(45)
    descricao : VARCHAR(500)
    pessoa_id : INT
}

entity vaga {
    + id : INT
    --
    titulo : VARCHAR(45)
    area_atuacao : VARCHAR(45)
    tecnologia : VARCHAR(45)
    descricao : VARCHAR(500)
    nivel : VARCHAR(45)
    modelo : VARCHAR(45)
    salario : VARCHAR(45)
    status : VARCHAR(45)
    cidade : VARCHAR(45)
    estado : VARCHAR(2)
    data_publicacao : DATE
    empresa_id : INT
}

entity r_vaga_pessoa {
    + vaga_id : INT
    + pessoa_id : INT
}

empresa ||--o{ endereco : possui
empresa ||--o{ usuario : usa
pessoa ||--o{ endereco : reside
pessoa ||--o{ usuario : possui
pessoa ||--o{ formacao : tem
pessoa ||--o{ historico_profissional : possui
vaga ||--o{ empresa : pertence
pessoa ||--o{ r_vaga_pessoa : aplica
vaga ||--o{ r_vaga_pessoa : candidatar-se

@enduml
```
![Diagrama Estrutural](./Diagrama%20Estrutural.png)
