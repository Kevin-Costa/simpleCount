package model;

public class Model extends AbsModel{
	  public void setOp(String ope){    
		    calc();
		    this.op = ope;
		    if (!ope.equals("=")){
		    	this.calcul = "";
		    }
	  }
	@Override
	public void reset() {
	this.res = 0;
	this.op = "";
	this.calcul = "0";
	this.ans = 0;
	notifyObserver(String.valueOf(this.res));
	}
	@Override
	public void calc() {
		this.res = (this.ans != 0 && res == 0) ? this.ans : this.res; 
		this.calcul = (calcul == "") ? "0" : this.calcul; 
	    if(this.op.equals("")){
	      this.res = Double.parseDouble(this.calcul);
	    }
	    else{
	      if(!this.op.equals("")){
	        if(this.op.equals("+"))
	          this.res += Double.parseDouble(this.calcul);
	        if(this.op.equals("-"))
	          this.res -= Double.parseDouble(this.calcul);
	        if(this.op.equals("*") && this.calcul != "0")
	          this.res *= Double.parseDouble(this.calcul); 
	        if(this.op.equals("%") && this.calcul != "0"){
	        	try{
	        		this.res %= Double.parseDouble(this.calcul);
	        	 }catch(ArithmeticException e){
	 	            this.res = 0;
	        	 }
	        }
	        if(this.op.equals("/") && this.calcul != "0"){
	          try{
	            this.res /= Double.parseDouble(this.calcul);
	          }catch(ArithmeticException e){
	            this.res = 0;
	          }
	        }
            this.ans = this.res;
	      }
	    }
	    this.calcul = "0";
		this.op = "";
	    notifyObserver(String.valueOf(this.res));
	  }
	@Override
	public void getRes() {
		calc();
	}
	@Override
	public void setNombre(String nb) {
		this.calcul += nb;
		notifyObserver(this.calcul);
	}
}