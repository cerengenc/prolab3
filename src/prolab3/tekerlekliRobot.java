package prolab3;

class tekerlekliRobot extends gezginRobotlar {
      
           tekerlekliRobot(int sayac,double hiz,int tekerlek,int motor,double yük){
           
           this.isim=1;
           this.motorSayisi=motor;
           this.gezinmeHizi=hiz;
           this.deger=tekerlek;
           this.gecerMi=true;
           this.yükMiktari=yük;
           this.sira=sayac;
           this.gecmeHizi = this.gecmeHizi();
           
       }
           @Override
            double gecmeHizi(){
                return this.motorSayisi*0.5;
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
            public int getSira() {
                return this.sira;        
            }
            
        }
