/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackproject;

import listproject.List;

/**
 *
 * @author heikki
 */
public class Stack extends List {
	
	/**
	 *
	 */
	public Stack() {
		start = null;
		size = 0;
	}

	/**
	 * Muodostaa uuden lista-alkion, asettaa sen pinon huipulle.
	 */
	public void push(String data) {

		ListItem i = new ListItem(data);
		i.setNext(start);
		start = i;
		size++;
	}


	/**
	 * Poistaa pinon huipulla olevan alkion ja palauttaa sen.
	 * Jos pino on tyhjä, palautetaan null;
	 */
	public ListItem pop() {
		if (size == 0) {
			return null;
		}
		ListItem toReturn = start;
		size--;

		start = start.getNext();
		return toReturn;
	}

}
