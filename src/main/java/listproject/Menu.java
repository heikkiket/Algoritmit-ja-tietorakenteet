
package listproject;

import stackproject.*;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: </p>
 *
 * <p>Company: Stadia</p>
 *
 * @author JPK
 * @version 1.0
 */
public class Menu {
//printMenu alkaa------------------------------------------------------------------
	public void printMenu() {
                char select;
                List l = new List(); // pino-olio
                String data; // Pinon data-kenttä
                do {

                        System.out.println("\n\t\t\t1. Alkion lisääminen.");
                        System.out.println("\t\t\t2. Alkion poistaminen.");
                        System.out.println("\t\t\t3. Listan sisältö.");
                        System.out.println("\t\t\t4. Alkioiden lukumäärä.");
                        System.out.println("\t\t\t5. Edellinen alkio.");
                        System.out.println("\t\t\t6. Seuraava alkio.");
                        System.out.println("\t\t\t7. Nykyinen positio.");
                        System.out.println("\t\t\t8. lopetus ");
                        System.out.print("\n\n"); // tehdään tyhjiä rivejä
                        select = Lue.merkki();
                        switch (select) {
                        case '1':
                            System.out.println("Anna alkion sisältö (merkkijono)");
                            data = new String(Lue.rivi());
                            l.add(data);
                            break;
                        case '2':
				ListItem removed = l.remove();
                           if(removed == null)
                                System.out.println("Lista on tyhjä");
                            else
                                System.out.println("Poistettu alkio: " + removed.getData());
                            break;
                        case '3':
				System.out.println(l);
                            break;
                        case '4':
                            System.out.println("Lukumäärä = "+l.getSize());
                            break;
                        case '5':
				l.revPos();
                            break;
                        case '6':
				l.nextPos();
                            break;
                        case '7':
				String pos = l.getPos().getData();
				if(pos != null)
					System.out.println(pos);
                            break;

			case '8':
				break;
                        }
                }
                while (select != '8');
        }
//printMenu loppuu ----------------------------------------------------------------
}
