# 🏥 Sistema de Gestão Hospitalar — MedManager

Um sistema de gestão hospitalar completo desenvolvido em **Java 11+** utilizando o padrão de arquitetura **MVC (Model-View-Controller)** de forma estrita, com persistência de dados local baseada em arquivos **JSON**. 

O projeto foi projetado de forma modular, simulando o ecossistema real de uma clínica ou hospital, onde diferentes módulos interagem entre si para gerenciar desde o fluxo de pacientes até o histórico clínico em prontuários.

---

## 🚀 Funcionalidades do Sistema

O sistema é dividido em macro-módulos integrados que gerenciam as principais entidades hospitalares:

* **Gestão de Pacientes e Convênios:** Cadastro, atualização e listagem de pacientes, associando-os aos seus respectivos planos de saúde.
* **Gestão de Corpo Médico e Especialidades:** Controle de médicos ativos, seus registros profissionais (CRM) e especializações clínicas.
* **Agendamento de Consultas e Exames:** Vínculo de pacientes e médicos para a realização de atendimentos clínicos e solicitações de exames de diagnóstico.
* **Controle de Internações e Quartos:** Gerenciamento de leitos hospitalares, ocupação de quartos e fluxo de internação de pacientes em estado grave.
* **Prontuário Eletrônico (PEP):** Histórico centralizado de saúde do paciente, unificando todas as suas consultas, alergias registradas e observações médicas.
* **Módulo Administrativo:** Controle de acesso geral ao sistema, permitindo que apenas usuários autenticados realizem operações críticas de CRUD.

---

## 📐 Arquitetura do Projeto

O projeto adota uma arquitetura em camadas rígida para garantir a separação de conceitos, manutenibilidade e escalabilidade do código:

1.  **Model (Modelo):** Entidades puras que representam os dados (POJOs), contendo atributos, construtores, getters e setters.
2.  **View (Visão):** Camada de interface de usuário via console (Terminal) baseada em inputs de dados (`Scanner`) e menus dinâmicos.
3.  **Controller (Controlador):** Intercepta os comandos da View, transforma os dados brutos em objetos de modelo e orquestra as chamadas de serviço.
4.  **Service (Serviço):** Concentra todas as **regras de negócio**, validações (como checagem de duplicidade de logins ou CPFs) e tratamento de exceções.
5.  **Repository (Repositório):** Camada de persistência. Em vez de banco de dados relacional, gerencia listas em memória que são sincronizadas dinamicamente com arquivos JSON locais.

---

## 👥 Divisão de Desenvolvimento (Equipe)

O projeto foi dividido em módulos independentes integrados através de um ecossistema compartilhado:

* **Pessoa 1 — Pacientes (Heitor):** Desenvolvimento do fluxo completo do MVC de **Paciente** e MVC de **Convênio**.
* **Pessoa 2 — Médicos (Kenzo):** Desenvolvimento do fluxo completo do MVC de **Médico** (com login por CRM) e MVC de **Especialidade**.
* **Pessoa 3 — Consultas (Tissi):** Desenvolvimento do fluxo completo do MVC de **Consulta** e MVC de **Exame**.
* **Pessoa 4 — Internações (Felipe):** Desenvolvimento do fluxo completo do MVC de **Internação** e MVC de **Quarto**.
* **Pessoa 5 — Prontuários e Sistema (Guilherme Taborda):** Desenvolvimento do fluxo completo do MVC de **Prontuário**, MVC de **Administrador**, além da infraestrutura central compartilhada (`Pessoa`, `Autenticavel`, `MenuPrincipal` e utilitários de arquivos).

---

## 📦 Estrutura de Pacotes

```text
src/
└── Hospital/                  # Raiz principal do sistema
    ├── controller/            # Controladores que orquestram o fluxo de dados
    │   ├── AdministradorController.java
    │   ├── ProntuarioController.java
    │   └── ... (Demais controladores do grupo)
    │
    ├── interfaces/            # Contratos e Interfaces globais
    │   └── Autenticavel.java
    │
    ├── main/                  # Classes alternativas de inicialização e testes
    │   ├── MainHospital.java
    │   └── MainKaito.java
    │
    ├── model/                 # Entidades de dados (POJOs) e heranças
    │   ├── Pessoa.java        # Classe abstrata base
    │   ├── Administrador.java
    │   ├── Prontuario.java
    │   └── ... (Convenio, Medico, Paciente, Quarto, etc.)
    │
    ├── repository/            # Camada de persistência (leitura e escrita dos arquivos)
    │   ├── AdministradorRepository.java
    │   ├── ProntuarioRepository.java
    │   └── ... (Demais repositórios do grupo)
    │
    ├── service/               # Camada onde ficam isoladas as regras de negócio
    │   ├── AdministradorService.java
    │   ├── ProntuarioService.java
    │   └── ... (Demais regras do grupo)
    │
    ├── util/                  # Utilitários globais compartilhados por todos
    │   ├── ArquivoUtil.java   # Gerenciamento de I/O físico de arquivos em UTF-8
    │   ├── InputHelper.java   # Auxiliar para leituras de teclado (Scanner)
    │   └── JsonUtil.java      # Parser genérico do Google Gson (<T>)
    │
    ├── view/                  # Telas de interação com o usuário via terminal
    │   ├── AdministradorView.java
    │   ├── ProntuarioView.java
    │   └── ... (Demais visualizações do grupo)
    │
    └── Main.java              # Ponto de partida oficial da aplicação
