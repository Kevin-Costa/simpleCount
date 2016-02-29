package simpleCount;

import controler.*;
import model.*;
import view.View;

public class Main {
	  public static void main(String[] args) {
	    AbsModel calcul = new Model();
	    AbsControler controler = new Controler(calcul);
	    View simpleCount = new View(controler);
	    calcul.addObserver(simpleCount);
	  }
}
