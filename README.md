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


# Differ — Сравнение конфигурационных файлов

**Differ** — консольное приложение на Java, предназначенное для сравнения двух конфигурационных файлов (`.json`, `.yml`) и отображения различий в удобном формате.

---

## Возможности

- Поддержка форматов входных файлов: **JSON**, **YAML**
- Форматы вывода результата:
  - **Stylish** — древовидное форматирование
  - **Plain** — текстовое описание изменений
  - **JSON** — структурированный JSON-вывод
  - **Default** — stylish, если формат не указан
- Корректная обработка вложенных структур (nested)
- Универсальные тесты с использованием JUnit 5

---

## Установка и запуск

1. **Клонируйте репозиторий**
   ```
   git clone https://github.com/TechWizard-SS/java-project-71.git
   cd java-project-71
   ```

2. **Сборка проекта**
   ```
   make build
   ```

3. **Запуск приложения**
   ```
   make run-dist
   ```

4. **Примеры использования**

   ### Сравнение JSON-файлов с выводом в стиле "stylish"
   ```
   .app/build/install/app/bin/app src/main/resources/file1.json src/main/resources/file2.json --format stylish
   ```

   ### Сравнение YAML-файлов с выводом в стиле "plain"
   ```
   .app/build/install/app/bin/app src/main/resources/file1.yml src/main/resources/file2.yml --format plain
   ```

   ### Формат по умолчанию (stylish)
   ```
   .app/build/install/app/bin/app src/main/resources/file1.json src/main/resources/file2.json
   ```

## Скриншоты запусков на тестовых файлах


<img width="875" height="576" alt="image" src="https://github.com/user-attachments/assets/a7608ff8-a809-4b00-9e54-748a8503a504" />

<img width="862" height="307" alt="image" src="https://github.com/user-attachments/assets/b049bc0d-b9db-4af9-8c89-6f1d4ce48b48" />

<img width="731" height="569" alt="image" src="https://github.com/user-attachments/assets/faf813b7-11c9-4c2b-ac41-c264c4e6a2fe" />

<img width="858" height="573" alt="image" src="https://github.com/user-attachments/assets/d01f9a58-17f7-4234-8dd0-ee2565ada035" />

<img width="840" height="308" alt="image" src="https://github.com/user-attachments/assets/2a3a2f2d-9603-4a0d-9b81-794b411c1262" />

<img width="721" height="576" alt="image" src="https://github.com/user-attachments/assets/9dd6ec85-5b52-4040-adf7-336a2bd0e317" />

