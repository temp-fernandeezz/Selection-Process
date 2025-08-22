# Criando Um Pequeno Sistema Para **Validação de Processo Seletivo** ☕️

Projeto em **Java (console)** para treinar **condicionais**, **laços**, **exceções** e regras simples de negócio.  
Desafio inspirado na trilha da **DIO**: validar candidatos pela **pretensão salarial** e simular um mini fluxo de **seleção e contato**.

> Este repositório inclui **duas versões**:
>
> - `ProcessoSeletivoMin.java` → versão **mínima** (entrada/saída simples).
> - `ProcessoSeletivoApp.java` → versão **com menu** (cadastro, análise, seleção e tentativa de contato).

---

## ✨ Funcionalidades

- **Analisar candidato** comparando pretensão com salário base:
  - `< base` → **LIGAR PARA CANDIDATO**
  - `= base` → **LIGAR, COM CONTRA PROPOSTA**
  - `> base` → **AGUARDAR RESULTADO DOS DEMAIS CANDIDATOS**
- (Menu) **Cadastrar** e **listar** candidatos.
- (Menu) **Analisar em massa**.
- (Menu) **Selecionar Top 5** com melhor pretensão (≤ base).
- (Menu) **Simular contato** (até 3 tentativas/candidato).

---

## 🧰 Tecnologias

- **Java 17+**
- **VS Code** (ou IDE de sua preferência)
- Extensão **Extension Pack for Java** (recomendado no VS Code)

---

## 📦 Estrutura

```
.
├─ src/
│  ├─ ProcessoSeletivoMin.java      # versão mínima
│  └─ ProcessoSeletivoApp.java      # versão com menu
└─ README.md
```

---

## ▶️ Como executar

> Você pode rodar pelo **VS Code** (botão ▶️ acima do `main`) ou pelo **terminal**.

### Versão mínima

```bash
# compilar
javac -d bin src/ProcessoSeletivoMin.java

# executar
java -cp bin ProcessoSeletivoMin
```

**Exemplo de entrada:**
```
3
Ana 1800
Beto 2000
Carla 2500
```

**Saída esperada:**
```
LIGAR PARA CANDIDATO
LIGAR, COM CONTRA PROPOSTA
AGUARDAR RESULTADO DOS DEMAIS CANDIDATOS
```

---

### Versão com menu

```bash
# compilar
javac -d bin src/ProcessoSeletivoApp.java

# executar
java -cp bin ProcessoSeletivoApp
```

**Fluxo (exemplo):**
```
=== Processo Seletivo ===
Salário base atual: R$ 2.000,00
1) Definir salário base
2) Adicionar candidato
3) Listar candidatos
4) Analisar todos
5) Selecionar (top 5) e tentar contato
0) Sair
Escolha: 2
Nome: Ana
Pretensão (ex: 1800,00): 1800,00
Candidato adicionado.
```

---

## ✅ Checklist (DIO)

- [x] Entrada/saída via **console**
- [x] **Condicionais** e **laços**
- [x] **Tratamento** simples de entrada (menu)
- [x] Regras de **negócio** aplicadas
- [x] Organização em **classe** (menu)

---

## 🚀 Próximos passos (ideias)

- Testes com **JUnit**
- Persistência simples (CSV/JSON)
- Logs e níveis de severidade
- **API REST** com Spring Boot
- Validações mais ricas (duplicidade, formatos, etc.)

---

## 👩‍💻 Autora

**Fernanda Fernandes** – Full Stack (PHP, Laravel, WordPress) explorando **Java**  
📧 nandafernandes259@gmail.com

---

## 📄 Licença

Distribuído sob a **MIT License**. Sinta-se à vontade para usar e evoluir.
