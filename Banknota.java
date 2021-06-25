import java.util.ArrayList;

class DefaultHandler extends Handler {
    @Override
	public boolean handle(int request, ArrayList<Integer> answer) {
		System.out.println( String.format(" Summa %d can not be given!!! ", request) );
		return false;
	}
}

class Banknota extends Handler {
    // поля
    private int nominal;
    private int amount;
    // методы
    // конструктор
    public Banknota( int _nominal, int _amount ) {
        this.nominal = _nominal;
        amount = _amount;
    }
    public String toString() {
        return String.format( "%d[%d]\t", nominal, amount );
    }
    // геттеры
    public int getNominal() { return nominal; }
    @Override
    // запрашиваемая сумма
    public boolean handle(int request, ArrayList<Integer> answer) { 
        // кол-во купюр текущего номинала
        int n = request/nominal; 
        if (n!=0) {
            System.out.print( String.format( "\t may give me %d banknotes of %d $ ?", n, nominal) );
            int n_give = mayGiveBanknot( n );
            System.out.println( String.format( " \t giving %d banknotes of %d $", n_give, nominal) );
            answer.add( n_give );
            int remaind = request - nominal * n_give;
            if (remaind==0) {
                System.out.println( String.format(" == Sum WILL be given. ") );
                return true;
            } else return next.handle( remaind, answer );
        } else {
            return next.handle( request, answer );
        }
    }
    public boolean giveMe(int n) {
        if (n<=amount) { amount -= n; return true; } else { return false; }
    }
    // private методы
    private int mayGiveBanknot( int n ) {
        if ( n<=amount ) {
            // amount -= n;
            return n;
        } else {
            return amount;
        }
    }
}