def read_json(file_path):
    import json
    try:
        with open(file_path, 'r') as file:
            return json.load(file)
    except FileNotFoundError:
        return []
    except json.JSONDecodeError:
        return []

def write_json(file_path, data):
    import json
    with open(file_path, 'w') as file:
        json.dump(data, file, indent=4)

def find_object_by_id(objects, object_id):
    for obj in objects:
        if obj.get('id') == object_id:
            return obj
    return None

def update_object(objects, updated_object):
    for index, obj in enumerate(objects):
        if obj.get('id') == updated_object.get('id'):
            objects[index] = updated_object
            return True
    return False

def delete_object(objects, object_id):
    for index, obj in enumerate(objects):
        if obj.get('id') == object_id:
            del objects[index]
            return True
    return False