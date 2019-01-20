package prolab3;

public class seriRobot implements gezmeyenRobotlar {
    
    int isim;
    double kolUzunlugu;
    double yükKapasitesi;
    int motorSayisi;
    double yükMiktari;
    double tasimaHizi;
    int sira;
    boolean gecerMi;
            
            seriRobot(int sayac,double kol,double kapasite,double hiz,double yük,int motor){
            
            this.isim=2;
            this.kolUzunlugu=kol/10;
            this.yükKapasitesi=kapasite;
            this.motorSayisi=motor;
            this.yükMiktari=yük;
            this.tasimaHizi=hiz;
            this.sira=sayac;
            this.gecerMi=false;
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
            public int getSira() {
                return this.sira;        
            }
            
            @Override
            public boolean gecerMi() {
                 return this.gecerMi;
            }
        }