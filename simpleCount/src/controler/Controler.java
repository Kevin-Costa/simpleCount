package controler;

import model.AbsModel;

public class Controler extends AbsControler{
	public Controler(AbsModel calcul) {
		super(calcul);
	}
	@Override
	void control() {
	    if(this.listOperateur.contains(this.op)){
	        if(this.op.equals("="))
	          this.calc.getRes();
	        else
	          this.calc.setOp(this.op);
	      }
	      if(this.nbr.matches("^[0-9.]+$"))
	        this.calc.setNombre(this.nbr);
	      this.op = "";
	      this.nbr = "";	
	}
}
