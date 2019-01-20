package prolab3;

public class gezginRobotlar implements Robot{
    
     double gezinmeHizi;
     int deger;
     boolean gecerMi;
     double gecmeHizi;
     int isim;
     int motorSayisi;
     double yükMiktari;
     int sira;
     
     double gecmeHizi(){
       return this.gecmeHizi; 
     }
       
     boolean Hepsihizkarsilastir(double hiz1,double hiz2,double hiz3){
         return (hiz1>hiz2 && hiz1>hiz3 && hiz2>hiz3);
     }
     boolean hizKarsilastir (double hiz1,double hiz2){
        return hiz1>hiz2;
     }

    @Override
    public int getmotorSayisi() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getYükmiktari() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getAd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getSira() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean gecerMi() {
        return this.gecerMi;
    }

    
    
}
