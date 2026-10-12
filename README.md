# Employee Management System

A simple console-based Employee Management System written in Java. It stores employees in memory (an `ArrayList`) and lets you manage them from a text menu.

## Features

- Add an employee (with validation for name, email, department and salary)
- View all employees
- Search an employee by ID
- Update an employee
- Delete an employee
- Search employees by department
- Sort employees by salary (highest first)

## Project Structure

```
.
├── Main.java        # Menu, input handling and program logic
├── Employee.java    # Employee model class
└── README.md
```

## Requirements

- Java JDK 8 or higher

## How to Run

```bash
javac Main.java Employee.java
java Main
```

## Notes

- Data is stored in memory only, so it is lost when the program exits.
- Possible future improvements: save data to a file or database, prevent duplicate IDs.
