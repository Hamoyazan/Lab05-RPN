# Lab 05 – Reverse Polish Notation Evaluator

This project was developed as part of the course *Informatik 2* (Summer Semester 2025) at HTW Berlin.

## Overview

This Java program allows users to input arithmetic expressions in **infix** notation, converts them into **postfix** (Reverse Polish Notation), and evaluates them instantly. It supports all basic arithmetic operations and parentheses.

---

## Features

- Infix ➜ Postfix conversion (Shunting Yard algorithm)
- Postfix evaluation using a custom stack
- Modular design using packages: `stack`, `scanner`, `postfix`
- Continuous input through console (`exit` to stop)
- Fully tested with JUnit5

---

## Example

**Input:**  
```
( 3 + 4 ) * 2 ^ 2
```

**Output:**  
```
→ Tokens: ( 3 + 4 ) * 2 ^ 2  
→ Postfix: 3 4 + 2 2 ^ *  
→ Result: 28.0
```

---

## Structure

```
src/
├── stack/        # Stack interface + implementation + exception
├── scanner/      # Tokenizer for user input
├── postfix/      # Infix-to-postfix converter and evaluator
└── Main.java     # Program entry point

test/
├── stack/        # Unit tests for stack behavior
├── scanner/      # Tests for tokenization logic
└── postfix/      # Tests for infix and postfix functionality
```

---

## How to Run

1. Open the project in **IntelliJ** (or any Java IDE)
2. Make sure **JDK 17** is selected
3. Run `Main.java`
4. Enter infix expressions with spaces (e.g., `( 2 + 3 ) * 4`)
5. Type `exit` to quit the loop

---

## Report

You can find the final documentation report here:  
 `Lab05_Bericht_Yazan.docx`

---

## Author

**Mhd Yazan Hammoud**  
HTW Berlin – Internationale Medieninformatik (B.Sc.)  
Summer Semester 2025
