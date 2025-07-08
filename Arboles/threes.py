class Node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

class BinaryTree:
    def __init__(self):
        self.root = None

    def add(self, value):
        if not self.root:
            self.root = Node(value)
        else:
            self._add(self.root, value)

    def _add(self, node, value):
        if value < node.value:
            if node.left:
                self._add(node.left, value)
            else:
                node.left = Node(value)
        else:
            if node.right:
                self._add(node.right, value)
            else:
                node.right = Node(value)

    def search(self, value):
        return self._search(self.root, value)

    def _search(self, node, value):
        if not node:
            return False
        if node.value == value:
            return True
        elif value < node.value:
            return self._search(node.left, value)
        else:
            return self._search(node.right, value)

    def delete(self, value):
        self.root = self._delete(self.root, value)

    def _delete(self, node, value):
        if not node:
            return node
        if value < node.value:
            node.left = self._delete(node.left, value)
        elif value > node.value:
            node.right = self._delete(node.right, value)
        else:
            if not node.left:
                return node.right
            elif not node.right:
                return node.left
            temp = self._min_value_node(node.right)
            node.value = temp.value
            node.right = self._delete(node.right, temp.value)
        return node
    
    def find_node(self, value):
        """Devuelve el nodo con el valor dado, o None si no existe."""
        return self._find_node(self.root, value)

    def _find_node(self, node, value):
        if node is None:
            return None
        if node.value == value:
            return node
        elif value < node.value:
            return self._find_node(node.left, value)
        else:
            return self._find_node(node.right, value)

    def node_height(self, value):
        """Altura del subárbol cuya raíz es el nodo con ese valor."""
        node = self.find_node(value)
        if node is None:
            return -1
        return self._height(node)

    def node_degree(self, value):
        """Grado del nodo con ese valor."""
        node = self.find_node(value)
        if node is None:
            return -1
        return self.degree(node)

    def node_level(self, value):
        """Nivel del nodo con ese valor."""
        return self.level(value)

    def _min_value_node(self, node):
        current = node
        while current.left:
            current = current.left
        return current

    def height(self):
        return self._height(self.root)

    def _height(self, node):
        if node is None:
            return -1
        return 1 + max(self._height(node.left), self._height(node.right))

    def degree(self, node):
        degree = 0
        if node.left:
            degree += 1
        if node.right:
            degree += 1
        return degree

    def level(self, value):
        return self._level(self.root, value, 1)

    def _level(self, node, value, level):
        if not node:
            return 0
        if node.value == value:
            return level
        downlevel = self._level(node.left, value, level + 1)
        if downlevel != 0:
            return downlevel
        return self._level(node.right, value, level + 1)

    def is_full(self, node=None):
        if node is None:
            return True  # Si se llama con un nodo None, significa que es hoja válida
        if (node.left is None) != (node.right is None):
            return False
        return self.is_full(node.left) and self.is_full(node.right)


    def is_complete(self):
        if not self.root:
            return True
        queue = [self.root]
        found_none_child = False
        while queue:
            node = queue.pop(0)
            if node.left:
                if found_none_child:
                    return False
                queue.append(node.left)
            else:
                found_none_child = True
            if node.right:
                if found_none_child:
                    return False
                queue.append(node.right)
            else:
                found_none_child = True
        return True

    def is_perfect(self):
        def count_nodes(node):
            if not node:
                return 0
            return 1 + count_nodes(node.left) + count_nodes(node.right)

        h = self.height()
        n = count_nodes(self.root)
        return n == 2 ** (h + 1) - 1

    def tree_type(self):
        types = []
        if self.is_full():
            types.append("Lleno")
        if self.is_complete():
            types.append("Completo")
        if self.is_perfect():
            types.append("Perfecto")
        if not types:
            types.append("Ninguno")
        return types

tree = BinaryTree()
tree.add(1)
tree.add(8)
tree.add(15)
tree.add(7)
tree.add(9)
tree.add(13)
tree.add(4)
nd=4
print("Altura del nodo:", tree.node_height(nd))
print("Grado del nodo:", tree.node_degree(nd))
print("Nivel del nodo:", tree.node_level(nd))

print("Altura del árbol:", tree.height())  # 3
print("Grado del nodo raíz:", tree.degree(tree.root))  # 2
print("Nivel del nodo 15:", tree.level(15))  # 0, no existe
print("Tipo de árbol:", tree.tree_type())  # ['Completo']