package prolab3;


    
    public class paletliRobot extends gezginRobotlar{
        
            paletliRobot(int sayac,double hiz,int palet,int motor,double yük){
      
           this.isim=2;
           this.motorSayisi=motor;
           this.gezinmeHizi=hiz;
           this.gecerMi=true;
           this.deger=palet;
           this.yükMiktari=yük;
           this.sira=sayac;
           this.gecmeHizi=this.gecmeHizi();
           
    }
            @Override
            double gecmeHizi(){
                return this.motorSayisi*3; 
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
    