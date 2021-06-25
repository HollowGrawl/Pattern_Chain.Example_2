
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) { 
	    int [] nominals1 = { 100, 50, 20, 10, 5, 1 };
	    int [] amounts1 = { 10, 10, 10, 10, 5, 5 };
	    Bankomat bankomat1 = new Bankomat(nominals1, amounts1);
	    System.out.println( bankomat1 );
	    if ( bankomat1.giveMe(287) ) System.out.println( bankomat1 );
	    if ( bankomat1.giveMe(4) ) System.out.println( bankomat1 );
	    if ( bankomat1.giveMe(239) ) {}
	    System.out.println( bankomat1 );
	    
	    System.out.println( "\n\n\n" );
	    
	    int [] nominals2 = { 100, 50, 20, 10, 5 };
	    int [] amounts2 = { 5, 5, 5, 5, 5 };
	    Bankomat bankomat2 = new Bankomat(nominals2, amounts2);
	    System.out.println( bankomat2 );
	    if ( bankomat2.giveMe(4) ) System.out.println( bankomat2 );
	    if ( bankomat2.giveMe(239) ) System.out.println( bankomat2 );
	    if ( bankomat2.giveMe(915) ) System.out.println( bankomat2 );
		
	}
}
