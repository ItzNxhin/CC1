# AVL CRUD Application

This project implements a CRUD (Create, Read, Update, Delete) application using an AVL tree to manage JSON objects. Each object contains attributes such as ID, name, and age, and is stored in a JSON file.

## Project Structure

```
avl_crud_app
├── src
│   ├── avl_tree.py      # Implementation of the AVL tree
│   ├── crud.py          # Handles CRUD operations for JSON objects
│   ├── menu.py          # User interface for the application
│   └── utils.py         # Utility functions for file handling
├── data
│   └── objects.json     # JSON file to store objects
├── requirements.txt      # Dependencies for the project
└── README.md            # Documentation for the project
```

## Installation

1. Clone the repository:
   ```
   git clone <repository-url>
   cd avl_crud_app
   ```

2. Install the required dependencies:
   ```
   pip install -r requirements.txt
   ```

## Usage

1. Run the application:
   ```
   python src/menu.py
   ```

2. Follow the on-screen instructions to perform CRUD operations on the JSON objects.

## Features

- Efficient searching, inserting, and deleting of objects using an AVL tree.
- User-friendly menu for easy navigation and operation selection.
- JSON file storage for persistent data management.

## Contributing

Contributions are welcome! Please open an issue or submit a pull request for any enhancements or bug fixes.