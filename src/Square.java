public class Square {
    private Symbol s;

    public Square() {}

    public boolean setSymbol(Symbol newSymbol){
        if(s != null){
            return false;
        } else {
            this.s = newSymbol;
            return true;
        }
    }

    public Symbol getSymbol(){
        return this.s;
    }

    public String toString(){
        if(s != null){
            return s.toString();
        } else {
            return " ";
        }
    }
}