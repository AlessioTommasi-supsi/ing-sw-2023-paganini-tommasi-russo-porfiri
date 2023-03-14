package org.example.Model;
import java.util.*;

/**
 * -> le posizoni  Giuste in cui mettere le tessere sono istanziate.
 * 
 * ->quando rimuovo una tessera l attributo carta di posizione sara NULL pero la posizione contiua ad esistere!!!
 */
public class PosizioneTessera {

	/**
	 * Default constructor
	 */
	public PosizioneTessera() {
	}

	/**
	 * 
	 */
	private Tessera[] tessera_row;

	/**
	 * 
	 */
	private int x;

	/**
	 * 
	 */
	private int y;

	/**
	 * @return
	 */
	public boolean isEmpty() {
		// TODO implement here
		return false;
	}

	/**
	 * @param t 
	 * @return
	 */
	public void setTessera(Tessera t) {
		// TODO implement here
	}

	/**
	 * @return
	 */
	public Tessera getTessera() {
		// TODO implement here
		return null;
	}

}