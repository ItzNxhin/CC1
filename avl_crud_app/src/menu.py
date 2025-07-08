import os
import sys
from utils import read_json, write_json
from crud import CRUD

DATA_DIR = os.path.join(os.path.dirname(__file__), '..', 'data')

def list_json_files():
    files = [f for f in os.listdir(DATA_DIR) if f.endswith('.json')]
    return files

def create_new_json():
    name = input("Enter new JSON filename (without .json): ").strip()
    if not name:
        print("Invalid name.")
        return
    path = os.path.join(DATA_DIR, f"{name}.json")
    if os.path.exists(path):
        print("File already exists.")
        return
    write_json(path, [])
    print(f"Created {name}.json.")

def select_json_file():
    files = list_json_files()
    if not files:
        print("No JSON files found. Please create one first.")
        return None
    print("Available JSON files:")
    for idx, fname in enumerate(files, 1):
        print(f"{idx}. {fname}")
    choice = input("Select a file by number: ")
    try:
        idx = int(choice) - 1
        if 0 <= idx < len(files):
            return files[idx]
    except ValueError:
        pass
    print("Invalid selection.")
    return None

def crud_menu(filename):
    path = os.path.join(DATA_DIR, filename)
    values = read_json(path)
    if not isinstance(values, list):
        print("Invalid JSON format. Must be a list.")
        return

    crud = CRUD()
    for value in values:
        crud.create(value)

    while True:
        print(f"\nCRUD Menu for {filename}")
        print("1. Create value")
        print("2. Read value")
        print("3. Update value")
        print("4. Delete value")
        print("5. List all values")
        print("6. Back to main menu")
        choice = input("Choose an option: ")

        if choice == '1':
            value = input("Enter value: ")
            crud.create(value)
            values.append(value)
            write_json(path, values)
            print("Value created.")

        elif choice == '2':
            value = input("Enter value to search: ")
            node = crud.avl_tree.search(crud.root, value)
            if node:
                print("Found:", node.value)
            else:
                print("Not found.")

        elif choice == '3':
            old_value = input("Enter value to update: ")
            new_value = input("Enter new value: ")
            crud.update(old_value, new_value)
            for i, v in enumerate(values):
                if v == old_value:
                    values[i] = new_value
                    break
            write_json(path, values)
            print("Value updated.")

        elif choice == '4':
            value = input("Enter value to delete: ")
            crud.delete(value)
            values = [v for v in values if v != value]
            write_json(path, values)
            print("Value deleted.")

        elif choice == '5':
            print("All values (pre-order):")
            preordered = crud.avl_tree.preorder(crud.root)
            for value in preordered:
                print(value)

        elif choice == '6':
            break
        else:
            print("Invalid option.")

def main_menu():
    while True:
        print("\nMain Menu")
        print("1. Create new JSON object file")
        print("2. Select and manage existing JSON object file")
        print("3. Exit")
        choice = input("Choose an option: ")
        if choice == '1':
            create_new_json()
        elif choice == '2':
            filename = select_json_file()
            if filename:
                crud_menu(filename)
        elif choice == '3':
            print("Goodbye!")
            sys.exit(0)
        else:
            print("Invalid option.")

if __name__ == "__main__":
    main_menu()