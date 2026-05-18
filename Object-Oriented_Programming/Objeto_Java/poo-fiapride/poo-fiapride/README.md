# Projeto FiapRide - [Seu Nome Completo]

## 📋 Informações do Aluno

- **Nome:** Bruna Marques e Queiroz
- **RM:** 565648
- **Turma:** 2CCPW
- **Curso:** Ciência da Computação
---

## Descrição do Projeto

Este projeto é o resultado do aprendizado nas aulas 1-9 de Programação Orientada a Objetos, onde desenvolvemos o sistema de **Projeto Pessoal: Garrafa de Água** — modelagem completa de uma garrafa reutilizável aplicando todos os pilares de POO aprendidos no semestre.

---

## Checklist de Implementação

- [x] Aula 1 - Classes e Objetos
- [x] Aula 2 - Métodos
- [x] Aula 3 - Encapsulamento
- [x] Aula 4 - Construtores
- [x] Aula 5 - Associação
- [x] Aula 6 - Herança
- [x] Aula 7 - Polimorfismo
- [x] Aula 8 - Classes Abstratas
- [x] Aula 9 - Interfaces

---

##  Perguntas de Reflexão

### Aula 1 - Classes e Objetos

**Pergunta:** Por que precisamos criar uma classe `Passageiro`? Não seria mais fácil apenas criar variáveis soltas no main?

**Sua Resposta:**
Criar variáveis soltas como `String nomeAna = "Ana"` e `double saldoAna = 50.0` funciona para um único usuário. Com 1 milhão de usuários, teríamos 2 milhões de variáveis soltas sem nenhuma relação entre si — impossível de gerenciar. A Classe resolve isso criando um molde: com ele instanciamos `new Passageiro(...)` quantas vezes precisarmos, cada objeto carregando seus próprios dados de forma organizada. A Classe também agrupa dados e comportamentos relacionados num único lugar, facilitando manutenção, leitura e reutilização.

---

### Aula 2 - Métodos

**Pergunta:** Se podemos fazer `passageiro.saldo = passageiro.saldo + 100` diretamente, por que criar `adicionarSaldo(valor)`?

**Sua Resposta:**
Alterar o saldo diretamente no código principal abre brechas sérias: qualquer programador da equipe pode escrever `passageiro.saldo = -500` ou `passageiro.saldo = 99999999` sem nenhum controle. Com o método `adicionarSaldo(valor)`, a regra de negócio fica dentro da classe — só aceita valores positivos, registra logs, pode acionar notificações. Se a regra mudar, mudamos em um único ponto, não em centenas de lugares espalhados pelo código. O método é o porteiro que protege o estado do objeto.

---

### Aula 3 - Encapsulamento

**Pergunta:** Por que é seguro deixar o `get` público, mas perigoso deixar o atributo original público?

**Sua Resposta:**
O getter entrega uma **cópia** do valor — quem recebe pode ler, mas não pode alterar o original. Deixar o atributo público é como entregar o documento original para alguém rasurar: `passageiro.saldo = -1000` passa direto, sem validação. Com `getSaldo()` público e `saldo` privado, garantimos que a leitura é livre mas a escrita sempre passa pelo setter — onde vivem as regras de negócio. É a diferença entre emprestar uma fotocópia e assinar um cheque em branco.

---

### Aula 4 - Construtores

**Pergunta:** Por que é um erro gravíssimo clicar em "Gerar Getters e Setters para tudo" automaticamente?

**Sua Resposta:**
Gerar setter para tudo viola as regras de negócio do domínio. No `Veiculo`, o modelo é imutável — um Fiat Uno não vira um Corolla. Se geramos `setModelo()`, qualquer código pode trocar o modelo a qualquer hora, corrompendo dados históricos de corridas, contratos e multas. O `setPlaca()` é privado porque a placa só muda via processo real no Detran (`atualizarPlaca()`), que inclui validação e log. Setter automático para tudo é como dar chave do cofre para qualquer estagiário: conveniente, mas perigoso.

---

### Aula 5 - Associação

**Pergunta:** Por que exigir o objeto `Passageiro` inteiro no construtor de `Viagem`, se só precisamos do nome?

**Sua Resposta:**
Porque a `Viagem` não precisa só do nome — ela precisa de acesso ao objeto real. Quando a viagem termina e o sistema desconta o saldo, ele chama `this.solicitante.pagarViagem(custo)`. Se a `Viagem` tiver apenas a `String "Ana Silva"`, ela é incapaz de mexer no saldo de Ana. A associação por objeto inteiro permite navegar entre objetos em tempo real, garantindo que qualquer alteração no `Passageiro` (novo saldo, bloqueio de conta) seja imediatamente visível pela `Viagem` que o referencia.

---

### Aula 6 - Herança

**Pergunta:** Por que Java não deixa a filha alterar as variáveis `private` da mãe diretamente?

**Sua Resposta:**
Porque isso violaria o Encapsulamento — o princípio aprendido na Aula 3. O fato de `Carro` herdar de `Veiculo` não significa que o `Carro` tem autoridade para invadir o estado interno da mãe. `placa` e `modelo` são privados da `Veiculo` porque a regra de validação da placa pertence à `Veiculo`. Se `Carro` pudesse fazer `this.placa = "ABC"` diretamente, burlariam a validação. Por isso é obrigado a usar `super(placa, modelo)` ou `setPlaca()` — sempre passando pelo porteiro.

---

### Aula 7 - Polimorfismo

**Pergunta:** Se não criássemos `calcularAutonomia()` na classe mãe `Veiculo`, conseguiríamos chamá-lo no loop `for (Veiculo v : frota)`?

**Sua Resposta:**
Não. A variável `veiculo` é do tipo `Veiculo` — o compilador só enxerga os métodos declarados em `Veiculo`. Mesmo que `Carro` e `Moto` tenham `calcularAutonomia()`, o compilador não sabe disso em tempo de compilação ao olhar para uma referência do tipo `Veiculo`. O contrato precisa existir na base da hierarquia para que o compilador confie que qualquer objeto naquela lista obedece o contrato. Sem o contrato na mãe, precisaríamos de `instanceof` e casts feios — exatamente o anti-padrão que o Polimorfismo veio eliminar.

---

### Aula 8 - Classes Abstratas

**Pergunta:** Por que precisamos escrever `abstract` explicitamente? Por que Java não deduz sozinho?

**Sua Resposta:**
Java é uma linguagem de **intenção explícita**: o programador deve comunicar claramente o design. Se esquecermos o `abstract`, alguém pode escrever `new Veiculo("ABC", "Generico")` e criar um objeto sem regra de autonomia, sem tipo definido — corrompendo a lógica do sistema. O `abstract` é uma barreira de proteção que o compilador faz valer. Java não deduz porque a classe pode ter todos os métodos implementados e ainda assim ser projetada para nunca ser instanciada diretamente — a intenção do arquiteto precisa ser declarada.

---

### Aula 9 - Interfaces

**Pergunta:** Por que Java permite múltipla implementação de interfaces mas não herança múltipla?

**Sua Resposta:**
Herança múltipla de classes gera o "Problema do Diamante": se `Televisor` e `Radio` ambos têm `ligar()` e `TVRadio` herda das duas, qual `ligar()` executar? É ambiguidade de código real. Interfaces não têm implementação — são apenas contratos (assinaturas). Se duas interfaces definem `ligar()`, a classe implementa **uma vez** e satisfaz ambas, sem conflito. No projeto da Garrafa, `GarrafaEsportiva` e `CantilMilitar` são de hierarquias completamente diferentes mas ambas assinam `Reutilizavel` — isso seria impossível com herança, mas é trivial com interfaces.

---

## 🔧 Desafios Técnicos Implementados

### Desafio Pessoal — Sistema de Garrafa Reutilizável

**Qual foi o domínio escolhido?**
Sistema de Garrafa de Água — modelagem de um produto cotidiano que evoluiu progressivamente aula a aula.

**Quais classes foram criadas?**
- `Garrafa` — classe concreta principal 
- `Tampa` — classe associada 
- `GarrafaBase` — superclasse abstrata
- `GarrafaEsportiva` — subclasse concreta
- `GarrafaTermica` — subclasse concreta
- `CantilMilitar` — classe de hierarquia diferente que implementa a interface
- `Reutilizavel` — interface de comportamento 

**Qual foi o maior desafio técnico?**
O maior desafio foi entender quando usar Classe Abstrata e quando usar Interface. No início, queria fazer `Reutilizavel` como classe abstrata, mas percebi que `CantilMilitar` não é uma `GarrafaBase` — é um objeto de natureza diferente que compartilha apenas o *comportamento* de ser reutilizável. A interface resolveu isso: `GarrafaEsportiva`, `GarrafaTermica` e `CantilMilitar` podiam todas implementar `Reutilizavel` sem precisar compartilhar uma ancestral comum. O loop `for (Reutilizavel r : itensReutilizaveis)` com os três tipos diferentes foi o momento em que o conceito realmente "clicou".

---

## 🏆 Conclusão

**O que você aprendeu nestas 9 aulas?**
Aprendi que POO não é sobre escrever código que funciona — é sobre escrever código que *comunica intenção* e *resiste ao tempo*. Cada aula adicionou uma camada de proteção: encapsulamento protege os dados, construtores protegem o estado inicial, herança elimina repetição, polimorfismo elimina ifs feios, classes abstratas documentam design, interfaces permitem flexibilidade sem acoplamento.

**Qual conceito foi mais difícil de entender?**
Polimorfismo foi o mais difícil. Entender que a variável do tipo `GarrafaBase` aponta para um `GarrafaEsportiva` e o Java escolhe o método correto em tempo de execução — não de compilação — exigiu ver o código rodando várias vezes para internalizar.

**O que você melhoraria se pudesse refazer?**
Teria criado a `GarrafaBase` abstrata já na aula 1, com o domínio completo em mente. Evoluir de `Garrafa` concreta para hierarquia abstrata na aula 6 gerou retrabalho. Planejar a hierarquia antes de escrever a primeira linha é a lição.

---

## 📁 Estrutura do Projeto

```
poo-fiapride/
├── src/
│   └── br/
│       └── com/
│           └── fiap/
│               ├── model/
│               │   ├── Garrafa.java          (aulas 1-5)
│               │   ├── Tampa.java            (aula 5)
│               │   ├── GarrafaBase.java      (aulas 6-8)
│               │   ├── GarrafaEsportiva.java (aulas 6-9)
│               │   ├── GarrafaTermica.java   (aulas 6-9)
│               │   ├── CantilMilitar.java    (aula 9)
│               │   └── Reutilizavel.java     (aula 9)
│               └── main/
│                   └── Main.java
├── README.md
└── .gitignore
```

---
