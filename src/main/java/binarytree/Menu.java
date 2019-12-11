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

public class Menu {
//main alkaa-----------------------------------------------------------------------------
    
    public static void main(String[] args) {
        
        printMenu();
        
    }
//main loppuu --------------------------------------------------------------------------
//printMenu alkaa------------------------------------------------------------------
    
    private static void printMenu() {
        char select, select1;
        BinaryTree tree = null, upDated = null;
        String data;
        do {
            
            System.out.println("\n\t\t\t1. Luo juurisolmu.");
            System.out.println("\t\t\t2. Lisää avain.");
            System.out.println("\t\t\t3. Käy puu läpi esijärjestyksessä.");
            System.out.println("\t\t\t4. Etsi solmua avaimella");
            System.out.println("\t\t\t5. Päivitä uusi uusi solmu.");
            System.out.println("\t\t\t6. lopetus ");
            System.out.print("\n\n"); // tehdään tyhjiä rivejä
            select = Lue.merkki();
            switch (select) {
                case '1':
                    System.out.println("Anna juuren sisältö (merkkijono)");
                    data = new String(Lue.rivi());
                    tree = new BinaryTree(data);
                    break;
                case '2':
                    System.out.println("Anna lisättävä avain:");
                    tree.addKey(new String(Lue.rivi()));
                    break;
                case '3':
                    tree.preOrder();
                    char h = Lue.merkki(); // pysäytetään kontrolli
                    break;
                case '4':
                    System.out.println("Anna avain, jota haetaan");
                    Node result = tree.searchKey(Lue.rivi());
                    if(result != null) {
                        System.out.println("Tulos: " + result.getData());
                    } else {
                        System.out.println("Avaimella ei löytynyt mitään.");
                    }
                    break;
                case '5':
                    if (tree == null) {
                        System.out.println("Et ole muodostanut juurisolmua.");
                    } else {
                        System.out.println("Anna solmun sisältö (merkkijono)");
                        BinaryTree newTree = new BinaryTree(new String(Lue.rivi()));
                        
                        tree.setNotFound();
                        tree.findWithPreOrder();
                        upDated = BinaryTree.getFound();
                        if (upDated == null) // ei valittu mitään
                        {
                            break;
                        }
                        System.out.print("Kytke vasemmalle? (k/e)");
                        select1 = Lue.merkki();
                        if (select1 == 'k') {
                            upDated.setLeft(newTree);
                        } else {
                            System.out.print("Kytke oikealle? (k/e)");
                            select1 = Lue.merkki();
                            if (select1 == 'k') {
                                upDated.setRight(newTree);
                            }
                        }
                    }
                    break;
                case '6':
                    break;
            }
        } while (select != '6');
    }
//printMenu loppuu ----------------------------------------------------------------
} 
