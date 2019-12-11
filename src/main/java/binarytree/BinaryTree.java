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

    public Node searchKey(String key) {
        if(root == null) {
            return null;
        } else {
            int result = key.compareTo(root.getData());

            if(result < 0) {
                return searchFromLeft(key);
            } else if(result > 0) {
                return searchFromRight(key);
            } else {
                return root;
            }
        }

    }

    private Node searchFromLeft(String key) {
       if(root.left() == null) {
           return null;
       } else {
           return root.left().searchKey(key);
       }
    }

    private Node searchFromRight(String key) {
        if(root.right() == null) {
            return null;
        } else {
            return root.right().searchKey(key);
        }

    }

}
