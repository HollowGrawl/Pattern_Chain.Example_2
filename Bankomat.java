import java.util.ArrayList;

class Bankomat {
    // поля
    private Banknota first_handl;
    // методы
    public Bankomat(int [] nominals, int [] amounts) {
        int l = nominals.length;
        Banknota [] arr_bankn = new Banknota[ l ];
	    for (int i=0; i<l; i++) {
	        arr_bankn[i] = new Banknota( nominals[i], amounts[i] );
	        //if (i>=1) arr_bankn[i-1].setNext( arr_bankn[i] );
	        if (i>=1) arr_bankn[0].append( arr_bankn[i] ); 
	    }
	    DefaultHandler dh = new DefaultHandler();
	    arr_bankn[ l-1 ].setNext( dh );
	    // начало цепочки обработчиков
	    first_handl = arr_bankn[0]; 
    }
    public String toString() {
        return "Bankomat has { " + first_handl.infoChainHandlers() + " }";
    }
    public boolean giveMe( int request ) {
        System.out.println( "Request sum = "+ request );
        ArrayList<Integer> answer = new ArrayList<>();
        boolean res = first_handl.handle( request, answer );
        if ( res ) giveMoney( request, answer );
        System.out.println( "\t\t" + answer );
        System.out.println( "res = " + res );
        return res; // ( answer.size() != 0 ) ? true : false; 
    }
    // private методы
    private void giveMoney( int request, ArrayList<Integer> answer ) {
        Handler tmp = first_handl;
        System.out.print( "Giving money "+request+"$ = ");
        for ( int n : answer ) {
            ((Banknota)tmp).giveMe(n); System.out.print( String.format( " + %d*%d$", n, ((Banknota)tmp).getNominal() ) );
            tmp = tmp.next;
        }
        System.out.println( " = "+request+"." );
    }
}