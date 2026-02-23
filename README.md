# 📱 Calculadora Integrada: Matemática & Física ⚡

Este projeto foi desenvolvido para a disciplina de **Programação para Dispositivos Móveis** do curso de Análise e Desenvolvimento de Sistemas na **Unisanta**. O objetivo é aplicar conceitos de lógica de programação, manipulação de UI e tratamento de erros em ambiente Android.

---

## 🧭 Estrutura do Aplicativo
O app foi projetado com uma **Tela Inicial de Escolha**, permitindo que o usuário navegue entre dois módulos principais:

### 1. 🔢 Calculadora de Operações Básicas
Desenvolvida para realizar cálculos matemáticos fundamentais com precisão:
- **Soma (+)**
- **Subtração (-)**
- **Multiplicação (×)**
- **Divisão (÷)**: Com validação de segurança para evitar divisões por zero.

### 2. ⚡ Módulo Lei de Ohm (Física)
Ferramenta específica para cálculos de grandezas elétricas baseada na Primeira Lei de Ohm:
- **Tensão ($V$):** Calculada como $V = R \cdot I$.
- **Corrente ($I$):** Calculada como $I = V / R$.
- **Resistência ($R$):** Calculada como $R = V / I$.



---

## 🛠️ Detalhes Técnicos e Validações
Para garantir uma boa nota na disciplina e estabilidade no uso, o app conta com:
- **Tratamento de Exceções:** Uso de `toDoubleOrNull()` para evitar que o app feche caso o usuário digite letras ou deixe campos vazios.
- **Validação de Fluxo:** Mensagens de erro claras quando apenas um campo é preenchido.
- **Interface Otimizada:** XML estruturado para rodar de forma fluida em dispositivos com hardware limitado (2GB RAM).
- **Linguagem:** Kotlin 1.9+
- **IDE:** Android Studio



---

## 🚀 Como Executar o Projeto
### Via Clone (Git):
```bash
git clone [https://github.com/WilliamBrazao/Calculadora-Lei-de-Ohm.git](https://github.com/WilliamBrazao/Calculadora-Lei-de-Ohm.git)
