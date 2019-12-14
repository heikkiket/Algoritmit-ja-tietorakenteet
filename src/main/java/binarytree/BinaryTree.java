/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytree;

/**
 *
 * @author heikki
 */
public class BinaryTree {

    private Node root;
    public static BinaryTree found;
    
    public BinaryTree() {
        this.root = null;
    }
    
    BinaryTree(String data) {
        this.root = new Node(data);
    }
    
    
    static BinaryTree getFound() {
        return found;
    }

    public Node getNode() {
        return root;
    }
    
    void setNotFound() {
        found = null;
    }

    public void findWithPreOrder() {

        if (root != null) {
            System.out.print(root.getData() + ": muokkaatko tätä?");
            if (root.left() == null) {
                System.out.print(" (vasemmalla tilaa)");
            }
            if (root.right() == null) {
                System.out.println(" (oikealla tilaa)");
            }
            char select = Lue.merkki();
            if (select == 'k') {
                found = this;
                return;
            }
            if (found == null && root.left() != null) // pääseekö vasemmalle?
            {
                root.left().findWithPreOrder();
            }
            if (found == null && root.right() != null) // pääseekö oikealle?
            {
                root.right().findWithPreOrder();
            }
        }

    }

    void setLeft(BinaryTree newTree) {
        root.setLeft(newTree);
    }

    void setRight(BinaryTree newTree) {
        root.setRight(newTree);
    }

    void preOrder() {
        if(root != null) {
            System.out.println(root.getData() + ", ");
            if(root.left() != null) {
                root.left().preOrder();
            }
            if(root.right() != null) {
                root.right().preOrder();
            }
        }
    }

    void addKey(String string) {
        if(root == null) {
            this.root = new Node(string);
        }

        // returns -1 if smaller, 0 if same and 1 if larger
        int result = string.compareTo(root.getData());
        if(result < 0) {
            if(root.left() == null) {
                root.setLeft(new BinaryTree(string));
            } else {
                root.left().addKey(string);
            }
        } else if(result > 0) {
            if(root.right() == null) {
                root.setRight(new BinaryTree(string));
            } else {
                root.right().addKey(string);
            }
        } else {
            System.out.println("Avain " + string + " löytyy jo puusta.");
        }
    }

    public BinaryTree searchKey(String key) {
        if(root == null) {
            return null;
        } else {
            int result = key.compareTo(root.getData());

            if(result < 0) {
                return searchRecursive(root.left(), key);
            } else if(result > 0) {
                return searchRecursive(root.right(), key);
            } else {
                return this;
            }
        }

    }

    private BinaryTree searchRecursive(BinaryTree tree, String key) {
       if(tree == null) {
           return null;
       } else {
           return tree.searchKey(key);
       }
    }

    public Node removeLeftmostNode() {
        return this.removeLeftmostNode(null);
    }

    public Node removeLeftmostNode(BinaryTree parent) {
        if(root.left() == null) {
            // this is the leftmost node, so remove itself.

            // if we have a right node, move it to parents left.
            parent.setLeft(null);
            if(root.right() != null) {
                parent.setLeft(root.right());
            }
            return this.root;
        } else {
            return root.left().removeLeftmostNode(this);
        }
    }

    public void removeNode(String key) {
        this.removeRecursive(null, key);
    }

    private BinaryTree removeRecursive(BinaryTree parent, String key) {
        // Empty tree
        if(this.root == null) {
            return null;
        }

        int result = key.compareTo(root.getData());
        if(result < 0) {
            root.setLeft(root.left().removeRecursive(this, key));
            return this;
        } else if(result > 0) {
            root.setRight(root.right().removeRecursive(this, key));
            return this;
        } else {

            if(root.isLeaf()) {
                root = null;
                return null;
            } else if(root.left() == null) {
                return root.right();
            } else if(root.right() == null) {
                return root.left();
           
            // root has two subtrees:
            } else
                this.root = root.right().removeLeftmostNode();
                return parent;
            }
    }

    private void setRoot(Node node) {
        root = node;
    }

}
