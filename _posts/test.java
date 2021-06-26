public class Main() {
    public static void main(String[] args) {
    Person SH = new Person();
    Person MJ = new Person();
    
    Life myLife = new Life(SH);
    Life myGFLife = new Life(MJ);

    while( !(SH.isLoved(MJ) && MJ.isLoved(SH))) {
        SH.giveLove(MJ);MJ.giveLove(SH);
        if(myLife.death() || myGFLife.death()) break;
    }
    }
}