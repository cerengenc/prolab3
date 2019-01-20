package prolab3;

class spiderRobot extends gezginRobotlar {
     
            spiderRobot (int sayac,double hiz,int bacak,int motor,double yük){
           
           this.isim=3;
           this.motorSayisi=motor;
           this.gezinmeHizi=hiz;
           this.deger=bacak;
           this.gecerMi=false;
           this.gecmeHizi=this.gecmeHizi;
           this.yükMiktari=yük;
           this.sira=sayac;
           
       }
            double gecmeHizi(){
                return 0;
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