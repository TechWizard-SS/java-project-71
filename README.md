### Hexlet tests and linter status:
[![Actions Status](https://github.com/TechWizard-SS/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/TechWizard-SS/java-project-71/actions)



[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=TechWizard-SS_java-project-71&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=TechWizard-SS_java-project-71)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=TechWizard-SS_java-project-71&metric=bugs)](https://sonarcloud.io/summary/new_code?id=TechWizard-SS_java-project-71)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=TechWizard-SS_java-project-71&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=TechWizard-SS_java-project-71)
[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=TechWizard-SS_java-project-71&metric=duplicated_lines_density)](https://sonarcloud.io/summary/new_code?id=TechWizard-SS_java-project-71)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=TechWizard-SS_java-project-71&metric=ncloc)](https://sonarcloud.io/summary/new_code?id=TechWizard-SS_java-project-71)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=TechWizard-SS_java-project-71&metric=reliability_rating)](https://sonarcloud.io/summary/new_code?id=TechWizard-SS_java-project-71)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=TechWizard-SS_java-project-71&metric=security_rating)](https://sonarcloud.io/summary/new_code?id=TechWizard-SS_java-project-71)
[![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=TechWizard-SS_java-project-71&metric=sqale_index)](https://sonarcloud.io/summary/new_code?id=TechWizard-SS_java-project-71)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=TechWizard-SS_java-project-71&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=TechWizard-SS_java-project-71)
[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=TechWizard-SS_java-project-71&metric=vulnerabilities)](https://sonarcloud.io/summary/new_code?id=TechWizard-SS_java-project-71)


#  Differ — Сравнение конфигурационных файлов

**Differ** — консольное приложение на Java, предназначенное для сравнения двух конфигурационных файлов (`.json`, `.yml`) и отображения различий в удобном формате.

---

##  Возможности

- Поддержка форматов входных файлов: **JSON**, **YAML**
- Форматы вывода результата:
  - **Stylish** — древовидное форматирование
  - **Plain** — текстовое описание изменений
  - **JSON** — структурированный JSON-вывод
  - **Default** — stylish, если формат не указан
- Корректная обработка вложенных структур (nested)
- Универсальные тесты с использованием JUnit 5

---

##  Установка и запуск

### 1. Клонируйте репозиторий

git clone https://github.com/TechWizard-SS/java-project-71.git
cd java-project-71
2. Сборка проекта
bash
Копировать код
make build
3. Запуск приложения
bash
Копировать код
make run
4. Примеры использования
bash
Копировать код
## Сравнение JSON-файлов с выводом в стиле "stylish"
./app/build/install/app/bin/app file1.json file2.json --format stylish

## Сравнение YAML-файлов с выводом в стиле "plain"
./app/build/install/app/bin/app file1.yml file2.yml --format plain

## Формат по умолчанию (stylish)
./app/build/install/app/bin/app file1.json file2.json
