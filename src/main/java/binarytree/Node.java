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
class Node {
        
        private final String content;
        private BinaryTree left;
        private BinaryTree right;
        
        public Node(String content) {
                this.content = content;
        }
        
        public Node(String content, BinaryTree left, BinaryTree right) {
                this.content = content;
                this.left = left;
                this.right = right;
        }
        
        public BinaryTree left() {
                return left;
        }
        
        public BinaryTree right() {
                return right;
        }

        public void setLeft(BinaryTree left) {
                this.left = left;
        }

        public void setRight(BinaryTree right) {
                this.right = right;
        }

        public String getData() {
                return content;
        }
        
        public Boolean isLeaf() {
            if( left == null && right == null) {
                return true;
            }

            return false;
        }

        public Boolean hasTwoSubtrees() {
            if(left != null && right != null) {
                return true;
            }

            return false;
        }
        
}
