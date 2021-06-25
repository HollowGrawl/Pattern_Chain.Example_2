import java.util.ArrayList;
// extends Object
abstract class Handler { 
    protected Handler next = null;
    public Handler getNext() { return next; }
    public void setNext(Handler n) {
        next = n;
    }
    public void append(Handler n) {
        if (next != null) {
           System.out.println( "\t next.add "+n);
           next.add(n);
        } else {
           System.out.println( "\t next="+n);
           next = n;
        }
    }
    public String infoChainHandlers() {
        if ( next != null ) return String.format( "%s -> %s", this, next.infoChainHandlers() );
        else 
        return String.format( "%s -> %s", this, next );
        /*StringBuilder sb = new StringBuilder(  String.format( "%s -> %s", this, this.next ) );
        Base tmp = this.next;
        while ( tmp != null ) {
            tmp = tmp.next;
            sb.append( String.format( " -> %s", tmp ) );
        }
        return sb.toString();*/
    }
	abstract public boolean handle(int request, ArrayList<Integer> answer);
}


    