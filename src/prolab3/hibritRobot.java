package prolab3;

public class hibritRobot extends gezginRobotlar implements gezmeyenRobotlar{
    
        double kolUzunlugu;
        double yükKapasitesi;
        double tasimaHizi;
        int sira;
        double sabitlenme;
        
hibritRobot(double sabit,int sayac,int ad,double kol,double kapasite,double ghiz,double thiz,double yük,int motor,int deger){
    
            this.deger=deger;
            this.gezinmeHizi=ghiz;
            this.kolUzunlugu=kol/10;
            this.motorSayisi=motor;
            this.tasimaHizi=thiz;
            this.yükKapasitesi=kapasite;
            this.yükMiktari=yük;
            this.isim=ad;
            this.sira=sayac;
            this.sabitlenme=sabit;
            
            
                if(ad == 1){
                    this.gecmeHizi=motor*0.5;
                    this.gecerMi=true;
                }
                else if(ad == 2){
                    this.gecmeHizi=motor*3;
                    this.gecerMi=true;
                }
                else if(ad== 3){
                    this.gecmeHizi=0;
                    this.gecerMi=false;
                }
        }

    hibritRobot() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean tasirMi(double yük, double kapasite) {
        return kapasite >= yük;
    }

    @Override
    public boolean hangisiAgir(double yük1, double yük2) {
        return yük1>yük2;
    }
    
    
      @Override
            public int getmotorSayisi(){
                return this.motorSayisi;
            }
            @Override
            public double getYükmiktari(){
                return this.yükMiktari;
            }
            @Override
            public int getAd(){
                return this.isim;
            }

             @Override
             public double getKolUzunlugu() {
                return this.kolUzunlugu;
             }

            @Override
            public double getYukKapasitesi() {
                return this.yükKapasitesi;
            }

             @Override
             public double getTasimaHizi() {
                return this.tasimaHizi;
            }
             
            @Override
            public int getSira(){
                return this.sira;
            }
            
        @Override
            public boolean gecerMi() {
                return this.gecerMi;
            }
}